package com.techelevator.example.controller;

import com.techelevator.example.model.Vote;
import com.techelevator.example.model.VoteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@PreAuthorize("isAuthenticated()")
public class VoteController {

    private Map<String,Vote> allVotes = new HashMap<>();


    @PostMapping("/vote")
    public Vote castVote(@Valid @RequestBody VoteDTO voteDTO, Principal principal) {

        if (allVotes.containsKey(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You can only vote once!");
        }

        Vote newVote = new Vote();
        newVote.setYesOrNo(voteDTO.getYesOrNo());
        newVote.setUsername(principal.getName());

        allVotes.put(newVote.getUsername(), newVote);

        return newVote;
    }

}
