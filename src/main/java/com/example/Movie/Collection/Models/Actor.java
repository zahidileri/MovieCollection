package com.example.Movie.Collection.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @OneToMany
    private Set<Role> roles = new HashSet<>();
    public Actor(){

    }

    public Actor(String name, Set<Role> roles) {
        this.name = name;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getActorName() {
        return name;
    }

    public void setActorName(String actorName) {
        this.name = actorName;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "Actor{" +
                "actorName='" + name + '\'' +
                ", casts=" + roles +
                '}';
    }
}