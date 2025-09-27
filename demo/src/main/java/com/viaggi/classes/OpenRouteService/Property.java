package com.viaggi.classes.OpenRouteService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Property {
    private Segment[] segments;

    public Property() { }

    @Override
    public String toString() {
        String ret = "";
        for (int i = 0; i < segments.length; i++) {
            Segment f = segments[i];
            ret += f.toString();
        }
        return ret;
    }

    public Segment[] getSegments() {
        return segments;
    }

    public void setSegments(Segment[] segments) {
        this.segments = segments;
    }
}