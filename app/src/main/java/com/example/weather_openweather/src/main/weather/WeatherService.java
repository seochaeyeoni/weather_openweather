package com.example.weather_openweather.src.main.weather;

import android.util.Log;

import com.example.weather_openweather.src.ApplicationClass;
import com.example.weather_openweather.src.main.weather.interfaces.WeatherRetrofitInterface;
import com.example.weather_openweather.src.main.weather.interfaces.WeatherView;
import com.example.weather_openweather.src.main.weather.models.CurrentWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherService {
    private final WeatherView mWeatherView;

    WeatherService(final WeatherView weatherView) {
        this.mWeatherView = weatherView;
    }

    String API_KEY = "9624f5754e9546192d5c78282c452fd3";
    void getCurrentWeather() {
        final WeatherRetrofitInterface weatherRetrofitInterface = ApplicationClass.getRetrofit().create(WeatherRetrofitInterface.class);
        weatherRetrofitInterface.getCurrentWeather(37,127, API_KEY).enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                Log.v("network","fine");
                final CurrentWeather currentWeather = response.body();
                if (currentWeather == null) {
                    mWeatherView.currentWeatherFailure(null);
                    return;
                }

                mWeatherView.currentWeatherSuccess(currentWeather);
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                mWeatherView.currentWeatherFailure(null);
            }
        });
    }
}
