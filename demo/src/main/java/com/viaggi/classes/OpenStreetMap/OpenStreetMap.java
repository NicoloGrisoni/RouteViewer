package com.viaggi.classes.OpenStreetMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenStreetMap {
    public String lat, lon, name;

    public OpenStreetMap() { };

    @Override
    public String toString() {
        String ret = "\r\nName: " + getCityName();
        ret += "\r\n\tLatitude: " + getFloatLat();
        ret += "\r\n\tLongitude: " + getFloatLon();
        return ret;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getCityName() {
        return name;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getFloatLat() {
        return Float.parseFloat(lat);
    }

    public float getFloatLon() {
        return Float.parseFloat(lon);
    }
}
