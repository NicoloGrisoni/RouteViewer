package com.viaggi.classes.OpenWeatherMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MainCondition {
    private double temp_min, temp_max;

    public MainCondition() { }

    @Override
    public String toString() {
        String ret = "";
        ret += "min temp: " + Math.round(this.temp_min) + "\r\n";
        ret += "max temp: " + Math.round(this.temp_max);
        return ret;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }
}