package com.iodigital.weather.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class WeatherAPIClient {
    private static final Logger log = LoggerFactory.getLogger(WeatherAPIClient.class);

    private final WebClient http;
    private final String host;
    private final String apiKey;

    public WeatherAPIClient(
        final WebClient http,
        @Value("${weatherapi.host}") final String host,
        @Value("${weatherapi.api-key}") final String apiKey
    ) {
        this.http = http;
        this.host = host;
        this.apiKey = apiKey;
    }

    public Mono<WeatherAPIResponse> getWeather(final String city) {
        return http
            .get()
            .uri("%s/v1/forecast.json?key=%s&q=%s&days=7".formatted(host, apiKey, city))
            .exchangeToMono(response -> response.bodyToMono(WeatherAPIResponse.class))
            .doFirst(() -> log.info("Getting weather forecast for city {}", city))
            .doOnError(e -> log.error("Cannot get weather forecast for %s".formatted(city), e))
            .doOnSuccess(response -> log.info("Weather forecast for city {}: {}", city, response));
    }
}
