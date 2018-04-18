package org.springframework.koans.boot.service;

import org.springframework.koans.boot.dto.VoteDto;

import java.util.Set;

public interface PartyService {
    void castVote(VoteDto vote);

    Set<String> getParticipants();
}
