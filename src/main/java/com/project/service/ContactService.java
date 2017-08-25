package com.project.service;
import com.project.domain.Contact;
import com.project.service.base.IDBService;

public interface ContactService extends IDBService<Contact> {

    public Contact findByUserId(Long userid);

}
