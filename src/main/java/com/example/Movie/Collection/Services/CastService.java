package com.example.Movie.Collection.Services;

import com.example.Movie.Collection.Repositories.CastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CastService {
    private final CastRepository castRepository;

    @Autowired
    public CastService(CastRepository castRepository) {
        this.castRepository = castRepository;
    }
}
