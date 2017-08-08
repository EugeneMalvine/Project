package com.vit.domain.service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vit.domain.Users;
import com.vit.domain.persistence.UsersMapper;
import java.util.List;

@Service("usersService")
@Repository
@Transactional
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    public List findAll() {
        List userss = usersMapper.findAll();
        return userss;
    }

    public Users findById(Long id) {
        Users users = usersMapper.findByID(id);
        return users;
    }

    public Users save(Users users) {
        if (users.getId() == null) {
            insert(users);
        } else {
            update(users);
        }
        return users;
    }

    private Users insert(Users users) {
        usersMapper.insert(users);
        return users;
    }

    private Users update(Users users) {
        usersMapper.update(users);
        return users;
    }

    public void delete(Users users) {
        Long usersId = users.getId();
        usersMapper.delete(usersId);
    }
}
