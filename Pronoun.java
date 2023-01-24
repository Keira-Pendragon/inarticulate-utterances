/**
 * Pronoun.java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

public class Pronoun extends Words
{
    private static final int POSSESSION = 0;
    private static final int ROLE = 1;
    private static final int GENUS = 2;
    private static final int COUNT = 3;
    private static final int NOTSINGLE = 4;
    private static final int[] p0_pattern = {ROLE, GENUS, COUNT};
    private static final int[] p1_pattern = {ROLE, GENUS, COUNT, NOTSINGLE};
    private static final int[] p2_pattern = {POSSESSION, ROLE, GENUS, COUNT};
    private static final int[] p3_pattern = {POSSESSION, ROLE, GENUS, COUNT, NOTSINGLE};
    private static final int[][] pronoun_pattern = {p0_pattern, p1_pattern, p2_pattern, p3_pattern};

    public Pronoun()
    {
        
    }
    
    public static Word detailWord(int type)
    {
        boolean random = randomWord();
        int length = clusterLength();
        boolean singular = singularWord(); 
        int possessive = selectPossessiveness();
        int genus = selectGenus();
        int count = selectNounCount();
        int role = selectRole();
        int [] pattern = selectPronounPattern(random, singular, possessive);
        Word aWord = new Word(type, random, length, pattern, singular, possessive, genus, count, role);
        return aWord;
     }
    
    private static int[] selectPronounPattern(boolean random, boolean singular, int possessive)
    {
        int index = 0;
        if(singular && possessive > 0)
        {
            index = 2;
        }
        else if(!singular && possessive == 0)
        {
            index = 1;
        }
        else if(!singular && possessive > 0)
        {
            index = 3;
        }

        return pronoun_pattern[index];
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
