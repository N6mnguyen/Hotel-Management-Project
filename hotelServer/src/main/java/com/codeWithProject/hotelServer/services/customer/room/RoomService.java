package com.codeWithProject.hotelServer.services.customer.room;

import com.codeWithProject.hotelServer.dto.RoomsResponseDto;

public interface RoomService {
    RoomsResponseDto  getAvailableRooms (int pageNumber);
}
