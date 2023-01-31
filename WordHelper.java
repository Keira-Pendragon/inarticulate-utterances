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
      Word aWord;
      int wordCount = 5;
      boolean onceMore = true;
      while(onceMore)
      {        
        aWord = detailWord();
        for(int i = 0; i < wordCount; i++)
        {
            SUI.displayTextLn(fetchWord(aWord));
        }
        SUI.displayTextLn("\nWord Batch complete.");
        onceMore = SUI.ValidateAgreement("\nWould you like to generate more words?\n1) Yes\n2) No");
      }
    }

    protected static String fetchWord(Word aWord)
    {        
        return Wordz.buildAWord(aWord);
    }

    protected static Word detailWord()
    {
        int type = SUI.ValidateIndex(Words.TypeRange(), Words.TypePrompt());
        return Wordz.requestWord(type);
    }

}
