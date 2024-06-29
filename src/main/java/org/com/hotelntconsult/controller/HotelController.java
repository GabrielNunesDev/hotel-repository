package org.com.hotelntconsult.controller;

import org.com.hotelntconsult.model.Hotel;
import org.com.hotelntconsult.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/search")
    public List<Hotel> searchHotels(
            @RequestParam String location,
            @RequestParam double minPrice,
            @RequestParam double maxPrice) {
        return hotelService.searchHotels(location, minPrice, maxPrice);
    }

    @GetMapping("/{id}")
    public Hotel getHotel(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }
}