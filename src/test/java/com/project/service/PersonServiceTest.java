package com.project.service;

import com.project.domain.Contact;
import com.project.domain.Person;
import com.project.persistence.PersonMapper;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class PersonServiceTest {

    @Autowired
    private PersonService personService;


    @Test
    public void findById(){

        Person person = personService.findById(-1l);

        Assert.assertEquals(person.getId(),new Long(-1l));

    }


    @Test
    public void findAll() {

        Long size = new Long(personService.findAll().size());

        Assert.assertEquals(size,personService.size());

    }

    @Test
    public void delete(){
        Person person = new Person();
        person.setFirstName("Test");
        person.setLastName("Test");

        personService.insert(person);

        Person person2 = personService.findById(person.getId());

        Assert.assertEquals(person.getId(),person2.getId());

        personService.delete(person.getId());

        person2 = personService.findById(person.getId());

        Assert.assertNull(person2);
    }

    @Test
    public void update(){
        Person person = new Person();
        person.setFirstName("Test");
        person.setLastName("Test");

        personService.insert(person);

        Person person2 = personService.findById(person.getId());

        Assert.assertEquals(person.getId(),person2.getId());

        person2.setFirstName("Updated");

        personService.update(person2);

        person2 = personService.findById(person.getId());

        Assert.assertEquals(person2.getFirstName(),"Updated");

        person2.setId(100l);

        personService.update(person2);

        person2 = personService.findById(person.getId());

        Assert.assertEquals(person.getId(),person2.getId());

        personService.delete(person.getId());
        personService.delete(person2.getId());
    }
}