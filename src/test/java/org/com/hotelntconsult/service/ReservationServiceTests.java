package org.com.hotelntconsult.service;

import org.com.hotelntconsult.config.RabbitMQConfig;
import org.com.hotelntconsult.model.Hotel;
import org.com.hotelntconsult.model.Reservation;
import org.com.hotelntconsult.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ReservationServiceTests {

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private ReservationServiceImpl reservationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testMakeReservation() {
        Hotel hotel = new Hotel();
        hotel.setId(1L);
        hotel.setName("Test Hotel");

        Reservation reservation = new Reservation();
        reservation.setCustomerName("John Doe");
        reservation.setContact("contact@test.com");
        reservation.setCheckIn(LocalDate.now());
        reservation.setCheckOut(LocalDate.now().plusDays(1));
        reservation.setRooms(1);
        reservation.setGuests(2);
        reservation.setHotel(hotel);

        when(reservationRepository.save(any(Reservation.class))).thenReturn(reservation);

        Reservation result = reservationService.makeReservation(reservation);

        assertEquals("CONFIRMED", result.getStatus());
        verify(rabbitTemplate, times(1)).convertAndSend(eq(RabbitMQConfig.QUEUE_NAME), any(Reservation.class));
    }
}
