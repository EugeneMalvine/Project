package com.project.service;
import com.project.domain.Lists;
import com.project.persistence.ListsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("listsService")
@Transactional
public class ListsServiceImpl implements ListsService {
    private static ListsMapper listsMapper;

    public void setListsMapper(ListsMapper listsMapper){
        this.listsMapper = listsMapper;
    }

    public List<Lists> findAll() {
        List<Lists> listss = listsMapper.findAll();
        return listss;
    }

    public Lists findByName(String name) {
        Lists lists = listsMapper.findByName(name);
        return lists;
    }

    public Lists findByUserId(Long userlist) {
        Lists lists = listsMapper.findByUserId(userlist);
        return lists;
    }

    public Lists save(Lists lists) {
        if (lists.getId() == null) {
            insert(lists);
        } else {
            update(lists);
        }
        return lists;
    }

    private Lists insert(Lists lists) {
        listsMapper.insert(lists);
        return lists;
    }

    private Lists update(Lists lists) {
        listsMapper.update(lists);
        return lists;
    }

    public void delete(Lists lists) {
        Long listsId = lists.getId();
        listsMapper.delete(listsId);
    }

    public void clear(){
        List<Lists> listss = listsMapper.findAll();
        for (int i=0;i < listss.size();i++) {
            delete(listss.get(i));
        }
    }
}
