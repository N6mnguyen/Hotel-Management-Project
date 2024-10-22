package com.codeWithProject.hotelServer.dto;

import com.codeWithProject.hotelServer.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {
private String Jwt;
private Long userId;
private UserRole userRole;
}
