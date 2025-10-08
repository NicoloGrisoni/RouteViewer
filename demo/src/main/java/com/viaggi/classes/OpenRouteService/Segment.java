package com.viaggi.classes.OpenRouteService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Segment {
    private double distance;

    public Segment() { }

    @Override
    public String toString() {
        return String.valueOf(Math.round(this.distance / 1000));
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
