package com.project.service;

import com.project.domain.Contact;
import com.project.domain.User;
import com.project.persistence.ContactMapper;

import com.project.persistence.PersonMapper;
import com.project.service.base.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("contactService")
@Transactional
public class ContactServiceImpl extends DBService<Contact> implements ContactService{

    @Autowired
    private ContactMapper _mapper;

    public void setContactMapper(ContactMapper contactMapper){
        _mapper = contactMapper;
    }

    protected ContactMapper getMapper(){
        return _mapper;
    }

    public Contact findByUserId(Long userid) {
        Contact contact = _mapper.findByUserId(userid);
        return contact;
    }

}
