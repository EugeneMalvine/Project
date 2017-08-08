package com.project.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/")
public class MainController {

    @RequestMapping(value= "/{text}", method = RequestMethod.GET)
    @ResponseBody
    public String getMyData(@PathVariable String text) {
        return text;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "Hello =) To use this service, add to this uri some string for example : /lolkek";
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
