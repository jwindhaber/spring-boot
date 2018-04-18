package org.springframework.koans.boot.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.koans.boot.persistence.entity.Vote;


public interface VoteRepository extends PagingAndSortingRepository<Vote, String> {

}
