package com.example.weather.controller;

import com.example.weather.entity.WeatherForecast;
import com.example.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    // Default formatted 7-day forecast for one city
    @GetMapping("/{city}")
    public String getFormattedForecast(@PathVariable String city) {
        List<WeatherForecast> forecastList = weatherService.get7DayForecast(city);
        StringBuilder sb = new StringBuilder();

        for (WeatherForecast f : forecastList) {
            sb.append(f.getDate())
                    .append(": Temp=").append(f.getTemperature()).append("°C")
                    .append(", Humidity=").append(f.getHumidity()).append("%")
                    .append(", Wind=").append(f.getWindSpeed()).append(" km/h")
                    .append(System.lineSeparator())
                    .append("<br>");
        }

        return sb.toString();
    }

    // JSON response
    @GetMapping("/{city}/json")
    public List<WeatherForecast> getJsonForecast(@PathVariable String city) {
        return weatherService.get7DayForecast(city);
    }

    // JSON comparison of two cities
    @GetMapping("/compare")
    public Map<String, List<WeatherForecast>> compareForecasts(@RequestParam String city1,
                                                               @RequestParam String city2) {
        return weatherService.compareForecasts(city1, city2);
    }

    // Formatted comparison of two cities
    @GetMapping("/compare/formatted")
    public String compareForecastsFormatted(@RequestParam String city1,
                                            @RequestParam String city2) {
        Map<String, List<WeatherForecast>> forecasts = weatherService.compareForecasts(city1, city2);
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, List<WeatherForecast>> entry : forecasts.entrySet()) {
            String city = entry.getKey();
            for (WeatherForecast f : entry.getValue()) {
                sb.append(city)
                        .append(" - ")
                        .append(f.getDate())
                        .append(": Temp=").append(f.getTemperature()).append("°C")
                        .append(", Humidity=").append(f.getHumidity()).append("%")
                        .append(", Wind=").append(f.getWindSpeed()).append(" km/h")
                        .append("| |")
                        .append("<br>");
            }
        }

        return sb.toString();
    }
}
