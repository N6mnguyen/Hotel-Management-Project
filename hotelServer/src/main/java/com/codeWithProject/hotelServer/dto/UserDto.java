package com.codeWithProject.hotelServer.dto;

import com.codeWithProject.hotelServer.entity.User;
import com.codeWithProject.hotelServer.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String name;
    private UserRole userRole;
}
