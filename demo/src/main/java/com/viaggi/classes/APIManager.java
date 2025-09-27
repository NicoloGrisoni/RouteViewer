package com.viaggi.classes;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import com.viaggi.classes.OpenRouteService.OpenRouteService;
import com.viaggi.classes.OpenStreetMap.OpenStreetMap;
import com.viaggi.classes.OpenWeatherMap.OpenWeatherMap;

public class APIManager {
    private static String GetOpenWeatherMapURL(String city) {
        String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
        String key = APIKeys.OpenWeatherMapKey;
        
        return "https://api.openweathermap.org/data/2.5/weather?q=" + encodedCity + "&appid=" +
        key + "&units=metric";
    }

    private static String GetOpenRouteServiceURL(float latDeparture, float lonDeparture, float latDestination, float lonDestination) {
        String start = URLEncoder.encode(lonDeparture + "," + latDeparture, StandardCharsets.UTF_8);
        String end = URLEncoder.encode(lonDestination + "," + latDestination, StandardCharsets.UTF_8);
        String key = APIKeys.OpenRouteServiceKey;

        return "https://api.openrouteservice.org/v2/directions/driving-car?api_key=" + 
        key +"&start=" + start +"&end="+ end;
    }

    private static String GetOpenStreetMapURL(String city) {
        String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
        return "https://nominatim.openstreetmap.org/search?q=" + encodedCity + "&format=json&addressdetails=1";
    }

    private static String GetJsonResponse(InputStream stream) {
        Scanner sc = new Scanner(stream);
        StringBuilder response = new StringBuilder();
        while (sc.hasNext()) {
            response.append(sc.nextLine());
        }
        sc.close();

        return response.toString();
    }

    public static OpenStreetMap GetCityCoordinates(String city) {
        try {
            String urlString = GetOpenStreetMapURL(city);

            @SuppressWarnings("deprecation")
            URL url = new URL(urlString);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int status = conn.getResponseCode();
            if (status != 200) {
                System.out.println("Request error " + status);
                return null;
            } else {
                String response = GetJsonResponse(url.openStream());
                OpenStreetMap[] results = JsonManager.ParseJsonArray(response, OpenStreetMap[].class);

                if (results != null && results.length > 0) {
                    return results[0];
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static OpenRouteService GetCitiesDistance(OpenStreetMap departure, OpenStreetMap destination) {
        try {
            String urlString = GetOpenRouteServiceURL(
                departure.getFloatLat(), 
                departure.getFloatLon(),
                destination.getFloatLat(),
                destination.getFloatLon()
            );

            @SuppressWarnings("deprecation")
            URL url = new URL(urlString);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int status = conn.getResponseCode();
            if (status != 200) {
                System.out.println("Request error " + status);
                return null;
            } else {
                String response = GetJsonResponse(url.openStream());
                OpenRouteService results = JsonManager.ParseJson(response, OpenRouteService.class);
                return results;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static OpenWeatherMap GetCityWeather(String city) {
        try {
            String urlString = GetOpenWeatherMapURL(city);

            @SuppressWarnings("deprecation")
            URL url = new URL(urlString);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int status = conn.getResponseCode();
            if (status != 200) {
                System.out.println("Request error " + status);
                return null;
            } else {
                String response = GetJsonResponse(url.openStream());
                OpenWeatherMap results = JsonManager.ParseJson(response, OpenWeatherMap.class);
                return results;
            }
        } catch (Exception e) {
            return null;
        }
    }
}