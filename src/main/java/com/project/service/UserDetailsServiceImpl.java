package com.project.service;

import com.project.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.project.domain.User;
import com.project.domain.enums.UserRoleEnum;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // с помощью нашего сервиса UserService получаем User
        User user = userService.getUser(email);
        if(user == null)
            return null;
        // указываем роли для этого пользователя
        Set<GrantedAuthority> roles = new HashSet();
        int role = user.getRole();

        //проверка первого бита на true
        if((role&1) != 0)
            roles.add(new SimpleGrantedAuthority(UserRoleEnum.ROLE_USER.name()));

        //проверка второго бита на true
        if((role&2) != 0)
            roles.add(new SimpleGrantedAuthority(UserRoleEnum.ROLE_ADMIN.name()));

        // на основании полученныйх даных формируем объект UserDetails
        // который позволит проверить введеный пользователем логин и пароль
        // и уже потом аутентифицировать пользователя
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getLogin(),
                        user.getPassword(),
                        roles);

        return userDetails;
    }

}