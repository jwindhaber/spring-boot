package org.springframework.koans.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.koans.persistence.entity.Person;

public interface PersonRepository extends PagingAndSortingRepository<Person, String> {

}
