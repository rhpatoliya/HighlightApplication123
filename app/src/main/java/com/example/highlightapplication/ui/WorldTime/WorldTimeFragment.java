package com.example.highlightapplication.ui.WorldTime;

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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.highlightapplication.R;
import com.example.highlightapplication.databinding.FragmentWorldtimeBinding;


public class WorldTimeFragment extends Fragment implements SearchView.OnQueryTextListener {
    SearchView worldtime_searchview;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_worldtime, container, false);

        worldtime_searchview = view.findViewById(R.id.worldtime_searchview);

        worldtime_searchview.setOnQueryTextListener(this);
        worldtime_searchview.setQueryHint("Search City for World Time");
        setHasOptionsMenu(true);

        return view;
    }



    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d("query change", query);

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d("query change", newText);
        if (newText.length() >= 3) {
            // seach for city
            //networkingService.fetchCitiesData(newText);
           // https://www.amdoren.com/api/locations.php

        }
        else {
           /* adapter.cityList = new ArrayList<>(0);
            adapter.notifyDataSetChanged();*/
        }
        return false;    }
}