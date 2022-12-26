package com.iodigital.weather;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface WeatherRepository extends ReactiveCrudRepository<WeatherInfo, Long> {
    Flux<WeatherInfo> findAllByCityIgnoreCase(final String city);
}
