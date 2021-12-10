package com.example.highlightapplication.ui.RoomDatabase;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.fragment.app.FragmentActivity;
import androidx.room.Room;

import com.example.highlightapplication.MainActivity;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseServices {

    public DatabaseServices(Context appContext) {

    }

    public void setListener(DatabaseListener listener) {
        this.listener=listener;
    }

    public interface DatabaseListener{
        void databaseCitiesListener(List<WeatherCity> weatherCities);
    }
    public DatabaseListener listener;
    public static AppDatabase dbInstance;

    ExecutorService citiesExecutor = Executors.newFixedThreadPool(4);
    Handler citiesHandler = new Handler(Looper.getMainLooper());

    private void buildDB(Context context){
        dbInstance = Room.databaseBuilder(context,
                AppDatabase.class, "highlight_database").build();
    }


    public AppDatabase getDbInstance(Context context){
        if (dbInstance == null)
            buildDB(context);
        return dbInstance;
    }


    public void  getAllCitiesFromDB(){
        //dbService.dbInstance.getDao().getAllCities();

        citiesExecutor.execute(new Runnable() {
            @Override
            public void run() {
                List<WeatherCity> cities = dbInstance.weatherDao().getWeatherAll();
                citiesHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        listener.databaseCitiesListener(cities);
                    }
                });
            }
        });
    }

    public void saveNewCity(WeatherCity c){
        citiesExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dbInstance.weatherDao().insertWeatherAll(c);
            }
        });
    }

}
