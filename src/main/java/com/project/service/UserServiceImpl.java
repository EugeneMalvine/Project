package com.project.service;

import com.project.domain.User;
import com.project.persistence.PersonMapper;
import com.project.persistence.UserMapper;
import com.project.service.base.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Denis on 13.08.2017.
 */
@Service("userService")
@Transactional
public class UserServiceImpl extends DBService<User> implements UserService {

    @Autowired
    private UserMapper _mapper;

    protected UserMapper getMapper(){
        return _mapper;
    }

    public void setUserMapper(UserMapper userMapper){
        this._mapper = userMapper;
    }

    @Override
    public User getUser(String name) {
        return _mapper.findByName(name);
    }
}