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
     * @param base12Dig
     */
    public Word(int type, boolean random, String base12Dig)
    {
        setType(type);
        setRandom(random);
        setbase12Value(base12Dig);
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


    private void setdigits(String wValue, String sValue)
    {
        whole_digit_count = wValue.length();
        spare_digit_count = wValue.length();
        whole_digits = wValue;
        spare_digits = sValue;
        SUI.displayTextLn("spare_digit_count set to " + spare_digit_count + " from sCount which is " + sCount);
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
        SUI.displayTextLn("base12 value is " + value);
        String wDig = "";
        String sDig = "";
        boolean done = false;

        int step = 0;
        char c;
        while(step < value.length() && !done)
        {
            c = value.charAt(step);
            if(c == '/' || c == '.' )
            {
                done = true;
            }
            else if(c != '0')
            {
                wDig += c;
            }
            step++;
        }
        int d = c;
        while(step > value.length())
        {
            c = value.charAt(step);
            if(c != 0  && c!= '/' && c != '.')
            {
                sDig += c;
            }
            step++;
        }
        setdigits(wDig, sDig));
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
