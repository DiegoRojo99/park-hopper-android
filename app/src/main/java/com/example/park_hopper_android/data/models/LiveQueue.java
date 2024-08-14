package com.example.park_hopper_android.data.models;

import com.google.gson.annotations.SerializedName;

public class LiveQueue {
    @SerializedName("STANDBY")
    private Standby standby;

    // Getters and Setters
    public Standby getStandby() {
        return standby;
    }

    public void setStandby(Standby standby) {
        this.standby = standby;
    }

    public static class Standby {
        @SerializedName("waitTime")
        private int waitTime;

        // Getters and Setters
        public int getWaitTime() {
            return waitTime;
        }

        public void setWaitTime(int waitTime) {
            this.waitTime = waitTime;
        }
    }
}
