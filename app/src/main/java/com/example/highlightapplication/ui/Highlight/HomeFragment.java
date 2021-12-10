package com.example.highlightapplication.ui.Highlight;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.highlightapplication.R;
import com.example.highlightapplication.databinding.FragmentHomeBinding;
import com.example.highlightapplication.ui.RoomDatabase.DatabaseServices;
import com.example.highlightapplication.ui.RoomDatabase.WeatherCity;

import java.util.List;

public class HomeFragment extends Fragment implements DatabaseServices.DatabaseListener {

    RecyclerView recyclerview;
    HomeAdapter homeAdapter;
    DatabaseServices dbService;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerview=view.findViewById(R.id.recyclerview);
        dbService=new DatabaseServices(getActivity());
        dbService.setListener(this);
        dbService.getDbInstance(getActivity());
        dbService.getAllCitiesFromDB();
        return view;
    }

    @Override
    public void databaseCitiesListener(List<WeatherCity> weatherCities) {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(layoutManager);
        homeAdapter=new HomeAdapter(getActivity(),weatherCities);
        recyclerview.setAdapter(homeAdapter);
    }
}