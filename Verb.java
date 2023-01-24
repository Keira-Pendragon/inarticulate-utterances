/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

 public class Verb extends Words
{
    public Verb()
    {
        
    }
    
    public static Word detailWord(int type)
    {
       boolean random = randomWord();
       int length = clusterLength();
       int [] pattern = verbPattern();
       int mood = selectMood();
       int tense = selectTense();
       Word aWord = new Word(type, random, length, pattern, mood, tense);
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
