package com.kavi.rental.user.service.impl;

import com.kavi.rental.user.dao.UserDAO;
import com.kavi.rental.user.model.User;
import com.kavi.rental.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.core.SpringVersion;

import javax.swing.*;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    @Mock
    private UserDAO userDAO;

    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.userService = new UserServiceImpl(userDAO);
    }

    @Test
    public void testGetUser() {
        Mockito.when(userDAO.get(Mockito.anyInt())).thenReturn(Mockito.mock(User.class));

        User result = userService.getUser(1);
        assertEquals(0, result.getId());
    }

    @Test
    public void testGetUsers() {
        Mockito.when(userDAO.get()).thenReturn(Collections.singletonList(Mockito.mock(User.class)));

        List<User> result = userService.getUsers();
        assertEquals(1, result.size());
    }

    @Test
    public void testGetByName() {
        Mockito.when(userDAO.getByName(Mockito.anyString())).thenReturn(Mockito.mock(User.class));

        User result = userService.getByName("a_name");
        assertEquals(0, result.getId());
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setId(101);
        user.setEmail("unitTestEmail");
        user.setName("unitTestName");

        Mockito.when(userDAO.create(Mockito.any(User.class))).thenReturn(user);

        User result = userService.addUser(Mockito.mock(User.class));
        assertEquals(101, result.getId());
        assertEquals("unitTestEmail", result.getEmail());
        assertEquals("unitTestName", result.getName());
    }
}