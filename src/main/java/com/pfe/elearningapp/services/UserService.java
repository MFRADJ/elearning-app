package com.pfe.elearningapp.services;

import com.pfe.elearningapp.dto.UserDto;
import com.pfe.elearningapp.models.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    User register(UserDto userDto);
    UserDetails loadUserByUsername(String email);
}
