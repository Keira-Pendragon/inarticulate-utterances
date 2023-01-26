/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

 public class SentenceHelper extends WordHelper
{
  private static final int[] sentence_count_range = {1, 20};
  private static final int[] word_count_range = {1, 15};
  private static final String sentence_count_prompt = "How many sentences of this type would you like?\n(limit 20)";
  private static final String word_count_prompt = "How many words should be in the sentence?\n(limite 15)";
    public SentenceHelper()
    {
        
    }

    public static void helperLoop()
    {
      boolean onceMore = true;
      int sentenceCount;
      Sentence sayWhat;
      while(onceMore)
      {
       sayWhat = detailSentence();
       sentenceCount = SUI.ValidateInt(sentence_count_range, sentence_count_prompt);
       for(int i = 0; i < sentenceCount; i++)
       {
         SUI.displayTextLn(buildSentence(sayWhat));
       }
       SUI.displayTextLn("Sentence batch Complete.");
       onceMore = SUI.ValidateAgreement("Would you like to build more sentences?\n1) yes\n2) No");
      }
    }
  
  private static Sentence detailSentence()
  {
   int wordCount = SUI.ValidateInt(word_count_range, word_count_prompt);
   Sentence sayWhat = new Sentence();
   for(int i = 0; i < wordCount; i++)
   {
     sayWhat.addWord(detailWord());
   }
   return sayWhat;
  }
  
  private static String buildSentence(Sentence sayWhat)
  {
  String sayThis = "";
   for(int i = 0; i < sayWhat.wordCount(); i++)
   {
    sayThis+= fetchWord(sayWhat.fetchWord(i));
    sayThis+= (i + 1 == sayWhat.wordCount()) ? " " : ".";
   }
   return sayThis;
  }
}
