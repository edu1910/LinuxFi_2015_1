package br.com.ceducarneiro.exercicioaula4.view.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.ceducarneiro.exercicioaula4.R;
import br.com.ceducarneiro.exercicioaula4.model.Place;
import butterknife.ButterKnife;

public class DetailFragment extends Fragment {

    private static final String KEY_PLACE = "key_place";

    public static DetailFragment createInstance(Place place) {
        DetailFragment fragment = new DetailFragment();

        if (place != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(KEY_PLACE, place);
            fragment.setArguments(bundle);
        }

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);

        Place place = null;

        if (getArguments() != null && getArguments().keySet().contains(KEY_PLACE)) {
            place = (Place) getArguments().getSerializable(KEY_PLACE);
        }

        if (place != null) {
            TextView txtName = ButterKnife.findById(v, R.id.txtName);
            TextView txtTemperature = ButterKnife.findById(v, R.id.txtTemperature);
            TextView txtHumidity = ButterKnife.findById(v, R.id.txtHumidity);
            TextView txtPressure = ButterKnife.findById(v, R.id.txtPressure);
            TextView txtWindDirection = ButterKnife.findById(v, R.id.txtWindDirection);
            TextView txtWindSpeed = ButterKnife.findById(v, R.id.txtWindSpeed);
            TextView txtUpdate = ButterKnife.findById(v, R.id.txtUpdate);

            txtName.setText(place.getName());
            txtTemperature.setText(place.getWeather().getTemperature()+"º");
            txtHumidity.setText(place.getWeather().getHumidity());
            txtPressure.setText(place.getWeather().getPressure());
            txtWindDirection.setText(place.getWeather().getWindDirection());
            txtWindSpeed.setText(place.getWeather().getWindSpeed());
            txtUpdate.setText(place.getWeather().getLastUpdate());

            ButterKnife.findById(v, R.id.placeholder).setVisibility(View.INVISIBLE);
        } else {
            ButterKnife.findById(v, R.id.placeholder).setVisibility(View.VISIBLE);
        }

        return v;
    }
}
