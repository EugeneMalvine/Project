package com.project.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

    //temporary: redirect to work page
    @RequestMapping(method = RequestMethod.GET)
    public String mainPage(Model model){
        return "work";
    }

}
