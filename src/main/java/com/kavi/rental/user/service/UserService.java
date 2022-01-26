package com.kavi.rental.user.service;

import com.kavi.rental.user.model.User;

import java.util.List;

public interface UserService {
    User getUser(int id);
    List<User> getUsers();
    User addUser(User user);
}
