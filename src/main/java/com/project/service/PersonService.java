package com.project.service;

import com.project.domain.Person;

import java.util.List;

public interface PersonService {

    // Find all persons
    public List<Person> findAll();

    // Find by ID - person
    public Person findById(Long id);

    // Create a new or save an existing person
    public Person save(Person person);

    // Delete a person
    public void delete(Person person);

    //To clear collections
    public void clear();

    //получить диапазон записей
    //from - c какой записи
    //ammount - сколько записей
    public List<Person> findRange(int from,int ammount);

}
