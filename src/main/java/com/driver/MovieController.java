package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;


@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
            movieService.addMovie(movie);
            return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
            movieService.addDirector(director);
            return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("name") String Name,
                                                       @RequestParam("name") String name){
            movieService.addMovieDirectorPair(Name,name);
            return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name")String name){
        //Entity n = movieService.getMovieByName(name);
       // Movie m=new Movie();

        return new ResponseEntity<Movie>(movieService.getMovieByName(name),HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name")String name){
        //Director d=new Director();
        return new ResponseEntity<Director>(movieService.getDirectorByName(name),HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>>getMoviesByDirectorName(@PathVariable("director") String director){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(director),HttpStatus.OK);
    }

    @GetMapping("get-all-movies")
    public ResponseEntity<List<String>>findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("name") String name){
        movieService.deleteDirectorByName(name);
        return new ResponseEntity("success",HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity("success",HttpStatus.OK);
    }
}
