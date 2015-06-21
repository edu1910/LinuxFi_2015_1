package br.com.ceducarneiro.exemplointentfilter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class MainActivity extends ActionBarActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    private EditText edtUrl;
    private ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUrl = (EditText) findViewById(R.id.edtUrl);
        imgPhoto = (ImageView) findViewById(R.id.imgPhoto);
    }

    public void onOpenClick(View v) {
        String url = edtUrl.getText().toString();

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }

        Uri webpage = Uri.parse(url);
        Intent it = new Intent(Intent.ACTION_VIEW, webpage);
        if (it.resolveActivity(getPackageManager()) != null) {
            startActivity(it);
        }
    }

    private Uri getPhotoUri() {
        return Uri.parse("file://" + getPhotoPath());
    }

    private String getPhotoPath() {
        return Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "/imagem.png";
    }

    public void onCaptureClick(View v) {
        Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        Log.d("CAMINHO", getPhotoPath().toString());

        it.putExtra(MediaStore.EXTRA_OUTPUT, getPhotoUri());

        if (it.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(it, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void onPhotoClick(View v) {
        Intent it = new Intent(Intent.ACTION_VIEW);
        it.setDataAndType(getPhotoUri(), "image/*");

        if (it.resolveActivity(getPackageManager()) != null) {
            startActivity(it);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            if (resultCode == RESULT_OK) {
                //Bitmap thumbnail = data.getParcelableExtra("data");
                /*BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 4;

                Bitmap photo = BitmapFactory.decodeFile(getPhotoPath(), options);
                imgPhoto.setImageBitmap(photo);*/
                Picasso.with(this)
                        .load(getPhotoUri())
                        .resize(300, 300)
                        .into(imgPhoto);
            } else {
                Toast.makeText(this, "Foto cancelada!", Toast.LENGTH_LONG).show();
                imgPhoto.setImageBitmap(null);
            }
        }
    }
}
