package com.vit.domain;
import java.io.Serializable;
import java.util.Date;

public class Users {
    private Long id;
    private String email;
    private String password;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    public  String getEmail(){
        return  email;
    }
    public void setPassword(String password){
        this.password= password;
    }
    public  String getPassword(){
        return  password;
    }
    public void setEmail(String email){
        this.email= email;
    }
    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + email + '\'' +
                ", lastName='" + password + '\'' +
                '}';
    }

}
