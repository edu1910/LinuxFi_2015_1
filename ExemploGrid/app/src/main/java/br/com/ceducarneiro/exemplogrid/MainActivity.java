package br.com.ceducarneiro.exemplogrid;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;


public class MainActivity extends ActionBarActivity {

    @Bind(R.id.gridCities)
    GridView gridCities;

    private CityAdapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuAdd) {
            Toast.makeText(this, "Add!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.menuSeiLa) {
            Toast.makeText(this, "Sei lá!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<City> cities = new ArrayList<>();
        cities.add(new City("João Pessoa", "Chuva pra carmaba", "30"));
        cities.add(new City("Cajazeiras", "Sol até à noite", "45"));
        cities.add(new City("Patos", "Derreteu o termômetro", "58"));
        cities.add(new City("Conde", null, "20"));
        cities.add(new City("Guarabira", null, "32"));

        adapter = new CityAdapter(cities);
        gridCities.setAdapter(adapter);
    }

    @OnItemClick(R.id.gridCities)
    public void onCityClick(int position, long id) {
        Toast.makeText(this, "#"+position+": "
                + adapter.getItem(position), Toast.LENGTH_SHORT).show();
    }
}
