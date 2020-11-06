package com.weatherforecast.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WeatherforecastExceptionHandler {

	@ExceptionHandler(value = WeatherURLNotFoundException.class)
	   public ResponseEntity<Object> exception(WeatherforecastExceptionHandler exception) {
	      return new ResponseEntity<>("URL not found", HttpStatus.NOT_FOUND);
	   }
}
