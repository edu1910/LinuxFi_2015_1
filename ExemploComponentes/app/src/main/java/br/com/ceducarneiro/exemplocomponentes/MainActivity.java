package br.com.ceducarneiro.exemplocomponentes;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;


public class MainActivity extends ActionBarActivity {

    private ImageView imgPhoto;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar sbImage = (SeekBar) findViewById(R.id.sbImage);
        imgPhoto = (ImageView) findViewById(R.id.imgPhoto);

        sbImage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                imgPhoto.setAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public void onChangeClick(View v) {
        EditText edtTest = (EditText) findViewById(R.id.edtTest);

        Drawable drw = getResources().getDrawable(android.R.drawable.ic_input_add);
        drw.setBounds(0,0,100,100);
        edtTest.setCompoundDrawables(drw, null, null, null);
    }

    @Override
    public void onBackPressed() {
        dialog = new AlertDialog.Builder(this)
                .setTitle("Confirmação")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Deseja realmente com certeza sem dúvidas fechar a aplicação?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .show();
    }
}
