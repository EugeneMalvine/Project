package com.project.service;


import java.util.List;
import com.project.domain.Lists;
import com.project.domain.User;

public interface ListsService {


    public List<Lists> findAll();

    public Lists findByName(String name);

    public List<Lists> findByUserId(Long userlist);

    public Lists save(Lists lists);

    public void delete(Lists lists);

    public void delete(Long id);

    //имеет ли user права на список id
    public boolean checkAuthority(User user, Long id);

    //To clear collections
    public void clear();



}
