package com.project.service;


import java.util.List;
import com.project.domain.Lists;
import com.project.domain.User;
import com.project.service.base.IDBService;

public interface ListsService extends IDBService<Lists> {

    Lists findByName(String name);

    List<Lists> findByUserId(Long userlist);

    //имеет ли user права на список id
    boolean checkAuthority(User user, Long id);

    void deepDelete(Long id);

}
