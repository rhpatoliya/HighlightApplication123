package com.example.highlightapplication.ui.WorldTime;

import android.util.Log;

import com.example.highlightapplication.GlobalCity;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class TimeJason {
    String TAG="TimeJason";
    public ArrayList<GlobalCity> parseCitiesAPIJson(String jsonCities) {
        Log.e(TAG,"Data="+jsonCities);
        ArrayList<GlobalCity> alltimezonecities = new ArrayList<>(0);
        try {//
            JSONArray jsonArray = new JSONArray(jsonCities);
            for (int i = 0 ; i< jsonArray.length(); i++){
//                String cityName = jsonArray.getString(i);
//                City newCity = new City(jsonArray.getString(i));
                alltimezonecities.add(new GlobalCity(jsonArray.getString(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return alltimezonecities;
    }
}
