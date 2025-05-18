package com.tuyendung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuyendung.dto.UserDTO;
import com.tuyendung.entity.User;
import com.tuyendung.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAccountType(userDTO.getAccountType());
        userRepository.save(user);
        return userDTO;
    }
}
