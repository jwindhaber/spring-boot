package org.algorithm.recursive

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class TextAlgorithmTest extends Specification {

    @Subject
    private static final String loremIpsumText = TextUtils.readTextFromFile()

    def "Read the loremIpsumFile from the resource folder and evaluate highest weight"() {

        expect:
        TextAlgorithmUtils.highestWeight(loremIpsumText) == 237504

    }


    @Unroll
    def 'For the given text: "#text" the highest weight is: #weight '() {

        expect:
        TextAlgorithmUtils.highestWeight(text) == weight

        where:
        text                     | weight
        "B A B"                  | 2
        "A B C C B C"            | 12
        "A B C C D B D C"        | 18
        "B A B C C D B D C"      | 24
        "B A B C C D B E E B C"  | 39

    }







}
