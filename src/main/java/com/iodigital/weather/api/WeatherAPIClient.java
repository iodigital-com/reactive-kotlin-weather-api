package com.iodigital.weather.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherAPIClient {
    private static final Logger log = LoggerFactory.getLogger(WeatherAPIClient.class);

    private final RestTemplate http;
    private final String host;
    private final String apiKey;

    public WeatherAPIClient(
            final RestTemplate http,
            @Value("${weatherapi.host}") final String host,
            @Value("${weatherapi.api-key}") final String apiKey
    ) {
        this.http = http;
        this.host = host;
        this.apiKey = apiKey;
    }

    public WeatherAPIResponse getWeather(final String city) {
        log.info("Getting weather forecast for {}", city);

        final var response = http
                .getForObject(
                        "%s/v1/forecast.json?key=%s&q=%s&days=7".formatted(host, apiKey, city),
                        WeatherAPIResponse.class
                );

        log.info("Weather forecast for city {}: {}", city, response);

        return response;
    }
}
