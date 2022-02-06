package com.kavi.rental.user.service;

import com.kavi.rental.user.model.User;

import java.util.List;

public interface UserService {
    User getUser(int id);
    User getByName(String name);
    List<User> getUsers();
    User addUser(User user);
}
