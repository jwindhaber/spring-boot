package org.algorithm.recursive;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static java.math.BigInteger.*;


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

    private final Map<BigInteger, BigInteger> memo = new HashMap<>();

    public BigInteger calculateNumbers(BigInteger n) {
        counter++;

        if(n.equals(ZERO)) {
            memo.put(ZERO, ZERO);
            return ZERO;
        }

        if(n.equals(ONE)) {
            memo.put(ONE, ONE);
            return ONE;
        }

        BigInteger nOne =n.subtract(ONE);
        BigInteger gameOne = memo.get(nOne);
        if(gameOne == null){
            gameOne = calculateNumbers(nOne);
            memo.put(nOne, gameOne);
        }


        BigInteger nTwo = n.subtract(TWO);
        BigInteger gameTwo = memo.get(nTwo);
        if(gameTwo == null){
            gameTwo = calculateNumbers(nTwo);
            memo.put(nTwo, gameTwo);
        }

        return gameOne.multiply(TWO).add(gameTwo);

    }

    public Integer countPrimeNumbers() {

        return 1;
    }

    public int getCounter() {
        return counter;
    }

}
