package com.project.service;

import com.project.domain.User;

/**
 * Created by Denis on 13.08.2017.
 */


public interface UserService {

    User getUser(String login);

    User save(User user);

    void delete(User user);

}