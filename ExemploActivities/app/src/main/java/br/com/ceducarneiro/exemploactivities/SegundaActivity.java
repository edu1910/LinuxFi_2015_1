package br.com.ceducarneiro.exemploactivities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaActivity extends ActionBarActivity {

    public static final String KEY_NAME = "key_name";
    public static final String KEY_LAST_NAME = "key_last_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        if (getIntent().hasExtra(KEY_NAME)) {
            String name = getIntent().getStringExtra(KEY_NAME);

            TextView txtName = (TextView) findViewById(R.id.txtName);
            txtName.setText(name);
        }
    }

    @Override
    public void onBackPressed() {
        EditText edtLastName = (EditText) findViewById(R.id.edtLastName);
        Intent it = new Intent();
        it.putExtra(KEY_LAST_NAME, edtLastName.getText().toString());
        setResult(RESULT_OK, it);

        super.onBackPressed();
    }
}
