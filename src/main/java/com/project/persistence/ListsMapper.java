package com.project.persistence;

import com.project.domain.Lists;
import java.util.List;

public interface ListsMapper {

    public List<Lists> findAll();

    public Lists findByName(String name);

    public Lists findByUserId(Long userlist);

    public void insert(Lists lists);

    public void update(Lists lists);

    public void delete(Long id);


}
