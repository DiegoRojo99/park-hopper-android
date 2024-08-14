package com.example.park_hopper_android.data.api.services;

import com.example.park_hopper_android.data.models.Park;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BackendApiService {

    @GET("allParks")
    Call<List<Park>> getParks();

}
