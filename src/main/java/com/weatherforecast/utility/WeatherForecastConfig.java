package com.weatherforecast.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:weatherForecast.properties")
public class WeatherForecastConfig {

	@Value("${api.appKey}")
    private String appkey;

    @Value("${api.url.weather}")
    private String weatherUrl;

    public String getAppkey() {
        return appkey;
    }

    public String getWeatherUrl() {
        return weatherUrl;
    }
}
