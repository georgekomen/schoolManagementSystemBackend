package com.example.arafatproject.SchoolManagement.Domain.Authentication;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.arafatproject.SchoolManagement.Domain.view;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Permission implements Serializable {
    @JsonView(view.listView.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(view.listView.class)
    private String name;

    @JsonView(view.listView.class)
    private String description;

    public Permission(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Permission() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
