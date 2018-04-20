package org.algorithm.recursive;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class TextUtils {


    /**
     * reads the loremIpsum.txt file from the resources folder.
     * @return content as string
     */
    public static String readTextFromFile() {

        Path path = null;
        try {
            path = Paths.get(ClassLoader.getSystemResource("loremIpsum.txt").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        StringBuilder data = new StringBuilder();
        Stream<String> lines = null;
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines.forEach(line -> data.append(line).append("\n"));
        lines.close();
        return data.toString();

    }

    /**
     * returns the number of words for the given text
     */
    public static int countWords(String text) {
        return StringUtils.split(text).length;

    }

    /**
     * returns the longest word in the given text. it also strips away ?.! characters
     */
    public static String longestWord(String text) {

        return Arrays.stream(StringUtils.split(text))
                .map(word -> StringUtils.strip(word, "?!."))
                .max(comparing( String::length)).get();
    }

    /**
     * returns the word which occurs the most often in the given text. it also strips away ?.! characters
     */
    public static String mostOccurrences(String text) {

        Map<String, Long> collect = Arrays.stream(StringUtils.split(text))
                .map(word -> StringUtils.strip(word, "?!."))
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));


       return collect.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElseThrow(RuntimeException::new);

    }




}
