package br.com.ceducarneiro.exemplolista;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;

public class DetailFragment extends Fragment {

    public static final String KEY_CITY = "key_city";

    public static DetailFragment newInstance(City city) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(DetailFragment.KEY_CITY, city);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        City city = (City) getArguments().getSerializable(KEY_CITY);

        if (city != null) {
            TextView txtCidade = ButterKnife.findById(getView(), R.id.txtCidade);
            txtCidade.setText(city.getNome());
        }
    }
}
