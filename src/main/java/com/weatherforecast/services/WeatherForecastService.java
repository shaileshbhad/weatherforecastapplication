package com.weatherforecast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestTemplate;

import com.weatherforecast.interfaces.WeatherForecastInterface;
import com.weatherforecast.utility.RestHandler;
import com.weatherforecast.utility.WeatherForecastConfig;
import com.weatherforecast.utility.WeatherURLNotFoundException;
import com.weatherforecast.utility.WeatherforecastExceptionHandler;


@Service
public class WeatherForecastService implements WeatherForecastInterface{

	@Autowired
	private RestHandler restHandler;
	private final WeatherForecastConfig config;

	
	public WeatherForecastService(WeatherForecastConfig config) {
		super();
		this.config = config;
	}


	@Override
	@ExceptionHandler
	public ResponseEntity<Object> getWeatherByCity(String cityCode) {
		//Reading base URL and API key from config file
		 final String uri = config.getWeatherUrl()+"?q="+cityCode+"&mode=json&appid="+config.getAppkey()+"&units=metric";
		try {
		 RestTemplate restTemplate = new RestTemplate();
		 ResponseEntity<Object> responseEntity= restTemplate.exchange(uri,HttpMethod.GET,restHandler.getHeader(), Object.class);
		 return responseEntity;
		}
		 catch(Exception e) {  
			 throw new WeatherURLNotFoundException();
		 }
	}

	@Override
	public ResponseEntity<Object> getWeatherForecastByHourly() {
		// TODO Auto-generated method stub
		return null;
	}
}
