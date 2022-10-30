package com.driver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MovieRepository {
    HashMap<String, Movie> mapOfMovies = new HashMap<>();
    HashMap<String, Director> mapOfDirector = new HashMap<>();
    HashMap<String, String> listOfMovieDirectorPair = new HashMap<>();

    void addMovie(Movie movie) {
        mapOfMovies.put(movie.getName(), movie);
    }

    void addDirector(Director director) {
        mapOfDirector.put(director.getName(), director);
    }

    void addMovieDirectorPair(String movieName, String directorName) {
        listOfMovieDirectorPair.put(movieName, directorName);
    }

    Movie getMovieByName(String movieName) {
        return mapOfMovies.get(movieName);
    }

    Director getDirectorByName(String directorName) {
        return mapOfDirector.get(directorName);
    }

    List<String> getMoviesByDirectorName(String directorname) {
        List listOfAllMoviesByDirector = new ArrayList();

        for (Map.Entry<String, String> entry : listOfMovieDirectorPair.entrySet()) {
            if (entry.getValue() == directorname) {
                listOfAllMoviesByDirector.add(entry.getKey());
            }

        }
        return listOfAllMoviesByDirector;
    }
    List<String> findAllMovies(){
        List listOfAllMovies=new ArrayList();
        for(String movieName:mapOfMovies.keySet()){
            listOfAllMovies.add(movieName);
        }
        return listOfAllMovies;
    }
    void deleteDirectorByName(String directorName) {
        for (Map.Entry<String, String> entry : listOfMovieDirectorPair.entrySet()) {
            if (entry.getValue() == directorName) {
                listOfMovieDirectorPair.remove(entry.getKey());
            }
        }
    }

    void deleteAllDirectors(){
        for (Map.Entry<String, String> entry : listOfMovieDirectorPair.entrySet()) {
            if (entry.getValue()!= null) {
                listOfMovieDirectorPair.remove(entry.getKey());
            }
        }
    }

}

