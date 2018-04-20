package org.springframework.koans.boot.service;


import org.springframework.koans.boot.dto.VoteDto;
import org.springframework.koans.boot.persistence.entity.Vote;
import org.springframework.stereotype.Service;

import java.util.Set;

import static org.springframework.koans.boot.util.VoteMappingUtil.mapVoteDtoToEntity;

@Service
public class PartyServiceImpl implements PartyService {


    @Override
    public void castVote(VoteDto vote) {
        Vote voteEntity = mapVoteDtoToEntity(vote);
        //TODO create a repository for that
        //TODO save all votes in the database
    }

    @Override
    public Set<String> getParticipants() {
        throw new UnsupportedOperationException();
        //TODO find all votes in the database
        //return allParticipants(votes);
    }

    private Set<String> allParticipants(Iterable<Vote> votes) {
        //TODO implement participates method
        throw new UnsupportedOperationException();
    }


}
