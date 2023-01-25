/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

public class Word
{
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
    private int word_digits;
    private String word_base12Digits;
    private char delimiter;
    private int del_loc;
    private String siathael_word;
    private String english_translation;
    private String whole_digits;
    private String spare_digits;

    /**
     * Word Constructor for Nouns, Adjectives and Pronouns
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
     * Word constructor for Verbs and Adverbs
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
     * Word constructor for Clarifier words
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
     * Word constructor for specfic numbers
     * @param type
     * @param random
     * @param digits
     * @param word_base12Digits
     */
    public Word(int type, boolean random, int digits, String word_base12Digits)
    {
        setType(type);
        setRandom(random);
        setdigits(digits);
        setbase12Value(word_base12Digits);        
    }

    /**
     * Word constructor for random numbers
     * @param type
     * @param random
     * @param digits
     */
    public Word(int type, boolean random, int digits)
    {
        setType(type);
        setRandom(random);
        setdigits(digits);        
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
    public int Posessiveness()
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


    private void setdigits(int digits)
    {
        word_digits = digits;
    }
    public int numDigits()
    {
        return word_digits;
    }

    private void setbase12Value(String value)
    {
        word_base12Digits = value;
        
        delimiter = '';
        // default to the length of the value, or 37, whichever is shorter, in case there is no delimiter...
        del_loc = (value.length < 36) ?  value.length : 37;
        for(int i = 0; i < value.length(); i++)
        {
            if (value.charAt(i) == '/' || value.charAt(i) == '.')
            {
                delimiter = value.charAt(i);
                del_loc = i;
            }
        }
        if(delimiter != '')
        {
            whole_digits = SUI.trimString(value, 0, del_loc -1);
            spare_digits = SUI.trimString(value, del_loc + 1, value.length() -1);
        }
        else
        {
            whole_digits = value;
            spare_digits = "";
        }        
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
    
    private void setTranslation()
    {
    }
    
    private void getTranslation()
    {
    }
    
}
