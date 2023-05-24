package com.example.soccer.mapper;

import com.example.soccer.dto.UserDTO;
import com.example.soccer.domain.User;

public class UserMapper {
    public static User convertToModel (UserDTO userDto) {
        User user = new User();
        user.setNickname(userDto.getNickname());
        user.setEmail(userDto.getEmail());
        return user;
    }

    public static UserDTO convertToDto (User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setNickname(user.getNickname());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
