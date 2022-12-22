package com.iodigital.weather.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Location(
        @JsonProperty("name") String city,
        String region,
        String country
) {
}
