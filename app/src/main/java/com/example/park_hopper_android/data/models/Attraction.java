package com.example.park_hopper_android.data.models;

public class Attraction {
    private String AttractionID;
    private String DestinationID;
    private String ParkID;
    private int ZoneID;
    private String AttractionName;
    private String Slug;
    private String AttractionDescription;
    private int QueueTimesID;

    public String getAttractionID() {
        return AttractionID;
    }

    public void setAttractionID(String attractionID) {
        AttractionID = attractionID;
    }

    public String getDestinationID() {
        return DestinationID;
    }

    public void setDestinationID(String destinationID) {
        DestinationID = destinationID;
    }

    public String getParkID() {
        return ParkID;
    }

    public void setParkID(String parkID) {
        ParkID = parkID;
    }

    public int getZoneID() {
        return ZoneID;
    }

    public void setZoneID(int zoneID) {
        ZoneID = zoneID;
    }

    public String getAttractionName() {
        return AttractionName;
    }

    public void setAttractionName(String attractionName) {
        AttractionName = attractionName;
    }

    public String getSlug() {
        return Slug;
    }

    public void setSlug(String slug) {
        Slug = slug;
    }

    public String getAttractionDescription() {
        return AttractionDescription;
    }

    public void setAttractionDescription(String attractionDescription) {
        AttractionDescription = attractionDescription;
    }

    public int getQueueTimesID() {
        return QueueTimesID;
    }

    public void setQueueTimesID(int queueTimesID) {
        QueueTimesID = queueTimesID;
    }
}
