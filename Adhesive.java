/**
 * Adhesive.java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

public class Adhesive extends Words
{
    public Adhesive()
    {

    }
    
    public static Word detailWord(int type)
    {
        boolean random = randomWord();
        int length = clusterLength();
        int[] pattern = altPattern();
        Word aWord = new Word(type, random, length, pattern);
        return aWord;
    }
    
    
}
