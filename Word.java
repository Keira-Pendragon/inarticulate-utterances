/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

public class Word
{
    private static final int DEF_LEN = 1;
    private static final int DEF_TYPE = 6;
    private static final int DEF_CLUS = 5;
    private static final int[] Def_Pattern = {DEF_CLUS};

    private int word_type;
    private boolean word_random;
    private int word_length;
    private int [] word_pattern;
    private boolean word_singular;
    private int word_posessive;
    private int word_count;
    private int word_role;
    private int word_genus;
    private int word_mood;
    private int word_tense;
    private int whole_digit_count;
    private int spare_digit_count;
    private String word_base12Digits;
    private char delimiter;
    private int del_loc;
    private String siathael_word;
    private String english_translation;
    private String whole_digits;
    private String spare_digits;

    /**
     * Word Constructor for Nouns and Pronouns
     * @param type
     * @param random
     * @param length
     * @param pattern
     * @param singular
     * @param posessive
     * @param genus
     * @param count
     * @param role
     */
    public Word(int type, boolean random, int length, int[] pattern, boolean singular, int posessive, int genus, int count, int role)
    {
        setType(type);
        setRandom(random);
        setLength(length);
        setPattern(pattern);
        setSingular(singular);
        setPossessive(posessive);
        setGenus(genus);
        setCount(count);
        setRole(role);
    }

    /**
     * Word constructor for Verbs
     * @param type
     * @param random
     * @param length
     * @param pattern
     * @param mood
     * @param tense
     */
    public Word(int type, boolean random, int length, int[] pattern, int mood, int tense)
    {
        setType(type);
        setRandom(random);
        setLength(length);
        setPattern(pattern);
        setMood(mood);
        setTense(tense);
    }

    /**
     * Word constructor for Adverbs, Adjectives, and Adhesive words
     * @param type
     * @param random
     * @param length
     * @param pattern
     */
    public Word(int type, boolean random, int length, int[] pattern)
    {
        setType(type);
        setRandom(random);
        setLength(length);
        setPattern(pattern);
    }

    /**
     * Word constructor for numbers
     * @param type
     * @param random
     * @param digits
     * @param word_base12Digits
     */
    public Word(int type, boolean random, String word_base12Digits)
    {
        setType(type);
        setRandom(random);
        setbase12Value(word_base12Digits);        
    }

    public Word(boolean random)
    {
        setRandom(random);
        setType(DEF_TYPE);
        setLength(DEF_LEN);
        setPattern(Def_Pattern);
    }
    
    private void setType(int type)
    {
        word_type = type;
    }
    public int Type()
    {
        return word_type;
    }



    private void setRandom(boolean random)
    {
        word_random = random;
    }
    public boolean isRandom()
    {
        return word_random;
    }



    private void setLength(int length)
    {
        word_length = length;
    }
    public int clusterLength()
    {
        return word_length;
    }



    private void setPattern(int[] pattern)
    {
        word_pattern = pattern;
    }

    public int[] Pattern()
    {
        return word_pattern;
    }


    private void setSingular(boolean singular)
    {
        word_singular = singular;
    }
    public boolean isSingular()
    {
        return word_singular;
    }


    private void setCount(int count)
    {
        word_count = count;
    }
    public int mentionCount()
    {
        return word_count;
    }


    private void setRole(int role)
    {
        word_role = role;
    }
    public int ConvoRole()
    {
        return word_role;
    }

    
    private void setPossessive(int posessive)
    {
        word_posessive = posessive;
    }
    public int Possessiveness()
    {
        return word_posessive;
    }


    private void setGenus(int genus)
    {
        word_genus = genus;
    }
    public int Genus()
    {
        return word_genus;
    }


    private void setMood(int mood)
    {
        word_mood = mood;
    }
    public int Mood()
    {
        return word_mood;
    }


    private void setTense(int tense)
    {
        word_tense = tense;
    }
    public int Tense()
    {
        return word_tense;
    }


    private void setdigits(int wCount, int sCount)
    {
        whole_digit_count = wCount;
        spare_digit_count = sCount;
    }
    public int wholeDigitCount()
    {
        return whole_digit_count;
    }

    public int spareDigitCount()
    {
        return spare_digit_count;
    }

    private void setbase12Value(String value)
    {
        word_base12Digits = value;
        
        delimiter = ' ';
        // default to the length of the value, or 37, whichever is shorter, in case there is no delimiter...
        del_loc = (value.length() < 36) ?  value.length() : 37;
        for(int i = 0; i < value.length(); i++)
        {
            if (value.charAt(i) == '/' || value.charAt(i) == '.')
            {
                delimiter = value.charAt(i);
                del_loc = i;
            }
        }
        if(delimiter != ' ')
        {
            whole_digits = SUI.trimString(value, 0, del_loc -1);
            spare_digits = SUI.trimString(value, del_loc + 1, value.length() -1);
        }
        else
        {
            whole_digits = value;
            spare_digits = "";
        }
        setdigits(whole_digits.length(), spare_digits.length());
    }
    public String Base12Value()
    {
        return word_base12Digits;
    }
    
    public char Delimiter()
    {
        return delimiter;
    }
    public int DelimiterLoc()
    {
        return del_loc;
    }
    public String WholeValue()
    {
        return whole_digits;
    }
    public String SpareValue()
    {
        return spare_digits;
    }
    
    public void commitWord(String word)
    {
        siathael_word = word;
    }
    public String SiathaelWord()
    {
        return siathael_word;
    }
    
    protected void setTranslation(String eWord)
    {
        english_translation = eWord;
    }
    
    protected String getTranslation()
    {
        return english_translation;
    }
    
}
