package com.viaggi.classes.OpenRouteService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenRouteService {
    private Feature[] features;

    public OpenRouteService() { }

    @Override
    public String toString() {
        String ret = "";
        for (int i = 0; i < features.length; i++) {
            Feature f = features[i];
            ret += f.toString();
        }
        return ret;
    }

    public Feature[] getFeatures() {
        return features;
    }

    public void setFeatures(Feature[] features) {
        this.features = features;
    }
}