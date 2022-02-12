package com.kavi.rental.user.controller;

import com.kavi.rental.user.dto.UserDTO;
import com.kavi.rental.user.dto.mapper.UserDTOMapper;
import com.kavi.rental.user.model.User;
import com.kavi.rental.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class UserController {
    private UserService userService;
    private UserDTOMapper userDTOMapper;

    UserController (final UserDTOMapper userDTOMapper, final UserService userService) {
        this.userDTOMapper = userDTOMapper;
        this.userService = userService;
    }

    @RequestMapping("/")
    public String hello()
    {
        return "Demo User";
    }

    @RequestMapping("/user")
    public List<UserDTO> getAllUsers()
    {
        List<User> users = userService.getUsers();
        return users.stream().map(user -> userDTOMapper.map(user)).collect(toList());
    }

    @GetMapping("/user/{id}")
    public UserDTO getUser(@PathVariable int id)
    {
        return userDTOMapper.map(userService.getUser(id));
    }

    @GetMapping("/user/name/{name}")
    public UserDTO getUserByName(@PathVariable String name)
    {
        User user = userService.getByName(name);
        return user != null ? userDTOMapper.map(user) : null;
    }

    @PostMapping(path = "/user")
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

//    @GetMapping("/logout")
//    public String logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
//        JwtUtil.invalidateRelatedTokens(httpServletRequest);
//        CookieUtil.clear(httpServletResponse, jwtTokenCookieName);
//        return "redirect:/";
//    }
}

