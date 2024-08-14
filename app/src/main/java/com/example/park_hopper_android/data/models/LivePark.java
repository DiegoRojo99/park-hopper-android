package com.example.park_hopper_android.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LivePark {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("entityType")
    private String entityType;

    @SerializedName("timezone")
    private String timezone;

    @SerializedName("liveData")
    private List<LiveData> liveData;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public List<LiveData> getLiveData() {
        return liveData;
    }

    public void setLiveData(List<LiveData> liveData) {
        this.liveData = liveData;
    }
}
