package com.techelevator.moviereviews;

import com.techelevator.moviereviews.dao.Movie;
import com.techelevator.moviereviews.dao.MovieDAO;
import com.techelevator.moviereviews.dao.Quote;
import com.techelevator.moviereviews.dao.QuoteDAO;
import com.techelevator.moviereviews.dto.MovieReviewDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private MovieDAO movieDAO;
    private QuoteDAO quoteDAO;

    public MovieController(MovieDAO movieDAO, QuoteDAO quoteDAO) {
        this.movieDAO = movieDAO;
        this.quoteDAO = quoteDAO;
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
    public MovieReviewDTO fetchReviews(@PathVariable long id) {
        MovieReviewDTO result = new MovieReviewDTO();
        Movie movie = movieDAO.getMovie(id);
        result.setMovieTitle(movie.getTitle());
        for (int i = 0; i < 3; i++) {
            Quote quote = quoteDAO.getRandomQuote();
            result.addReview(quote.getQuoteText());
        }
        return result;
    }

    @GetMapping("/quote")
    public Quote fetchQuote() {
        return quoteDAO.getRandomQuote();
    }

}
