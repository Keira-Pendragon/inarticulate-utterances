/**
 * Noun.java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */
public class Noun extends Words
{
    public Noun()
    {
        
    }
    public static Word detailWord(int type)
    {
        boolean random = randomWord();
        int length = clusterLength();
        int[] pattern = nounPattern();
        boolean singular = singularWord();
        int possessive = selectPossessiveness();
        int genus = selectGenus();
        int count = selectNounCount();
        int role = selectRole();
        Word aWord = new Word(type, random, length, pattern, singular, possessive, genus, count, role);
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
