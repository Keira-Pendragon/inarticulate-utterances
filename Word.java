/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

public class Word
{  
    private final int RANDOM = -1;
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
    private boolean mention_count_is_random;
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
        setType(type);
        setB12Value(b12);
    }

    /**
     * Constructor for random numbers of a given magnitude.
     * @param type
     * @param digits
     */
    public Word(int type, int digits)
    {
        setType(type);
        setDigitCount(digits);        
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
        setType(type);
        setPattern(pattern);
        setStyle(style);
        setLength(length);
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
        setType(type);
        setPattern(pattern);
        setStyle(style);
        setLength(length);
        setGenus(genus);
        setSingularity(singularity);
        setPossessive(possessive);
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
        setType(type);
        setRole(role);
        setMention(mention);
        setGenus(genus);
        setSingularity(singularity);
        setPossessive(possessive);
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
        setType(type);
        setPattern(pattern);
        setStyle(style);
        setLength(length);
        setMood(mood);
        setTense(tense);
    }

    private void setFullRandom(boolean random)
    {
        all_is_random = random;
        if(all_is_random)
        {
            pattern_is_random = true;
            length_is_random = true;
            style_is_random = true;
            value_is_random = true;
            tense_is_random = true;
            mood_is_random = true;
            genus_is_random = true;
            singularity_is_random = true;
            possession_is_random = true;
            mention_count_is_random = true;
            role_is_random;
        }
    }
    
    private boolean FullRandom()
    {
        return all_is_random;
    }
    
    public boolean isSingular()
    {
        return (singularity_is_random) ? Dice.coinToss() : word_is_singular;
    }
    
    private void setType(int type)
    {
        word_type = (type == RANDOM) ? setType(true) : type;
    }

    private void setType(boolean random)
    {
        word_type = Dice.rand(0, 6);
        setTypeRandomness(true);
    }
        
    public int Type()
    {
        return word_type;
    }

    private void setTypeRandomness(boolean random)
    {
        type_is_random = random;
    }
    private boolean TypeIsRandom()
    {
        return type_is_random;
    }

    private void setPatternRandom(boolean random)
    {
        pattern_is_random = random;
    }
    private boolean PatternIsRandom()
    {
        return pattern_is_random;
    }
    
    private void setLengthRandom(boolean random)
    {
        length_is_random = random;
    }
    private boolean LengthIsRandom()
    {
        return length_is_random;
    }
    
    private void setStyleRandom(boolean random)
    {
        style_is_random = random;
    }
    
    private boolean StyleIsRandom()
    {
        return style_is_random;
    }

    private void setValueRandom(boolean random)
    {
        value_is_random = random;
    }
    
    private boolean ValueIsRandom()
    {
        return value_is_random;
    }

    private void setTenseRandom(boolean random)
    {
        tense_is_random = random;
    }
    
    private boolean TenseIsRandom()
    {
        return tense_is_random;
    }
    private void setMoodRandom(boolean random)
    {
        mood_is_random = random;
    }
    private boolean MoodIsRandom()
    {
        return mood_is_random;
    }

    private void setGenusRandom(boolean random)
    {
        genus_is_random = random;
    }
    private boolean GenusIsRandom()
    {
        return genus_is_random;
    }

    private void setPossessionRandom(boolean random)
    {
        possession_is_random = random;
    }
    private boolean PossessivenessIsRandom()
    {
        return possession_is_random;
    }

    private void setSingularRandom(boolean random)
    {
        singularity_is_random = random;
    }
    private boolean SingularIsRandom()
    {
        return singularity_is_random;
    }

    private void setMentionCountRandom(boolean random)
    {
        mention_count_is_random = random;
    }
    private boolean CountIsRandom()
    {
        return mention_count_is_random;
    }

    private void setRoleRandom(boolean random)
    {
        role_is_random = random;
    }
    private boolean RoleIsRandom()
    {
        return role_is_random;
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
        setLengthRandom(length == RANDOM);
        word_length = length;
    }
    
    public int ClusterLength()
    {
        return (LengthIsRandom()) ? Dice.rand(0, 2) : word_length;
    }
    
    
    private void setConsonantStyle(int style)
    {
        setStyleRandom(style == RANDOM);
        consonant_style = style;
    }
    
    public int ConsonantStyle()
    {
        return (StyleIsRandom())? Dice.rand(0,2) : consonant_style;
    }
    
    private void setPattern(int[] pattern)
    {
        setPatternRandom(pattern[0] == RANDOM);
        word_pattern = pattern;
    }
    public int[] Pattern()
    {
        return (PatternIsRandom()) ? randomPattern() : word_pattern;
    }
    
    private void setIsSingular(boolean [] singular)
    {
        setSingularRandom(singular[0]);
        word_is_singular = singular[1];
    }
    public boolean IsSingular()
    {
        return (SingularIsRandom())? Dice.coinToss() : word_is_singular;
    }

    private void setPossessiveness(int possessiveness)
    {
        posessive_style = possessiveness;
        setPossessiveRandom(possessiveness == RANDOM);
    }
    public int PossessionStyle()
    {
        return (PossessiveIsRandom())? Dice.Rand(0, 5) : possessive_style;
    }
    

    private void setMentionCount(int count)
    {
        mention_count = count;
        setMentionRandom(count == RANDOM);
    }
    public int MentionCount()
    {
        return(MentionCountIsRandom())? Dice.(1, 11): mention_count;
    }
    
    private void setScopeRole(int role)
    {
        scope_role = role;
        setRoleRandom(role == RANDOM);
    }
    
    public int Role()
    {
        return (RoleIsRandom())? Dice.rand(0, 3) : scope_role;
    }

    private void setGenus(int[] genus)
    {
        word_genus = genus;
        setGenusRandom(genus[0] == RANDOM);
    }
    public int[] Genus()
    {
        return (GenusIsRandom())? randomGenus() : word_genus;
    }
    
    private int[] randomGenus()
    {
    }
    
    private void setMood(int mood)
    {
        verb_mood = mood;
        setMoodRandom(mood == RANDOM);
    }
    public int Mood()
    {
        return (MoodIsRandom())? Dice.rand(0, 4) : verb_mood;
    }
    
    private void setTense(int tense)
    {
        verb_tense = tense;
        setTenseRandom(tense == RANDOM);
    }
    
    public int Tense()
    {
        return (TenseIsRandom())? Dice.rand(0, 3) : verb_tense;
    }
    
    
    private void setDigitCount(int count)
    {
        digit_count = count;
        setDigitCountRandom(count == RANDOM);
    }
    
    private void DigitCount()
    {
        return (DigitCountIsRandom()) ? Dice.rand(1, 66) : digit_count;
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
