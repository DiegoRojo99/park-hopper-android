package com.example.park_hopper_android.ui.park;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.park_hopper_android.R;
import com.example.park_hopper_android.data.api.RetrofitInstance;
import com.example.park_hopper_android.data.api.services.WaitingTimeApiService;
import com.example.park_hopper_android.data.models.LiveAttraction;
import com.example.park_hopper_android.data.models.LiveData;
import com.example.park_hopper_android.ui.adapters.AttractionAdapter;

import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ParkDetailsFragment extends Fragment {

    private static final String ARG_PARK_ID = "park_id";
    private TextView parkNameTextView;
    private RecyclerView attractionsRecyclerView;
    private AttractionAdapter adapter;

    public ParkDetailsFragment() {
        // Required empty public constructor
    }

    public static ParkDetailsFragment newInstance(String parkId) {
        ParkDetailsFragment fragment = new ParkDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARK_ID, parkId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_waiting_times, container, false);

        parkNameTextView = view.findViewById(R.id.parkName);
        attractionsRecyclerView = view.findViewById(R.id.attractionsRecyclerView);
        attractionsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if (getArguments() != null) {
            String parkId = getArguments().getString(ARG_PARK_ID);
            fetchAttractions(parkId);
        }

        return view;
    }

    private void fetchAttractions(String parkId) {
        WaitingTimeApiService apiService = RetrofitInstance.getWaitingTimeApiInstance().create(WaitingTimeApiService.class);
        apiService.getLiveData(parkId).enqueue(new Callback<LiveData>() {
            @Override
            public void onResponse(@NonNull Call<LiveData> call, @NonNull Response<LiveData> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<LiveAttraction> entityList = response.body().getLiveData();
                    if (entityList != null) {
                        List<LiveAttraction> attractionsList = entityList.stream().filter(entity -> entity.getEntityType().equals("ATTRACTION")).sorted((a, b) -> Integer.compare(b.getWaitTime(), a.getWaitTime())).collect(Collectors.toList());
                        adapter = new AttractionAdapter(attractionsList, new AttractionAdapter.OnAttractionClickListener() {
                            @Override
                            public void onAttractionClick(LiveAttraction attraction) {
                                // Handle attraction click if needed
                            }
                        });
                        attractionsRecyclerView.setAdapter(adapter);
                    } else {
                        Log.e("ParkDetailsFragment", "Attractions list is null");
                    }
                } else {
                    Log.e("ParkDetailsFragment", "Response error: " + response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<LiveData> call, @NonNull Throwable t) {
                Log.e("ParkDetailsFragment", "Failed to fetch attractions", t);
            }
        });
    }
}
