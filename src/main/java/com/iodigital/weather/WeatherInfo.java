package com.iodigital.weather;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.StringJoiner;

public class WeatherInfo {
    @Id
    private Long id;
    private String region;
    private String country;
    private String state;
    private String city;
    private LocalDate localDate;
    private String avgTemperature;

    public WeatherInfo() {
    }

    public WeatherInfo(Long id, String region, String country, String state, String city, LocalDate localDate, String avgTemperature) {
        this.id = id;
        this.region = region;
        this.country = country;
        this.state = state;
        this.city = city;
        this.localDate = localDate;
        this.avgTemperature = avgTemperature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getAvgTemperature() {
        return avgTemperature;
    }

    public void setAvgTemperature(String avgTemperature) {
        this.avgTemperature = avgTemperature;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", WeatherInfo.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("region='" + region + "'")
                .add("country='" + country + "'")
                .add("state='" + state + "'")
                .add("city='" + city + "'")
                .add("localDate=" + localDate)
                .add("avgTemperature='" + avgTemperature + "'")
                .toString();
    }
}
