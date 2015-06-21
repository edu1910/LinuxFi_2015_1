package br.com.ceducarneiro.exercicioaula1;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

public abstract class LogActivity extends ActionBarActivity {

    public abstract String getLogTag();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(getLogTag(), "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        Log.d(getLogTag(), "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(getLogTag(), "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(getLogTag(), "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(getLogTag(), "onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.d(getLogTag(), "onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d(getLogTag(), "onDestroy");
        super.onDestroy();
    }

}
