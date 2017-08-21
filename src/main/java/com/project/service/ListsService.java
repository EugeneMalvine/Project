package com.project.service;


import java.util.List;
import com.project.domain.Lists;

public interface ListsService {


    public List<Lists> findAll();

    public Lists findByName(String name);

    public Lists findByUserId(Long userlist);

    public Lists save(Lists lists);

    public void delete(Lists lists);

    //To clear collections
    public void clear();



}
