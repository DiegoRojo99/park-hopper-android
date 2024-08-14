package com.example.park_hopper_android.data.repository;

import com.example.park_hopper_android.data.api.RetrofitInstance;
import com.example.park_hopper_android.data.api.services.BackendApiService;
import com.example.park_hopper_android.data.models.Park;

import java.util.List;

import retrofit2.Call;

public class ParkRepository {

    private final BackendApiService apiService;

    public ParkRepository() {
        apiService = RetrofitInstance.getBackendApiInstance().create(BackendApiService.class);
    }

    public Call<List<Park>> getParks() {
        return apiService.getParks();
    }

}
