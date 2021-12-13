package com.example.highlightapplication.ui.WorldTime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.highlightapplication.GlobalCity;
import com.example.highlightapplication.R;
import com.example.highlightapplication.ui.Weather.WeatherAdapter;

import java.util.ArrayList;

public class WorldTimeAdapter extends RecyclerView.Adapter<WorldTimeAdapter.ViewHolder> {

    interface CityclickListner {
        public void cityClicked(GlobalCity selectedCity);
    }
    private Context mCtx;
    public ArrayList<GlobalCity> cityList;
    CityclickListner listner;

    public WorldTimeAdapter(Context context, ArrayList<GlobalCity> cityList, CityclickListner cityclickListner) {
        this.mCtx = context;
        this.cityList = cityList;
        listner = cityclickListner;
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mCtx).inflate(R.layout.worldtime_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        GlobalCity t = cityList.get(position);
        holder.city_time.setText(t.getCityName() );
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView city_time, countryTextView;

        public ViewHolder( View itemView) {
            super(itemView);
            city_time = itemView.findViewById(R.id.city_time);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listner.cityClicked(cityList.get(getAdapterPosition()));

        }
    }
}
