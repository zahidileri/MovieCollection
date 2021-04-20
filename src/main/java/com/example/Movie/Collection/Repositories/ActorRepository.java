package com.example.Movie.Collection.Repositories;

import com.example.Movie.Collection.Models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {


}
