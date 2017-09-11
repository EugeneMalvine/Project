package com.project.service;

import com.project.domain.User;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml","classpath:TestContext.xml"})
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
        String expPassword = "12dea96fec20593566ab75692c9949596833adc9";
        
        User user = userService.getUser(expLogin);

        Assert.assertEquals(expLogin, user.getUsername());
        Assert.assertEquals(expPassword, user.getPassword());
    }

}