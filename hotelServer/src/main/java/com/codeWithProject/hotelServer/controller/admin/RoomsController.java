package com.codeWithProject.hotelServer.controller.admin;

import com.codeWithProject.hotelServer.dto.RoomDto;
import com.codeWithProject.hotelServer.services.admin.rooms.RoomsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class RoomsController {

    private final RoomsService roomsService;

    @PostMapping("/room")
    public ResponseEntity<?> postRoom(@RequestBody RoomDto roomDto){
        boolean success = roomsService.postRoom(roomDto);
        if(success) {
            return  ResponseEntity.status(HttpStatus.OK).build();
        }
        else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping("/rooms/{pageNumber}")
    public ResponseEntity<?> getAllRooms(@PathVariable int pageNumber){
        return ResponseEntity.ok(roomsService.getAllRooms(pageNumber));
    }
    @GetMapping("/room/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(roomsService.getRoomById(id));
        }
        catch (EntityNotFoundException e )
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e ){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("some went wrong.");
        }
    }
    @PutMapping("/room/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable Long id,@RequestBody RoomDto roomDto) {
        boolean success = roomsService.updateRoom(id,roomDto);
        if(success){
          return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/room/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable Long id){
        try{
         roomsService.deleteRoom(id);
         return ResponseEntity.ok(null);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
