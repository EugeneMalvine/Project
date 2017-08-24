package com.project.service;

import com.project.domain.Contact;
import com.project.domain.User;
import com.project.persistence.ContactMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class ContactServiceImpl implements ContactService{

    private static ContactMapper contactMapper;

    public void setListsMapper(ContactMapper contactMapper){
        this.contactMapper = contactMapper;
    }

    public List<Contact> findAll() {
        List<Contact> contacts = contactMapper.findAll();
        return contacts;
    }


    public List<Contact> findByUserId(Long userid) {
        List<Contact> contact = contactMapper.findByUserId(userid);
        return contact;
    }

    public Contact save(Contact contact) {
        if (contact.getId() == null) {
            insert(contact);
        } else {
            update(contact);
        }
        return contact;
    }

    private Contact insert(Contact contact) {
        contactMapper.insert(contact);
        return contact;
    }

    private Contact update(Contact contact) {
        contactMapper.update(contact);
        return contact;
    }

    public void delete(Contact contact) {
        Long contactId = contact.getId();
        delete(contactId);
    }

    public void delete(Long id){
        contactMapper.delete(id);
    }

    public void clear(){
        List<Contact> contacts = findAll();
        for (int i=0;i < contacts.size();i++) {
            delete(contacts.get(i));
        }
    }

}
