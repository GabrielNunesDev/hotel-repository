package org.com.hotelntconsult;


import org.com.hotelntconsult.config.RabbitMQConfig;
import org.com.hotelntconsult.model.Reservation;
import org.com.hotelntconsult.repository.ReservationRepository;
import org.com.hotelntconsult.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.time.LocalDate;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;

@SpringBootTest
public class RabbitMQIntegrationTests {

    @Autowired
    private ReservationService reservationService;

    @MockBean
    private ReservationRepository reservationRepository;

    @MockBean
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testMakeReservationSendsMessage() {
        Reservation reservation = new Reservation();
        reservation.setCustomerName("John Doe");
        reservation.setContact("contact@test.com");
        reservation.setCheckIn(LocalDate.now());
        reservation.setCheckOut(LocalDate.now().plusDays(1));
        reservation.setRooms(1);
        reservation.setGuests(2);
        reservation.setStatus(null);

        Mockito.when(reservationRepository.save(any(Reservation.class))).thenReturn(reservation);

        reservationService.makeReservation(reservation);

        Mockito.verify(rabbitTemplate, times(1)).convertAndSend(eq(RabbitMQConfig.QUEUE_NAME), any(Reservation.class));
    }
}