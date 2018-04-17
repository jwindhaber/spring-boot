package org.springframework.koans.boot

import org.apache.ignite.Ignite
import org.apache.ignite.IgniteCache
import org.junit.Assert
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

@SpringBootTest
class Lesson05AutostarterIgniteTest extends Specification {

    @Autowired
    ApplicationContext context

    def "Retrieving a working ignite cluster instance from spring boot" () {

        setup:
        Ignite ignite = context.getBean(Ignite)
        IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCacheName");

        when: "Storing keys in the cache (values will end up on different cache nodes)"
        (1..10).each {
            cache.put(it, Integer.toString(it));
        }

        then: "Cached values getting retrieved from the cache"
        noExceptionThrown()
        (1..10).each {
            it.toString() == cache.get(it)
        }
    }
}
