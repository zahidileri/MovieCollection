package com.example.Movie.Collection.Repositories;

import com.example.Movie.Collection.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastRepository extends JpaRepository<Role,Long> {
}
