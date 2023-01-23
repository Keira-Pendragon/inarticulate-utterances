/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

 public class WordHelper
{
    private static final String word_count_prompt = "How many words of this type would you like?\n(Limit 50)";
    private static final int[] word_count_range = {1, 50};
    
    public WordHelper()
    {

    }

    public static void helperLoop()
    {
        int wordCount = SUI.validateInt(word_count_range, word_count_prompt);
        int type = SUI.validateIndex(Words.TypeRange(), Words.TypePrompt());
        //Word aWord = detailWord(type);
        for(int i = 0; i < wordCount; i++)
        {
            //SUI.displayText(nextWord(aWord));
        }
    }
        
}
