/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */
public class Number extends Words
{
    public Number()
    {
        
    }
    public static Word detailWord(int type)
    {
        boolean random = randomWord();
        int digits = selectDigitCount();
        String b12 = requestB12ToTranslate();
        Word aWord = new Word(type, random, digits, b12);
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
