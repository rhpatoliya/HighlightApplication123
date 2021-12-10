package com.example.highlightapplication.ui.Highlight;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.highlightapplication.R;
import com.example.highlightapplication.ui.HelperMethod;
import com.example.highlightapplication.ui.RoomDatabase.WeatherCity;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    String TAG="HomeAdapter";
    List<WeatherCity> weatherCities;
    Context appContext;
    public HomeAdapter(FragmentActivity activity, List<WeatherCity> weatherCities) {
        appContext=activity;
        this.weatherCities=weatherCities;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(appContext).inflate(R.layout.home_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        WeatherCity weatherCity=weatherCities.get(position);

        holder.txt_cityname.setText(weatherCity.cityName);
        holder.txt_temp.setText(weatherCity.temp+" ");
//        holder.txt_cityname.setText(HelperMethod.ConvertTemp(weatherCity.temp)+" ");
    }

    @Override
    public int getItemCount() {
        return weatherCities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_cityname,txt_temp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_cityname=itemView.findViewById(R.id.txt_cityname);
            txt_temp=itemView.findViewById(R.id.txt_temp);
        }
    }
}
