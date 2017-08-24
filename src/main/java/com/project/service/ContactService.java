package com.project.service;
import java.util.List;
import com.project.domain.Contact;
import com.project.domain.User;
import com.project.persistence.ContactMapper;

public interface ContactService {

    public List<Contact> findAll();

    public List<Contact> findByUserId(Long userid);

    public Contact save(Contact contact);

    public void delete(Contact contact);

    public void delete(Long id);

    //To clear collections
    public void clear();
}
