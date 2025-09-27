package com.viaggi.classes;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonManager {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T ParseJson(String json, Class<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T[] ParseJsonArray(String jsonString, Class<T[]> type) {
        try {
            return mapper.readValue(jsonString, type);
        } catch (Exception e) {
            return null;
        }
    }
}