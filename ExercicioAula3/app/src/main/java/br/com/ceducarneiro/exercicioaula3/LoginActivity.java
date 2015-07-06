package br.com.ceducarneiro.exercicioaula3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btEnter)
    public void onEnterClick() {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();
    }

}
