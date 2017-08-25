package com.project.service;

import com.project.domain.User;
import com.project.service.base.IDBService;

/**
 * Created by Denis on 13.08.2017.
 */


public interface UserService extends IDBService<User> {

    User getUser(String login);

}