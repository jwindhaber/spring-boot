package org.algorithm.recursive;

import com.google.common.base.CharMatcher;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Find the segment weight of the text where the weight multiplied by the weight of the delimiter has the highest value.
 * A Segment is defined as the the words between two words which have the same weight.
 * A weight of a word is defined as the number of occurrences in the text.
 * <p>
 * Text: A B C C B C
 * <p>
 * Weight(A) = 1
 * Weight(B) = 2
 * Weight(C) = 3
 * <p>
 * Index:      0 1 2 3 4 5 => i
 * Text:       A B C C B C => t
 * WordWeight: 1 2 3 3 2 3 => ww
 * SegmentWeight: sw
 * <p>
 * sw(I(1)->I(4)) = (3+3)*2 = 12
 * sw(I(3)->I(5)) = 2*3 = 6
 * sw(I(2)->I(3)) = 0*3 = 0
 * <p>
 * => sw max = (I(1)->I(4))
 */
public class TextAlgorithmUtils {

    /**
     * Returns the highest weight in the text.
     */
    public static Long highestWeight(String text) {

        String[] words = StringUtils.split(CharMatcher.anyOf("?!.,").removeFrom(text));

        Map<String, Long> mapOfWordsAndTheirWeights = Arrays.stream(words)
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Long weight = 0L;
        Long highestWeight = 0L;
        Map<String, Long> currentWeightOfSegmentStart = new HashMap<>();

        for (String word : words) {

            // Condition for a Segment End
            if (currentWeightOfSegmentStart.containsKey(word)) {

                Long segmentWeight = (weight - currentWeightOfSegmentStart.get(word)) * mapOfWordsAndTheirWeights.get(word);
                if (segmentWeight > highestWeight) {
                    highestWeight = segmentWeight;
                }
                currentWeightOfSegmentStart.remove(word);
            }

            weight += mapOfWordsAndTheirWeights.get(word);

            if (mapOfWordsAndTheirWeights.get(word) != 1) {
                // put the segment in the map if it is not 1. if it is 1 it will only have an opener
                currentWeightOfSegmentStart.put(word, weight);
            }

        }

        return highestWeight;
    }
}
