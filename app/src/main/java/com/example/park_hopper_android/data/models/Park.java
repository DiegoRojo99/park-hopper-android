package com.example.park_hopper_android.data.models;

public class Park {
    private String ParkID;
    private String DestinationID;
    private String ParkName;
    private String Slug;
    private String ParkDescription;
    private float Latitude;
    private float Longitude;
    private String Country;
    private String Continent;
    private int QueueTimesID;

    public String getParkID() {
        return ParkID;
    }

    public void setParkID(String parkID) {
        ParkID = parkID;
    }

    public String getDestinationID() {
        return DestinationID;
    }

    public void setDestinationID(String destinationID) {
        DestinationID = destinationID;
    }

    public int getQueueTimesID() {
        return QueueTimesID;
    }

    public void setQueueTimesID(int queueTimesID) {
        QueueTimesID = queueTimesID;
    }

    public String getContinent() {
        return Continent;
    }

    public void setContinent(String continent) {
        Continent = continent;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public float getLongitude() {
        return Longitude;
    }

    public void setLongitude(float longitude) {
        Longitude = longitude;
    }

    public float getLatitude() {
        return Latitude;
    }

    public void setLatitude(float latitude) {
        Latitude = latitude;
    }

    public String getParkDescription() {
        return ParkDescription;
    }

    public void setParkDescription(String parkDescription) {
        ParkDescription = parkDescription;
    }

    public String getSlug() {
        return Slug;
    }

    public void setSlug(String slug) {
        Slug = slug;
    }

    public String getParkName() {
        return ParkName;
    }

    public void setParkName(String parkName) {
        ParkName = parkName;
    }

}
