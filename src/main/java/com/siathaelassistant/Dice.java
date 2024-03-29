/**
 * Because I don't like having to remember how random.nextInt works, and I'll need it everywhere \@__@/
 */
package com.siathaelassistant;

import java.util.Random;

public class Dice
{
    private static Random random = new Random();

    public Dice()
    {

    }

    /**
     * returns a random within a range given by an array, inclusive.
    * @param range an int array containing the min then the max inclusive values.
    * @return the randomly chosen number
    */
    public static int rRand(int[] range)
    {
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
     * flip a coin~
    * @return heads or tails ie, true or false...
    */
    public static boolean coinToss()
    {
        return (rand(0, 10) % 2 == 0);
    }

    public static int weight()
    {
        return rand(0, 100);
    }
    public static int weight(int max)
    {
        return rand(0, max);
    }

}