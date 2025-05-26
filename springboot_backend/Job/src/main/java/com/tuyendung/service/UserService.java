package com.tuyendung.service;

import com.tuyendung.dto.LoginDTO;
import com.tuyendung.dto.UserDTO;
import com.tuyendung.exception.JobPortalException;

import jakarta.validation.Valid;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO) throws JobPortalException;

    UserDTO loginUser(LoginDTO loginDTO) throws JobPortalException;
}
