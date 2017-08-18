package com.project.persistence;

import com.project.domain.Person;
import com.project.domain.User;

import java.util.List;

public interface UserMapper {

    public User findByName(String name);

    public void insert(User user);

    public void delete(Long id);

}
