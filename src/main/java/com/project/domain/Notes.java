package com.project.domain;

import java.io.Serializable;

public class Notes implements Serializable,IEntity {

    private Long id;

    private String name;

    private Boolean checkmark;


    private Long listsid;

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

    public Boolean getCheckmark() {
        return checkmark;
    }

    public void setCheckmark(Boolean checkmark) {
        this.checkmark = checkmark;
    }


    public Long getListsid() {
        return listsid;
    }

    public void setListsid(Long listsid) {
        this.listsid = listsid;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", checkmark=" + checkmark +
                ", listsname='" + listsid + '\'' +
                '}';
    }
}
