# RouteViewer
This project is made in Java with Maven. It functions  Its main goal is helping people visualize their route during a travel, with information as the actual weather in every cities and the distance between each other, with a final recap of all the kilometers made. In order to function, this project uses some external services, in particular OpenWeatherMap, OpenRouteService and OpenStreetMap.
<br>

## ⚠️Important
This project runs as a **command-line interface (CLI)** application.  
It does **not** provide a graphical user interface (GUI).
<br>

## ⚙️ API Keys Configuration
The services used in this project required API keys, except for OpenStreetMap. To use the project, follow this instructions:
1. Create a file named `APIKeys.java` in this folder 'src/main/java/com/viaggi/classes/'
2. Copy the content of file 'APIKeys.java' given down here and insert your personal API keys:
```java
package com.viaggi.classes;

public class APIKeys {
    public static final String OpenWeatherMapKey = "YOUR API KEY";
    public static final String OpenRouteServiceKey = "YOUR API KEY";
}
