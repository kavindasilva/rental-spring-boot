package com.kavi.rental.user.service.impl;

import com.kavi.rental.user.dao.UserDAO;
import com.kavi.rental.user.model.User;
import com.kavi.rental.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

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
}
