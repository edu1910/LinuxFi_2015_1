package br.com.ceducarneiro.exemplolista;

import android.support.v7.app.ActionBarActivity;

abstract public class BaseActivity extends ActionBarActivity {

    public boolean isTablet() {
        return getResources().getBoolean(R.bool.isTablet);
    }

}
