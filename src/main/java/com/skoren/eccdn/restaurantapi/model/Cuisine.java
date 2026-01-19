package com.skoren.eccdn.restaurantapi.model;

public class Cuisine {

    private String objectId;
    private String name;

    public Cuisine() {}

    public Cuisine(String name) {
        this.name = name;
    }

    public Cuisine(String objectId, String name) {
        this.objectId = objectId;
        this.name = name;
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

    @Override
    public String toString() {
        return "Cuisine{" +
                "objectId='" + objectId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
