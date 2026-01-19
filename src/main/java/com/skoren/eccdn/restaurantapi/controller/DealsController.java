package com.skoren.eccdn.restaurantapi.controller;

import com.skoren.eccdn.restaurantapi.dto.response.ActiveDealResponse;
import com.skoren.eccdn.restaurantapi.model.Deal;
import com.skoren.eccdn.restaurantapi.service.DealService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
public class DealsController {


    private final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendPattern("[hh:mma][h:mma][HH:mm][H:mm]") // Parse for 24 hr time or AM/pm time
            .toFormatter(Locale.ENGLISH);

    @GetMapping("/deals/active/{time}")
    public ActiveDealResponse getActiveDeals(@PathVariable("time") String time) {
        LocalTime parsedTime = LocalTime.parse(time, formatter);
        return DealService.getActiveDeals(parsedTime);
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
