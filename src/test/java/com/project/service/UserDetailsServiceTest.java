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
@ContextConfiguration
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
        String expLogin = "colibri";
        String expPassword = "7110eda4d09e062aa5e4a390b0a572ac0d2c0220";
        Set<GrantedAuthority> expRoles = new HashSet();

        expRoles.add(new SimpleGrantedAuthority(UserRoleEnum.USER.name()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(expLogin);

        Assert.assertEquals(expLogin, userDetails.getUsername());
        Assert.assertEquals(expPassword, userDetails.getPassword());
        Assert.assertEquals(expRoles, userDetails.getAuthorities());
    }

}