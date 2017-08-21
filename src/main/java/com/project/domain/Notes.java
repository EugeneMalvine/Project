package com.project.domain;

import java.io.Serializable;

public class Notes implements Serializable {

    private Long id;

    private String name;

    private Long checkmark;

    private String listsname;

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

    public Long getCheckmark() {
        return checkmark;
    }

    public void setCheckmark(Long checkmark) {
        this.checkmark = checkmark;
    }

    public String getListsname() {
        return listsname;
    }

    public void setListsname(String listsname) {
        this.listsname = listsname;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", checkmark=" + checkmark +
                ", listsname='" + listsname + '\'' +
                '}';
    }
}
