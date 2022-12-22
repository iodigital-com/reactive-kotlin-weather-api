package com.iodigital.weather.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Temperature(@JsonProperty("avgtemp_f") double avgF) {
}
