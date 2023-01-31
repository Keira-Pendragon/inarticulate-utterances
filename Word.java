/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

public class Word
{  
    private boolean type_is_random;
    private boolean all_is_random;
    private boolean pattern_is_random;
    private boolean length_is_random;
    private boolean style_is_random;
    
    private boolean value_is_random;
    
    private boolean tense_is_random;
    private boolean mood_is_random;
    
    private boolean genus_is_random;
    private boolean singularity_is_random;
    private boolean possession_is_random;
    private boolean count_is_random;
    private boolean role_is_random;
    
    
    private int word_type;
    
    private String siathael_word;
    private String english_translation;
    
    private int word_length;
    private int consonant_style;
    private int [] word_pattern;
    
    private boolean word_is_singular;
    private int posessive_style;
    private int mention_count;
    private int scope_role;
    private int[] word_genus;
    
    private int verb_mood;
    private int verb_tense;
    
    private int [] digit_count;
    private String word_base12Digits;
    private String[] digit_value;
    private char delimiter;
    


    /**
     * Constructor for utterly random words.
     */
    public Word()
    {
        all_is_random = true;
        type_is_random = true;
        setType(true);
    }

    /**
     * Constructor for completely random words of a given type.
     * @param type
     */
    public Word(int type)
    {
        setFullRandom(true);
        setType(type);
    }

    /**
     * Constructor for specific b12 numbers
     * @param type
     * @param b12
     */
    public Word(int type, String b12)
    {

    }

    /**
     * Constructor for random numbers of a given magnitude.
     * @param type
     * @param digits
     */
    public Word(int type, int digits)
    {

    }

    /**
     * Constructor for everything but numbers and pronouns where everything else is undefined.
     * @param type
     * @param pattern
     * @param style
     * @param length
     */
    public Word(int type, int[] pattern, int style, int length)
    {

    }

    /**
     * Constructor for nouns with possibly random components.
     * @param type
     * @param pattern
     * @param style
     * @param length
     * @param genus
     * @param randomSingularity
     * @param singular
     * @param possessive
     */
    public Word(int type, int[] pattern, int style, int length, int[] genus, boolean [] singularity, int possessive)
    {

    }

    /**
     * Consructor for Pronouns with possibly random components
     * @param type
     * @param role
     * @param posessive
     * @param mention
     * @param singularity
     * @param genus
     */
    public Word(int type, int role, int posessive, int mention, boolean[] singularity, int[] genus)
    {

    }

    /**
     * Constructor for Pronouns with possibly random components.
     * @param type
     * @param mood
     * @param tense
     * @param pattern
     * @param length
     * @param style
     */
    public Word(int type, int mood, int tense, int[] pattern, int length, int style)
    {

    }

    private void setFullRandom(boolean random)
    {
        all_is_random = random;
    }
    
    public boolean isSingular()
    {
        return (singularity_is_random) ? Dice.coinToss() : word_is_singular;
    }
    
    private void setType(int type)
    {
        word_type = type;
    }

    private void setType(boolean random)
    {
        word_type = Dice.rand(0, 6);
    }
        
    public int Type()
    {
        return word_type;
    }

    private void setTypeRandomness(boolean random)
    {
        type_is_random = random;
    }

    private void setPatternRandom(boolean random)
    {
        pattern_is_random = random;
    }
    private void setLengthRandom(boolean random)
    {
        length_is_random = random;
    }
    private void setStyleRandom(boolean random)
    {
        style_is_random = random;
    }

    private void setValueRandom(boolean random)
    {
        value_is_random = random;
    }

    private void setTenseRandom(boolean random)
    {
        tense_is_random = random;
    }
    private void setMoodRandom(boolean random)
    {
        mood_is_random = random;
    }

    private void setGenusRandom(boolean random)
    {
        genus_is_random = random;
    }

    private void setPossessionRandom(boolean random)
    {
        possession_is_random = random;
    }

    private void setSingularRandom(boolean random)
    {
        singularity_is_random = random;
    }

    private void setCountRandom(boolean random)
    {
        count_is_random = random;
    }

    private void setRoleRandom(boolean random)
    {
        role_is_random = random;
    }

    private void setSiathaelWord(String word)
    {
        siathael_word = word;
    }
    private void setTranslation(String translation)
    {
        english_translation = translation;
    }
    private void setClusterLength(int length)
    {
        word_length = length;
    }
    private void setConsonantStyle(int style)
    {
        consonant_style = style;
    }
    private void setPattern(int[] pattern)
    {
        word_pattern = pattern;
    }
    
    private void setIsSingular(boolean singular)
    {
        word_is_singular = singular;
    }

    private void setPossessiveness(int possessiveness)
    {
        posessive_style = possessiveness;
    }

    private void setMentionCount(int count)
    {
        mention_count = count;
    }

    
    private void setScopeRole(int role)
    {
        scope_role = role;
    }

    private void setGenus(int[] genus)
    {

    }
    
    private void setMood(int mood)
    {
        verb_mood = mood;
    }
    private void setTense(int tense)
    {
        verb_tense = tense;
    }
    private void setDigitCount(int[] count)
    {
        digit_count = count;
    }
    private void setB12Value(String fullB12)
    {
        word_base12Digits = fullB12;
    }
    private void setDigitValues(String fullB12)
    {
        digit_value = processB12(fullB12);
    }
    private void setDelimiter(char del)
    {
        delimiter = del;
    }

    private String[] processB12(String fullB12)
    {
        return new String[] {"", ""};
    }

}
