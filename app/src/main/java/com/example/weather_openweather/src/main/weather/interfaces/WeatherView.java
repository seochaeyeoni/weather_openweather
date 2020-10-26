package com.example.weather_openweather.src.main.weather.interfaces;

import com.example.weather_openweather.src.main.weather.models.CurrentWeather;

public interface WeatherView {
    void currentWeatherSuccess(CurrentWeather currentWeather);

    void currentWeatherFailure(String message);
}
