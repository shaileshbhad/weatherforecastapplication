package com.weatherforecast.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.weatherforecast.services.WeatherForecastService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WeatherForecastController {
	
	@Autowired
	private WeatherForecastService weatherForecastService;
	
	@RequestMapping(value ="/getWeatherByCity/{cityCode}", method= RequestMethod.GET)
	public ResponseEntity<Object>  getWeatherByCity(@PathVariable("cityCode") String cityCode){
			ResponseEntity<Object> obj =weatherForecastService.getWeatherByCity(cityCode);
		return obj;
		
	}
	public ResponseEntity<String> getWeatherForecastByHourly(){
		return null;
	}

}
