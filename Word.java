

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
    public Word(int type, int random, int length, int[] pattern, int mood, int tense)
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
    public Word(int type, int random, int length, int[] pattern)
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
    public Word(int type, int random, int digits, String word_base12Digits)
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
    public Word(int type, int random, int digits)
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
    public int[][] Pattern()
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
    }
    public String Base12Value()
    {
        return word_base12Digits;
    }
}