package com.weatherforecast.interfaces;

import org.springframework.http.ResponseEntity;

public interface WeatherForecastInterface {

	public ResponseEntity<Object>  getWeatherByCity(String cityCode);
	public ResponseEntity<Object> getWeatherForecastByHourly();
}
