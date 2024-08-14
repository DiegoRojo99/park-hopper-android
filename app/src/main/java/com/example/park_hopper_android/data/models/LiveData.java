package com.example.park_hopper_android.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LiveData {

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

    @SerializedName("queue")
    private Queue queue;

    @SerializedName("status")
    private String status;

    @SerializedName("lastUpdated")
    private String lastUpdated;

    @SerializedName("showtimes")
    private List<Showtime> showtimes;

    @SerializedName("operatingHours")
    private List<OperatingHour> operatingHours;

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

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
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

    public List<Showtime> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(List<Showtime> showtimes) {
        this.showtimes = showtimes;
    }

    public List<OperatingHour> getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(List<OperatingHour> operatingHours) {
        this.operatingHours = operatingHours;
    }

    // Inner classes for nested objects

    public static class Queue {
        @SerializedName("STANDBY")
        private WaitTime standby;

        @SerializedName("SINGLE_RIDER")
        private WaitTime singleRider;

        public WaitTime getStandby() {
            return standby;
        }

        public void setStandby(WaitTime standby) {
            this.standby = standby;
        }

        public WaitTime getSingleRider() {
            return singleRider;
        }

        public void setSingleRider(WaitTime singleRider) {
            this.singleRider = singleRider;
        }

        public static class WaitTime {
            @SerializedName("waitTime")
            private Integer waitTime;

            public Integer getWaitTime() {
                return waitTime;
            }

            public void setWaitTime(Integer waitTime) {
                this.waitTime = waitTime;
            }
        }
    }

    public static class Showtime {
        @SerializedName("type")
        private String type;

        @SerializedName("startTime")
        private String startTime;

        @SerializedName("endTime")
        private String endTime;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }
    }

    public static class OperatingHour {
        @SerializedName("type")
        private String type;

        @SerializedName("startTime")
        private String startTime;

        @SerializedName("endTime")
        private String endTime;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

    }
}
