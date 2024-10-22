package com.codeWithProject.hotelServer.dto;

import com.codeWithProject.hotelServer.entity.Room;
import lombok.Data;

import java.util.List;
//phân trang
@Data
public class RoomsResponseDto {
    private List<RoomDto> roomDtoList;
    private Integer totalPages;
    private Integer pageNumber;
}
