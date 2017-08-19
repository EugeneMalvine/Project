package com.project.service;

import com.project.domain.Person;
import com.project.persistence.PersonMapper;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PersonServiceTest {
    @Configuration
    static class PersonServiceTestContextConfiguration{
        @Bean
        public PersonServiceImpl personService(){
            return new PersonServiceImpl();
        }
        @Bean
        public PersonMapper personMapper(){
            return Mockito.mock(PersonMapper.class);
        }
    }

    @Autowired
    private PersonServiceImpl personService;
    @Autowired
    private PersonMapper personMapper;

    private Person expPerson = new Person();

    @Before
    public void setup(){
        expPerson.setId(1L);
        expPerson.setFirstName("firstname");
        expPerson.setLastName("lastname");
        personService.setPersonMapper(personMapper);

    }

    @Test
    public void findAll() throws Exception {
        List<Person> expPersons =  new ArrayList<>();
        expPersons.add(expPerson);
        Mockito.when(personMapper.findAll()).thenReturn(expPersons);
        List<Person> persons =  personService.findAll();

        Assert.assertEquals(expPersons,persons);
    }

    @Test
    public void findById(){
        Mockito.when(personMapper.findById(expPerson.getId())).thenReturn(expPerson);
        Person person = personService.findById(expPerson.getId());

        Assert.assertSame(expPerson,person);
    }

    @Test
    public void save() throws Exception {
        Person person = personService.save(expPerson);

        Assert.assertSame(expPerson, person);
    }
}