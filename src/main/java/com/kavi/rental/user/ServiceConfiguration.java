package com.kavi.rental.user;

import com.kavi.rental.security.AppUserDetailsServiceImpl;
import com.kavi.rental.security.WebSecurity;
import com.kavi.rental.user.dao.UserDAO;
import com.kavi.rental.user.dao.impl.UserDAOImpl;
import com.kavi.rental.user.dto.mapper.UserDTOMapper;
import com.kavi.rental.user.service.UserService;
import com.kavi.rental.user.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ServiceConfiguration {
    @Bean(name = "com.kavi.rental.user.dto.UserDTOMapper")
    UserDTOMapper getUserDTOMapper() {
        return new UserDTOMapper();
    }

    @Bean(name = "com.kavi.rental.user.dao.UserDAO")
    UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    @Bean(name = "com.kavi.rental.user.service.UserService")
    UserService getUserService() {
        return new UserServiceImpl(getUserDAO());
    }

    @Bean(name = "com.kavi.rental.security.AppUserDetailsServiceImpl")
    UserDetailsService getUserDetailsService() {
        return new AppUserDetailsServiceImpl(getUserDAO());
    }

    @Bean(name = "com.kavi.rental.security.AppUserDetailsServiceImpl")
    WebSecurity getWebSecurity() {
        return new WebSecurity(getUserDetailsService(), getBCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
