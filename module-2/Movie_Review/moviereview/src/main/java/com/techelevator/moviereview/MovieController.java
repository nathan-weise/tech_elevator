package com.techelevator.moviereview;

import com.techelevator.moviereview.dao.Movie;
import com.techelevator.moviereview.dao.MovieDAO;
import com.techelevator.moviereview.dao.Quote;
import com.techelevator.moviereview.dao.QuoteDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private MovieDAO movieDAO;
    private QuoteDAO quoteDAO;

    public QuoteDAO getQuoteDAO() {
        return quoteDAO;
    }

    public void setQuoteDAO(QuoteDAO quoteDAO) {
        this.quoteDAO = quoteDAO;
    }

    public MovieController(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    @GetMapping("/movies")
    public List<Movie> listMovies() {
    return movieDAO.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie fetchMovie(@PathVariable long id) {
        return movieDAO.getMovie(id);
    }

    @GetMapping("/movies/{id}/reviews")
    public MovieReview fetchReviews(@PathVariable long id) {
        Movie movie = movieDAO.getMovie(id);
        for (int i = 0; i < 3; i++) {
            Quote quote = quoteDAO.getRandomQuote();
        }
    }

}
