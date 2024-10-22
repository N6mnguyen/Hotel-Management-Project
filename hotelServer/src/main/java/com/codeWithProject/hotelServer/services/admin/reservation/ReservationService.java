package com.codeWithProject.hotelServer.services.admin.reservation;

import com.codeWithProject.hotelServer.dto.ReservationResponseDto;
import com.codeWithProject.hotelServer.entity.Reservation;

public interface ReservationService {
    ReservationResponseDto getAllReservation(int pageNumber);
    boolean changeReservationStatus(Long id, String status);
}
