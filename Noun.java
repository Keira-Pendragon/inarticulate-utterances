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
    public static Word detailWord()
    {
        boolean random = randomWord();
        int length = clusterLength();
        int[] pattern = nounPattern();
        boolean plural = pluralWord();
        int possessive = selectPossessiveness();
        int genus = selectGenus();
        int count = selectNounCount();
        int role = selectRole();
        Word aWord = new Word(random, length, pattern, plural, possessive, genus, count, role);
        return aWord;
    }
}
