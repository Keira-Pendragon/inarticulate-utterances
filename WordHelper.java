/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

public class WordHelper
{    
  protected static final int NUMBER = 0;
  protected static final int PRONOUN = 1;
  protected static final int NOUN = 2;
  protected static final int ADJECTIVE = 3;
  protected static final int VERB = 4;
  protected static final int ADVERB = 5;
  protected static final int ADHESIVE = 6;

  private static final String word_count_prompt = "How many words of this type would you like?\n(Limit 50)";
  private static final int[] word_count_range = {1, 50};

  public WordHelper()
  {

  }

  public static void helperLoop()
  {
    SUI.displayTextLn("Damage Control : " + Cluster.clusterDC());
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

  public static String fetchWord(Word w)
  {
     return Words.buildAWord(w);
  }

  protected static Word detailWord()
  {
    int type = SUI.ValidateIndex(Words.TypeRange(), Words.TypePrompt());
    return Words.requestWord(type);
  }

}
