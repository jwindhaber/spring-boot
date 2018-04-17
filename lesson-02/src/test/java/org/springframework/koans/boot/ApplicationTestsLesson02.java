package org.springframework.koans.boot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.koans.boot.config.persistence.PersistenceConfiguration;
import org.springframework.koans.boot.persistence.entity.Person;
import org.springframework.koans.boot.persistence.repository.PersonRepository;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * See: <a href="http://docs.spring.io/spring-boot/docs/1.4.0.M3/reference/htmlsingle/#boot-features-testing-spring-boot-applications-testing-autoconfigured-jpa-test">Auto-configured Data JPA tests</a>
 *
 * @see PersistenceConfiguration
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ApplicationTestsLesson02 {

    @Autowired
    private PersonRepository personRepository;


    @Test
    public void repositoryTest() {

        Person person = new Person();
        person.setName("Barney");
        person.setPersonId("abc");

        personRepository.save(person);

        final Person personAbc = personRepository.findOne("abc");

        Assert.assertEquals(personAbc.getName(), "Barney");

        System.out.println(personAbc.getName());

    }

}
