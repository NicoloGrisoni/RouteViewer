package com.viaggi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.viaggi.classes.APIManager;
import com.viaggi.classes.OpenRouteService.OpenRouteService;
import com.viaggi.classes.OpenStreetMap.OpenStreetMap;
import com.viaggi.classes.OpenWeatherMap.OpenWeatherMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            List<String> cities = new ArrayList<String>();

            System.out.print("Insert the names of the cities separated with the comma: ");
            String input = scanner.nextLine();
            String[] fields = input.split(",");

            for (String s : fields) {
                cities.add(s);
            }

            double totalKm = 0;
            for (int i = 0; i < cities.size() - 1; i++) {
                System.out.println("\r\nTravel n°" + (i + 1));

                String departureName = cities.get(i), 
                    destinationName = cities.get(i + 1);

                OpenStreetMap departure = APIManager.GetCityCoordinates(departureName),
                    destination = APIManager.GetCityCoordinates(destinationName);

                OpenWeatherMap departureWeather = APIManager.GetCityWeather(departureName),
                    destinationWeather = APIManager.GetCityWeather(destinationName);

                OpenRouteService distance = APIManager.GetCitiesDistance(departure, destination);

                System.out.println(departureName + " weather: " + departureWeather.toString());
                System.out.println("\r\n" + destinationName + " weather: " + destinationWeather.toString());
                System.out.println("\r\nDistance " + departureName + "-" + destinationName + " : " + distance.toString() + " km\r\n");

                totalKm += Double.parseDouble(distance.toString());
            }

            System.out.println("\r\nTotal of km: " + Math.round(totalKm) + " km");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}

/*
    Creare in Java un programma cli che dia la possibilità di gestire le tappe per un viaggio "concatenato":
    l'utente deve inserire le tappe che vuole visitare in ordine ( ad esempio Mariano comense, Milano, Torino, Genova, Savona ) 
    al termine dell'inserimento, l'utente dovrà visualizzare: 
        - km di strada tra una tappa e l'altra 
        - condizioni meteo generali della giornata in quella città ( meteo, temp min e max )
        - km totali del viaggio

    usare i servizi:
        openrouteservice: https://openrouteservice.org/dev/#/api-docs/v2/directions/{profile}/get
        meteo:  https://openweathermap.org
        openStreetMap: https://nominatim.openstreetmap.org/search?q=RICERCA&format=json&addressdetails=1
        modificare il campo "ricerca" passando una stringa da cercare ( tipo: "mariano comense" o "seregno" )
 */