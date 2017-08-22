package com.project.service;
import com.project.domain.Lists;
import com.project.domain.User;
import com.project.persistence.ListsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


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

    public List<Lists> findByUserId(Long userlist) {
        List<Lists> lists = listsMapper.findByUserId(userlist);
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
        delete(listsId);
    }

    public void delete(Long id){
        listsMapper.delete(id);
    }

    public boolean checkAuthority(User user, Long id){
        List<Long> mayAccess =  findByUserId(user.getId()).stream().map((Lists it) -> it.getId()).collect(Collectors.toList());
        //если текущий юзер не имеет права получать записи из этого списка кидаем исключение
        return mayAccess.contains(id);
    }

    public void clear(){
        List<Lists> listss = findAll();
        for (int i=0;i < listss.size();i++) {
            delete(listss.get(i));
        }
    }
}
