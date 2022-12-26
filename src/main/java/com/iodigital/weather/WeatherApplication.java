package com.iodigital.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.client.reactive.ReactorResourceFactory;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@EnableR2dbcRepositories
@SpringBootApplication
public class WeatherApplication {
    @Bean
    public ReactorResourceFactory resourceFactory() {
        return new ReactorResourceFactory();
    }

    @Bean
    public WebClient webClient() {
        return WebClient
            .builder()
            .clientConnector(
                new ReactorClientHttpConnector(
                    resourceFactory(),
                    client -> client.responseTimeout(Duration.ofSeconds(10))
                )
            )
            .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(WeatherApplication.class, args);
    }
}
