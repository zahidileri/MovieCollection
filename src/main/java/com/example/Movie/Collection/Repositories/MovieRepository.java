package com.example.Movie.Collection.Repositories;

import com.example.Movie.Collection.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Query(value = "select * from movie where movie.id in(select movie_id from movie_languages where languages_id in(select id from language where language=?1))",nativeQuery = true)
    List<Movie> getMoviesByLanguage(String language);

    @Query(value = "select * from movie where movie.id in(select movie_id from role where actor_id in(select id from actor where name =?1))",nativeQuery = true)
    List<Movie> getMoviesByActor(String name);

    @Query(value = "select * from movie where genre=?1", nativeQuery = true)
    List<Movie> getMoviesByGenre(String genre);

    @Query(value = "select * from movie where movie_name=?1",nativeQuery = true)
    List<Movie> getMoviesByMovieName(String movieName);

}
