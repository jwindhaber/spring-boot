package org.springframework.koans.boot

import org.springframework.koans.boot.persistence.entity.Vote
import org.springframework.koans.boot.service.PartyServiceImpl
import spock.lang.Specification
import spock.lang.Subject

class Lesson20ParticipationTest extends Specification {

    @Subject
    PartyServiceImpl partyService = new PartyServiceImpl()

    def "Calling the party service and get participants back" () {

        setup: "Votes"

        List<Vote> votes= [
                new Vote(name: "Tom" , participate: false, timestamp: toDate('18.05.2001')),
                new Vote(name: "TOM" , participate: true,  timestamp: toDate('18.05.2000')),
                new Vote(name: "EllA", participate: true,  timestamp: toDate('18.05.2001')),
                new Vote(name: "Ella", participate: false, timestamp: toDate('18.05.2000')),
        ]

        when: "Get participants"

        def participants = partyService.allParticipants(votes)

        then: "check the participants"

        participants.sort() == ["ella"]

    }

    private static Date toDate(String dateString) {
        return new Date().parse("dd.MM.yyy", dateString)
    }


}
