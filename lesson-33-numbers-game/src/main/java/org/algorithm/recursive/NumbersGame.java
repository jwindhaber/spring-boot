package org.algorithm.recursive;

import java.math.BigInteger;

import static java.math.BigInteger.valueOf;


/**
 * Function description:
 * F(0) = 0
 * F(1) = 1
 * F(n) = 2 * F(n-1) + F(n-2)
 *
 * Please implement this function in a way that it is time efficient.
 *
 */
public class NumbersGame {

    private static final BigInteger TWO = valueOf(2);
    private int counter = 0;

    public BigInteger calculateNumbers(BigInteger n) {
        counter++;

        //TODO implement algorithm and remove exception
        throw new UnsupportedOperationException();

    }

    public int getCounter() {
        return counter;
    }

}
