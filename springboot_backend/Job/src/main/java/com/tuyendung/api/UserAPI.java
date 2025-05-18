package com.tuyendung.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.tuyendung.dto.UserDTO;
import com.tuyendung.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserAPI {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        userDTO = userService.registerUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }
}
