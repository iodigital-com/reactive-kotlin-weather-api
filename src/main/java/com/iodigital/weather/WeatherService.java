package com.iodigital.weather;

import com.iodigital.weather.api.WeatherAPIClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {
    private final WeatherAPIClient api;
    private final WeatherRepository repository;

    public WeatherService(final WeatherAPIClient api, final WeatherRepository repository) {
        this.api = api;
        this.repository = repository;
    }

    public List<WeatherInfo> getAll() {
        return repository.findAll();
    }

    public List<WeatherInfo> getForCity(final String city) {
        final var weatherForCity = repository.findAllByCityIgnoreCase(city);

        if (!weatherForCity.isEmpty()) {
            return weatherForCity;
        }

        final var apiResponse = api.getWeather(city);

        return repository.saveAll(apiResponse.toWeatherInfoList());
    }
}
