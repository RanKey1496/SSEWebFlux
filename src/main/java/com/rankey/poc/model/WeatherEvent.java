package com.rankey.poc.model;

import java.time.LocalDateTime;

public class WeatherEvent {

	public WeatherEvent(Weather weather, LocalDateTime updatedAt) {
		super();
		this.weather = weather;
		this.updatedAt = updatedAt;
	}

	private Weather weather;

	private LocalDateTime updatedAt;

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
