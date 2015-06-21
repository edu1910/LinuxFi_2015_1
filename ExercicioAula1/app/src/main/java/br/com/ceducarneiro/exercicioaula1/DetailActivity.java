package br.com.ceducarneiro.exercicioaula1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class DetailActivity extends LogActivity {

    private static final String LOG_TAG = "DetailActivity";

    public static final String KEY_NAME = "key_name";
    public static final String KEY_PASSWORD = "key_password";

    private static final String DEFAULT_NAME = "Android";
    private static final String DEFAULT_PASS = "123Mudar";

    private boolean toastShowed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (savedInstanceState != null) {
            toastShowed = savedInstanceState.getBoolean("toastShowed");
        }

        Button btAction = (Button) findViewById(R.id.btAction);
        TextView txtMessage = (TextView) findViewById(R.id.txtMessage);

        String name = getIntent().getStringExtra(KEY_NAME);
        String password = getIntent().getStringExtra(KEY_PASSWORD);

        if (DEFAULT_NAME.equals(name) && DEFAULT_PASS.equals(password)) {
            txtMessage.setText(getString(R.string.bemvindo_android));
            btAction.setText(getString(R.string.sair));
        } else {
            txtMessage.setVisibility(View.GONE);
            btAction.setText(getString(R.string.voltar));

            if (!toastShowed) {
                Toast.makeText(this, getString(R.string.usuariosenha_invalidos), Toast.LENGTH_LONG).show();
                toastShowed = true;
            }
        }
    }

    @Override
    public String getLogTag() {
        return LOG_TAG;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("toastShowed", toastShowed);
        super.onSaveInstanceState(outState);
    }

    public void onActionClick(View v) {
        finish();
    }

}
