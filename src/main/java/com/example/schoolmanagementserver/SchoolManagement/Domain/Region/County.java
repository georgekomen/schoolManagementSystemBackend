package com.example.schoolmanagementserver.SchoolManagement.Domain.Region;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.schoolmanagementserver.SchoolManagement.Domain.view;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class County {
    @JsonView(view.listView.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(view.listView.class)
    private String name;

    @JsonView(view.upTreeView.class)
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @JsonView(view.detailsView.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "county")
    private Set<SubCounty> subCounties = new HashSet<>();


    public County(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public County() {

    }

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<SubCounty> getSubCounties() {
        return subCounties;
    }

    public void setSubCounties(Set<SubCounty> subCounties) {
        this.subCounties = subCounties;
    }
}
