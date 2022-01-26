package com.kavi.rental.user.controller;

import com.kavi.rental.user.dto.UserDTO;
import com.kavi.rental.user.dto.UserDTOMapper;
import com.kavi.rental.user.model.User;
import com.kavi.rental.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private UserDTOMapper userDTOMapper;

    @RequestMapping("/")
    public String hello()
    {
        return "Demo User";
    }

    @RequestMapping("/user")
    public List<User> getAllUsers()
    {
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public UserDTO getUser(@PathVariable int id)
    {
        return userDTOMapper.map(userService.getUser(id));
    }

    @PostMapping(path = "/user")
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }
}
