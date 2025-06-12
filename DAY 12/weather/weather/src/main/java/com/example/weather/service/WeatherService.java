package com.example.weather.service;

import com.example.weather.entity.WeatherForecast;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.*;

@Service
public class WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();

    // Simulated Excel Mapping: City -> [Latitude, Longitude]
    private final Map<String, double[]> cityCoordinates = Map.of(
            "Delhi", new double[]{28.6139, 77.2090},
            "Mumbai", new double[]{19.0760, 72.8777},
            "Chennai", new double[]{13.0827, 80.2707},
            "Kolkata", new double[]{22.5726, 88.3639}
    );

    public List<WeatherForecast> get7DayForecast(String city) {
        if (!cityCoordinates.containsKey(city)) {
            throw new IllegalArgumentException("City not found");
        }

        double[] coords = cityCoordinates.get(city);
        String url = UriComponentsBuilder.fromHttpUrl("https://api.open-meteo.com/v1/forecast")
                .queryParam("latitude", coords[0])
                .queryParam("longitude", coords[1])
                .queryParam("daily", "temperature_2m_max")
                .queryParam("timezone", "auto")
                .toUriString();

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        Map<String, List<Object>> daily = (Map<String, List<Object>>) response.get("daily");

        List<Object> dates = daily.get("time");
        List<Object> temps = daily.get("temperature_2m_max");

        List<WeatherForecast> forecasts = new ArrayList<>();
        for (int i = 0; i < dates.size(); i++) {
            forecasts.add(new WeatherForecast(
                    LocalDate.parse((String) dates.get(i)),
                    ((Number) temps.get(i)).doubleValue(),
                    0, // Humidity placeholder
                    0  // Wind speed placeholder
            ));
        }

        return forecasts;
    }

    public Map<String, List<WeatherForecast>> compareForecasts(String city1, String city2) {
        List<WeatherForecast> forecast1 = get7DayForecast(city1);
        List<WeatherForecast> forecast2 = get7DayForecast(city2);

        Map<String, List<WeatherForecast>> result = new HashMap<>();
        result.put(city1, forecast1);
        result.put(city2, forecast2);
        return result;
    }
}
