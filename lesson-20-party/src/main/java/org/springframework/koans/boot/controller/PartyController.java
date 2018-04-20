package org.springframework.koans.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.koans.boot.dto.VoteDto;
import org.springframework.koans.boot.service.PartyService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @see RestController
 *
 */
@RestController
public class PartyController {

    @Autowired
    PartyService partyService;

    //TODO do PostMapping
    public void castVote(@RequestBody VoteDto vote) {
        partyService.castVote(vote);
    }

    //TODO do GetMapping
    public Set<String> getParticipants() {
        return partyService.getParticipants();
    }





}
