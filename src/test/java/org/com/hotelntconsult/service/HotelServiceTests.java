package org.com.hotelntconsult.service;

import org.com.hotelntconsult.model.Hotel;
import org.com.hotelntconsult.repository.HotelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class HotelServiceTests {

    @Mock
    private HotelRepository hotelRepository;

    @InjectMocks
    private HotelServiceImpl hotelService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSearchHotels() {
        Hotel hotel1 = new Hotel();
        hotel1.setName("Hotel One");
        hotel1.setLocation("Test Location");
        hotel1.setPrice(100);

        Hotel hotel2 = new Hotel();
        hotel2.setName("Hotel Two");
        hotel2.setLocation("Test Location");
        hotel2.setPrice(150);

        List<Hotel> hotels = Arrays.asList(hotel1, hotel2);

        when(hotelRepository.findByLocationAndPriceBetween("Test Location", 50, 200)).thenReturn(hotels);

        List<Hotel> result = hotelService.searchHotels("Test Location", 50, 200);

        assertEquals(2, result.size());
        assertEquals("Hotel One", result.get(0).getName());
        assertEquals("Hotel Two", result.get(1).getName());
    }
}
