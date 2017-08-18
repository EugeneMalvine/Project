package com.project.service;

import com.project.domain.User;
import com.project.persistence.PersonMapper;
import com.project.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Denis on 13.08.2017.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    UserMapper userMapper;

    public static UserMapper Mapper;

    public void setUserMapper(UserMapper userMapper){
        this.userMapper = userMapper;
        Mapper = userMapper;
    }

    @Override
    public User save(User user) {
        if(userMapper == null)
            userMapper = Mapper;

        User temp = userMapper.findByName(user.getLogin());
        //if user exist
        if(temp != null)
        {
            //maybe i must throw exception
            return null;
        }
        userMapper.insert(user);
        return userMapper.findByName(user.getLogin());
    }

    @Override
    public void delete(User user) {
        if(userMapper == null)
            userMapper = Mapper;
        userMapper.delete(user.getId());
    }


    @Override
    public User getUser(String name) {
        if(userMapper == null)
            userMapper = Mapper;
        return userMapper.findByName(name);
    }
}