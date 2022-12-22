package com.iodigital.weather.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record ForecastDay(LocalDate date, @JsonProperty("day") Temperature temperature) {
}
