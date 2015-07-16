package br.com.ceducarneiro.exercicioaula4.view.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.ceducarneiro.exercicioaula4.R;
import br.com.ceducarneiro.exercicioaula4.controller.ExercicioAppController;
import br.com.ceducarneiro.exercicioaula4.model.Place;
import butterknife.ButterKnife;

public class PlaceAdapter extends BaseAdapter {

    private List<Place> places;

    public PlaceAdapter(List<Place> places) {
        this.places = places;
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Object getItem(int position) {
        return places.get(position);
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

            convertView = inflater.inflate(R.layout.item_place, parent, false);
            holder = new ViewHolder();
            holder.imgIcon = ButterKnife.findById(convertView, R.id.imgIcon);
            holder.txtName = ButterKnife.findById(convertView, R.id.txtName);
            holder.txtCondition = ButterKnife.findById(convertView, R.id.txtCondition);
            holder.txtTemperature = ButterKnife.findById(convertView, R.id.txtTemperature);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Place place = places.get(position);
        //TODO: holder.imgIcon.setImageDrawable();
        holder.txtName.setText(place.getName() + ", " + place.getCountry());
        holder.txtCondition.setText(place.getWeather().getCondition());
        holder.txtTemperature.setText(place.getWeather().getTemperature()+"º");

        return convertView;
    }

    static class ViewHolder {
        ImageView imgIcon;
        TextView txtName;
        TextView txtCondition;
        TextView txtTemperature;
    }
}
