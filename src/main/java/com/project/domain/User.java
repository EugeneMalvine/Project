package com.project.domain;

import com.project.domain.enums.UserRoleEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Denis on 13.08.2017.
 */
public class User implements UserDetails {

    private String login;
    private String password;
    private long id;
    private int role;

      public User(String login, String password, int role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return login;
    }

    public void setUsername(String userName) {
          login = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // указываем роли для этого пользователя
        Set<GrantedAuthority> roles = new HashSet();
        //проверка первого бита на true
        if((role&1) != 0)
            roles.add(new SimpleGrantedAuthority(UserRoleEnum.ROLE_USER.name()));

        //проверка второго бита на true
        if((role&2) != 0)
            roles.add(new SimpleGrantedAuthority(UserRoleEnum.ROLE_ADMIN.name()));
        return roles;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", role=" + role +
                '}';
    }

}