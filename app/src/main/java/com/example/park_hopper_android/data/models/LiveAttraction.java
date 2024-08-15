package com.example.park_hopper_android.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LiveAttraction implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("entityType")
    private String entityType;

    @SerializedName("parkId")
    private String parkId;

    @SerializedName("externalId")
    private String externalId;

    @SerializedName("status")
    private String status;

    @SerializedName("lastUpdated")
    private String lastUpdated;

    @SerializedName("queue")
    private LiveQueue queue;

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

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public LiveQueue getQueue() {
        return queue;
    }

    public void setQueue(LiveQueue queue) {
        this.queue = queue;
    }

    public int getWaitTime() {
        if (queue != null && queue.getStandby() != null) {
            return queue.getStandby().getWaitTime();
        } else {
            return -1;
        }
    }

}
