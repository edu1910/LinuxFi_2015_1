package br.com.ceducarneiro.exercicioaula4.view.main;

import android.os.Bundle;

import br.com.ceducarneiro.exercicioaula4.R;
import br.com.ceducarneiro.exercicioaula4.model.Place;
import br.com.ceducarneiro.exercicioaula4.view.base.BaseActivity;

public class DetailActivity extends BaseActivity {

    public static final String KEY_PLACE = "key_place";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Place place = null;

        if (getIntent().hasExtra(KEY_PLACE)) {
            place = (Place) getIntent().getSerializableExtra(KEY_PLACE);
        }

        setContentView(R.layout.activity_detail);
        changeDetailFragment(place);
    }
}
