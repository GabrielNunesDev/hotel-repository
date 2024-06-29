package org.com.hotelntconsult.repository;

import org.com.hotelntconsult.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}