package org.springframework.koans.boot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * See: <a href="http://docs.spring.io/spring-boot/docs/2.0.0.RELEASE/reference/htmlsingle/#boot-features-testing-spring-boot-applications-testing-autoconfigured-mvc-tests">Auto-configured Spring MVC tests</a>
 *
 */
class Lesson03WebTest extends Specification {

    @Autowired
    private MockMvc mvc

    @Autowired(required = false)
    private JdbcTemplate jdbcTemplate

    def "Hello world REST response" () {

        when: "REST call is performed"
        ResultActions result = mvc.perform(get("/hello").accept(MediaType.TEXT_PLAIN))

        then: "We are getting a nice hello world back"
        result.andExpect(status().isOk()).andExpect(content().string("Hello World!"))
    }

    def "The persistence layer is not accessible" () {

        when: "Placeholder for spock limitation"
        println "placeholder"

        then: "The persistence layer is not present"
        jdbcTemplate == null

    }

}
