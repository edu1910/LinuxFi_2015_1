package br.com.ceducarneiro.exemplolista;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class DetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        City city = (City) getIntent().getSerializableExtra(DetailFragment.KEY_CITY);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        DetailFragment fragment = DetailFragment.newInstance(city);

        transaction.replace(R.id.detail, fragment);

        transaction.commitAllowingStateLoss();
    }
}
