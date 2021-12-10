package com.example.highlightapplication.ui.Weather;

import android.util.Log;

import com.example.highlightapplication.GlobalCity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonService {
    String TAG="JsonService";
    public ArrayList<GlobalCity> parseCitiesAPIJson(String jsonCities) {
        Log.e(TAG,"Data="+jsonCities);
        ArrayList<GlobalCity> allCitiesFromAPI = new ArrayList<>(0);
        try {//
            JSONArray jsonArray = new JSONArray(jsonCities);
            for (int i = 0 ; i< jsonArray.length(); i++){
//                String cityName = jsonArray.getString(i);
//                City newCity = new City(jsonArray.getString(i));
                allCitiesFromAPI.add(new GlobalCity(jsonArray.getString(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return allCitiesFromAPI;
    }

    public WeatherData parseWeatherAPIData(String jsonWeatherString){
        Log.e(TAG,"Data1="+jsonWeatherString);
        WeatherData weatherData = new WeatherData();
        try {
            JSONObject jsonObject = new JSONObject(jsonWeatherString);// root
            JSONObject mainObject = jsonObject.getJSONObject("main");
            Double temp = mainObject.getDouble("temp");
            weatherData = new WeatherData(temp);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  weatherData;
    }

    //

}
