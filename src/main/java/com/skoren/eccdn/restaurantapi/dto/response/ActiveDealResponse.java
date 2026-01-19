package com.skoren.eccdn.restaurantapi.dto.response;

import com.skoren.eccdn.restaurantapi.model.Deal;
import com.skoren.eccdn.restaurantapi.model.Restaurant;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ActiveDealResponse {
    public ActiveDealResponse(HashMap<Restaurant, List<Deal>> dealMap) {
        this.deals = new ArrayList<ActiveDeal>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mma");

        for (Map.Entry<Restaurant, List<Deal>> record : dealMap.entrySet()) {
            Restaurant restaurant = record.getKey();

            List<Deal> foundDeals = record.getValue();

            for (Deal deal : foundDeals) {
                deals.add(new ActiveDeal(
                        restaurant.getObjectId(),
                        restaurant.getName(),
                        restaurant.getAddress1(),
                        restaurant.getSuburb(),
                        restaurant.getOpen().format(formatter),
                        restaurant.getClose().format(formatter),
                        deal.getObjectId(),
                        deal.getDiscount(),
                        deal.getDineIn(),
                        deal.getLightning(),
                        deal.getQtyLeft()
                ));
            }
        }
    }

    private List<ActiveDeal> deals;


    public static class ActiveDeal {
        private String restaurantObjectId;
        private String restaurantName;
        private String restaurantAddress1;
        private String restaurantSuburb;
        private String restaurantOpen;
        private String restaurantClose;
        private String dealObjectId;
        private Integer discount;
        private Boolean dineIn;
        private Boolean lightning;
        private Integer qtyLeft;

        public ActiveDeal(String restaurantObjectId, String restaurantName, String restaurantAddress1, String restaurantSuburb, String restaurantOpen, String restaurantClose, String dealObjectId, Integer discount, Boolean dineIn, Boolean lightning, Integer qtyLeft) {
            this.restaurantObjectId = restaurantObjectId;
            this.restaurantName = restaurantName;
            this.restaurantAddress1 = restaurantAddress1;
            this.restaurantSuburb = restaurantSuburb;
            this.restaurantOpen = restaurantOpen;
            this.restaurantClose = restaurantClose;
            this.dealObjectId = dealObjectId;
            this.discount = discount;
            this.dineIn = dineIn;
            this.lightning = lightning;
            this.qtyLeft = qtyLeft;
        }

        public String getRestaurantObjectId() {
            return restaurantObjectId;
        }

        public void setRestaurantObjectId(String restaurantObjectId) {
            this.restaurantObjectId = restaurantObjectId;
        }

        public String getRestaurantName() {
            return restaurantName;
        }

        public void setRestaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
        }

        public String getRestaurantAddress1() {
            return restaurantAddress1;
        }

        public void setRestaurantAddress1(String restaurantAddress1) {
            this.restaurantAddress1 = restaurantAddress1;
        }

        public String getRestaurantSuburb() {
            return restaurantSuburb;
        }

        public void setRestaurantSuburb(String restaurantSuburb) {
            this.restaurantSuburb = restaurantSuburb;
        }

        public String getRestaurantOpen() {
            return restaurantOpen;
        }

        public void setRestaurantOpen(String restaurantOpen) {
            this.restaurantOpen = restaurantOpen;
        }

        public String getRestaurantClose() {
            return restaurantClose;
        }

        public void setRestaurantClose(String restaurantClose) {
            this.restaurantClose = restaurantClose;
        }

        public String getDealObjectId() {
            return dealObjectId;
        }

        public void setDealObjectId(String dealObjectId) {
            this.dealObjectId = dealObjectId;
        }

        public Integer getDiscount() {
            return discount;
        }

        public void setDiscount(Integer discount) {
            this.discount = discount;
        }

        public Boolean getDineIn() {
            return dineIn;
        }

        public void setDineIn(Boolean dineIn) {
            this.dineIn = dineIn;
        }

        public Boolean getLightning() {
            return lightning;
        }

        public void setLightning(Boolean lightning) {
            this.lightning = lightning;
        }

        public Integer getQtyLeft() {
            return qtyLeft;
        }

        public void setQtyLeft(Integer qtyLeft) {
            this.qtyLeft = qtyLeft;
        }
    }

    public List<ActiveDeal> getDeals() {
        return deals;
    }
    public void setDeals(List<ActiveDeal> deals) {
        this.deals = deals;
    }
}
