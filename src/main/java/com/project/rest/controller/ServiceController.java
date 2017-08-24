package com.project.rest.controller;

import com.project.domain.Lists;
import com.project.domain.Notes;
import com.project.domain.User;
import com.project.service.ListsService;
import com.project.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/service")
public class ServiceController {

    @RequestMapping(value = "/credential",method = RequestMethod.GET)
    @ResponseBody
    public User getLists() {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }



}
