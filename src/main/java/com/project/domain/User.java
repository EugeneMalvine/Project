package com.project.domain;

/**
 * Created by Denis on 13.08.2017.
 */
public class User {

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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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