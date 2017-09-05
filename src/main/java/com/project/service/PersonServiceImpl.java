package com.project.service;

import com.project.domain.Person;
import com.project.persistence.PersonMapper;
import com.project.service.base.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("personService")
public class PersonServiceImpl extends DBService<Person> implements PersonService {

    @Autowired
    private PersonMapper _mapper;

    public void setPersonMapper(PersonMapper personMapper){
        this._mapper = personMapper;
    }

    protected PersonMapper getMapper(){
        return _mapper;
    }
}
