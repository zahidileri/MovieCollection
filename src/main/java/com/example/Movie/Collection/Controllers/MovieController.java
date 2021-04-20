package com.example.Movie.Collection.Controllers;

import com.example.Movie.Collection.Models.Movie;
import com.example.Movie.Collection.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @RequestMapping("/")
    public String getAllMovies(Model model){
        List<Movie> movies=movieService.getAllMovies();
        model.addAttribute("movies",movies);
        return "movieList";
    }

    @GetMapping(path = "/byLanguage{language}")
    public List<Movie> getMoviesByLanguage(String language){
        return movieService.getMoviesByLanguage(language);
    }
    @GetMapping(path = "/byMovieName{movieName}")
    public List<Movie> getMoviesByMovieName(String movieName){
        return movieService.getMoviesByMovieName(movieName);
    }

    @GetMapping(path = "/byActor{name}")
    public List<Movie> getMoviesByActor(String name){
        return movieService.getMoviesByActor(name);
    }

    @GetMapping(path = "/byGenre")
    public List<Movie> getMoviesByGenre(String genre){
        return movieService.getMoviesByGenre(genre);
    }

    @RequestMapping("/newMovieForm")
    public String newMovieForm(Model model){
        Movie movie=new Movie();
        model.addAttribute("movie",movie);
        return "newMovie";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editMovieForm(@PathVariable(name="id") long id){
        ModelAndView modelAndView = new ModelAndView("editMovie");
        Movie movie=movieService.getById(id);
        modelAndView.addObject("movie",movie);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteMovie(@PathVariable(name="id") long id){
        movieService.deleteMovie(id);
        return "redirect:/";
    }


    @RequestMapping(value = "/newMovie", method = RequestMethod.POST)
    public String addNewMovie(@ModelAttribute("movie") Movie movie){
        movieService.addNewMovie(movie);
        return "redirect:/";
    }


}
