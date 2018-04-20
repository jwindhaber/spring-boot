package org.springframework.koans.boot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.koans.persistence.entity.Person
import org.springframework.koans.persistence.repository.PersonRepository
import spock.lang.Specification

/**
 *
 * See: <a href="http://docs.spring.io/spring-boot/docs/2.0.0.RELEASE/reference/htmlsingle/#boot-features-testing-spring-boot-applications-testing-autoconfigured-jpa-test">Auto-configured Data JPA tests</a>
 *
 */
@DataJpaTest
class Lesson02PersistenceTest extends Specification {

    @Autowired
    private PersonRepository personRepository


    def "Saving Barney into the database and retrieving it again" () {

        setup: "Barney is saved into the database"
        personRepository.save(new Person(name: "Barney", personId: "SomeId"))

        when: "The person is retrieved"
        final Optional<Person> person = personRepository.findById("SomeId")

        then: "Its name is Barney"
        noExceptionThrown()
        person.isPresent()
        person.get().name == "Barney"

    }




}
