package com.viaggi.classes.OpenWeatherMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherMap {
    private Weather[] weather;
    private MainCondition main;

    public OpenWeatherMap () { }

    @Override
    public String toString() {
        String ret = "";
        for (int i = 0; i < weather.length; i++) {
            Weather w = weather[i];
            ret += w.toString() + "\r\n";
        }
        ret += main.toString();
        return ret;
    }

    public Weather[] getWeather() {
        return weather;
    }
    public void setWeather(Weather[] weathers) {
        this.weather = weathers;
    }
    public MainCondition getMain() {
        return main;
    }
    public void setMain(MainCondition main) {
        this.main = main;
    }
}
