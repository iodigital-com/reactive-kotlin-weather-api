package com.iodigital.weather;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends ListCrudRepository<WeatherInfo, Long> {
    List<WeatherInfo> findAllByCityIgnoreCase(final String city);
}
