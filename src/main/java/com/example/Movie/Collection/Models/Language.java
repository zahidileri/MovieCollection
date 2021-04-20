package com.example.Movie.Collection.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String language;
    @ManyToMany
    private Set<Movie> movies=new HashSet<>();
    public Language(){

    }

    public Language(String language, Set<Movie> movies) {
        this.language = language;
        this.movies = movies;
    }

    public Long getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Language{" +
                "language='" + language + '\'' +
                ", movies=" + movies +
                '}';
    }
}
