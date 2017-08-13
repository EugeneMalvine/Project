package com.project.service;

import com.project.domain.User;
import org.springframework.stereotype.Service;

/**
 * Created by Denis on 13.08.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(String login) {
        User user = new User();
        user.setLogin(login);
        //sha1(1234)
        user.setPassword("7110eda4d09e062aa5e4a390b0a572ac0d2c0220");

        return user;
    }

}