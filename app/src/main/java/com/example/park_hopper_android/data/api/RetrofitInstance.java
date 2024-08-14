package com.example.park_hopper_android.data.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    // Base URLs for each API
    private static final String BASE_URL_BACKEND_API = "https://park-hopper-backend-8a49b628e08c.herokuapp.com/api/";
    private static final String BASE_URL_WAITING_TIME_API = "https://api.themeparks.wiki/v1/";

    // Retrofit instances
    private static Retrofit retrofitBackendApi;
    private static Retrofit retrofitWaitingTimeApi;

    // Private constructor to prevent instantiation
    private RetrofitInstance() {
    }

    // Method to get the Retrofit instance for Backend API
    public static Retrofit getBackendApiInstance() {
        if (retrofitBackendApi == null) {
            retrofitBackendApi = new Retrofit.Builder()
                    .baseUrl(BASE_URL_BACKEND_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitBackendApi;
    }

    // Method to get the Retrofit instance for Theme Parks Waiting Time API
    public static Retrofit getWaitingTimeApiInstance() {
        if (retrofitWaitingTimeApi == null) {
            retrofitWaitingTimeApi = new Retrofit.Builder()
                    .baseUrl(BASE_URL_WAITING_TIME_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitWaitingTimeApi;
    }
}
