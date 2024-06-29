package org.com.hotelntconsult.repository;

import org.com.hotelntconsult.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByLocationAndPriceBetween(String location, double minPrice, double maxPrice);
}
