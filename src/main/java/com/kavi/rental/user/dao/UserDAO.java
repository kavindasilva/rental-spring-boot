package com.kavi.rental.user.dao;

import com.kavi.rental.user.model.User;

import java.util.List;

public interface UserDAO {
    User create(User user);
    User get(int id);
    List<User> get();
}
