package br.com.ceducarneiro.exemplolista;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class ListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListListener listener;
    private CityAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        List<City> cities = new ArrayList<>();
        cities.add(new City("João Pessoa", "Chuva pra carmaba", "30"));
        cities.add(new City("Cajazeiras", "Sol até à noite", "45"));
        cities.add(new City("Patos", "Derreteu o termômetro", "58"));

        adapter = new CityAdapter(cities);
        ListView listCities = ButterKnife.findById(view, R.id.listCities);
        listCities.setAdapter(adapter);

        listCities.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listener = (ListListener) getActivity();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        listener.onCityClick(position, (City) adapter.getItem(position));
    }
}
