/**
 * Because I don't like having to remember how random.nextInt works, and I'll need it everywhere \@__@/
 */
package com.siathaelassistant;

import java.util.Random;

public class Dice
{
    private static Random random = new Random();

    /**
     * Returns a random number within a range given by an array, inclusive.
     * @param range an int array containing the min then the max inclusive values.
     * @return the randomly chosen number
     * @throws IllegalArgumentException if the range array has less than two elements
     */
    public static int randInRange(int[] range) 
    {
        if (range.length < 2) 
        {
            throw new IllegalArgumentException("Range array must have at least two elements");
        }
        return rand(range[0], range[1]);
    }
    

    /**
     * rand(int, int) inclusive bound random numbers
    * @param min smallest inclusive value
    * @param max largest inclusive value
    * @return A NUMBER
    */
    public static int rand(int min, int max)
    {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Simulates flipping a coin
     * @return true for heads, false for tails
     */
    public static boolean coinToss()
    {
        return (rand(0, 1) == 0);
    }

    /**
     * Generates a random number between 0 and 100, simulating a roll of a weighted die.
     * @return a random number between 0 and 100
     */
    public static int weight()
    {
        return rand(0, 100);
    }

    /**
     * Generates a random number between 0 and a given max value, simulating a roll of a weighted die.
     * @return a random number between 0 and max
     */
    public static int weight(int max)
    {
        return rand(0, max);
    }
}