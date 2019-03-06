package com.rankey.poc.service;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rankey.poc.model.Weather;
import com.rankey.poc.repository.WeatherRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository weatherRepository;

	public Mono<Weather> getById(String id) {
		System.out.println(id);
		return weatherRepository.findById(id);
	}

	public Flux<Weather> getAll() {
		Flux<Long> interval = Flux.interval(Duration.ofMillis(250));
		return interval.flatMap(s -> {
			return weatherRepository.findAll();
		});
	}

	public Flux<Object> streamEvents(String id) {
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
		return interval.flatMap(s -> {
			return weatherRepository.findById(id);
		});
	}

	public Flux<String> streamString() {
		return Flux.interval(Duration.ofSeconds(1)).map(secuence -> "Flux - " + LocalDateTime.now().toString());
	}

	public Mono<Weather> save(Weather weather) {
		return weatherRepository.save(weather);
	}

}
