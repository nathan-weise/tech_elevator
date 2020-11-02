package com.techelevator.moviereviews.dto;

import com.techelevator.moviereviews.dao.Quote;

public class QuoteGardenDTO {

    private int statusCode;
    private Quote quote;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }
}
