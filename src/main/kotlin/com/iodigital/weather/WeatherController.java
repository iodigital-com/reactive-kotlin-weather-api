package com.iodigital.weather;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService service;

    public WeatherController(final WeatherService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<WeatherInfo> getAll() {
        return service.getAll();
    }

    @GetMapping("/city/{city}")
    public Flux<WeatherInfo> getForCity(@PathVariable final String city) {
        return service.getForCity(city);
    }
}
