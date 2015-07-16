package br.com.ceducarneiro.exercicioaula4.view.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;

import br.com.ceducarneiro.exercicioaula4.R;
import br.com.ceducarneiro.exercicioaula4.model.Place;
import br.com.ceducarneiro.exercicioaula4.view.main.DetailFragment;

public abstract class BaseActivity extends ActionBarActivity {

    protected boolean isTablet() {
        return getResources().getBoolean(R.bool.isTablet);
    }

    protected void changeDetailFragment(Place place) {
        if (findViewById(R.id.detail) != null) {
            Fragment fragment = DetailFragment.createInstance(place);

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.detail, fragment);
            transaction.commitAllowingStateLoss();
        }
    }

}
