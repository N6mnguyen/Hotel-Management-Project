package com.codeWithProject.hotelServer.entity;

import com.codeWithProject.hotelServer.dto.ReservationDto;
import com.codeWithProject.hotelServer.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
@Setter
@Getter
@Entity
public class Reservation {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Long price;
    private ReservationStatus reservationStatus;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "room_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Room room;
    //
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public ReservationDto getReservationDto(){
    ReservationDto reservationDto = new ReservationDto();

    reservationDto.setId(id);
    reservationDto.setPrice(price);
    reservationDto.setCheckInDate(checkInDate);
    reservationDto.setCheckOutDate(checkOutDate);
    reservationDto.setReservationStatus(reservationStatus);

    reservationDto.setUserId(user.getId());
    reservationDto.setUserName(user.getUsername());

    reservationDto.setRoomId(room.getId());
    reservationDto.setRoomName(room.getName());
    reservationDto.setRoomType(room.getType());
    return reservationDto;
    }
}
