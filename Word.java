public class Word 
{
    protected static final int NUMBER = 0;
    protected static final int PRONOUN = 1;
    protected static final int NOUN = 2;
    protected static final int ADJECTIVE = 3;
    protected static final int VERB = 4;
    protected static final int ADVERB = 5;
    protected static final int ADHESIVE = 6;

    private final int RANDOM = -1;

    private int word_type;
    private int primary_genus;
    private int genus_mod;
    private boolean singular;
    private int possessive;
    private int mention_order;
    private int scope_role;
    private int verb_mood;
    private int verb_tense;
    private int[] pattern;
    private int cluster_lenght;
    private int consonant_style;
    private int digit_count;
    private String whole_value;
    private String spare_value;
    private char delimiter;

    private boolean random_type;
    private boolean random_b12_value;
    private boolean random_digit_count;
    private boolean random_pattern;
    private boolean random_length;
    private boolean random_consonant_style;
    private boolean random_mood;
    private boolean random_tense;
    private boolean random_genus;
    private boolean randomly_singular;
    private boolean randomly_possessive;
    private boolean random_mention;
    private boolean random_role;

    /**
     * Pronoun Constructor
     * @param genus
     * @param mod
     * @param singularity
     * @param possession
     * @param mention
     * @param role
     */
    public Word(int genus, int mod, int singularity, int possession, int mention, int role)
    {
        setAllRandom();
        word_type = PRONOUN;
        setGenus(genus, mod);
        setSingularity(singularity);
        setPossession(possession);
        setMentionOrder(mention);
        setRole(role);
    }



    /**
     * Verb Constructor
     * @param mood
     * @param tense
     * @param vPattern
     * @param cLength
     */
    public Word(int mood, int tense, int[] vPattern, int cLength, int cStyle)
    {
        setAllRandom();
        word_type = VERB;
        setMood(mood);
        setTense(tense);
        setPattern(vPattern);
        setClusterLength(cLength);
        setStyle(cStyle);

    }

    /**
     * Noun Constructor
     * @param primaryGenus
     * @param genusMod
     * @param nPattern
     * @param cLength
     * @param nSingular
     * @param nPossessive
     */
    public Word(int primaryGenus, int genusMod, int[] nPattern, int cLength, int nSingular, int nPossessive, int style)
    {
        setAllRandom();
        word_type = NOUN;
        setGenus(primaryGenus, genusMod);
        setPattern(nPattern);
        setStyle(style);
        setClusterLength(cLength);
        setSingularity(nSingular);
        setPossession(nPossessive);
    }

    /**
     * Constructor for Adjectives, Adverbs and Adhesives.
     * @param type
     * @param aPattern
     * @param cLength
     */
    public Word(int type, int[] aPattern, int cLength, int style)
    {
        setAllRandom();
        random_type = (type == RANDOM);
        if(type != RANDOM)
        {
            word_type = type;
            setPattern(aPattern);
            setClusterLength(cLength);
            setStyle(style);
        }
        else
        {
            word_type = Dice.rand(1, 6);
        }
    }

    /**
     * For almost completely random words for the generic sentence pattern.
     * @param type
     */
    public Word(int type)
    {
        setAllRandom();
        word_type = type;
        random_type = false;
    }

    /**
     * Constructor for Numbers
     * @param b12
     * @param digits
     */
    public Word(String b12, int digits)
    {
        word_type = NUMBER;
        setB12Value(b12);
        setDigitCount(digits);
    }

    /**
     * Completely randomized words o.o
     */
    public Word()
    {
        setAllRandom();
        word_type = Dice.rand(1, 6);
    }

    /**
     * 
     */
    public void refreshWord()
    {
        if(RandomType())
        {
            word_type = Dice.rand(1, 6);
        }
    }

    /**
     * 
     * @return
     */
    public int Type()
    {
        return word_type;
    }

    /**
     * 
     * @return
     */
    public boolean RandomType()
    {
        return random_type;
    }

    /**
     * Defaults all randoms to true to prevent errors for different word types.
     * They should be properly updated after the init for whatever type is being built.
     */
    private void setAllRandom()
    {
        random_b12_value = true;
        random_digit_count = true;
        random_pattern = true;
        random_length = true;
        random_consonant_style = true;
        random_mood = true;
        random_tense = true;
        random_genus = true;
        randomly_singular = true;
        randomly_possessive = true;
        random_mention = true;
        random_role = true;

    }

    /**
     * 
     * @return
     */
    public boolean OnlyOne()
    {
        boolean onlyOne = false;
        if((Type() == PRONOUN && !RandomPronoun()) || (Type() == NUMBER && !RandomB12()))
        {
            onlyOne = true;
        }
        return onlyOne;
    }

    /**
     * 
     * @return
     */
    private boolean RandomPronoun()
    {
        return (RandomGenus() || RandomMention() || RandomSingularity() || RandomRole() || RandomlyPossessive());
    }

    /**
     * 
     * @param b12
     */
    private void setB12Value(String b12)
    {
        random_b12_value = (b12.contains(RANDOM + ""));
        SUI.displayTextLn("B12 randomness is " + RandomB12() + " B12 is " + b12);
        if(!RandomB12())
        {
            processB12(b12);
        }
    }

    /**
     * 
     * @return
     */
    public boolean RandomB12()
    {
        return random_b12_value;
    }

    /**
     * 
     * @param b12
     */
    private void processB12(String b12)
    {
        String w = "";
        String s = "";
        delimiter = '-';
        char c;
        int delLoc = b12.length();
        for(int i = 0; i < b12.length(); i++)
        {
            c = b12.charAt(i);
            if(c >= '0' && c <= '9' || c == 'A' || c == 'a' || c == 'b' || c == 'B')
            {
                w += c;
            }
            if(c == '.' || c == '/')
            {
                delLoc = i;
                i = b12.length();
                delimiter = c;
            }
        }
        if(delLoc < b12.length())
        {
            for(int j = delLoc; j < b12.length(); j++)
            {
                c = b12.charAt(j);
                if(c >= '0' && c <= '9' || c == 'A' || c == 'a' || c == 'b' || c == 'B')
                {
                    s += c;
                }
            }
        }
        whole_value = w;
        spare_value = s;
    }

    /**
     * 
     * @return
     */
    public char Delimiter()
    {
        return delimiter;
    }

    /**
     * 
     * @return
     */
    public String WholeValue()
    {
        return whole_value;
    }
    /**
     * 
     * @return
     */
    public String SpareValue()
    {
        return spare_value;
    }

    /**
     * 
     * @param digits
     */
    private void setDigitCount(int digits)
    {
        digit_count = digits;
        random_digit_count = (digits == RANDOM);
    }
    /**
     * 
     * @return
     */
    public boolean RandomDigitCount()
    {
        return random_digit_count;
    }

    /**
     * 
     * @return
     */
    public int DigitCount()
    {
        return digit_count;
    }

    /**
     * 
     * @param nPattern
     */
    private void setPattern(int[] nPattern)
    {
        pattern = nPattern;
        random_pattern = (pattern[0] == RANDOM);
    }

    /**
     * 
     * @return
     */
    public boolean RandomPattern()
    {
        return random_pattern;
    }

    /**
     * 
     * @return
     */
    public int[] Pattern()
    {
        return (RandomPattern())? Words.RandomPattern(word_type) : pattern;
    }

    /**
     * 
     * @param cLength
     */
    private void setClusterLength(int cLength)
    {
        cluster_lenght = cLength;
        random_length = (cLength == RANDOM);
    }
    /**
     * 
     * @return
     */
    public boolean RandomClusterLength()
    {
        return random_length;
    }

    /**
     * 
     * @return
     */
    public int ClusterLength()
    {
        return (RandomClusterLength())? Dice.rand(0, 2) : cluster_lenght;
    }

    /**
     * 
     * @param style
     */
    private void setStyle(int style)
    {
        consonant_style = style;
        random_consonant_style = (style == RANDOM);
    }
    /**
     * 
     * @return
     */
    public boolean RandomStyle()
    {
        return random_consonant_style;
    }
    /**
     * 
     * @return
     */
    public int ConsonantStyle()
    {
        return (RandomStyle())? Dice.rand(0, 2) : consonant_style;
    }

    /**
     * 
     * @param mood
     */
    private void setMood(int mood)
    {
        verb_mood = mood;
        random_mood = (mood == RANDOM);
    }
    /**
     * 
     * @return
     */
    public boolean RandomMood()
    {
        return random_mood;
    }
    /**
     * 
     * @return
     */
    public int Mood()
    {
        return (RandomMood()) ? Dice.rand(0, 4) : verb_mood;
    }

    /**
     * 
     * @param tense
     */
    private void setTense(int tense)
    {
        verb_tense = tense;
        random_tense = (tense == RANDOM);
    }
    /**
     * 
     * @return
     */
    public boolean RandomTense()
    {
        return random_tense;
    }
    /**
     * 
     * @return
     */
    public int Tense()
    {
        return (RandomTense())? Dice.rand(0, 3) : verb_tense;
    }

    /**
     * 
     * @param primaryGenus
     * @param genusMod
     */
    private void setGenus(int primaryGenus, int genusMod)
    {
        primary_genus = primaryGenus;
        genus_mod = genusMod;
        random_genus = (primaryGenus == RANDOM);
    }
    /**
     * 
     * @return
     */
    public boolean RandomGenus()
    {
        return random_genus;
    }

    /**
     * 
     * @return
     */
    public int PrimaryGenus()
    {
        return (RandomGenus())? Dice.rand(0, 3) : primary_genus;
    }
    /**
     * 
     * @return
     */
    public int GenusModifier()
    {
        return (RandomGenus())? Dice.rand(0, 5) : genus_mod;
    }

    /**
     * 
     * @param nSingular
     */
    private void setSingularity(int nSingular)
    {
        randomly_singular = (nSingular == RANDOM);
        singular = (nSingular == 1) ? true : false;
    }

    /**
     * 
     * @return
     */
    public boolean RandomSingularity()
    {
        return randomly_singular;
    }

    /**
     * 
     * @return
     */
    public boolean Singular()
    {
        return (RandomSingularity()) ? Dice.coinToss() : singular;
    }

    /**
     * 
     * @param nPossessive
     */
    private void setPossession(int nPossessive)
    {
        randomly_possessive = (nPossessive == RANDOM);
        possessive = nPossessive;
    }
    /**
     * 
     * @return
     */
    public boolean RandomlyPossessive()
    {
        return randomly_possessive;
    }
    /**
     * 
     * @return
     */
    public int Possessiveness()
    {
        return (RandomlyPossessive()) ? Dice.rand(0, 5) : possessive;
    }

    /**
     * 
     * @param mention
     */
    private void setMentionOrder(int mention)
    {
        mention_order = mention;
        random_mention = (mention == RANDOM);
    }
    /**
     * 
     * @return
     */
    public boolean RandomMention()
    {
        return random_mention;
    }
    /**
     * 
     * @return
     */
    public int MentionOrder()
    {
        return (RandomMention())? Dice.rand(1, 11) : mention_order;
    }

    /**
     * 
     * @param role
     */
    private void setRole(int role)
    {
        scope_role = role;
        random_role = (role == RANDOM);
    }
    /**
     * 
     * @return
     */
    public boolean RandomRole()
    {
        return random_role;
    }
    /**
     * 
     * @return
     */
    public int Role()
    {
        return (RandomRole())? Dice.rand(0, 3) : scope_role;
    }
    
}
