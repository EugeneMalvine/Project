package com.project.persistence;

import com.project.domain.Person;

import java.util.List;

public interface PersonMapper {

    public List<Person> findAll();

    //получить диапазон записей
    //from - c какой записи
    //ammount - сколько записей
    public List<Person> findRange(int from,int ammount);

    public Person findById(Long id);

    public void insert(Person person);

    public void update(Person person);

    public void delete(Long id);

}
