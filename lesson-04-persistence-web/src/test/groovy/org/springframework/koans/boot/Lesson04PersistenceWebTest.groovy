package org.springframework.koans.boot

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.koans.boot.persistence.entity.Person
import org.springframework.koans.boot.persistence.repository.PersonRepository
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.hamcrest.Matchers.is
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * @see org.springframework.boot.test.context.SpringBootTest
 * @see org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
 */
@SpringBootTest
@AutoConfigureMockMvc
class Lesson04PersistenceWebTest extends Specification {

    @Autowired
    private MockMvc mvc

    @Autowired
    private PersonRepository personRepository

    def "Getting Barney over the REST interface" () {

        when: "Barney is saved into the database"
        personRepository.save(new Person(name: "Barney", personId: "SomeId"))

        then: "Barney is retrieved over REST from the database"
        this.mvc.perform(get("/persons/SomeId").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.name', is("Barney")))

    }

}
