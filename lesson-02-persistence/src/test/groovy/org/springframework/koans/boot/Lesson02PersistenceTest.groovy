package org.springframework.koans.boot

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.core.env.Environment
import org.springframework.koans.boot.persistence.entity.Person
import org.springframework.koans.boot.persistence.repository.PersonRepository
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Specification

/**
 *
 * See: <a href="http://docs.spring.io/spring-boot/docs/2.0.0.RELEASE/reference/htmlsingle/#boot-features-testing-spring-boot-applications-testing-autoconfigured-jpa-test">Auto-configured Data JPA tests</a>
 *
 * @see org.springframework.koans.boot.config.persistence.PersistenceConfiguration
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
