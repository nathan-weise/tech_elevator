package com.techelevator.moviereview.dao;

import com.techelevator.moviereview.dto.QuoteGardenDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Component
public class RestQuoteDAO implements QuoteDAO {
    @Override
    public Quote getRandomQuote() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            QuoteGardenDTO response = restTemplate.getForObject("https://quote-garden.herokuapp.com/api/v2/quotes/random", QuoteGardenDTO.class);
            return response.getQuote();
        } catch (ResponseStatusException | ResourceAccessException e) {
            return null;
        }
    }
}
