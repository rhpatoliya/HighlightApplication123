package com.example.highlightapplication;

public class GlobalCity {
    private int id;
    private String cityName;// Toronto , On,Canada

    public GlobalCity(String city){
        this.cityName = city;
    }

    public int getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
