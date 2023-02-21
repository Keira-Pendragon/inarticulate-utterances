/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

public class WordHelper extends SDef
{
  private static final String word_count_prompt = "How many words of this type would you like?\n(Limit 1000)";
  private static final int[] word_count_range = {1, 1000};

  public WordHelper()
  {

  }

  /**
   * 
   */
  public static void helperLoop()
  {
    Word aWord;
    int wordCount = 5;
    boolean onceMore = true;
    while(onceMore)
    {        
      aWord = detailWord();
      wordCount = (aWord.OnlyOne())? 1 : SUI.ValidateInt(word_count_range, word_count_prompt);
      for(int i = 0; i < wordCount; i++)
      {
        SUI.displayTextLn(fetchWord(aWord));
        aWord.refreshWord();
      }
      SUI.displayTextLn("\nWord Batch complete.");
      onceMore = SUI.ValidateAgreement("\nWould you like to generate more words?\n1) Yes\n2) No");
    }
  }

  public static void batchHelperLoop()
  {
    Word aWord;
    int wordCount = 1000;
    boolean onceMore = true;
    while(onceMore)
    {        
      aWord = detailWord();
      for(int i = 0; i < wordCount; i++)
      {
        SUI.displayTextLn(fetchWord(aWord));
        aWord.refreshWord();
      }
      SUI.displayTextLn("\nWord Batch complete.");
      onceMore = SUI.ValidateAgreement("\nWould you like to generate more words?\n1) Yes\n2) No");
    }
  }

  /**
   * 
   * @param w
   * @return
   */
  public static String fetchWord(Word w)
  {
     return Words.buildAWord(w);
  }

  /**
   * 
   * @return
   */
  protected static Word detailWord()
  {
    int type = SUI.ValidateIndex(Words.TypeRange(), Words.TypePrompt());
    return Words.requestWord(type);
  }

}
