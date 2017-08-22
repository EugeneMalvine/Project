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

    public static UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        User temp = userMapper.findByName(user.getUsername());
        //if user exist
        if(temp != null)
        {
            //maybe i must throw exception
            return null;
        }
        userMapper.insert(user);
        return userMapper.findByName(user.getUsername());
    }

    @Override
    public void delete(User user) {
        userMapper.delete(user.getId());
    }


    @Override
    public User getUser(String name) {
        return userMapper.findByName(name);
    }
}