package com.techelevator.moviereviews.dto;

import java.util.ArrayList;
import java.util.List;

public class MovieReviewDTO {

    private String movieTitle;
    private List<String> reviews = new ArrayList<>();

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void addReview(String review) {
        reviews.add(review);
    }

    public List<String> getReviews() {
        return reviews;
    }
}
