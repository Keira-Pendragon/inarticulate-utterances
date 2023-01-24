/**
 * Pronoun.java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

public class Pronoun extends Words
{
    public Pronoun()
    {
        
    }
    
    public static Word detailWord(int type)
    {
        boolean random = randomWord();
        int length = clusterLength();
        int [] pattern = pronoun_pattern;
        boolean singular = singularWord(); // TODO correct this for nouns...
        int possessive = selectPossessiveness();
        int genus = selectGenus();
        int count = selectNounCount();
        int role = selectRole();
        Word aWord = new Word(type, random, length, pattern, singular, possessive, genus, count, role);
        return aWord;
     }
    
}
