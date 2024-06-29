package org.com.hotelntconsult.service;

import org.com.hotelntconsult.model.Reservation;

public interface ReservationService {
    Reservation makeReservation(Reservation reservation);
    void cancelReservation(Long reservationId);
}
