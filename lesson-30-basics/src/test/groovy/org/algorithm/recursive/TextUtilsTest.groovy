package org.algorithm.recursive

import spock.lang.Specification
import spock.lang.Subject

class TextUtilsTest extends Specification {

    @Subject
    private static final String loremIpsumText = TextUtils.readTextFromFile()

    def "Read the loremIpsumFile from the resource folder"() {

        expect:
        loremIpsumText.startsWith("Lorem ipsum")
    }

    def "Count all words in the lorem ipsum text"() {

        expect:
        TextUtils.countWords(loremIpsumText) == 3000
    }

    def "The word with the most characters"() {

        expect: "the longest word in the text without characters like !?."
        TextUtils.longestWord(loremIpsumText) == "conclusionemquevi"
    }

    def "The word which occurs most often in the text"() {

        expect: "the longest word in the text without characters like !?."
        TextUtils.mostOccurrences(loremIpsumText) == "eu"
    }

    def "The sentence in the text with the minimum weight"() {

        expect: "the longest word in the text without characters like !?."
        TextUtils.mostOccurrences(loremIpsumText) == "eu"
    }





}
