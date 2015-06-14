package br.com.ceducarneiro.exemploactivities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class PrimeiraActivity extends ActionBarActivity {

    private static final String LOG_TAG = "CICLO_VIDA";
    private static final int REQUEST_SEGUNDA_TELA = 10;
    private EditText edtName;

    private static final String KEY_QTD_CLICKS = "qtd_clicks";

    private int qtd_clicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "[in] onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira);
        edtName = (EditText) findViewById(R.id.edtName);

        if (savedInstanceState != null) {
            Log.d(LOG_TAG, "onReCreate");
            qtd_clicks = savedInstanceState.getInt(KEY_QTD_CLICKS);
        }

        Log.d(LOG_TAG, "[out] onCreate");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_QTD_CLICKS, qtd_clicks);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        Log.d(LOG_TAG, "[in] onStart");
        super.onStart();
        Log.d(LOG_TAG, "[out] onStart");
    }

    @Override
    protected void onResume() {
        Log.d(LOG_TAG, "[in] onResume");
        super.onResume();
        Log.d(LOG_TAG, "[out] onResume");
    }

    @Override
    protected void onPause() {
        Log.d(LOG_TAG, "[in] onPause");
        super.onPause();
        Log.d(LOG_TAG, "[out] onPause");
    }

    @Override
    protected void onStop() {
        Log.d(LOG_TAG, "[in] onStop");
        super.onStop();
        Log.d(LOG_TAG, "[out] onStop");
    }

    @Override
    protected void onDestroy() {
        Log.d(LOG_TAG, "[in] onDestroy");
        super.onDestroy();
        Log.d(LOG_TAG, "[out] onDestroy");
    }

    @Override
    protected void onRestart() {
        Log.d(LOG_TAG, "[in] onRestart");
        super.onRestart();
        Log.d(LOG_TAG, "[out] onRestart");
    }

    public void onSendClick(View v) {
        Intent it = new Intent(this, SegundaActivity.class);
        it.putExtra(SegundaActivity.KEY_NAME, edtName.getText().toString());
        startActivityForResult(it, REQUEST_SEGUNDA_TELA);
        qtd_clicks++;
        Log.d(LOG_TAG, "CLICKS: " + qtd_clicks);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SEGUNDA_TELA && resultCode == RESULT_OK && data != null) {
            String lastName = data.getStringExtra(SegundaActivity.KEY_LAST_NAME);

            if (lastName != null)
                edtName.setText(edtName.getText().toString() + " " + lastName);
        }
    }
}
