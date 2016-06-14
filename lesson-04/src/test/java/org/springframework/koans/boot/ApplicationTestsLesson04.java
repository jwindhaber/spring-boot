package org.springframework.koans.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.koans.boot.persistence.entity.Person;
import org.springframework.koans.boot.persistence.repository.PersonRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTestsLesson04 {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PersonRepository personRepository;


    @Test
    public void getBarneyOverRest() throws Exception {

        Person person = new Person();
        person.setName("Barney");
        person.setPersonId("abc");
        personRepository.save(person);

        this.mvc.perform(get("/persons/abc").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Barney")));

    }

}
