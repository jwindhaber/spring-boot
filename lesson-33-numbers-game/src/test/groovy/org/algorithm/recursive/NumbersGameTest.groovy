package org.algorithm.recursive

import spock.lang.Specification
import spock.lang.Timeout
import spock.lang.Unroll

class NumbersGameTest extends Specification {

    // If this test takes longer than 5 seconds to return you can have to optimize your algorithm further
    @Timeout(5)
    @Unroll
    def "The number calculated for the input: #n is: #expected"() {

        when:
        NumbersGame numbersGame = new NumbersGame()
        BigInteger result = numbersGame.calculateNumbers(n)

        println "Number of invocations is: ${numbersGame.getCounter()}"

        then:
        result == expected

        where:
        n | expected
        0 | 0
        1 | 1
        2 | 2
        3 | 5
        4 | 12
        5 | 29
        6 | 70
        7 | 169
        8 | 408
        9 | 985
        10 | 2378
        20 | 15994428
        30 | 107578520350
        40 | 723573111879672
        50 | 4866752642924153522

    }



}
