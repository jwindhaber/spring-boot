package org.springframework.koans.boot.util;

import org.springframework.koans.boot.dto.VoteDto;
import org.springframework.koans.boot.persistence.entity.Vote;

import java.util.UUID;

public class VoteMappingUtil {

    public static Vote mapVoteDtoToEntity(VoteDto vote) {
        Vote voteEntity = new Vote();
        voteEntity.setVoteId(UUID.randomUUID().toString());
        voteEntity.setName(vote.getName());
        voteEntity.setParticipate(vote.getParticipate());
        voteEntity.setTimestamp(vote.getTimestamp());
        return voteEntity;
    }

}
