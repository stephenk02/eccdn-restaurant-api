package com.skoren.eccdn.restaurantapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;

public class Restaurant {

    private String objectId;
    private String name;
    private String address1;
    private String suburb;
    private HashSet<Cuisine> cuisines;
    private String imageLink;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "h:mma")
    private LocalTime open;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "h:mma")
    private LocalTime close;

    private List<Deal> deals;

    public Restaurant() {}

    public Restaurant(String objectId, String name, String address1, String suburb, HashSet<Cuisine> cuisines, String imageLink, LocalTime open, LocalTime close, List<Deal> deals) {
        this.objectId = objectId;
        this.name = name;
        this.address1 = address1;
        this.suburb = suburb;
        this.cuisines = cuisines;
        this.imageLink = imageLink;
        this.open = open;
        this.close = close;
        this.deals = deals;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public HashSet<Cuisine> getCuisines() {
        return cuisines;
    }

    public void setCuisines(HashSet<Cuisine> cuisines) {
        this.cuisines = cuisines;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public LocalTime getOpen() {
        return open;
    }

    public void setOpen(LocalTime open) {
        this.open = open;
    }

    public LocalTime getClose() {
        return close;
    }

    public void setClose(LocalTime close) {
        this.close = close;
    }

    public List<Deal> getDeals() {
        return deals;
    }

    public void setDeals(List<Deal> deals) {
        this.deals = deals;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "objectId='" + objectId + '\'' +
                ", name='" + name + '\'' +
                ", address1='" + address1 + '\'' +
                ", suburb='" + suburb + '\'' +
                ", cuisines=" + cuisines +
                ", imageLink='" + imageLink + '\'' +
                ", open=" + open +
                ", close=" + close +
                ", deals=" + deals +
                '}';
    }
}
