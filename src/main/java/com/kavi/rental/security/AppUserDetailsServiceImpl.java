package com.kavi.rental.security;


import com.kavi.rental.user.dao.UserDAO;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

//@Service
public class AppUserDetailsServiceImpl implements UserDetailsService {
    private UserDAO userDAO;

    public AppUserDetailsServiceImpl(UserDAO applicationUserRepository) {
        this.userDAO = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.kavi.rental.user.model.User applicationUser = null;
        try {
            applicationUser = this.loadUserData(username);
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getName(), applicationUser.getPassword(), emptyList());
    }

    public com.kavi.rental.user.model.User loadUserData(String username) throws UsernameNotFoundException {
        com.kavi.rental.user.model.User applicationUser = userDAO.getByName(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return applicationUser;
    }
}