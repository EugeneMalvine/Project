package com.project.service;

import com.project.domain.Person;
import com.project.persistence.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

    private PersonMapper personMapper;

    public void setPersonMapper(PersonMapper personMapper){
        this.personMapper = personMapper;
    }

    public List<Person> findAll() {
        List<Person> persons = personMapper.findAll();
        return persons;
    }

    public Person findById(Long id) {
        Person person = personMapper.findById(id);
        return person;
    }

    public Person save(Person person) {
        if (person.getId() == null) {
            insert(person);
        } else {
            update(person);
        }
        return person;
    }

    private Person insert(Person person) {
        personMapper.insert(person);
        return person;
    }

    private Person update(Person person) {
        personMapper.update(person);
        return person;
    }

    public void delete(Person person) {
        Long personId = person.getId();
        personMapper.delete(personId);
    }

    public void clear(){
        List<Person> persons = personMapper.findAll();
        for (int i=0;i < persons.size();i++) {
            delete(persons.get(i));
        }
    }
}
