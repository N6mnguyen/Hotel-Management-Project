package com.codeWithProject.hotelServer.entity;


import com.codeWithProject.hotelServer.dto.RoomDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Room {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private Long price;
    private boolean available;
   public RoomDto getRoomDto(){
      RoomDto roomDto  = new RoomDto();
      roomDto.setId(id);
      roomDto.setName(name);
      roomDto.setType(type);
      roomDto.setAvailable(available);
      roomDto.setPrice(price);
      return roomDto;
   }
}
