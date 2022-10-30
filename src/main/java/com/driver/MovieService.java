package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }

    void addDirector(Director director){
        movieRepository.addDirector(director);
    }

    void addMovieDirectorPair(String movieName, String directorName){
        movieRepository.addMovieDirectorPair(movieName,directorName);
    }
    Movie getMovieByName(String movieName){
        return movieRepository.getMovieByName(movieName);
    }

    Director getDirectorByName(String directorName){
        return movieRepository.getDirectorByName(directorName);
    }

    List<String> getMoviesByDirectorName(String directorname){
        return movieRepository.getMoviesByDirectorName(directorname);
    }

    List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    void deleteDirectorByName(String directorName) {
        movieRepository.deleteDirectorByName(directorName);
    }

    void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }
}
