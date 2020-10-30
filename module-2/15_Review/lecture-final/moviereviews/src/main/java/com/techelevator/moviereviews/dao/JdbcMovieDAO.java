package com.techelevator.moviereviews.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMovieDAO implements MovieDAO {

    private static final String ALL_FIELDS = "film_id, title, description, release_year";

    private JdbcTemplate jdbcTemplate;

    public JdbcMovieDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Movie> getAllMovies() {
        List<Movie> result = new ArrayList<>();
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet("SELECT " + ALL_FIELDS + " FROM film;");
        while (rowSet.next()) {
            Movie movie = mapRowToMovie(rowSet);
            result.add(movie);
        }
        return result;
    }

    @Override
    public Movie getMovie(long id) {
        Movie result = null;
        String sql = "SELECT " + ALL_FIELDS + " FROM film WHERE film_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);
        if (rowSet.next()) {
            result = mapRowToMovie(rowSet);
        }
        return result;
    }

    @Override
    public void updateMovie(Movie updatedMovie) {

    }

    @Override
    public void deleteMovie(long id) {

    }

    private Movie mapRowToMovie(SqlRowSet rowSet) {
        Movie movie = new Movie();
        movie.setId(rowSet.getLong("film_id"));
        movie.setTitle(rowSet.getString("title"));
        movie.setDescription(rowSet.getString("description"));
        movie.setReleaseYear(rowSet.getInt("release_year"));
        return movie;
    }
}
