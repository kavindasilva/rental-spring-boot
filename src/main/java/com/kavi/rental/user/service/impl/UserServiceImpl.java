package com.kavi.rental.user.service.impl;

import com.kavi.rental.user.dao.UserDAO;
import com.kavi.rental.user.model.User;
import com.kavi.rental.user.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl(final UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUser(int id) {
        return userDAO.get(id);
    }

    @Override
    public User addUser(User user) {
        return userDAO.create(user);
    }

    @Override
    public List<User> getUsers() {
        return userDAO.get();
    }

    @Override
    public User getByName(String name) {
        return userDAO.getByName(name);
    }
}
