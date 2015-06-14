package br.com.ceducarneiro.exemplores;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btLog = (Button) findViewById(R.id.btLog);
        btLog.setOnLongClickListener(this);
    }

    public void onLogClick(View v) {
        Log.e("MEU_ERRO", "Meu primeiro log de erro!");
        Toast.makeText(this, "Meu primeiro toast!", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onLongClick(View v) {
        boolean result = false;

        if (v.getId() == R.id.btLog) {
            Log.w("MEU_ALERTA", "Meu primeiro log de alerta!");
            Toast.makeText(this, "Meu segundo toast!", Toast.LENGTH_LONG).show();

            result = true;
        }

        return result;
    }
}
