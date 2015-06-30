package br.com.ceducarneiro.exercicioaula2_app2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.Optional;


public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.edtPhoneNumber)
    EditText edtPhoneNumber;

    @InjectView(R.id.edtTextToShare)
    EditText edtTextToShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
    }

    public void onApp1Click(View v) {
        Intent it = new Intent();
        it.setAction("aula.android.linuxfi");

        if (it.resolveActivity(getPackageManager()) != null) {
            startActivity(it);
        }
    }

    @OnClick(R.id.btDial)
    public void onDialClick() {
        String number = "tel:"+edtPhoneNumber.getText().toString();

        Intent it = new Intent(Intent.ACTION_CALL);
        it.setData(Uri.parse(number));

        if (it.resolveActivity(getPackageManager()) != null) {
            startActivity(it);
        }
    }

    @OnClick(R.id.btShare)
    public void onShareClick() {
        Intent it = new Intent();
        it.setAction(Intent.ACTION_SEND);
        it.putExtra(Intent.EXTRA_TEXT, edtTextToShare.getText().toString());
        it.setType("text/plain");

        if (it.resolveActivity(getPackageManager()) != null) {
            startActivity(it);
        }
    }

}
