package org.springframework.koans.boot.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.koans.boot.persistence.entity.Person;

public interface PersonRepository extends PagingAndSortingRepository<Person, String> {

}
