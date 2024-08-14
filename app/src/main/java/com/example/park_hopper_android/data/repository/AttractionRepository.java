package com.example.park_hopper_android.data.repository;

import com.example.park_hopper_android.data.api.RetrofitInstance;
import com.example.park_hopper_android.data.api.services.WaitingTimeApiService;
import com.example.park_hopper_android.data.models.LiveData;

import retrofit2.Call;

public class AttractionRepository {

    private final WaitingTimeApiService apiService;

    public AttractionRepository() {
        apiService = RetrofitInstance.getWaitingTimeApiInstance().create(WaitingTimeApiService.class);
    }

    public Call<LiveData> getWaitingTime(String parkId) {
        return apiService.getLiveData(parkId);
    }
}
