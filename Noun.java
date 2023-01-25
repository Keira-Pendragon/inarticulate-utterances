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
        int length = clusterLength(random);
        int[] pattern = nounPattern(random);
        boolean singular = singularWord(random);
        int possessive = 0;//selectPossessiveness(random);
        int genus = selectGenus(random);
        int count = 0; //selectNounCount(random);
        int role = 0; selectRole(random);
        Word aWord = new Word(type, random, length, pattern, singular, possessive, genus, count, role);
        return aWord;
    }

    public static String buildWord(Word aWord)
    {
        SUI.displayTextLn("building a Noun");
        String nWord = "";
        int[] pattern = aWord.Pattern();
        String uhg = "";
        for(int p = 0; p < pattern.length; p++)
        {
            uhg+= pattern[p] + " ";
        }
        SUI.displayTextLn("Using pattern: " + uhg);
        for(int i = 0; i < pattern.length; i++)
        {
            nWord += nextCluster(pattern[i], aWord);
        }
        return nWord;
    }

    private static String nextCluster(int cluster, Word aWord)
    {
        String nCluster = "";
        String display = "Grabbing ";
        int length = aWord.clusterLength();
        switch (cluster) 
        {
            case ONSET:
                SUI.displayTextLn(display + "an Onset Cluster");
                nCluster = onsetCluster(length);
                break;
            case MIDCONST:
                SUI.displayTextLn(display + "a MidCost Cluster");
                nCluster = midConstCluster(length);
                break;
            case CODA:
                SUI.displayTextLn(display + "a Coda Cluster");
                nCluster = codaCluster(length);
                break;
            case VOWEL:
                SUI.displayTextLn(display + "a Vowel Cluster");
                nCluster = vowelCluster(length);
                break;
            case KEYMID:
                SUI.displayTextLn(display + "a KeyMid Cluster");
                nCluster = genusCluster(aWord);
                break;
            default:
                SUI.displayTextLn(display + "Whoops...");
                break;
        }
        SUI.displayTextLn("Got the cluster " + nCluster);
        return nCluster;
    }
}
