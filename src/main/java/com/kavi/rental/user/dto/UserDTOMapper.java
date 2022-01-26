package com.kavi.rental.user.dto;

import com.kavi.rental.user.model.User;

public class UserDTOMapper {
    public UserDTO map(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }
}
