package com.skoren.eccdn.restaurantapi.controller;

import com.skoren.eccdn.restaurantapi.model.Deal;
import com.skoren.eccdn.restaurantapi.model.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DealsController {

    @GetMapping("/deals/active")
    public List<Deal> getActiveDeals(@RequestParam(defaultValue = "10:30") String time) {
        List<Deal> list = new ArrayList<Deal>();
        list.add(new Deal());
        list.add(new Deal());
        list.add(new Deal());
        list.add(new Deal());
        list.add(new Deal());
        list.add(new Deal());
        return list;
    }


    @GetMapping("/deals/peak")
    public List<Deal> getPeakDeals() {
        List<Deal> list = new ArrayList<Deal>();
        list.add(new Deal());
        list.add(new Deal());
        list.add(new Deal());
        list.add(new Deal());
        list.add(new Deal());
        list.add(new Deal());
        return list;
    }

}
