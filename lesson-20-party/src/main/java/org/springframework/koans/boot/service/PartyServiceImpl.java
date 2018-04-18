package org.springframework.koans.boot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.koans.boot.dto.VoteDto;
import org.springframework.koans.boot.persistence.entity.Vote;
import org.springframework.koans.boot.persistence.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.StreamSupport;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
import static org.springframework.koans.boot.util.VoteMappingUtil.mapVoteDtoToEntity;

@Service
public class PartyServiceImpl implements PartyService {


    @Autowired
    VoteRepository voteRepository;

    @Override
    public void castVote(VoteDto vote) {
        Vote voteEntity = mapVoteDtoToEntity(vote);
        voteRepository.save(voteEntity);
    }

    @Override
    public Set<String> getParticipants() {
        Iterable<Vote> votes = voteRepository.findAll();
        return allParticipants(votes);
    }

    private Set<String> allParticipants(Iterable<Vote> votes) {
        Map<String, Boolean> participantsMap = StreamSupport.stream(votes.spliterator(), false)
                .collect(groupingBy(vote -> vote.getName().toLowerCase(),
                        collectingAndThen(maxBy(comparing(Vote::getTimestamp)), optionalVote -> optionalVote.get().getParticipate())));

        HashSet<String> participants = participantsMap.entrySet().stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .collect(toCollection(HashSet::new));

        return participants;
    }


}
