package com.example.park_hopper_android.data.repository;

import com.example.park_hopper_android.data.api.RetrofitInstance;
import com.example.park_hopper_android.data.api.services.BackendApiService;
import com.example.park_hopper_android.data.api.services.WaitingTimeApiService;
import com.example.park_hopper_android.data.models.LiveData;
import com.example.park_hopper_android.data.models.Park;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {

    private final BackendApiService backendApiService;
    private final WaitingTimeApiService waitingTimeApiService;

    public DataRepository() {
        backendApiService = RetrofitInstance.getBackendApiInstance().create(BackendApiService.class);
        waitingTimeApiService = RetrofitInstance.getWaitingTimeApiInstance().create(WaitingTimeApiService.class);
    }

    public void fetchParks() {
        Call<List<Park>> call = backendApiService.getParks();
        call.enqueue(new Callback<List<Park>>() {
            @Override
            public void onResponse(Call<List<Park>> call, Response<List<Park>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Park> parks = response.body();
                    // Handle the list of parks
                } else {
                    // Handle request errors
                }
            }

            @Override
            public void onFailure(Call<List<Park>> call, Throwable t) {
                // Handle network errors
            }
        });
    }

    public void fetchLiveData(String parkId) {
        Call<LiveData> call = waitingTimeApiService.getLiveData(parkId);
        call.enqueue(new Callback<LiveData>() {
            @Override
            public void onResponse(Call<LiveData> call, Response<LiveData> response) {
                if (response.isSuccessful() && response.body() != null) {
                    LiveData liveData = response.body();
                    // Handle the live data
                } else {
                    // Handle request errors
                }
            }

            @Override
            public void onFailure(Call<LiveData> call, Throwable t) {
                // Handle network errors
            }
        });
    }
}
