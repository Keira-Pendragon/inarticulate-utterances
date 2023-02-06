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
            word_type = Dice.rand(0, 6);
            setAllRandom();
        }
    }

    public void refreshWord()
    {
        if(RandomType())
        {
            word_type = Dice.rand(0, 6);
        }
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

    public int Type()
    {
        return word_type;
    }

    public boolean RandomType()
    {
        return random_type;
    }

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

    public boolean OnlyOne()
    {
        boolean onlyOne = false;
        if(Type() == PRONOUN || Type() == NUMBER)
        {
            if(RandomB12() || RandomPronoun())
            {
                onlyOne = true;
            }
        }
        return onlyOne;
    }

    private boolean RandomPronoun()
    {
        return (RandomGenus() || RandomMention() || RandomSingularity() || RandomRole() || RandomlyPossessive());
    }

    private void setB12Value(String b12)
    {
        random_b12_value = (b12.contains(RANDOM + ""));
        if(!RandomB12())
        {
            processB12(b12);
        }
    }

    public boolean RandomB12()
    {
        return random_b12_value;
    }

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
    public char Delimiter()
    {
        return delimiter;
    }

    public String WholeValue()
    {
        return whole_value;
    }
    public String SpareValue()
    {
        return spare_value;
    }

    private void setDigitCount(int digits)
    {
        digit_count = digits;
        random_digit_count = (digits == RANDOM);
    }
    public boolean RandomDigitCount()
    {
        return random_digit_count;
    }

    public int DigitCount()
    {
        return digit_count;
    }

    private void setPattern(int[] nPattern)
    {
        pattern = nPattern;
        random_pattern = (pattern[0] == RANDOM);
    }

    public boolean RandomPattern()
    {
        return random_pattern;
    }

    public int[] Pattern()
    {
        return (RandomPattern())? Words.RandomPattern(word_type) : pattern;
    }

    private void setClusterLength(int cLength)
    {
        cluster_lenght = cLength;
        random_length = (cLength == RANDOM);
    }
    public boolean RandomClusterLength()
    {
        return random_length;
    }

    public int ClusterLength()
    {
        return (RandomClusterLength())? Dice.rand(0, 2) : cluster_lenght;
    }

    private void setStyle(int style)
    {
        consonant_style = style;
        random_consonant_style = (style == RANDOM);
    }
    public boolean RandomStyle()
    {
        return random_consonant_style;
    }
    public int ConsonantStyle()
    {
        return (RandomStyle())? Dice.rand(0, 2) : consonant_style;
    }

    private void setMood(int mood)
    {
        verb_mood = mood;
        random_mood = (mood == RANDOM);
    }
    public boolean RandomMood()
    {
        return random_mood;
    }
    public int Mood()
    {
        return (RandomMood()) ? Dice.rand(0, 5) : verb_mood;
    }


    private void setTense(int tense)
    {
        verb_tense = tense;
        random_tense = (tense == RANDOM);
    }
    public boolean RandomTense()
    {
        return random_tense;
    }
    public int Tense()
    {
        return (RandomTense())? Dice.rand(0, 3) : verb_tense;
    }

    private void setGenus(int primaryGenus, int genusMod)
    {
        primary_genus = primaryGenus;
        genus_mod = genusMod;
        random_genus = (primaryGenus == RANDOM);
    }
    public boolean RandomGenus()
    {
        return random_genus;
    }

    public int PrimaryGenus()
    {
        return (RandomGenus())? Dice.rand(0, 4) : primary_genus;
    }
    public int GenusModifier()
    {
        return (RandomGenus())? Dice.rand(0, 4) : genus_mod;
    }

    private void setSingularity(int nSingular)
    {
        randomly_singular = (nSingular == RANDOM);
        singular = (nSingular == 1) ? true : false;
    }

    public boolean RandomSingularity()
    {
        return randomly_singular;
    }

    public boolean Singular()
    {
        return (RandomSingularity()) ? Dice.coinToss() : singular;
    }

    private void setPossession(int nPossessive)
    {
        randomly_possessive = (nPossessive == RANDOM);
        possessive = nPossessive;
    }
    public boolean RandomlyPossessive()
    {
        return randomly_possessive;
    }
    public int Possessiveness()
    {
        return (RandomlyPossessive()) ? Dice.rand(0, 6) : possessive;
    }

    private void setMentionOrder(int mention)
    {
        mention_order = mention;
        random_mention = (mention == RANDOM);
    }
    public boolean RandomMention()
    {
        return random_mention;
    }
    public int MentionOrder()
    {
        return (RandomMention())? Dice.rand(1, 11) : mention_order;
    }

    private void setRole(int role)
    {
        scope_role = role;
        random_role = (role == RANDOM);
    }
    public boolean RandomRole()
    {
        return random_role;
    }
    public int Role()
    {
        return (RandomRole())? Dice.rand(0, 3) : scope_role;
    }
    
}
