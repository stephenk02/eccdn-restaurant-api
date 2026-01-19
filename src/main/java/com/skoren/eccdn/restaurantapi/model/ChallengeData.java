package com.skoren.eccdn.restaurantapi.model;

import java.util.List;

public class ChallengeData {
    private List<Restaurant> restaurants;

    public ChallengeData() {}

    public ChallengeData(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
