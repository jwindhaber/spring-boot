package org.springframework.koans.boot

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.koans.boot.dto.VoteDto
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.ResultActions
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * @see org.springframework.boot.test.context.SpringBootTest
 * @see org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
 */
@SpringBootTest
@AutoConfigureMockMvc
class Lesson20VoteTest extends Specification {

    @Autowired
    private MockMvc mvc

    def "Posting votes for the party to the application and get the actual participants back" () {

        setup: "Votes are posted to the application"

        List<VoteDto> votes= [
                new VoteDto(name: "Tom" , participate: false, timestamp: toDate('18.05.2001')),
                new VoteDto(name: "TOM" , participate: true,  timestamp: toDate('18.05.2000')),
                new VoteDto(name: "EllA", participate: true,  timestamp: toDate('18.05.2001')),
                new VoteDto(name: "Ella", participate: false, timestamp: toDate('18.05.2000')),
        ]

        votes.each { mvc.perform(post("/votes").contentType(MediaType.APPLICATION_JSON).content(toJsonString(it))).andExpect(status().isOk()) }

        when: "All participants are fetched from the application"

        ResultActions response = mvc.perform(get("/participants").accept(MediaType.APPLICATION_JSON_VALUE))

        then: "All participants must be present in the response"

        MvcResult result = response.andExpect(status().isOk()).andReturn()
        List participants = new JsonSlurper().parseText(result.getResponse().getContentAsString()) as List

        participants.sort() == ["ella"]


    }

    private static Date toDate(String dateString) {
        return new Date().parse("dd.MM.yyy", dateString)
    }

    static toJsonString(Object payload) {
        return new ObjectMapper().writeValueAsString(payload)
    }



}
