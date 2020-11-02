package com.techelevator.moviereviews.dao;

import com.techelevator.moviereviews.dto.QuoteGardenDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestQuoteDAO implements QuoteDAO {


    @Override
    public Quote getRandomQuote() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            QuoteGardenDTO response = restTemplate.getForObject("https://quote-garden.herokuapp.com/api/v2/quotes/random",
                    QuoteGardenDTO.class);
            return response.getQuote();
        } catch (ResourceAccessException | RestClientResponseException e) {
            return null;
        }
    }
}
