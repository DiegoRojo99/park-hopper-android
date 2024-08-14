package com.example.park_hopper_android.data.api.services;

import com.example.park_hopper_android.data.models.LiveData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WaitingTimeApiService {

    @GET("entity/{parkId}/live")
    Call<LiveData> getLiveData(@Path("id") String parkId);

}
