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
      Word aWord;
      int wordCount;
      boolean onceMore = true;
      while(onceMore)
      {        
        aWord = detailWord();
        //aWord = requestWords();
        wordCount = (!onlyOne(aWord.Type(), aWord.isRandom())) ? SUI.ValidateInt(word_count_range, word_count_prompt) : 1;
        for(int i = 0; i < wordCount; i++)
        {
            SUI.displayTextLn(fetchWord(aWord));
        }
        SUI.displayTextLn("\nWord Batch complete.");
        onceMore = SUI.ValidateAgreement("\nWould you like to generate more words?\n1) Yes\n2) No");
      }
    }

    private static boolean onlyOne(int type, boolean random)
    {
        return ((type == NUMBER || type == PRONOUN) && random);
    }

    protected static String fetchWord(Word aWord)
    {
        int type = aWord.Type();
        String nWord = "";
        switch (type) {
            case NUMBER:
                nWord = Number.buildWord(aWord);
                break;
            case PRONOUN:
                nWord = Pronoun.buildWord(aWord);
                break;
            case NOUN:
                nWord = Noun.buildWord(aWord);
                break;
            case ADJECTIVE:
                nWord = Adjective.buildWord(aWord);
                break;
            case VERB:
                nWord = Verb.buildWord(aWord);                
                break;
            case ADVERB:
                nWord = Adverb.buildWord(aWord); 
                break;        
            default:
                nWord = Adhesive.buildWord(aWord);
                break;
        }
        return nWord;
    }

    protected static Word detailWord()
    {
        int type = SUI.ValidateIndex(Words.TypeRange(), Words.TypePrompt());
        Word aWord;
        switch (type) {
            case NUMBER:
                aWord = Number.detailWord(type);
                break;
            case PRONOUN:
                aWord = Pronoun.detailWord(type);
                break;
            case NOUN:
                aWord = Noun.detailWord(type);
                break;
            case ADJECTIVE:
                aWord = Adjective.detailWord(type);
                break;
            case VERB:
                aWord = Verb.detailWord(type);                
                break;
            case ADVERB:
                aWord = Adverb.detailWord(type); 
                break;        
            default:
                aWord = Adhesive.detailWord(type);
                break;
        }
        return aWord;
    }

    private static Word requestWords()
    {
        int type = SUI.ValidateIndex(Words.TypeRange(), Words.TypePrompt());
        return Wordz.requestWord(type);
    }
}
