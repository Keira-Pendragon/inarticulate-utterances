/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

public class Words extends Cluster
{
    private static final int RANDOM = -1;
    protected static final int[] v0_pattern = {KEYMID, MIDCONST, ENDKEY};
    protected static final int[] v1_pattern = {ONSET, KEYMID, MIDCONST, ENDKEY};
    protected static final int[] v2_pattern = {VOWEL, MIDCONST, KEYMID, MIDCONST, ENDKEY};
    protected static final int[] v3_pattern = {ONSET, VOWEL, MIDCONST, KEYMID, MIDCONST, ENDKEY};

    protected static final int[][] verb_pattern = {v0_pattern, v1_pattern, v2_pattern, v3_pattern};
    protected static final String verb_pattern_details = 
                                  "\n1) KeyMid, MidConst, EndKey" 
                                + "\n2) Onset, KeyMid, MidConst, EndKey"
                                + "\n3) Vowel, MidConst, KeyMid, MidConst, Endkey"
                                + "\n4) Onset, Vowel, MidConst, KeyMid, MidConst, Endkey";

    protected static final int[] av0_pattern = {VOWEL, MIDCONST, ADKEY};
    protected static final int[] av1_pattern = {ONSET, VOWEL, MIDCONST, ADKEY};
    protected static final int[] av2_pattern = {VOWEL, MIDCONST, VOWEL, MIDCONST, ADKEY};
    protected static final int[] av3_pattern = {ONSET, VOWEL, MIDCONST, VOWEL, MIDCONST, ADKEY};
    

    protected static final int[][] adverb_pattern = {av0_pattern, av1_pattern, av2_pattern, av3_pattern};
    protected static final String adverb_pattern_details = 
                                  "\n1) Vowel, MidConst, AdKey" 
                                + "\n2) Onset, Vowel, MidConst, AdKey"
                                + "\n3) Vowel, MidConst, Vowel, MidConst, AdKey"
                                + "\n4) Onset, Vowel, MidConst, Vowel, MidConst, AdKey";


    protected static final int[] n0_pattern = {KEYMID, CODA};
    protected static final int[] n1_pattern = {ONSET, KEYMID, CODA};
    protected static final int[] n2_pattern = {VOWEL, MIDCONST, KEYMID, CODA};
    protected static final int[] n3_pattern = {ONSET, VOWEL, MIDCONST, KEYMID, CODA};

    protected static final int[][] noun_pattern = {n0_pattern, n1_pattern, n2_pattern, n3_pattern};
    protected static final String noun_pattern_details = 
                                  "\n1) KeyMid, Coda"
                                + "\n2) Onset, KeyMid, Coda"
                                + "\n3) Vowel, MidConst, KeyMid, Coda"
                                + "\n4) Onset, Vowel, MidConst, KeyMid, Coda";

    protected static final int[] an0_pattern = {ADKEY, CODA};
    protected static final int[] an1_pattern = {ONSET, ADKEY, CODA};
    protected static final int[] an2_pattern = {VOWEL, MIDCONST, ADKEY, CODA};
    protected static final int[] an3_pattern = {ONSET, VOWEL, MIDCONST, ADKEY, CODA};

    protected static final int[][] adjective_pattern = {an0_pattern, an1_pattern, an2_pattern, an3_pattern};    
    protected static final String adjective_pattern_details = 
                                  "\n1) AdKey, Coda"
                                + "\n2) Onset, AdKey, Coda"
                                + "\n3) Vowel, MidConst, AdKey, Coda"
                                + "\n4) Onset, Vowel, MidConst, AdKey, Coda";

    protected static final int[] a0_pattern = {VOWEL};
    protected static final int[] a1_pattern = {SPAREKEY, CODA};
    protected static final int[] a2_pattern = {ONSET, SPAREKEY, CODA};
    protected static final int[] a3_pattern = {VOWEL, MIDCONST, SPAREKEY};
    protected static final int[] a4_pattern = {SPAREKEY, MIDCONST, VOWEL};
    protected static final int[] a5_pattern = {ONSET, SPAREKEY, MIDCONST, VOWEL};
    protected static final int[] a6_pattern = {ONSET, VOWEL, MIDCONST, SPAREKEY};    
    protected static final int[] a7_pattern = {VOWEL, MIDCONST, SPAREKEY, MIDCONST, VOWEL};
    protected static final int[] a8_pattern = {VOWEL, MIDCONST, VOWEL, MIDCONST, SPAREKEY};    
    protected static final int[] a9_pattern = {ONSET, VOWEL, MIDCONST, SPAREKEY, MIDCONST, VOWEL};
    protected static final int[] a10_pattern = {ONSET, VOWEL, MIDCONST, VOWEL, MIDCONST, SPAREKEY};
    protected static final int[] a11_pattern = {VOWEL, MIDCONST, VOWEL, MIDCONST, SPAREKEY, CODA};
    protected static final int[] a12_pattern = {ONSET, VOWEL, MIDCONST, VOWEL, MIDCONST, SPAREKEY, CODA};


    protected static final int[][] adhesive_pattern = 
    {
        a0_pattern, a1_pattern, a2_pattern, a3_pattern, a4_pattern, a5_pattern, a6_pattern, 
        a7_pattern, a8_pattern, a9_pattern, a10_pattern, a11_pattern, a12_pattern
    };

protected static final int[] standard_pattern_range = {0, 3};
protected static final int[] standard_pattern_range_for_prompt = {-1, 3};
protected static final int[] adhesive_pattern_range_for_prompt = {-1, 12};
protected static final int[] adhesive_pattern_range = {0, 12};

protected static final String adhesive_details = 
                                      "\n1) Vowel"
                                    + "\n2) SpareKey, Coda"
                                    + "\n3) Onset, SpareKey, Coda"
                                    + "\n4) Vowel, MidConst, SpareKey"
                                    + "\n5) SpareKey, MidConst, Vowel"
                                    + "\n6) Onset, SpareKey, MidConst, Vowel"
                                    + "\n7) Onset, Vowel, MidConst, SpareKey"
                                    + "\n8) Vowel, MidConst, SpareKey, MidConst, Vowel"
                                    + "\n9) Vowel, MidConst, Vowel, MidConst, SpareKey"
                                    + "\n10) Onset, Vowel, MidConst, SpareKey, MidConst, Vowel"
                                    + "\n11) Onset, Vowel, MidConst, Vowel, MidConst, SpareKey"
                                    + "\n12) Vowel, MidConst, Vowel, MidConst, SpareKey, Coda"
                                    + "\n13) Onset, Vowel, MidConst, Vowel, MidConst, SpareKey, Coda"


    // \n1) Concepts\n2) Objects\n3) Entities\n4) Places\n5) Traits or Qualities\n6) Actions
    protected static final String g0_prompt = "Should this concept relate to\n1) Standard Concept\n2) Objects\n3) Entities\n4) Places\n5) Traits or Qualities\n6) Actions";
    protected static final String g1_prompt = "Should this Object relate to\n1) Concepts\n2) Standard Object\n3) Entities\n4) Places\n5) Traits or Qualities\n6) Actions";
    protected static final String g2_prompt = "Should this entity be denoted by\n1) Concepts\n2) Objects\n3) Standard Entity\n4) Places\n5) Traits or Qualities\n6) Actions";
    protected static final String g3_prompt = "Should this place be associated with\n1) Concepts\n2) Objects\n3) Entities\n4) Standard Place\n5) Traits or Qualities\n6) Actions";
    protected static final int[] genus_mod_range = {0, 5};

    protected static final String random_prompt = "Would you like the word to be random?\n1) yes\n2) no";
    
    protected static final String singular_prompt = "Is the word Singular?\n0) Surprise Me\n1) yes\n2) no";
    protected static final int[] singular_range = {-1, 1};

    protected static final String genus_primary_prompt = "What is the primary genus of the noun?\n0) Surprise Me\n1) Concept\n2) Thing\n3) Entity\n4) Place";
    protected static final int[] genus_primary_range = {-1, 5};
    protected static final String [] genus_mod_prompt = {g0_prompt, g1_prompt, g2_prompt, g3_prompt};
    protected static final String tense_prompt = "How does this action relate to time?\n0) Surprise Me\n1) Timeless\n2) Past\n3) Present\n4) Future";
    protected static final int[] tense_range = {-1, 3};
    protected static final String mood_prompt = "Is this action a\n0) Surprise Me\n1) Request or Wish\n2) Directive\n3) Voluntary\n4) Passive\n5) Unwilling";
    protected static final int[] mood_range = {-1, 4};
    protected static final String role_prompt = "Is this pronoun\n0) Surprise Me\n1) The speaker\n2) The Lisener\n3) Both\n4) Neither";
    protected static final int[] role_range = {-1, 3};
    protected static final String possessive_prompt = "Is this noun posessive?\n0) Surprise Me\n1) no\n2) part of\n3) dear to\n4) owned by\n5) diminuiative to\n6) loosely associated";
    protected static final int[] possessive_range = {-1, 5};
    protected static final String noun_count_prompt = "Is there more than one of this specific pronoun in the context?\n0) Surprise Me\n1) no\n#) Yes, this is the nth of the same (n: 2 to 11)";
    protected static final int[] noun_count_range = {0, 11};
    protected static final String digit_count_prompt = "How many digits should the random number have?\n(Limit 33 for whole, 66 for mixed, 0 for random)";
    protected static final int[] digit_count_range = {1, 66};
    protected static final String b12_prompt = "Enter the base 12 number to translate\n(Valid Values include 0-9, 'A', 'a', 'B', 'b', ',', '.', '/')\n(Max digits 66 if '.' or '/' divide them to a max of 33 on either side)";
    protected static final String cluster_length_prompt = "How long should the clusters be?\n0) Surprise Me\n1) Short\n2) Average\n3) Long";
    protected static final int[] cluster_length_range = {-1, 2};
    protected static final String word_type_prompt = "What type of word should be generated?\n0) Surprise Me\n1) Number\n2) Pronoun\n3) Noun\n4) Adjective\n5) Verb\n6) Adverb\n7) Adhesive";
    protected static final int[] word_type_range = {-1, 6};
    protected static final String word_pattern_prompt = "Which pattern should the word follow?\n0) Surprise Me";
    protected static final int[] style_range = {-1, 2};
    protected static final String style_details = "Should the word's consonants be\n0) Surprise Me\n1) voiced\n2) neutral\n3) voiceless";
                                                  


    private static int MAXDIGITS = 36;
    /**
    * Max number of digits a mixed number can contain.
    */
    private static final int MAXCOOKEDDIGITS = (MAXDIGITS * 2);
    private static final int WHOLENUMBER = 0;
    private static final int DECIMALNUMBER = 1;
    private static final int FRACTIONNUMBER = 2;
    private static final int[] RANDOMINTARRAY  = {-1, -1};

    public Words()
    {

    }

    /**
     * 
     * @param type
     * @return
     */
    public static int[] RandomPattern(int type)
    {
        int[] p;
        switch (type) {
            case NOUN:
                p = RandomNounPattern();
                break;
            case VERB:
                p = RandomVerbPattern();
                break;
            case ADVERB:
                p = RandomAdverbPattern();
                break;
            case ADJECTIVE:
                p = RandomAdjectivePattern();
                break;
            default:
                p = RandomAdhesivePattern();
                break;
        }
        return p;
    }
    
    private static int WeightedRandomStandardPatternIndex()
    {
        int weight = Dice.rand(0, 100);
        return (weight > 15) ? 0 : (weight >  
    }
    
    private static int WeightedRandomAdhesivePatterIndex()
    {
    
    }
    
    /**
     * 
     * @return
     */
    public static int[] RandomNounPattern()
    {
        return noun_pattern[Dice.rRand(standard_pattern_range)];
    }

    /**
     * 
     * @return
     */
    public static int[] RandomAdjectivePattern()
    {
        return adjective_pattern[Dice.rRand(standard_pattern_range)];
    }
    /**
     * 
     * @return
     */
    public static int[] RandomVerbPattern()
    {
        return verb_pattern[Dice.rRand(standard_pattern_range)];
    }
    /**
     * 
     * @return
     */
    public static int[] RandomAdverbPattern()
    {
        return adverb_pattern[Dice.rRand(standard_pattern_range)];
    }
    /**
     * 
     * @return
     */
    public static int[] RandomAdhesivePattern()
    {
        return adhesive_pattern[Dice.rRand(adhesive_pattern_range)];
    }

    /**
     * 
     * @param type
     * @return
     */
    public static Word requestWord(int type)
    {
        boolean random = (type == RANDOM) ? true : randomWord();
        int length = (type == NUMBER || type == PRONOUN || random) ? RANDOM : clusterLength();
        String b12Value = ((type == NUMBER && random) || (type != NUMBER)) ? RANDOM + "" : requestB12ToTranslate();
        int digits = (type != NUMBER || random || b12Value.contains("" + RANDOM)) ? RANDOM : b12Value.length();
        int [] pattern = getPattern(type, random);
        int consonantStyle = (type == PRONOUN || type == NUMBER || random) ? RANDOM : selectConsonantStyle();
        int possessive = (type == NOUN || type == PRONOUN) ? ((random) ? RANDOM : selectPossessiveness()) : 0;
        int role = (type == PRONOUN && !random)? selectRole() : RANDOM;
        int count = (type == PRONOUN && !random) ? selectNounCount() : RANDOM; 
        int singular = ((type == NOUN || type == PRONOUN) && !random) ? singularWord() : RANDOM;
        int[] genus = ((type == NOUN || type == PRONOUN) && !random) ? selectComplexGenus() : RANDOMINTARRAY;
        int mood = (type == VERB && !random)? selectMood() : RANDOM;
        int tense = (type == VERB && !random)?  selectTense() : RANDOM;
        return whatWord(type, random, length, b12Value, pattern, possessive, role, count, singular, genus, mood, tense, digits, consonantStyle);
    }

    /**
     * 
     * @param type
     * @param random
     * @param length
     * @param b12Value
     * @param pattern
     * @param possessive
     * @param role
     * @param count
     * @param singular
     * @param genus
     * @param mood
     * @param tense
     * @param digits
     * @param style
     * @return
     */
    private static Word whatWord(int type, boolean random, int length, String b12Value, int[] pattern, int possessive, int role, int count, int singular, int[] genus, int mood, int tense, int digits, int style)
    {
        Word aWord;
        switch (type) 
        {
            case NOUN:
                aWord = new Word(genus[0], genus[1], pattern, length, singular, possessive, style);
                break;
            case PRONOUN:
                aWord = new Word(genus[0], genus[1], singular, possessive, count, role);
                break;
            case VERB:
                aWord = new Word(mood, tense, pattern, length, style);
                break;
            case NUMBER:
                aWord =  new Word(b12Value, digits);
                break;
            default:
                aWord = new Word(type, pattern, length, style);
                break;
        }
        return aWord;
    }

    /**
     * 
     * @param type
     * @param random
     * @return
     */
    private static int[] getPattern(int type, boolean random)
    {
        int[] pattern;
        type = (random) ? -1 : type;
        switch (type) 
        {
            case NOUN:
                pattern = nounPattern();
                break;
            case ADJECTIVE:
                pattern = adjectivePattern();
                break;
            case VERB:
                pattern = verbPattern();
                break;
            case ADVERB:
                pattern = adverbPattern();
                break;
            case ADHESIVE:
                pattern = altPattern();
                break;        
            default:
                pattern = RANDOMINTARRAY;
                break;
        }
        return pattern;
    }

    /**
     * 
     * @param w
     * @return
     */
    public static String buildAWord(Word w)
    {
        return (w.Type() == NUMBER) ? buildNumber(w) : (w.Type() == PRONOUN) ? buildPronoun(w) : buildWord(w);   
    }

    /**
     * 
     * @param aWord
     * @return
     */
    public static String buildWord(Word aWord)
    {
        StringBuilder nWord = new StringBuilder();
        int[] pattern = aWord.Pattern();
        for(int i: pattern)
        {
            nWord.append(nextCluster(i, aWord));
        }
        return nWord.toString();
    }

    /**
     * 
     * @param cluster
     * @param w
     * @return
     */
    private static String nextCluster(int cluster, Word w)
    {
        String c = "";
        int length = w.ClusterLength();
        int style = w.ConsonantStyle();
        switch (cluster) 
        {
            case ONSET:
                c = OnsetCluster(length, style);
                break;
            case MIDCONST:
                c = MidWordCluster(length, style);
                break;
            case CODA:
                c = CodaCluster(length, style);
                break;
            case VOWEL:
                c = vowelCluster(length);
                break;
            case KEYMID:
                c = (w.Type() == NOUN) ? genusCluster(w) : moodVowel(w.Mood());
                break;
            case ENDKEY:
                c = tenseVowel(w.Tense());
                break;
            case ADKEY:
                c = adVowel();
                break;
            case SPAREKEY:
                c = spareVowel();
                break;
            default:
                break;
        }
        return c;
    }

    /**
     * 
     * @param aWord
     * @return
     */
    public static String buildPronoun(Word aWord)
    {        
        return possessivePrefix(aWord.Possessiveness()) + pronounRole(aWord.Role()) + genusCluster(aWord) 
        + digitValue(aWord.MentionOrder()) + ((aWord.Singular()) ? "" : pluralSuffix());
    }

    /**
     * TODO: Major corrections to number handling for spare values o__o; Why are they getting flipped ftw
     * @param aWord
     * @return
     */
    public static String buildNumber(Word aWord)
    {
        String nNumber = "";
        String wholeValue;
        String spareValue;
        boolean spareExists;
        boolean wholeExists;
        char delimiter;
        if(aWord.RandomB12())
        {
            String[] b12 = cookedB12(aWord.RandomDigitCount() ? 0 : aWord.DigitCount());
            wholeValue = b12[0];
            spareValue = b12[1];
            
            wholeExists = wholeValue.length() > 0;
            spareExists = spareValue.length() > 0;
            delimiter = b12[2].charAt(0);
        }
        else
        {
            wholeValue = aWord.WholeValue();
            wholeExists = wholeValue.length() > 0;
            spareValue = aWord.SpareValue();
            spareExists = spareValue.length() > 0;
            delimiter = aWord.Delimiter();
        }
        // Get any whole number value  translated
        nNumber = (wholeExists) ? standardMethod(wholeValue, true, ' ') : "" ;
        // Get any denominator or decimal value (decimals are handled differently...)
        nNumber += (spareExists)? ((delimiter == '/') ? "|" + standardMethod(spareValue, false, delimiter) : ":" + decimalMethod(spareValue)) : "";       
        return nNumber;
    }

    /**
     * 
     * @param d
     * @return
     */
    private static int intifyB12Digit(char d)
    {
        return (d == 'A') ? 10 : (d == 'B') ? 11 : (d - '0');
    }

    /**
     * 
     * @param translate
     * @param isWhole
     * @param delim
     * @return
     */
    private static String standardMethod(String translate, boolean isWhole, char delim)
    {
        SUI.displayTextLn("getting a whole number? " + isWhole);
        String translation = "";
        int spare = translate.length() % 3;
        int trio = translate.length() / 3 - 1;
        int cDigit = 0;
        if(spare == 2)
        {
            translation += nextDigit(intifyB12Digit(translate.charAt(cDigit)), 1, trio + 1, delim) + "'";
            cDigit++;
            spare--;
        }
        if(spare == 1)
        {        
            translation += nextDigit(intifyB12Digit(translate.charAt(cDigit)), 0, trio + 1, delim) + "-";
            cDigit++;
        }   
        int dX__val;
        int d_Y_val;
        int d__Zval;

        while(trio >= 0)
        {
            dX__val = intifyB12Digit(translate.charAt(cDigit));
            cDigit++;
            d_Y_val = intifyB12Digit(translate.charAt(cDigit));
            cDigit++;
            d__Zval = intifyB12Digit(translate.charAt(cDigit));
            cDigit++;
            translation += (dX__val!= 0) ? nextDigit(dX__val, 2, trio, delim) + "'" : "";
            translation += (d_Y_val!= 0) ? nextDigit(d_Y_val, 1, trio, delim) + "'"  : "";
            translation += ((d__Zval + d_Y_val + dX__val) != 0) ? nextDigit(d__Zval, 0, trio, delim) + ((trio != 0)? "-" : "") : "";
            trio--;
        }
        
        return translation;
    }

    /**
     * 
     * @param translate
     * @return
     */
    private static String decimalMethod(String translate)
    {
        String translation = "";
        int trio = translate.length() / 3;
        char delim = '.';
        int cDigit = 0;
        int dX__val;
        int d_Y_val;
        int d__Zval;
        for(int i = 0; i < trio; i++)
        {
            dX__val = intifyB12Digit(translate.charAt(cDigit));
            cDigit++;
            d_Y_val = intifyB12Digit(translate.charAt(cDigit));
            cDigit++;
            d__Zval = intifyB12Digit(translate.charAt(cDigit));
            cDigit++;
            translation += (dX__val!= 0) ? nextDigit(dX__val, 2, i, delim) + "'" : "";
            translation += (d_Y_val!= 0) ? nextDigit(d_Y_val, 1, i, delim) + "'"  : "";
            translation += ((d__Zval + d_Y_val + dX__val) != 0) ? nextDigit(d__Zval, 0, i, delim) + ((i != trio) ? "-" : ""): "";
        }
        int lastIndex = translate.length() -1;
        if(cDigit < lastIndex)
        {
            translation+= nextDigit(intifyB12Digit(translate.charAt(cDigit)), 2, (trio + 1), delim) + ((cDigit != lastIndex -1)? "'" : "");
            cDigit++;
        }
        if(cDigit == lastIndex)
        {
            translation+= nextDigit(intifyB12Digit(translate.charAt(cDigit)), 1, (trio + 1), delim);
        }

        return translation;
    }

    /**
     * 
     * @param value
     * @param place
     * @param power
     * @param delim
     * @return
     */
    private static String nextDigit(int value, int place, int power, char delim)
    {
        int mag = (place == 0) ? power : 0;
        int style = (delim == ' ') ? 0 : (delim == '/')? 1 : 2;
        return digitValue(value) + digitKey(style) + digitCoda(place, mag);
    }


    /**
    * 
    * @param digits
    * @return
    */
    private static String[] cookedB12(int digits)
    {
        if(digits == 0)
        {
            digits = Dice.rand(1, 9);
        }
        String whole = "";
        String spare = "";
        // If the number is bigger than the maximum any one part of a mixed number can be, it Has to have a delimiter.
        int numberType = (Dice.rand(((digits <= MAXDIGITS) ? WHOLENUMBER : DECIMALNUMBER), FRACTIONNUMBER));
        // If the number of requested digits is more than the total maximum allowed, set it to the maximum instead.
        digits = (digits > MAXCOOKEDDIGITS) ? MAXCOOKEDDIGITS : digits;
        // determine the delimiter - whole numbers have none, decimals a '.' and fractions use '/'.
        String delimiter = (numberType == WHOLENUMBER) ? " " : (numberType == DECIMALNUMBER) ? "." : "/";
        // Initialize delimiterLoc for WholeNumber positioning.
        int delimiterLoc = 0;
        // If this isn't a whole number, determine the proper position (range) for the delimeter.
        if(numberType != WHOLENUMBER)
        {
            // the minimum value should be 1 for any numbers less than 33 otherwise, offset as needed
            int mindeloc = (digits - MAXDIGITS <= 0) ? 1 : (digits - MAXDIGITS);
            // the maximum value should be at least one sooner than the last digit, but adjust if there are more than 33 digits
            int maxdeloc = (digits - MAXDIGITS <= 0) ? digits - 1 : (digits -(digits - MAXDIGITS));
            // the actual delimiter loc should be between the two extremes.. unless they're exactly at the limit, 
            // then they should be one less than the minimum to avoid going out of range...
            delimiterLoc = (mindeloc < maxdeloc) ? Dice.rand(mindeloc, maxdeloc) : mindeloc - 1;
        }

        // Assemble the digits!
        for(int i = 0; i < digits; i++)
        {
            // the lazy way :D No really, no need to convert, just grab a representative from index 0 to 11 >:D!
            whole += (i < delimiterLoc) ? lazyDigit(Dice.rand(((i != 0 && i != (digits - 1)) ? 0 : 1), 11)) : "";
            spare += (i > delimiterLoc) ? lazyDigit(Dice.rand(((i != 0 && i != (digits - 1)) ? 0 : 1), 11)) : "";
        }
        return new String[] {whole, spare, delimiter};
    }

    /**
     * 
     * @return
     */
    public static String TypePrompt()
    {
       return word_type_prompt;
    }

    /**
     * 
     * @return
     */
    public static int[] TypeRange()
    {
        return word_type_range;
    }

    /**
     * 
     * @return
     */
    protected static boolean randomWord()
    {
        return SUI.ValidateAgreement(random_prompt);
    }

    /**
     * 
     * @param clusters
     * @return
     */
    protected static String randomCluster(String[] clusters)
    {
        return clusters[Dice.rand(0, clusters.length-1)];
    }

    /**
     * 
     * @return
     */
    protected static int[] selectComplexGenus()
    {
        int primary = selectGenus();
        return new int[] {primary, selectGenusMod(primary)};
    }

    /**
     * 
     * @param primary
     * @return
     */
    protected static int selectGenusMod(int primary)
    {
        int mod;
        if(primary == RANDOM)
        {
            mod = RANDOM;
        }
        else
        {
            mod = SUI.ValidateIndex(genus_mod_range, genus_mod_prompt[primary]);
        }
        return mod;
    }

    /**
     * 
     * @return
     */
    protected static int selectGenus()
    {
        return SUI.ValidateIndex(genus_primary_range, genus_primary_prompt);
    }

    /**
     * 
     * @return
     */
    protected static int selectRole()
    {
        return SUI.ValidateIndex(role_range, role_prompt);
    }

    /**
     * 
     * @return
     */
    protected static int selectTense()
    {
        return SUI.ValidateIndex(tense_range, tense_prompt);
    }

    /**
     * 
     * @return
     */
    protected static int selectMood()
    {
        return SUI.ValidateIndex(mood_range, mood_prompt);
    }

    /**
     * 
     * @return
     */
    protected static int selectClusterLength()
    {
        return SUI.ValidateIndex(cluster_length_range, cluster_length_prompt);
    }

    /**
     * 
     * @return
     */
    protected static int selectConsonantStyle()
    {
        return SUI.ValidateIndex(style_range, style_details);
    }

    /**
     * 
     * @return
     */
    protected static int selectPossessiveness()
    {
        return SUI.ValidateIndex(possessive_range, possessive_prompt);
    }

    /**
     * 
     * @return
     */
    protected static int selectNounCount()
    {
        return SUI.ValidateInt(noun_count_range, noun_count_prompt);
    }

    /**
     * 
     * @return
     */
    protected static int selectDigitCount()
    {
        return SUI.ValidateInt(digit_count_range, digit_count_prompt);
    }

    /**
     * 
     * @return
     */
    protected static String requestB12ToTranslate()
    {
        return SUI.ValidateB12(b12_prompt);
    }  

    /**
     * 
     * @return
     */
    protected static int singularWord()
    {
        return SUI.ValidateIndex(singular_range, singular_prompt);
    }

    /**
     * 
     * @return
     */
    protected static int clusterLength()
    {
        return SUI.ValidateIndex(cluster_length_range, cluster_length_prompt);
    }

    /**
     * 
     * @return
     */
    protected static int[] altPattern()
    {
        int index = SUI.ValidateIndex(adhesive_pattern_range_for_prompt, word_pattern_prompt + adhesive_details);
        return (index == RANDOM) ? RANDOMINTARRAY : adhesive_pattern[index];
    }

    /**
     * 
     * @return
     */
    protected static int[] nounPattern()
    {
        int index = SUI.ValidateIndex(standard_pattern_range_for_prompt, word_pattern_prompt + noun_pattern_details);
        return (index == RANDOM) ? RANDOMINTARRAY : noun_pattern[index];
    }

    /**
     * 
     * @return
     */
    protected static int[] adjectivePattern()
    {
        int index = SUI.ValidateIndex(standard_pattern_range_for_prompt, word_pattern_prompt + adjective_pattern_details);
        return (index == RANDOM) ? RANDOMINTARRAY : adjective_pattern[index];
    }

    /**
     * 
     * @return
     */
    protected static int[] verbPattern()
    {
        int index = SUI.ValidateIndex(standard_pattern_range_for_prompt, word_pattern_prompt + verb_pattern_details);
        return (index == RANDOM) ? RANDOMINTARRAY : verb_pattern[index];
    }

    /**
     * 
     * @return
     */
    protected static int[] adverbPattern()
    {
        int index = SUI.ValidateIndex(standard_pattern_range_for_prompt, word_pattern_prompt + adverb_pattern_details);
        return (index == RANDOM) ? RANDOMINTARRAY : adverb_pattern[index];
    }
}
