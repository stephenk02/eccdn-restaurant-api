package com.skoren.eccdn.restaurantapi.service;

import com.skoren.eccdn.restaurantapi.dto.response.ActiveDealResponse;
import com.skoren.eccdn.restaurantapi.dto.response.PeakDealWindowResponse;
import com.skoren.eccdn.restaurantapi.mapper.ChallengeDataMapper;
import com.skoren.eccdn.restaurantapi.model.ChallengeData;
import com.skoren.eccdn.restaurantapi.model.Deal;
import com.skoren.eccdn.restaurantapi.model.Restaurant;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class DealService {

    public static ActiveDealResponse getActiveDeals (LocalTime time) {

        ChallengeData data = ChallengeDataMapper.LoadChallengeData();
        HashMap<Restaurant, List<Deal>> activeMap = new HashMap<>();

        for (Restaurant restaurant : data.getRestaurants()) {
            // If restaurant is closed, deals are not active, so ignore it
            if (restaurant.getOpen().isAfter(time)) continue;
            if (restaurant.getClose().isBefore(time)) continue;
            for (Deal deal : restaurant.getDeals()) {
                // If no deals left, or outside of deal window, its not active, so ignore it.
                if (deal.getQtyLeft() <= 0) continue;
                if (deal.getStart() != null && deal.getStart().isAfter(time)) continue;
                if (deal.getEnd() != null && deal.getEnd().isBefore(time)) continue;
                if (!activeMap.containsKey(restaurant)) {
                    activeMap.put(restaurant, new ArrayList<>());
                }
                activeMap.get(restaurant).add(deal);
            }
        }

        return new ActiveDealResponse(activeMap);
    }

    private static class PeakWindowTimestamp {
        public LocalTime time;
        public Boolean isOpening;

        public PeakWindowTimestamp(LocalTime time, Boolean isOpening) {
            this.time = time;
            this.isOpening = isOpening;
        }
    }

    public static PeakDealWindowResponse getPeakDealWindow() {

        ChallengeData data = ChallengeDataMapper.LoadChallengeData();
        List<PeakWindowTimestamp> timestamps = new ArrayList<>();

        // Compile all deal times into timeStamp window,
        // using the restaurant hours if a deal time is not defined.
        // Open pairings are marked "true" and Close pairings "false"

        for (Restaurant restaurant : data.getRestaurants()) {
            for (Deal deal : restaurant.getDeals()) {
                if (deal.getQtyLeft() == 0) continue;

                timestamps.add(new PeakWindowTimestamp(
                        (deal.getStart() != null) ? deal.getStart() : restaurant.getOpen(),
                        true
                ));
                timestamps.add(new PeakWindowTimestamp(
                        (deal.getEnd() != null) ? deal.getEnd() : restaurant.getClose(),
                        false
                ));
            }
        }

        timestamps.sort(new Comparator<PeakWindowTimestamp>(){
            public int compare(PeakWindowTimestamp a, PeakWindowTimestamp b) {
                return a.time.compareTo(b.time);
            }
        });

        // Technically the whole day is peak deals if no deals exist...?
        LocalTime peakTimeStart = LocalTime.MIN, peakTimeEnd = LocalTime.MAX;
        int activeDeals = 0;
        int maxDeals = 0;

        for (PeakWindowTimestamp timestamp : timestamps) {
            if (timestamp.isOpening) {
                activeDeals++;
                if (maxDeals < activeDeals) {
                    maxDeals = activeDeals;
                    peakTimeStart = timestamp.time;
                }
            } else {
                if (maxDeals == activeDeals) {
                    peakTimeEnd = timestamp.time;
                }
                activeDeals--;
            }
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mma");

        return new PeakDealWindowResponse(peakTimeStart.format(formatter), peakTimeEnd.format((formatter)));
    }
}
