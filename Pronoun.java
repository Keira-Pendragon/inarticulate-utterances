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
        boolean singular = singularWord(random); 
        int possessive = selectPossessiveness(random);
        int [] cGenus = selectComplexGenus(random);
        int genus = cGenus[0];
        int gMod = cGenus[1];
        int count = selectNounCount(random);
        int role = selectRole(random);
        return new Word(type, random, singular, possessive, genus, gMod, count, role);
    }

    public static String buildWord(Word aWord)
    {        
        return possessivePrefix(aWord.Possessiveness()) + pronounRole(aWord.ConvoRole()) + genusCluster(aWord) 
                + digitValue(aWord.mentionCount()) + ((aWord.isSingular()) ? "" : pluralSuffix());
    }
}
