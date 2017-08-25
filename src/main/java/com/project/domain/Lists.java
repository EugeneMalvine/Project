package com.project.domain;

import java.io.Serializable;

public class Lists implements Serializable,IEntity {

    private Long id;

    private String name;

    private Long userlist;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userlist;
    }

    public void setUserId(Long user) {
        this.userlist = user;
    }

    @Override
    public String toString() {
        return "Lists{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + userlist +
                '}';
    }
}
