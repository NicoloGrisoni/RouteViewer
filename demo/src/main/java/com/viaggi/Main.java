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
        //Variable scanner as user input
        Scanner scanner = new Scanner(System.in);

        try {
            //List of strings to save the name of every city
            List<String> cities = new ArrayList<String>();

            System.out.print("Please, insert the names of the cities in your route separated with the comma: ");
            String input = scanner.nextLine();
            String[] fields = input.split(",");

            //Adding the name of every city into the list
            for (String s : fields) {
                cities.add(s.replaceFirst(" ", ""));
            }

            //Printing the weather of every city
            System.out.println("Here's the weather right now in every city you have mentioned in your route...");
            for (int i = 0; i < cities.size(); i++) {
                String name = cities.get(i);
                OpenWeatherMap weather = APIManager.GetCityWeather(name);
                System.out.println(name + " weather: " + weather.toString() + "\r\n");
            }

            //Printing the distances between the cities mentioned
            System.out.println("And now, here's the distance between the cities which compose your route...");

            int totalKm = 0;
            for (int i = 0; i < cities.size() - 1; i++) {
                System.out.println("Stage n°" + (i + 1));

                String departureName = cities.get(i), 
                    destinationName = cities.get(i + 1);

                OpenStreetMap departure = APIManager.GetCityCoordinates(departureName),
                    destination = APIManager.GetCityCoordinates(destinationName);

                OpenRouteService distance = APIManager.GetCitiesDistance(departure, destination);

                System.out.println(departureName + " - " + destinationName + ": " + distance.toString() + " km\r\n");
                totalKm += Double.parseDouble(distance.toString());
            }

            //Printing the sum of all the kilometers made by doing this travel
            System.out.println("The total of kilometers you will made by doing this travel are " + totalKm + " km");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}