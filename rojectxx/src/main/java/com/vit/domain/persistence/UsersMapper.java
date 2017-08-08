package com.vit.domain.persistence;
import com.vit.domain.Users;
import java.util.List;

public interface UsersMapper {
    public List findAll();

    public Users findByID(Long id);

    public  void insert(Users users);

    public  void update(Users users);

    public  void delete(Long id);
}
