package br.com.ceducarneiro.exemplolista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;


public class MainActivity extends BaseActivity implements ListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCityClick(int position, City city) {
        Toast.makeText(this, "#" + position + ": "
                + city, Toast.LENGTH_LONG).show();

        if (isTablet()) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            DetailFragment fragment = DetailFragment.newInstance(city);

            transaction.replace(R.id.detail, fragment);

            transaction.commitAllowingStateLoss();
        } else {
            Intent it = new Intent(this, DetailActivity.class);
            it.putExtra(DetailFragment.KEY_CITY, city);
            startActivity(it);
        }
    }

}

interface ListListener {
    void onCityClick(int position,City city);
}
