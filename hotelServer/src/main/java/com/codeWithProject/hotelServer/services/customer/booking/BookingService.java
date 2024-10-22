package com.codeWithProject.hotelServer.services.customer.booking;

import com.codeWithProject.hotelServer.dto.ReservationDto;
import com.codeWithProject.hotelServer.dto.ReservationResponseDto;
import com.codeWithProject.hotelServer.entity.Reservation;

public interface BookingService {
    boolean postReservation(ReservationDto reservationDto);
    ReservationResponseDto getAllReservationByUserId(Long userId, int pageNumber);
}
