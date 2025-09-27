package com.viaggi.classes.OpenRouteService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature {
    private Property properties;

    public Feature() { }

    @Override
    public String toString() {
        return properties.toString();
    }

    public Property getProperties() {
        return properties;
    }

    public void setProperties(Property properties) {
        this.properties = properties;
    }
}