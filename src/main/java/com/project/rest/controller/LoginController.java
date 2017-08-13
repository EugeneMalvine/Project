package com.project.rest.controller;

        import com.project.service.PersonService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.support.GenericXmlApplicationContext;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.validation.BindingResult;
        import org.springframework.web.bind.annotation.RestController;
        import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Denis on 11.08.2017.
 */
@RestController
@RequestMapping(value = "/login")
public class LoginController {
}
