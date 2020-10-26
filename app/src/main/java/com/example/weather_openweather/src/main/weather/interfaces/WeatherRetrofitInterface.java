package com.example.weather_openweather.src.main.weather.interfaces;

import com.example.weather_openweather.src.main.weather.models.CurrentWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherRetrofitInterface {
    @GET("/weather")
    Call<CurrentWeather> getCurrentWeather(
            @Query("lat") int lat,
            @Query("lon") int lon,
            @Query("appid") String API_KEY
    );

}
