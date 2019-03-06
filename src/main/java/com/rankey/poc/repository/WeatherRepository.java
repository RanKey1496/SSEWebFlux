package com.rankey.poc.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.rankey.poc.model.Weather;

@Repository
public interface WeatherRepository extends ReactiveMongoRepository<Weather, String> {

}
