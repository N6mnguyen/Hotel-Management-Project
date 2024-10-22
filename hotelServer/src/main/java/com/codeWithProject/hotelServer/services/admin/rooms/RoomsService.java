package com.codeWithProject.hotelServer.services.admin.rooms;

import com.codeWithProject.hotelServer.dto.RoomDto;
import com.codeWithProject.hotelServer.dto.RoomsResponseDto;

public interface RoomsService {
        boolean postRoom (RoomDto roomDto);
        RoomsResponseDto getAllRooms(int pageNumber);
        RoomDto getRoomById(Long id);
        boolean updateRoom (Long id, RoomDto roomDto);
        void deleteRoom(Long id);
}
