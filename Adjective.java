/**
 * Adjective.java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

public class Adjective extends Words
{
    public Adjective()
    {

    }
    public static Word detailWord(int type)
    {
        boolean random = randomWord();
        int length = clusterLength();
        int[] pattern = nounPattern();
        Word aWord = new Word(type, random, length, pattern);
        return aWord;
    }
}
