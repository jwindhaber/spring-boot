package org.algorithm.recursive;

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

        //TODO implement algorithm and remove exception
        throw new UnsupportedOperationException();
    }
}
