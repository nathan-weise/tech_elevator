package com.techelevator.moviereviews.dao;

import java.util.List;

public interface MovieDAO {

    List<Movie> getAllMovies();
    Movie getMovie(long id);

    void updateMovie(Movie updatedMovie);

    void deleteMovie(long id);

}
