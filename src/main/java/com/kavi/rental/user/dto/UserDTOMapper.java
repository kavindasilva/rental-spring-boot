package com.kavi.rental.user.dto;

import com.kavi.rental.user.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserDTOMapper {
//    @Bean(name = "com.kavi.rental.user.dto.UserDTOMapper")
    public UserDTO map(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }
}
