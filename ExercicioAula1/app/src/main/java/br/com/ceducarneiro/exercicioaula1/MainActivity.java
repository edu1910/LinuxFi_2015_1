package br.com.ceducarneiro.exercicioaula1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends LogActivity {

    private static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public String getLogTag() {
        return LOG_TAG;
    }

    public void onEnterClick(View v) {
        EditText edtName = (EditText) findViewById(R.id.edtName);
        EditText edtPassword = (EditText) findViewById(R.id.edtPassword);

        String name = edtName.getText().toString();
        String password = edtPassword.getText().toString();

        boolean error = false;

        if (name.isEmpty()) {
            edtName.setError("Preencha o nome");
            error = true;
        }

        if (password.isEmpty()) {
            edtPassword.setError("Preencha a senha");
            error = true;
        }

        if (!error) {
            Intent it = new Intent(this, DetailActivity.class);

            it.putExtra(DetailActivity.KEY_NAME, name);
            it.putExtra(DetailActivity.KEY_PASSWORD, password);

            startActivity(it);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        EditText edtName = (EditText) findViewById(R.id.edtName);
        edtName.requestFocus();
    }
}
