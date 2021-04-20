package com.example.Movie.Collection.Controllers;

import com.example.Movie.Collection.Services.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CastController {
    private final CastService castService;

    @Autowired
    public CastController(CastService castService) {
        this.castService = castService;
    }
}
