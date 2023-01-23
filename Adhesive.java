/**
 * Adhesive.java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

public class Adhesive extends Words
{
    public Adhesive()
    {

    }
    
    public static Word detailWord(int type)
    {
        int type = type;
        boolean random = SUI.validateBool(random_prompt);
        int length = SUI.validateInt(cluster_length_range, cluster_length_prompt);
        int[] pattern = alt_pattern[SUI.validateIndex(pattern_range, pattern_prompt)];
        Word aWord = new Word(type, random, length, pattern);
    }
    
    
}
