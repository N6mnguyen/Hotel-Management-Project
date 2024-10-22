package com.codeWithProject.hotelServer.services.auth;


import com.codeWithProject.hotelServer.dto.SignupRequest;
import com.codeWithProject.hotelServer.dto.UserDto;

public interface AuthService {
    UserDto createUser(SignupRequest signupRequest);
}
