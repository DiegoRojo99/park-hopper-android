package com.example.park_hopper_android.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.park_hopper_android.R;
import com.example.park_hopper_android.data.models.LiveAttraction;

import java.util.List;

public class WaitingTimesAdapter extends RecyclerView.Adapter<WaitingTimesAdapter.WaitingTimeViewHolder> {

    private final List<LiveAttraction> liveAttractions;

    public WaitingTimesAdapter(List<LiveAttraction> liveAttractions) {
        this.liveAttractions = liveAttractions;
    }

    @NonNull
    @Override
    public WaitingTimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_waiting_time, parent, false);
        return new WaitingTimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WaitingTimeViewHolder holder, int position) {
        LiveAttraction liveAttraction = liveAttractions.get(position);
        holder.nameTextView.setText(liveAttraction.getName());
        holder.waitTimeTextView.setText(formatWaitTime(liveAttraction.getQueue().getStandby().getWaitTime()));
    }

    @Override
    public int getItemCount() {
        return liveAttractions.size();
    }

    private String formatWaitTime(int waitTime) {
        if (waitTime == 0) {
            return "No wait time";
        } else {
            return waitTime + " min";
        }
    }

    static class WaitingTimeViewHolder extends RecyclerView.ViewHolder {

        final TextView nameTextView;
        final TextView waitTimeTextView;

        public WaitingTimeViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.attraction_name);
            waitTimeTextView = itemView.findViewById(R.id.wait_time);
        }
    }
}
