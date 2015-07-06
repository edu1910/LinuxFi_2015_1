package br.com.ceducarneiro.exercicioaula3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity implements DialogInterface.OnClickListener {

    private AlertDialog confirmDialog;

    @Bind(R.id.edtServiceOrder)
    EditText edtServiceOrder;

    @Bind(R.id.edtPhoneNumber)
    EditText edtPhoneNumber;

    @Bind(R.id.edtName)
    EditText edtName;

    @Bind(R.id.edtDescription)
    EditText edtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (confirmDialog != null && confirmDialog.isShowing())
            confirmDialog.dismiss();
    }

    @OnClick(R.id.btSave)
    public void onSaveClick() {
        boolean error = false;

        if (edtPhoneNumber.getText().toString().isEmpty()) {
            edtPhoneNumber.setError("Você deve preencher o número do telefone");
            error = true;
        }

        if (edtName.getText().toString().isEmpty()) {
            edtName.setError("Você deve preencher o nome do cliente");
            error = true;
        }

        if (!error) {
            if (confirmDialog != null && confirmDialog.isShowing())
                confirmDialog.dismiss();

            confirmDialog = new AlertDialog.Builder(this)
                    .setTitle("Confirmação")
                    .setMessage("Esta ação irá salvar os dados fornecidos. Deseja continuar?")
                    .setPositiveButton(android.R.string.yes, this)
                    .setNegativeButton(android.R.string.no, null)
                    .show();
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        edtServiceOrder.setText(null);
        edtPhoneNumber.setText(null);
        edtName.setText(null);
        edtDescription.setText(null);

        Toast.makeText(this, "Sucesso!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed() {
        if (confirmDialog != null && confirmDialog.isShowing())
            confirmDialog.dismiss();

        confirmDialog = new AlertDialog.Builder(this)
                .setTitle("Confirmação")
                .setMessage("Deseja sair da aplicação?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .show();
    }
}
