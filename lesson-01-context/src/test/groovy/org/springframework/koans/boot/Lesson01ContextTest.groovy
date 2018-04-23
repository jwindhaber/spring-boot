package org.springframework.koans.boot

import org.junit.Assert
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.core.env.Environment
import spock.lang.Specification

/**
 * See: <a href="https://docs.spring.io/spring-boot/docs/2.0.0.RELEASE/reference/htmlsingle/#boot-features-testing-spring-boot-applications">Testing Spring Boot applications</a>
 */
@SpringBootTest
class Lesson01ContextTest extends Specification {

    @Autowired
    ApplicationContext context

    def "Spring Boot starts and the Environment can be loaded" () {

        when: "The environment is fetched from the context"
        Environment environment = context.getEnvironment()

        then: "The environment is present"
        noExceptionThrown()
        environment != null

    }


}
