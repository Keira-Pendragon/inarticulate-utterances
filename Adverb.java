/**
 * Adverb.java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

public class Adverb extends Words
{
    public Adverb()
    {

    }
    
    public static Word detailWord(int type)
    {
        boolean random = randomWord();
        int length = clusterLength();
        int[] pattern = verbPattern();
        Word aWord = new Word(type, random, length, pattern);
        return aWord;
    }

    public static String buildWord(Word aWord)
    {
        String newWord = "";

        return newWord;
    }

    private static String nextCluster()
    {
        String aCluster = "";


        return aCluster;
    }
}
