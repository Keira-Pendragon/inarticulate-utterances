/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

public class Word
{
    private static final int DEFAULT_LENGTH = 1;
    private static final int DEFAULT_TYPE = 6;
    private static final int DEFAULT_CLUSTER = 5;
    private static final int[] Default_Pattern = {DEFAULT_CLUSTER};

    private int word_type;
    private boolean word_is_random;
    private int word_length;
    private int consonant_style;
    private int [] word_pattern;
    private boolean word_is_singular;
    private int word_posessive;
    private int word_count;
    private int word_role;
    private int word_genus;
    private int word_genus_mod;
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


    public Word()
    {

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
        word_is_random = random;
    }
    public boolean isRandom()
    {
        return word_is_random;
    }


    
    private void setConsonantStyle(int style)
    {
        consonant_style = style;
    }
    public int ConsonantStyle()
    {
        return consonant_style;
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
        word_is_singular = singular;
    }
    public boolean isSingular()
    {
        return word_is_singular;
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


    private void setGenus(int genus, int gMod)
    {
        word_genus = genus;
        word_genus_mod = gMod;
    }

    public int Genus()
    {
        return word_genus;
    }
    public int GenusMod()
    {
        return word_genus_mod;
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
        while(step < value.length())
        {
            c = value.charAt(step);
            if(c != 0  && c!= '/' && c != '.')
            {
                sDig += c;
            }
            step++;
        }
        setdigits(wDig, sDig);
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
