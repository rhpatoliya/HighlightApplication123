package com.example.highlightapplication.ui.GoldPrice;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GoldpriceViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GoldpriceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}