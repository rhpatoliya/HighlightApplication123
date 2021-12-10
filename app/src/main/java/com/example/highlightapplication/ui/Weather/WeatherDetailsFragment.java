package com.example.highlightapplication.ui.Weather;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.highlightapplication.GlobalCity;
import com.example.highlightapplication.MainActivity;
import com.example.highlightapplication.R;
import com.example.highlightapplication.ui.RoomDatabase.DatabaseServices;
import com.example.highlightapplication.ui.RoomDatabase.WeatherCity;

import java.awt.font.TextAttribute;

public class WeatherDetailsFragment extends Fragment implements NetworkingService.NetworkingListener, View.OnClickListener {

    Context appContext;
    NetworkingService networkingService;
    JsonService jsonService;
    String TAG="WeatherDetailsFragment";
    static TextView city_id;
    TextView temp_id;
    GlobalCity globalCity ;
    DatabaseServices dbService;
    Button btn_savedata;
    WeatherData weatherData;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.weatherdetails, container, false);

        appContext=getActivity();
        jsonService=new JsonService();
        networkingService = new NetworkingService(this);
        dbService=new DatabaseServices(getActivity());
        city_id = view.findViewById(R.id.city_id);
        temp_id = view.findViewById(R.id.temp_id);
        btn_savedata = view.findViewById(R.id.btn_savedata);

        city_id.setText(globalCity.getCityName());

        btn_savedata.setOnClickListener(this);
        networkingService.fetchWeatherData(globalCity);
        dbService.getDbInstance(getActivity());
        return view;

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void APINetworkListner(String jsonString) {
        weatherData = jsonService.parseWeatherAPIData(jsonString);
        temp_id.setText(weatherData.temp + " ");
    }

    public WeatherDetailsFragment(GlobalCity selectedCity) {
        globalCity=selectedCity;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_savedata:
                WeatherCity weatherCity=new WeatherCity();
                weatherCity.cityName=globalCity.getCityName();
                weatherCity.temp=weatherData.temp;
                dbService.saveNewCity(weatherCity);
                break;
        }
    }
}
