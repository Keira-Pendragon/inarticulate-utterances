/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

public class SentenceHelper extends WordHelper
{
  private static final int[] sentence_count_range = {1, 1000};
  private static final int[] word_count_range = {1, 15};
  private static final int[] batch_type_range = {1, 6};
  private static final String sentence_count_prompt = "How many sentences of this type would you like?\n(limit 1000)";
  private static final String word_count_prompt = "How many words should be in the sentence?\n(limite 15)";
  private static final String batch_type_prompt = "Do you want\n0) Sentence A\n1) Sentence B\n2) Sentence C\n"
                                                + "3) Just Nouns\n3) Just Verbs\n4) Just Adjectives\n"
                                                + "5) Just Adverbs\n6) Just Adhesives\n7 - 10) Some other sentence!?";


  public SentenceHelper()
  {

  }

  /**
   * 
   */
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

  public static int getBatchType()
  {
    return SUI.ValidateInt(batch_type_range, batch_type_prompt);
  }


  public static void BatchBuild(int which)
  {
    boolean onceMore = true;
    int sentenceCount = 1000;
    Sentence sayWhat;

    while(onceMore)
    {
      
      sayWhat = (which >= NOUN && which <= ADHESIVE)? BatchWords(which) : BatchSentence(which);
      for(int i = 0; i < sentenceCount; i++)
      {
        SUI.displayTextLn(buildSentence(sayWhat));
      }
      SUI.displayTextLn("Sentence batch Complete.");
      onceMore = SUI.ValidateAgreement("Would you like to build more sentences?\n1) yes\n2) No");
    }
  }

  /**
   * 
   * @return
   */
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

  private static Sentence BatchSentence(int which)
  {
    
    Sentence sayWhat = new Sentence();
    switch (which) {
      case 0:
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(ADJECTIVE);
        sayWhat.addWord(PRONOUN);
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(VERB);
        sayWhat.addWord(ADVERB);
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(ADJECTIVE);
        sayWhat.addWord(NOUN);        
        break;
      case 1:
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(NOUN);
        sayWhat.addWord(ADVERB);
        sayWhat.addWord(VERB);
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(ADJECTIVE);
        sayWhat.addWord(NOUN);        
        break;
      case 7:
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(NOUN);
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(ADJECTIVE);
        sayWhat.addWord(NOUN);
        sayWhat.addWord(ADVERB);
        sayWhat.addWord(VERB);
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(ADJECTIVE);
        sayWhat.addWord(NOUN);
        break;
      case 8:
        sayWhat.addWord(PRONOUN);
        sayWhat.addWord(VERB);
        sayWhat.addWord(PRONOUN);
        break;
      case 9:
        sayWhat.addWord(PRONOUN);
        sayWhat.addWord(VERB);
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(NOUN);     
        break;      
      default:
        sayWhat.addWord(NOUN);
        sayWhat.addWord(VERB);
        sayWhat.addWord(ADVERB);
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(NOUN);           
        break;
    }
    return sayWhat;
  }

  private static Sentence BatchWords(int type)
  {
    Sentence sayWhat = new Sentence();
    for(int i = 0; i < 9; i++)
    {
      sayWhat.addWord(type);
    }
    return sayWhat;
  }
  
  /**
   * 
   * @param sayWhat
   * @return
   */
  private static String buildSentence(Sentence sayWhat)
  {
    String sayThis = "";
    for(int i = 0; i < sayWhat.wordCount(); i++)
    {
      sayThis+= fetchWord(sayWhat.fetchWord(i));
      sayWhat.fetchWord(i).refreshWord();
      sayThis+= (i + 1 == sayWhat.wordCount()) ? "." : " ";
    }
    return sayThis;
  }
}
