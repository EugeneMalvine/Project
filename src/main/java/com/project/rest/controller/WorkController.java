package com.project.rest.controller;

import com.project.service.PersonService;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import com.project.domain.Person;

import java.util.List;

@RestController
@RequestMapping(value = "/functional")
public class WorkController {

    @Autowired
    private PersonService personMapper;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getUsers() {
        List<Person> temp = personMapper.findAll();
        return temp;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void addContact(@RequestBody Person contact) {
        personMapper.save(contact);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteContact(@RequestBody String id) {

        try {
            Long n_id = Long.parseLong(id ,10);
            Person toFind = personMapper.findById(n_id);
            if( toFind != null)
                personMapper.delete(toFind);
        }
        catch(Exception e){

        }
    }




    /*@RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public MyDataObject putMyData(@RequestBody MyDataObject md) {
        return md;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public MyDataObject postMyData() {
        return new MyDataObject(Calendar.getInstance(), "это ответ метода POST!");
    }

    @RequestMapping(value= "/{time}", method = RequestMethod.DELETE)
    @ResponseBody
    public MyDataObject deleteMyData(@PathVariable long time) {
        return new MyDataObject(Calendar.getInstance(), "Это ответ метода DELETE!");
    }*/
}
