package br.com.ceducarneiro.exercicioaula4.model;

import java.io.Serializable;

public class Weather implements Serializable {

    private String condition;
    private String temperature;
    private String humidity;
    private String windDirection;
    private String windSpeed;
    private String pressure;
    private String icon;
    private String lastUpdate;

    public Weather() {
        /* Empty */
    }

    public Weather(String condition, String temperature, String humidity,
                   String windDirection, String windSpeed, String pressure,
                   String icon, String lastUpdate) {
        setCondition(condition);
        setTemperature(temperature);
        setHumidity(humidity);
        setWindDirection(windDirection);
        setWindSpeed(windSpeed);
        setPressure(pressure);
        setIcon(icon);
        setLastUpdate(lastUpdate);
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
