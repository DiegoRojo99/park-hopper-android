package com.example.park_hopper_android.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.park_hopper_android.R;
import com.example.park_hopper_android.data.models.Park;

import java.util.ArrayList;
import java.util.List;

public class ParkAdapter extends RecyclerView.Adapter<ParkAdapter.ParkViewHolder> {

    private List<Park> parks = new ArrayList<>();

    public void setParks(List<Park> parks) {
        this.parks = parks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ParkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_park, parent, false);
        return new ParkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParkViewHolder holder, int position) {
        Park park = parks.get(position);
        holder.parkNameTextView.setText(park.getParkName());
        holder.parkLocationTextView.setText(park.getCountry());
    }

    @Override
    public int getItemCount() {
        return parks.size();
    }

    static class ParkViewHolder extends RecyclerView.ViewHolder {

        TextView parkNameTextView;
        TextView parkLocationTextView;

        public ParkViewHolder(@NonNull View itemView) {
            super(itemView);
            parkNameTextView = itemView.findViewById(R.id.park_name_text_view);
            parkLocationTextView = itemView.findViewById(R.id.park_location_text_view);
        }
    }
}
