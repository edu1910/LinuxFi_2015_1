package br.com.ceducarneiro.exercicioaula4.model;

import java.io.Serializable;

public class Place implements Serializable {

    private  String name;
    private  String country;
    private  Weather weather = new Weather();

    public Place() {
        /* Empty */
    }

    public Place(String name, String country,
                 String condition, String temperature, String humidity,
                 String windDirection, String windSpeed, String pressure,
                 String icon, String lastUpdate) {
        setName(name);
        setCountry(country);
        setWeather(new Weather(condition, temperature, humidity,
                windDirection, windSpeed, pressure,
                icon, lastUpdate));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}
