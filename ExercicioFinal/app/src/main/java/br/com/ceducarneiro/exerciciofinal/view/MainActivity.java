package br.com.ceducarneiro.exerciciofinal.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.crashlytics.android.Crashlytics;

import br.com.ceducarneiro.exerciciofinal.BuildConfig;
import io.fabric.sdk.android.Fabric;
import java.util.List;

import br.com.ceducarneiro.exerciciofinal.R;
import br.com.ceducarneiro.exerciciofinal.controller.AlarmController;
import br.com.ceducarneiro.exerciciofinal.controller.SyncController;
import br.com.ceducarneiro.exerciciofinal.controller.SyncListener;
import br.com.ceducarneiro.exerciciofinal.model.Book;
import br.com.ceducarneiro.exerciciofinal.service.SyncService;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;


public class MainActivity extends ActionBarActivity implements SyncListener {

    @Bind(R.id.listBooks)
    ListView listBooks;

    @Bind(R.id.loading)
    View loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!BuildConfig.DEBUG) {
            Fabric.with(this, new Crashlytics());
        }

        setContentView(R.layout.activity_main);
        SyncController.getInstance().addListener(this);

        ButterKnife.bind(this);

        startSyncService(false);

        AlarmController.getInstance().registerSyncAlarm();
    }

    @Override
    protected void onResume() {
        super.onResume();
        new BooksTask().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_sync) {
            startSyncService(true);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnItemClick(R.id.listBooks)
    public void onBookClick(int position, long id) {
        Intent it = new Intent(this, EditBookActivity.class);
        it.putExtra(EditBookActivity.KEY_BOOK_ID, id);
        startActivity(it);
    }

    private void startSyncService(boolean showLoading) {
        if (!SyncService.isRunning()) {
            Intent it = new Intent(this, SyncService.class);
            startService(it);

            if (showLoading) {
                showLoading();
            }
        }
    }

    private void showLoading() {
        loading.setVisibility(View.VISIBLE);
    }

    private void hideLoading() {
        loading.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onDestroy() {
        SyncController.getInstance().removeListener(this);
        super.onDestroy();
    }

    @Override
    public void onSyncSuccess() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hideLoading();
                new BooksTask().execute();
            }
        });
    }

    @Override
    public void onSyncError() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hideLoading();
            }
        });
    }

    class BooksTask extends AsyncTask<Void, Void, List<Book>> {
        @Override
        protected void onPreExecute() {
            showLoading();
        }

        @Override
        protected List<Book> doInBackground(Void... params) {
            return Book.listAll(Book.class);
        }

        @Override
        protected void onPostExecute(List<Book> books) {
            BookAdapter adapter = new BookAdapter(MainActivity.this,
                    android.R.layout.simple_list_item_1, books);
            listBooks.setAdapter(adapter);
            hideLoading();
        }
    }

}
