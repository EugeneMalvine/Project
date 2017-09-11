package com.project.service;

import com.project.domain.enums.UserRoleEnum;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml","classpath:TestContext.xml"})
public class UserDetailsServiceTest {
    @Configuration
    static class UserDetailsServiceTestContextConfiguration{
        @Bean
        public UserDetailsServiceImpl userDetailsService(){
            return new UserDetailsServiceImpl();
        }
        @Bean
        public UserServiceImpl userService(){
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @Test
    public void loadUserByUsername() throws Exception {
        String expLogin = "user";
        String expPassword = "12dea96fec20593566ab75692c9949596833adc9";
        Set<GrantedAuthority> expRoles = new HashSet();

        expRoles.add(new SimpleGrantedAuthority(UserRoleEnum.ROLE_USER.name()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(expLogin);

        Assert.assertEquals(expLogin, userDetails.getUsername());
        Assert.assertEquals(expPassword, userDetails.getPassword());
        Assert.assertEquals(expRoles, userDetails.getAuthorities());
    }

}