package com.example.highlightapplication.ui.Currency;

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

import com.example.highlightapplication.databinding.FragmentCurrencyBinding;


public class CurrencyFragment extends Fragment implements SearchView.OnQueryTextListener {

    private CurrencyViewModel slideshowViewModel;
    private FragmentCurrencyBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(CurrencyViewModel.class);

        binding = FragmentCurrencyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final SearchView search_view = binding.currencySearchview;
        search_view.setOnQueryTextListener(this);
        search_view.setQueryHint("Search City for Weather");
        setHasOptionsMenu(true);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
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
        return false;
    }
}