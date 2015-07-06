package br.com.ceducarneiro.exemplolista;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class CityAdapter extends BaseAdapter {

    private List<City> cities;

    public CityAdapter(List<City> cities) {
        this.cities = (cities != null) ?
                cities : new ArrayList<City>();
    }

    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public Object getItem(int position) {
        return position < cities.size() ?
                cities.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.city_item, parent, false);

            holder = new ViewHolder();
            holder.txtCidade = ButterKnife.findById(convertView, R.id.txtCidade);
            holder.txtCondicao = ButterKnife.findById(convertView, R.id.txtCondicao);
            holder.txtTemperatura = ButterKnife.findById(convertView, R.id.txtTemperatura);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        City city = cities.get(position);
        holder.txtCidade.setText(city.getNome());
        holder.txtCondicao.setText(city.getCondicaoClimatica());
        holder.txtTemperatura.setText(city.getTemperatura() + "ºC");

        return convertView;
    }

    static class ViewHolder {
        TextView txtCidade;
        TextView txtCondicao;
        TextView txtTemperatura;
    }

}
