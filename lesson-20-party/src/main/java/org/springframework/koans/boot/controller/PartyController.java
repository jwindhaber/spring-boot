package org.springframework.koans.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.koans.boot.dto.VoteDto;
import org.springframework.koans.boot.service.PartyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping(path = "/votes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void castVote(@RequestBody VoteDto vote) {
        partyService.castVote(vote);
    }

    @GetMapping(path = "/participants", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<String> getParticipants() {
        return partyService.getParticipants();
    }





}
