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
        boolean random = randomWord(random);
        int length = clusterLength(random);
        int[] pattern = verbPattern(random);
        Word aWord = new Word(type, random, length, pattern);
        return aWord;
    }

    public static String buildWord(Word aWord)
    {
        String nWord = "";
        int[] pattern = aWord.Pattern();
        for(int i = 0; i < pattern.length; i++)
        {
            nWord += nextCluster(pattern[i], aWord);
        }
        return nWord;
    }

    private static String nextCluster(int cluster, Word aWord)
    {
        String nCluster = "";
        int length = aWord.clusterLength();
        switch (cluster) 
        {
            case ONSET:
                nCluster = onsetCluster(length);
                break;
            case MIDCONST:
                nCluster = midConstCluster(length);
                break;
            case CODA:
                nCluster = codaCluster(length);
                break;
            case VOWEL:
                nCluster = vowelCluster(length);
                break;
            case ENDKEY:
                nCluster = adVowel();
                break;
            default:
                nCluster = vowelCluster(length);
                break;
        }
        return nCluster;
    }
}
