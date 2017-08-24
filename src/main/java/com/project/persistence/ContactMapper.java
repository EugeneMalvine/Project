package com.project.persistence;

import com.project.domain.Contact;
import java.util.List;

public interface ContactMapper {
    public List<Contact> findAll();

    public List<Contact> findByUserId(Long userid);

    public void insert(Contact lists);

    public void update(Contact lists);

    public void delete(Long id);
}
