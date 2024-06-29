package org.com.hotelntconsult.service;

import org.com.hotelntconsult.model.Hotel;
import org.com.hotelntconsult.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> searchHotels(String location, double minPrice, double maxPrice) {
        return hotelRepository.findByLocationAndPriceBetween(location, minPrice, maxPrice);
    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }
}
