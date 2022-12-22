package com.iodigital.weather.api;

import com.iodigital.weather.WeatherInfo;

import java.util.List;

public record WeatherAPIResponse(Location location, Forecast forecast) {
    public List<WeatherInfo> toWeatherInfoList() {
        final var region = location.region();
        final var country = location.country();
        final var city = location.city();
        return forecast.days().stream().map(f ->
                new WeatherInfo(
                        null,
                        region,
                        country,
                        "",
                        city,
                        f.date(),
                        "%.2f".formatted(f.temperature().avgF())
                )
        ).toList();
    }
}
