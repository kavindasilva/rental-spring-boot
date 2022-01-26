package com.kavi.rental.user;

import com.kavi.rental.user.dao.UserDAO;
import com.kavi.rental.user.dao.impl.UserDAOImpl;
import com.kavi.rental.user.dto.UserDTOMapper;
import com.kavi.rental.user.service.UserService;
import com.kavi.rental.user.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class serviceConfiguration {
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
}
