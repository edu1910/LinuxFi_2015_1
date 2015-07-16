package br.com.ceducarneiro.exercicioaula4.view.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.ceducarneiro.exercicioaula4.R;
import br.com.ceducarneiro.exercicioaula4.model.Place;
import butterknife.ButterKnife;

public class ListFragment extends Fragment implements AdapterView.OnItemClickListener, SearchView.OnQueryTextListener {

    private ListListener listener;
    private List<Place> places = new ArrayList<>();
    private PlaceAdapter adapter;
    private MenuItem searchItem;
    private ListView listPlaces;
    private SearchView searchView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        //TODO: dados fake no adapter
        places = new ArrayList<>();
        places.add(new Place("João Pessoa", "BR", "Parcialmente nublado", "20", "90", "300.00", "10,2", "1034", "", ""));
        places.add(new Place("Cabedelo", "BR", "Parcialmente nublado", "20", "90", "300.00", "10,2", "1034", "", ""));
        places.add(new Place("Fortaleza", "BR", "Parcialmente nublado", "20", "90", "300.00", "10,2", "1034", "", ""));
        places.add(new Place("Campina Grande", "BR", "Parcialmente nublado", "20", "90", "300.00", "10,2", "1034", "", ""));
        places.add(new Place("Patos", "BR", "Ensolarado", "40", "90", "300.00", "10,2", "1034", "", ""));

        adapter = new PlaceAdapter(places);

        listPlaces = ButterKnife.findById(v, R.id.listPlaces);
        listPlaces.setAdapter(adapter);

        listPlaces.setOnItemClickListener(this);

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_list, menu);

        searchItem = menu.findItem(R.id.menuSearch);

        if (searchItem != null) {
            searchView = (SearchView) MenuItemCompat
                    .getActionView(searchItem);

            if (searchView != null)
                searchView.setOnQueryTextListener(this);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuAdd) {
            if (listener != null) {
                listener.onAddPlaceClick();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listener = (ListListener) getActivity();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (listener != null) {
            listener.onPlaceClick((Place) adapter.getItem(position));
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        adapter = new PlaceAdapter(places);
        listPlaces.setAdapter(adapter);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        List<Place> newPlaces = new ArrayList<>();

        for (Place place : places) {
            if (place.getName().contains(newText)) {
                newPlaces.add(place);
            }
        }

        adapter = new PlaceAdapter(newPlaces);
        listPlaces.setAdapter(adapter);

        return true;
    }
}
