package com.skoren.eccdn.restaurantapi.service;

import com.skoren.eccdn.restaurantapi.dto.response.ActiveDealResponse;
import com.skoren.eccdn.restaurantapi.dto.response.PeakDealWindowResponse;
import com.skoren.eccdn.restaurantapi.mapper.ChallengeDataMapper;
import com.skoren.eccdn.restaurantapi.model.ChallengeData;
import com.skoren.eccdn.restaurantapi.model.Deal;
import com.skoren.eccdn.restaurantapi.model.Restaurant;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DealService {

    public static ActiveDealResponse getActiveDeals (LocalTime time) {

        ChallengeData data = ChallengeDataMapper.LoadChallengeData();

        HashMap<Restaurant, List<Deal>> activeMap = new HashMap<>();

        List<Deal> dealList = new ArrayList<>();
        dealList.add(data.getRestaurants().getFirst().getDeals().getFirst());

        activeMap.put(data.getRestaurants().getFirst(), dealList);

        ActiveDealResponse response = new ActiveDealResponse(activeMap);
        return response;
    }

    public static PeakDealWindowResponse getPeakDealWindow() {
        return null;
    }
}
