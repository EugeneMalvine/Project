package com.project.service;

import com.project.domain.User;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class UserServiceTest {
    @Configuration
    static class UserServiceTestContextConfiguration{
        @Bean
        public UserServiceImpl userService(){
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserService userService;

    @Test
    public void getUser() throws Exception {
        String expLogin = "user";
        String expPassword = "user";
        
        User user = userService.getUser(expLogin);

        Assert.assertEquals(expLogin, user.getLogin());
        Assert.assertEquals(expPassword, user.getPassword());
    }

}