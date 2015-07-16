package br.com.ceducarneiro.exercicioaula4.view.main;

import android.content.Intent;
import android.os.Bundle;

import br.com.ceducarneiro.exercicioaula4.R;
import br.com.ceducarneiro.exercicioaula4.model.Place;
import br.com.ceducarneiro.exercicioaula4.view.addplace.AddPlaceActivity;
import br.com.ceducarneiro.exercicioaula4.view.base.BaseActivity;

public class MainActivity extends BaseActivity implements ListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isTablet()) {
            changeDetailFragment(null);
        }
    }

    @Override
    public void onPlaceClick(Place place) {
        if (isTablet()) {
            changeDetailFragment(place);
        } else {
            Intent it = new Intent(this, DetailActivity.class);

            if (place != null)
                it.putExtra(DetailActivity.KEY_PLACE, place);

            startActivity(it);
        }
    }

    @Override
    public void onAddPlaceClick() {
        Intent it = new Intent(this, AddPlaceActivity.class);
        startActivity(it);
    }
}
