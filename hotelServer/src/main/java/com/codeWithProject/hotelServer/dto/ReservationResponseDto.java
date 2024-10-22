package com.codeWithProject.hotelServer.dto;

import com.codeWithProject.hotelServer.entity.Reservation;
import lombok.Data;

import java.util.List;

@Data
public class ReservationResponseDto {
private Integer totalPage;
private Integer pageNumber;
private List<ReservationDto> reservationDtoList;
}
