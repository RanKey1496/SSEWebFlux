package com.rankey.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rankey.poc.model.Weather;
import com.rankey.poc.service.WeatherService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@GetMapping(path = "/string", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> streamFlux() {
		return weatherService.streamString();
	}

	@GetMapping(path = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Weather> getAll() {
		return weatherService.getAll();
	}

	@GetMapping(path = "/events/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Object> streamFlux(@PathVariable("id") String id) {
		return weatherService.streamEvents(id);
	}

	@PostMapping(path = "")
	public Mono<Weather> save(@RequestBody Weather weather) {
		return weatherService.save(weather);
	}

}
