package com.project.service;

import com.project.domain.User;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserServiceTest {
    @Configuration
    static class UserServiceTestContextConfiguration{
        @Bean
        public UserServiceImpl userService(){
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void getUser() throws Exception {
        String expLogin = "EXP_LOGIN";
        String expPassword = "7110eda4d09e062aa5e4a390b0a572ac0d2c0220";
        
        User user = userService.getUser(expLogin);

        Assert.assertEquals(expLogin, user.getLogin());
        Assert.assertEquals(expPassword, user.getPassword());
    }

}