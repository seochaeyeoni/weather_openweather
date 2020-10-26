package com.example.weather_openweather.src.main.weather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.weather_openweather.R;
import com.example.weather_openweather.src.main.weather.interfaces.WeatherView;
import com.example.weather_openweather.src.main.weather.models.CurrentWeather;

public class WeatherFrag extends Fragment implements WeatherView {

    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_weather, container, false);

        TextView weather_city = (TextView) view.findViewById(R.id.weather_city_name);
        TextView weather_condition = (TextView) view.findViewById(R.id.weather_condition);
        ImageView weather_image = (ImageView) view.findViewById(R.id.weather_image);
        TextView weather_temp = (TextView) view.findViewById(R.id.weather_temp);
        TextView weather_temp_max_min = (TextView) view.findViewById(R.id.weather_temp_max_min);

        tryGetTest();
        return view;
    }



    private void tryGetTest() {

        final WeatherService weatherService = new WeatherService(this);
        weatherService.getCurrentWeather();
    }



    @Override
    public void currentWeatherSuccess(CurrentWeather currentWeather) {
        TextView weather_city = (TextView) view.findViewById(R.id.weather_city_name);
        TextView weather_condition = (TextView) view.findViewById(R.id.weather_condition);
        weather_city.setText(currentWeather.getName());
        weather_condition.setText(currentWeather.getWeather().get(0).getMain());

    }

    @Override
    public void currentWeatherFailure(@Nullable String message) {

    }
}
