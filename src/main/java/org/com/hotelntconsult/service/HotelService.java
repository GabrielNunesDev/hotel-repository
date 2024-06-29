package org.com.hotelntconsult.service;

import org.com.hotelntconsult.model.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> searchHotels(String location, double minPrice, double maxPrice);
    Hotel getHotelById(Long id);
}
