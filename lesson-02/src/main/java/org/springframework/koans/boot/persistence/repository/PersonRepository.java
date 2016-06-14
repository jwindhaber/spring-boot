package org.springframework.koans.boot.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.koans.boot.persistence.entity.Person;

/**
 * @author juergen.windhaber on 13.06.2016.
 * @since 1.0.0
 */
public interface PersonRepository extends PagingAndSortingRepository<Person, String> {

}
