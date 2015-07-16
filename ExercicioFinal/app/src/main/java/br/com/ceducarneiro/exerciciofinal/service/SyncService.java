package br.com.ceducarneiro.exerciciofinal.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import br.com.ceducarneiro.exerciciofinal.ExercicioApplication;
import br.com.ceducarneiro.exerciciofinal.controller.PrefsController;
import br.com.ceducarneiro.exerciciofinal.controller.SyncController;
import br.com.ceducarneiro.exerciciofinal.model.Author;
import br.com.ceducarneiro.exerciciofinal.model.Book;
import br.com.ceducarneiro.exerciciofinal.model.Publisher;

public class SyncService extends IntentService {

    public static boolean running = false;
    public static final MediaType JSON
            = MediaType.parse("application/json");

    public SyncService() {
        super("SyncService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        running = true;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://192.168.0.114:8000/sync/")
                .post(createRequestBody())
                .build();

        boolean success = false;

        try {
            Response response = client.newCall(request).execute();
            if (response.code() == 200) {
                success = processResponse(response.body().string());
            }
        } catch (IOException ex) {
            Log.e(ExercicioApplication.LOG_TAG, "onHandleIntent", ex);
        }

        if (success) {
            SyncController.getInstance().notifyOnSyncSuccess();
        } else {
            SyncController.getInstance().notifyOnSyncError();
        }

        running = false;
    }

    private boolean processResponse(String json) {
        boolean success = false;

        try {
            ObjectMapper mapper = new ObjectMapper();
            SyncResponse syncResponse = mapper.readValue(json, SyncResponse.class);

            for (Author author : syncResponse.getAuthors()) {
                Author dbAuthor = Author.findByGuid(author.getGuid());

                if (dbAuthor != null) {
                    author.setId(dbAuthor.getId());
                }

                author.save();
            }

            for (Publisher publisher : syncResponse.getPublishers()) {
                Publisher dbPublisher = Publisher.findByGuid(publisher.getGuid());

                if (dbPublisher != null) {
                    publisher.setId(dbPublisher.getId());
                }

                publisher.save();
            }

            for (Book book : syncResponse.getBooks()) {
                Book dbBook = Book.findByGuid(book.getGuid());

                if (dbBook != null) {
                    book.setId(dbBook.getId());
                }

                String authorsStr = "";
                for (Long author : book.getAuthors()) {
                    authorsStr += author + ",";
                }
                book.setAuthorsStr(authorsStr);

                book.save();
            }

            PrefsController.setLastSyncDate(syncResponse.getServerDate());

            success = true;
        } catch (IOException ex) {
            Log.e(ExercicioApplication.LOG_TAG, "processResponse", ex);
        }

        return success;
    }

    private RequestBody createRequestBody() {
        SyncRequest syncRequest = new SyncRequest();

        syncRequest.setAuthors(Author.findAllModified());
        syncRequest.setPublishers(Publisher.findAllModified());
        syncRequest.setBooks(Book.findAllModified());
        syncRequest.setLastSyncDate(PrefsController.getLastSyncDate());

        ObjectMapper mapper = new ObjectMapper();

        String jsonStr = "";

        try {
            jsonStr = mapper.writeValueAsString(syncRequest);
        } catch (JsonProcessingException ex) {
            Log.e(ExercicioApplication.LOG_TAG, "createRequestBody", ex);
        }

        return RequestBody.create(JSON, jsonStr);
    }

    public static boolean isRunning() {
        return running;
    }

}
