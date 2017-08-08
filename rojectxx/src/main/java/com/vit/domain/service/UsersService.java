package com.vit.domain.service;
import com.vit.domain.Users;
import java.util.List;

public interface UsersService {
    // Find all users
    public List findAll();

    // Find by ID - users
    public Users findById(Long id);

    // Create a new or save an existing users
    public Users save(Users users);

    // Delete a users
    public void delete(Users users);
}
