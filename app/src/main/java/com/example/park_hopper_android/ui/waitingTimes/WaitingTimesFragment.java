package com.example.park_hopper_android.ui.waitingTimes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.park_hopper_android.R;
import com.example.park_hopper_android.data.models.LiveAttraction;
import com.example.park_hopper_android.ui.adapters.WaitingTimesAdapter;

import java.util.ArrayList;
import java.util.List;

public class WaitingTimesFragment extends Fragment {

    private RecyclerView recyclerView;
    private WaitingTimesAdapter adapter;

    public static WaitingTimesFragment newInstance(List<LiveAttraction> liveAttractions) {
        WaitingTimesFragment fragment = new WaitingTimesFragment();
        Bundle args = new Bundle();
        args.putSerializable("liveAttractions", new ArrayList<>(liveAttractions));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_waiting_times, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if (getArguments() != null) {
            List<LiveAttraction> liveAttractions = (List<LiveAttraction>) getArguments().getSerializable("liveAttractions");
            if (liveAttractions != null) {
                adapter = new WaitingTimesAdapter(liveAttractions);
                recyclerView.setAdapter(adapter);
            }
        }

        return view;
    }

}
