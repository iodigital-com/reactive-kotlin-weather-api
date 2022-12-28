package com.iodigital.weather;

import com.iodigital.weather.api.WeatherAPIClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class WeatherService {
    private final WeatherAPIClient api;
    private final WeatherRepository repository;

    public WeatherService(final WeatherAPIClient api, final WeatherRepository repository) {
        this.api = api;
        this.repository = repository;
    }

    public Flux<WeatherInfo> getAll() {
        return repository.findAll();
    }

    public Flux<WeatherInfo> getForCity(final String city) {
        return repository
            .findAllByCityIgnoreCase(city)
            .switchIfEmpty(
                api
                    .getWeather(city)
                    .flatMapMany(apiResponse -> repository.saveAll(apiResponse.toWeatherInfoList()))
            );
    }
}
