package com.example.Movie.Collection.Services;

import com.example.Movie.Collection.Models.Movie;
import com.example.Movie.Collection.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    public List<Movie> getMoviesByLanguage(String language){
        return movieRepository.getMoviesByLanguage(language);

    }

    public Movie getById(long id){
        return movieRepository.getOne(id);
    }
    public List<Movie> getMoviesByMovieName(String movieName){
        return movieRepository.getMoviesByMovieName(movieName);
    }
    public List<Movie> getMoviesByActor(String name) {
        return movieRepository.getMoviesByActor(name);
    }

    public void addNewMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.getMoviesByGenre(genre);
    }


    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
