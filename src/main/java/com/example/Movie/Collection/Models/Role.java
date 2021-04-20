package com.example.Movie.Collection.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;
    @ManyToOne
    private Movie movie;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Actor actor;
    public Role(){

    }

    public Role(String roleName, Movie movie, Actor actor) {
        this.roleName = roleName;
        this.movie = movie;
        this.actor = actor;
    }

    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Cast{" +
                "role='" + roleName + '\'' +
                ", movie=" + movie +
                ", actor=" + actor +
                '}';
    }
}
