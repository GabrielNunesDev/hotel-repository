package org.com.hotelntconsult.service;

import org.com.hotelntconsult.model.Reservation;
import org.com.hotelntconsult.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final NotificationService notificationService;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, NotificationService notificationService) {
        this.reservationRepository = reservationRepository;
        this.notificationService = notificationService;
    }

    @Override
    public Reservation makeReservation(Reservation reservation) {
        reservation.setStatus("CONFIRMED");
        Reservation savedReservation = reservationRepository.save(reservation);
        notificationService.sendConfirmationMessage(savedReservation);
        return savedReservation;
    }

    @Override
    public void cancelReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}