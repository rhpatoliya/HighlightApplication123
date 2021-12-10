package com.example.highlightapplication.ui.StockPrice;

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
import com.example.highlightapplication.databinding.FragmentStockpriceBinding;


public class StockpriceFragment extends Fragment implements SearchView.OnQueryTextListener {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stockprice, container, false);

//        final SearchView search_view = binding.stockpriceSearchview;
//
//        search_view.setOnQueryTextListener(this);
//        search_view.setQueryHint("Search City for Weather");
//        setHasOptionsMenu(true);

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
            // networkingService.fetchCitiesData(newText);
        }
        else {
           /* adapter.cityList = new ArrayList<>(0);
            adapter.notifyDataSetChanged();*/
        }
        return false;    }
}