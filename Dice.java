/**
 * Because I don't like having to remember how random.nextInt works, and I'll need it everywhere \@__@/
 */

 
 import java.util.Random;

 public class Dice
 {
     private static Random random = new Random();
 
     public Dice()
     {
 
     }
 
     /**
      * returns a random within a range given by an array, inclusive.
      * @param range
      * @return
      */
     public static int rRand(int[] range)
     {
         return rand(range[0], range[1]);
     }
     
 
     /**
      * 
      * @param min
      * @param max
      * @return
      */
     public static int rand(int min, int max)
     {
         return random.nextInt(max - min) + min;
     }

     public static boolean coinToss()
     {
        return (rand(0, 10) % 2 == 0);
     }
 
 }