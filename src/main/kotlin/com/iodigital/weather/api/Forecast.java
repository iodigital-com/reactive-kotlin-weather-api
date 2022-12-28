package com.iodigital.weather.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Forecast(@JsonProperty("forecastday") List<ForecastDay> days) {
}
