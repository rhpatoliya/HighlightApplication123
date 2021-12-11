package com.example.highlightapplication.ui.WorldTime;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.highlightapplication.GlobalCity;
import com.example.highlightapplication.R;
import com.example.highlightapplication.databinding.FragmentWorldtimeBinding;
import com.example.highlightapplication.ui.Weather.JsonService;
import com.example.highlightapplication.ui.Weather.NetworkingService;
import com.example.highlightapplication.ui.Weather.WeatherAdapter;
import com.example.highlightapplication.ui.Weather.WeatherDetailsFragment;

import java.util.ArrayList;


public class WorldTimeFragment extends Fragment implements SearchView.OnQueryTextListener,SearchView.OnCloseListener,
        TimeNetwork.NetworkingListener , WorldTimeAdapter.CityclickListner {
    SearchView worldtime_searchview;

    String TAG="WorldTimeFragment";

    Context appContext;
    WeatherAdapter adapter;
    ArrayList<GlobalCity> timezone = new ArrayList<>();
    TimeNetwork timeNetwork;
    TimeJason timeJason;
    RecyclerView recyclerview_time;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_worldtime, container, false);

        appContext=getActivity();
        timeNetwork = new TimeNetwork(this);
        timeJason = new TimeJason();



        worldtime_searchview = view.findViewById(R.id.worldtime_searchview);

        worldtime_searchview.setOnQueryTextListener(this);
        worldtime_searchview.setQueryHint("Search City for World Time");
        setHasOptionsMenu(true);

        return view;
    }



    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d("query change", query);

        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText.length() >= 3) {
            timeNetwork.fetchTimeZone(newText);
        }
        else {
            timezone = new ArrayList<>(0);
            adapter.cityList=timezone;
            adapter.notifyDataSetChanged();
        }
        return false;
    }



    @Override
    public void APINetworkListner(String jsonString) {
        timezone =  timeJason.parseCitiesAPIJson(jsonString);
        adapter.cityList = timezone;
        adapter.notifyDataSetChanged();
    }


    @Override
    public void cityClicked(GlobalCity selectedCity) {

        WeatherDetailsFragment fragment2 = new WeatherDetailsFragment(selectedCity);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_content_main, fragment2);
        fragmentTransaction.commit();


    }

    @Override
    public boolean onClose() {
        timezone = new ArrayList<>(0);
        adapter.cityList=timezone;
        adapter.notifyDataSetChanged();
        return true;
    }
}