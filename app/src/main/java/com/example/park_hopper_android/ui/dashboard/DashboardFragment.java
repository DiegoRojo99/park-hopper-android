package com.example.park_hopper_android.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.park_hopper_android.data.api.RetrofitInstance;
import com.example.park_hopper_android.data.api.services.BackendApiService;
import com.example.park_hopper_android.data.models.Park;
import com.example.park_hopper_android.databinding.FragmentDashboardBinding;
import com.example.park_hopper_android.ui.adapters.ParkAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private ParkAdapter parkAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Set up RecyclerView and adapter
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        parkAdapter = new ParkAdapter(getActivity());
        binding.recyclerView.setAdapter(parkAdapter);

        // Get Parks data
        BackendApiService parkService = RetrofitInstance.getBackendApiInstance().create(BackendApiService.class);
        Call<List<Park>> call = parkService.getParks();
        call.enqueue(new Callback<List<Park>>() {
            @Override
            public void onResponse(Call<List<Park>> call, Response<List<Park>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    parkAdapter.setParks(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Park>> call, Throwable t) {
                // Handle failure
            }
        });

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
