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
        int wordCount = SUI.ValidateInt(word_count_range, word_count_prompt);
        int type = SUI.ValidateIndex(Words.TypeRange(), Words.TypePrompt());
        SUI.displayText("picked type");
        Word aWord = detailWord(type);
        SUI.displayText("detailing complete");
        for(int i = 0; i < wordCount; i++)
        {
            SUI.displayText(fetchWord(aWord));
        }
        SUI.displayText("Word Batch complete.");
    }

    private static String fetchWord(Word aWord)
    {
        int type = aWord.Type();
        String nWord = "";
        String display = "Fetching ";
        switch (type) {
            case NUMBER:
                SUI.displayText(display +  "a Number");
                nWord = Number.buildWord(aWord);
                break;
            case PRONOUN:
                SUI.displayText(display +  "a Pronoun");
                nWord = Pronoun.buildWord(aWord);
                break;
            case NOUN:
                SUI.displayText(display +  "a Noun");
                nWord = Noun.buildWord(aWord);
                break;
            case ADJECTIVE:
                SUI.displayText(display +  "an Adjective");
                nWord = Adjective.buildWord(aWord);
                break;
            case VERB:
                SUI.displayText(display +  "a Verb");
                nWord = Verb.buildWord(aWord);                
                break;
            case ADVERB:
                SUI.displayText(display +  "an Adverb");
                nWord = Adverb.buildWord(aWord); 
                break;        
            default:
                SUI.displayText(display +  "a Word...");
                nWord = Adhesive.buildWord(aWord);
                break;
        }
        return nWord;
    }

    private static Word detailWord(int type)
    {
        Word aWord;
        String display = "Detailing a";
        switch (type) {
            case NUMBER:
                SUI.displayText(display +  "Number");
                aWord = Number.detailWord(type);
                break;
            case PRONOUN:
                SUI.displayText(display +  " Pronoun");
                aWord = Pronoun.detailWord(type);
                break;
            case NOUN:
                SUI.displayText(display +  " Noun");
                aWord = Noun.detailWord(type);
                break;
            case ADJECTIVE:
                SUI.displayText(display +  "n Adjective");
                aWord = Adjective.detailWord(type);
                break;
            case VERB:
                SUI.displayText(display +  " Verb");
                aWord = Verb.detailWord(type);                
                break;
            case ADVERB:
                SUI.displayText(display +  "n Adverb");
                aWord = Adverb.detailWord(type); 
                break;        
            default:
                SUI.displayText(display +  " Word...");
                aWord = Adhesive.detailWord(type);
                break;
        }
        return aWord;
    }
        
}
