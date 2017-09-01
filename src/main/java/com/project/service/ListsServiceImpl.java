package com.project.service;
import com.project.domain.Lists;
import com.project.domain.User;
import com.project.persistence.ContactMapper;
import com.project.persistence.ListsMapper;
import com.project.service.base.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service("listsService")
@Transactional
public class ListsServiceImpl extends DBService<Lists> implements ListsService {

    @Autowired
    private ListsMapper _mapper;


    public void setListsMapper(ListsMapper listsMapper){
        this._mapper = listsMapper;
    }

    protected ListsMapper getMapper(){
        return _mapper;
    }


    public Lists findByName(String name) {
        Lists lists = _mapper.findByName(name);
        return lists;
    }

    public List<Lists> findByUserId(Long userlist) {
        List<Lists> lists = _mapper.findByUserId(userlist);
        return lists;
    }

    public boolean checkAuthority(User user, Long id){
        List<Long> mayAccess =  findByUserId(user.getId()).stream().map((Lists it) -> it.getId()).collect(Collectors.toList());
        //если текущий юзер не имеет права получать записи из этого списка кидаем исключение
        return mayAccess.contains(id);
    }

    public void deepDelete(Long id){
        _mapper.deepDelete(id);
    }
}
