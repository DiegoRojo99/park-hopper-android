package com.example.park_hopper_android.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DashboardViewModel() {
        mText = new MutableLiveData<String>();
        mText.setValue("All Parks");
    }

    public LiveData<String> getText() {
        return mText;
    }
}