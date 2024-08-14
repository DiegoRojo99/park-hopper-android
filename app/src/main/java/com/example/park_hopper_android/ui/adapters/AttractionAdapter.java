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

public class AttractionAdapter extends RecyclerView.Adapter<AttractionAdapter.AttractionViewHolder> {

    private final List<LiveAttraction> attractions;
    private final OnAttractionClickListener clickListener;

    public AttractionAdapter(List<LiveAttraction> attractions, OnAttractionClickListener clickListener) {
        this.attractions = attractions;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public AttractionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_attraction, parent, false);
        return new AttractionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttractionViewHolder holder, int position) {
        LiveAttraction attraction = attractions.get(position);
        holder.bind(attraction);
    }

    @Override
    public int getItemCount() {
        return attractions.size();
    }

    class AttractionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView attractionNameTextView;
        private final TextView attractionStatusTextView;
        private final TextView attractionWaitTimeTextView;

        public AttractionViewHolder(@NonNull View itemView) {
            super(itemView);
            attractionNameTextView = itemView.findViewById(R.id.attraction_name);
            attractionStatusTextView = itemView.findViewById(R.id.attraction_status);
            attractionWaitTimeTextView = itemView.findViewById(R.id.attraction_wait_time);
            itemView.setOnClickListener(this);
        }

        void bind(LiveAttraction attraction) {
            attractionNameTextView.setText(attraction.getName());
            attractionStatusTextView.setText(attraction.getStatus());

            // Check if the attraction has a queue and a standby wait time
            if (attraction.getQueue() != null && attraction.getQueue().getStandby() != null) {
                int waitTime = attraction.getQueue().getStandby().getWaitTime();
                attractionWaitTimeTextView.setText(itemView.getContext().getString(R.string.wait_time_format, waitTime));
            } else {
                attractionWaitTimeTextView.setText(itemView.getContext().getString(R.string.no_wait_time));
            }
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && clickListener != null) {
                clickListener.onAttractionClick(attractions.get(position));
            }
        }
    }

    public interface OnAttractionClickListener {
        void onAttractionClick(LiveAttraction attraction);
    }
}
