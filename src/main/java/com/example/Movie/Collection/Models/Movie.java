package com.example.Movie.Collection.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String movieName;
    @NotNull
    private LocalDateTime year;
    @NotNull
    private String genre;
    private String descriptions;
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Role> roles = new HashSet<>();
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Language>languages=new HashSet<>();

    public Movie(){

    }
    public Movie(String movieName, LocalDateTime year, String genre, String descriptions, Set<Role> roles, Set<Language> languages) {
        this.movieName = movieName;
        this.year = year;
        this.genre = genre;
        this.descriptions = descriptions;
        this.roles = roles;
        this.languages = languages;
    }

    public long getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public LocalDateTime getYear() {
        return year;
    }

    public void setYear(LocalDateTime year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", casts=" + roles +
                ", languages=" + languages +
                '}';
    }
}