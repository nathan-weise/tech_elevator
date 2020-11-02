package com.techelevator.services;

import com.techelevator.models.LoginDTO;
import org.springframework.http.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

public class AuthenticationService {

    private final String baseUrl;
    private RestTemplate restTemplate = new RestTemplate();

    public AuthenticationService(String url) {
        this.baseUrl = url;
    }


    public ResponseEntity<Map> login(String credentials) throws AuthenticationServiceException {
        LoginDTO loginDTO = new LoginDTO(credentials);
        ResponseEntity<Map> response = null;
        try {
        	// create the HttpHeaders and HttpEntity, and then send the login request here

        } catch(RestClientResponseException ex) {
            if (ex.getRawStatusCode() == 401 && ex.getResponseBodyAsString().length() == 0) {
                String message = ex.getRawStatusCode() + " : {\"timestamp\":\"" + LocalDateTime.now() + "+00:00\",\"status\":401,\"error\":\"Invalid credentials\",\"message\":\"Login failed: Invalid username or password\",\"path\":\"/login\"}";
                throw new AuthenticationServiceException(message);
            }
            else {
                String message = ex.getRawStatusCode() + " : " + ex.getResponseBodyAsString();
                throw new AuthenticationServiceException(message);
            }
        }
        return response;
    }

}
