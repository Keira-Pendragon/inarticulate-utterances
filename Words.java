/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

public class Words extends Cluster
{
    protected static final int[] a0_pattern = {ENDKEY};
    protected static final int[] a1_pattern = {ONSET, ENDKEY};
    protected static final int[] a2_pattern = {VOWEL, MIDCONST, ENDKEY};
    protected static final int[] a3_pattern = {KEYMID, MIDCONST, VOWEL};
    protected static final int[] a4_pattern = {ONSET, VOWEL, MIDCONST, ENDKEY};
    protected static final int[] a5_pattern = {ONSET, KEYMID, MIDCONST, VOWEL};
    protected static final int[] a6_pattern = {VOWEL, MIDCONST, VOWEL, MIDCONST, ENDKEY};
    protected static final int[] a7_pattern = {VOWEL, MIDCONST, KEYMID, MIDCONST, VOWEL};
    protected static final int[] a8_pattern = {ONSET, VOWEL, MIDCONST, VOWEL, MIDCONST, ENDKEY};
    protected static final int[] a9_pattern = {ONSET, VOWEL, MIDCONST, KEYMID, MIDCONST, VOWEL};
    protected static final int[] v0_pattern = {KEYMID, MIDCONST, ENDKEY};
    protected static final int[] v1_pattern = {ONSET, KEYMID, MIDCONST, ENDKEY};
    protected static final int[] v2_pattern = {VOWEL, MIDCONST, KEYMID, MIDCONST, ENDKEY};
    protected static final int[] v3_pattern = {ONSET, VOWEL, MIDCONST, KEYMID, MIDCONST, ENDKEY};
    protected static final int[] n0_pattern = {KEYMID, CODA};
    protected static final int[] n1_pattern = {ONSET, KEYMID, CODA};
    protected static final int[] n2_pattern = {VOWEL, MIDCONST, KEYMID, CODA};
    protected static final int[] n3_pattern = {ONSET, VOWEL, MIDCONST, KEYMID, CODA};

    protected static final String a0_name = "EndKey\n";
    protected static final String a1_name = "Onset + EndKey\n";
    protected static final String a2_name = "Vowel + MidConst + EndKey\n";
    protected static final String a3_name = "KeyMid + MidConst + Vowel\n";
    protected static final String a4_name = "Onset + Vowel + MidConst + EndKey\n";
    protected static final String a5_name = "Onset + KeyMid + MidConst + Vowel\n";
    protected static final String a6_name = "Vowel + MidConst + Vowel + MidConst + EndKey\n";
    protected static final String a7_name = "Vowel + MidConst + KeyMid + MidConst + Vowel\n";
    protected static final String a8_name = "Onset + Vowel + MidConst + Vowel + MidConst + EndKey\n";
    protected static final String a9_name = "Onset + VOWEL + MidConst + KeyMid + MidConst + Vowel\n";
    protected static final String v0_name = "KeyMid + MidConst + EndKey\n";
    protected static final String v1_name = "Onset + KeyMid + MidConst + EndKey\n";
    protected static final String v2_name = "Vowel + MidConst + KeyMid + MidConst + EndKey\n";
    protected static final String v3_name = "Onset + Vowel + MidConst + KeyMid + MidConst + EndKey";
    protected static final String n0_name = "KeyMid + Coda\n";
    protected static final String n1_name = "Onset + KeyMid + Coda\n";
    protected static final String n2_name = "Vowel + MidConst + KeyMid + Coda\n";
    protected static final String n3_name = "Onset + Vowel + MidConst + KeyMid + Coda";


    protected static final int[][] Verb_Pattern = {v0_pattern, v1_pattern, v2_pattern, v3_pattern};
    protected static final int[][] Noun_Pattern = {n0_pattern, n1_pattern, n2_pattern, n3_pattern};
    protected static final int[][] Alt_Pattern = {a0_pattern, a1_pattern, a2_pattern, a3_pattern, a4_pattern, 
                        a5_pattern, a6_pattern, a7_pattern, a8_pattern, a9_pattern, 
                        v0_pattern, v1_pattern, v2_pattern, v3_pattern, 
                        n0_pattern, n1_pattern, n2_pattern, n3_pattern};
                        
    protected static final int[] alt_pattern_range = {0, 17};
    protected static final int[] noun_pattern_range = {0, 3};
    protected static final int[] verb_pattern_range = {0, 3};    
    protected static final int[] genus_primary_range = {0, 3};
    protected static final int[] genus_mod_range = {0, 4};
    protected static final int[] role_range = {0, 3};
    protected static final int[] possessive_range = {0, 4};
    protected static final int[] noun_count_range = {1, 11};
    protected static final int[] mood_range = {0, 5};
    protected static final int[] tense_range = {0, 3};
    protected static final int[] cluster_length_range = {0, 2};
    protected static final int[] digit_count_range = {0, 66};
    protected static final int[] word_type_range = {0, 6};

    // \n1) Concepts\n2) Objects\n3) Entities\n4) Places\n5) Traits or Qualities\n6) Actions
    protected static final String g0_prompt = "Should this concept relate to\n1) Standard Concept\n2) Objects\n3) Entities\n4) Places\n5) Traits or Qualities\n6) Actions";
    protected static final String g1_prompt = "Should this Object relate to\n1) Concepts\n2) Standard Object\n3) Entities\n4) Places\n5) Traits or Qualities\n6) Actions";
    protected static final String g2_prompt = "Should this entity be denoted by \n1) Concepts\n2) Objects\n3) Standard Entity\n4) Places\n5) Traits or Qualities\n6) Actions";
    protected static final String g3_prompt = "Should this place be associated with\n1) Concepts\n2) Objects\n3) Entities\n4) Standard Place\n5) Traits or Qualities\n6) Actions";

    protected static final String random_prompt = "Would you like the word to be random?\n1) yes\n2) no";
    protected static final String singular_prompt = "Is the word Singular?\n1) yes\n2) no";
    protected static final String genus_primary_prompt = "What is the primary genus of the noun?\n1) Concept\n2) Thing\n3) Entity\n4) Place";
    protected static final String [] genus_mod_prompt = {g0_prompt, g1_prompt, g2_prompt, g3_prompt};
    protected static final String tense_prompt = "How does this action relate to time?\n1) Timeless\n2) Past\n3) Present\n4) Future";
    protected static final String mood_prompt = "Is this action a\n1) Request or Wish\n2) Directive\n3) Voluntary\n4) Passive\n5) Unwilling";
    protected static final String role_prompt = "Is this pronoun\n1) The speaker\n2) The Lisener\n3) Both\n4) Neither";
    protected static final String possessive_prompt = "Is this noun posessive?\n1) no\n2) part of\n3) dear to\n4) owned by\n5) diminuiative to\n6) loosely associated";
    protected static final String noun_count_prompt = "Is there more than one of this specific pronoun in the context?\n1) no\n#) Yes, this is the nth of the same (n: 2 to 11)";
    protected static final String digit_count_prompt = "How many digits should the random number have?\n(Limit 33 for whole, 66 for mixed, 0 for random)";
    protected static final String b12_prompt = "Enter the base 12 number to translate\n(Valid Values include 0-9, 'A', 'a', 'B', 'b', ',', '.', '/')\n(Max digits 66 if '.' or '/' divide them to a max of 33 on either side)";
    protected static final String cluster_length_prompt = "How long should the clusters be?\n1) Short\n2) Average\n3) Long";
    protected static final String word_type_prompt = "What type of word should be generated?\n1) Number\n2) Pronoun\n3) Noun\n4) Adjective\n5) Verb\n6) Adverb\n7) Adhesive";
    protected static final String alt_pattern_prompt = "Which pattern should the word follow?\n1) " + a0_name + "2) " + a1_name + "3) " + a2_name + "4) " + a3_name + "5) " + a4_name + "6) " 
                                                                            + a5_name + "7) " + a6_name + "8) " + a7_name + "9) " + a8_name + "10) " + a9_name + "11) " 
                                                                            + v0_name + "12) " + v1_name + "13) " + v2_name + "14) " + v3_name + "\n15) " 
                                                                            + n0_name + "16) " + n1_name + "17) " + n2_name + "18) " + n3_name;
                                                                        
    protected static final String noun_pattern_prompt = "Which pattern should the word follow?\n1) " + n0_name + "2) " + n1_name + "3) " + n2_name + "4) " + n3_name;
    protected static final String verb_pattern_prompt = "Which pattern should the word follow?\n1) " + v0_name + "2) " + v1_name + "3) " + v2_name + "4) " + v3_name;



    private static int MAXDIGITS = 36;
    /**
    * Max number of digits a mixed number can contain.
    */
    private static final int MAXCOOKEDDIGITS = (MAXDIGITS * 2);
    private static final int WHOLENUMBER = 0;
    private static final int DECIMALNUMBER = 1;
    private static final int FRACTIONNUMBER = 2;
    private static final int[] NONPATTERN = {0, 0};


    public static Word requestWord(int type)
    {
        boolean random = randomWord();
        int length = (type == NUMBER || type == PRONOUN)? 0 : clusterLength(random);
        String b12Value = (type == NUMBER) ? (random) ? cookedB12(selectDigitCount()) : requestB12ToTranslate() : "";
        int[] pattern = getPattern(type, random);
        int possessive = (type == NOUN || type == PRONOUN) ? selectPossessiveness(random) : 0;
        int role = (type == PRONOUN)? selectRole(random) : 0;
        int count = (type == PRONOUN)? selectNounCount(random) : 0; 
        boolean singular = (type == NOUN || type == PRONOUN) ? singularWord(random) : true;
        int[] genus = (type == NOUN || type == PRONOUN) ? selectComplexGenus(random) : NONPATTERN;
        int mood = (type == VERB) ? selectMood(random) : 0;
        int tense = (type == VERB) ? selectTense(random) : 0;
        return whatWord(type, random, length, b12Value, pattern, possessive, role, count, singular, genus, mood, tense);
    }

    /**
    * TODO: Fix this better.
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
    * @return
    */
    private static Word whatWord(int type, boolean random, int length, String b12Value, int[] pattern, int possessive, int role, int count, boolean singular, int[] genus, int mood, int tense)
    {
        Word aWord;
        switch (type) 
        {
            case NOUN:
                aWord = new Word(type, pattern, -1, length, genus, new boolean[] {false, singular}, possessive);
                break;
            case PRONOUN:
                aWord = new Word(type, role, possessive, count, new boolean[] {false, singular}, genus);
                break;
            case VERB:
                aWord = new Word(type, mood, tense, pattern, length, -1);
                break;
            case NUMBER:
                aWord = new Word(type, b12Value);
                break;        
            default:
                aWord = new Word(type, pattern, -1, length);
                break;
        }
        return aWord;
    }

    private static int[] getPattern(int type, boolean random)
    {
        int[] pattern;
        switch (type) 
        {
            case NOUN:
            case ADJECTIVE:
                pattern = nounPattern(random);
                break;
            case VERB:
            case ADVERB:
                pattern = verbPattern(random);
                break;
            case ADHESIVE:
                pattern = altPattern(random);
                break;        
            default:
                pattern = NONPATTERN;
                break;
        }
        return pattern;
    }

    public static String buildAWord(Word w)
    {
        return (w.Type() == NUMBER) ? buildNumber(w) : (w.Type() == PRONOUN) ? buildPronoun(w) : buildWord(w);
    }

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
                c = disambiguateKeyMid(w);
                break;
            case ENDKEY:
                c = disambiguatdEndKey(w);
                break;
            default:
                break;
        }
        return c;
    }

    private static String disambiguatdEndKey(Word w)
    {
        String c;
        switch (w.Type()) 
        {
            case VERB:
                c = tenseVowel(w.Tense());
                break;
            case ADVERB:
                c = adVowel();
                break;
            case ADHESIVE:
                c = spareVowel();
                break;        
            default:
                c = vowelCluster(w.ClusterLength());
                break;
        }
        return c;
    }

    private static String disambiguateKeyMid(Word w)
    {
        String c;
        switch (w.Type()) 
        {
            case NOUN:
            case PRONOUN:
                c = genusCluster(w);
                break;
            case VERB:
                c = moodVowel(w.Mood());
                break;
            case ADJECTIVE:
                c = adVowel();
                break;
            case ADHESIVE:
                c = spareVowel();
                break;
            default:
                c = vowelCluster(w.ClusterLength());
                break;
        }
        return c;
    }


    public static String buildPronoun(Word aWord)
    {        
        return possessivePrefix(aWord.PossessionStyle()) + pronounRole(aWord.Role()) + genusCluster(aWord) 
        + digitValue(aWord.MentionCount()) + ((aWord.isSingular()) ? "" : pluralSuffix());
    }

    /**
    * Number Stuff
    */

    public static String buildNumber(Word aWord)
    {
        String nNumber = "";
        if(aWord.ValueIsRandom())
        {
            // Make up a number!
        }
        // Get any whole number value  translated
        nNumber = (aWord.DelimiterLoc() < 37) ? standardMethod(aWord, true) : "" ;
        // Get any denominator or decimal value (decimals are handled differently...)
        nNumber += (aWord.SpareValue().length() > 0)? (aWord.Delimiter() == '/') ? standardMethod(aWord, false) : decimalMethod(aWord) : "";       
        return nNumber;
    }

    private static int intifyB12Digit(char d)
    {
    return (d == 'A') ? 10 : (d == 'B') ? 11 : (d - '0');
    }

    private static String standardMethod(Word aWord, boolean whole )
    {
        String translate = (whole)? aWord.WholeValue() : aWord.SpareValue();
        String translation = "";
        int spare = translate.length() % 3;
        int trio = translate.length() / 3 - 1;
        int cDigit = 0;
        char delim = (whole) ? ' ' : aWord.Delimiter();
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
            translation += ((d__Zval + d_Y_val + dX__val) != 0) ? nextDigit(d__Zval, 0, trio, delim) + "-" : "";
            trio--;
        }
        return translation;
    }

    private static String decimalMethod(Word aWord)
    {
        String translate = aWord.SpareValue();
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
            translation += ((d__Zval + d_Y_val + dX__val) != 0) ? nextDigit(d__Zval, 0, i, delim) + "-" : "";
        }
        int lastIndex = translate.length() -1;
        if(cDigit < lastIndex)
        {
            translation+= nextDigit(intifyB12Digit(translate.charAt(cDigit)), 2, (trio + 1), delim) + "'";
            cDigit++;
        }
        if(cDigit == lastIndex)
        {
            translation+= nextDigit(intifyB12Digit(translate.charAt(cDigit)), 1, (trio + 1), delim);
        }        
        return translation;
    }

    private static String nextDigit(int value, int place, int power, char delim)
    {
        SUI.displayTextLn("Value is: " + value);
        int mag = (place == 0) ? power : 0;
        int style = (delim == ' ') ? 0 : (delim == '/')? 1 : 2;
        return digitValue(value) + digitKey(style) + digitCoda(place, mag);
    }


    /**
    * 
    * @param digits
    * @return
    */
    private static String cookedB12(int digits)
    {
        if(digits == 0)
        {
            digits = Dice.rand(1, 66);
        }
        String baked = "";
        // If the number is bigger than the maximum any one part of a mixed number can be, it Has to have a delimiter.
        int numberType = (Dice.rand(((digits <= MAXDIGITS) ? WHOLENUMBER : DECIMALNUMBER), FRACTIONNUMBER));
        // If the number of requested digits is more than the total maximum allowed, set it to the maximum instead.
        digits = (digits > MAXCOOKEDDIGITS) ? MAXCOOKEDDIGITS : digits;
        // determine the delimiter - whole numbers have none, decimals a '.' and fractions use '/'.
        String delimiter = (numberType == WHOLENUMBER) ? "" : (numberType == DECIMALNUMBER) ? "." : "/";
        // Initialize delimiterLoc for WholeNumber positioning.
        int delimiterLoc = 0;
        // If this isn't a whole number, determine the proper position (range) for the delimeter.
        if(numberType != 0)
        {
            // the minimum value should be 1 for any numbers less than 33 otherwise, offset as needed
            int mindeloc = (digits - MAXDIGITS <= 0) ? 1 : (digits - MAXDIGITS);
            // the maximum value should be at least one sooner than the last digit, but adjust if there are more than 33 digits
            int maxdeloc = (digits - MAXDIGITS <= 0) ? digits - 1 : (digits -(digits - MAXDIGITS));
            // the actual delimiter loc should be between the two extremes.. unless they're exactly at the limit, 
            // then they should be one less than the minimum to avoid going out of range...
            // Technically decimal digits could be two digits longer, but I'm not messing with it because #lazy
            delimiterLoc = (mindeloc < maxdeloc) ? Dice.rand(mindeloc, maxdeloc) : mindeloc - 1;
        }

        // Assemble the digits!
        for(int i = 0; i < digits; i++)
        {
            // the lazy way :D No really, no need to convert, just grab a representative from index 0 to 11 >:D!
            baked += lazyDigit(Dice.rand(((i != 0 && i != (digits - 1)) ? 0 : 1), 11));
            // If this is where the delimiter should go, drop it after.
            baked += (i == delimiterLoc)? delimiter : "";
        }
        return baked;
    }

    public Words()
    {

    }

    public static String TypePrompt()
    {
       return word_type_prompt;
    }

    public static int[] TypeRange()
    {
        return word_type_range;
    }

    protected static boolean randomWord()
    {
        return SUI.ValidateAgreement(random_prompt);
    }


    protected static String randomCluster(String[] clusters)
    {
        return clusters[Dice.rand(0, clusters.length-1)];
    }

    protected static int[] selectComplexGenus(boolean random)
    {
        int primary = selectGenus(random);
        return new int[] {primary, selectGenusMod(primary, random)};
    }

    protected static int selectGenusMod(int primary, boolean random)
    {
        return (random)? Dice.rRand(genus_mod_range) : SUI.ValidateIndex(genus_mod_range, genus_mod_prompt[primary]);
    }


    protected static int selectGenus(boolean random)
    {
        return (random) ? Dice.rRand(genus_primary_range) : SUI.ValidateIndex(genus_primary_range, genus_primary_prompt);
    }

    protected static int selectRole(boolean random)
    {
        return (random) ? Dice.rRand(role_range) : SUI.ValidateIndex(role_range, role_prompt);
    }


    protected static int selectTense(boolean random)
    {
        return (random) ? Dice.rRand(tense_range) : SUI.ValidateIndex(tense_range, tense_prompt);
    }


    protected static int selectMood(boolean random)
    {
        return (random) ? Dice.rRand(mood_range) : SUI.ValidateIndex(mood_range, mood_prompt);
    }


    protected static int selectClusterLength(boolean random)
    {
        return (random) ? Dice.rRand(cluster_length_range) : SUI.ValidateIndex(cluster_length_range, cluster_length_prompt);
    }


    protected static int selectPossessiveness(boolean random)
    {
        return (random) ? Dice.rRand(possessive_range) : SUI.ValidateIndex(possessive_range, possessive_prompt);
    }


    protected static int selectNounCount(boolean random)
    {
        return (random) ? Dice.rRand(noun_count_range) : SUI.ValidateInt(noun_count_range, noun_count_prompt);
    }

    protected static int selectDigitCount()
    {
        return SUI.ValidateInt(digit_count_range, digit_count_prompt);
    }

    protected static String requestB12ToTranslate()
    {
        return SUI.ValidateB12(b12_prompt);
    }  

    protected static boolean singularWord(boolean random)
    {
        return (random) ? Dice.coinToss() : SUI.ValidateAgreement(singular_prompt);
    }

    protected static int clusterLength(boolean random)
    {
        return (random) ? Dice.rRand(cluster_length_range) : SUI.ValidateIndex(cluster_length_range, cluster_length_prompt);
    }

    protected static int[] altPattern(boolean random)
    {
        return Alt_Pattern[(random) ? Dice.rRand(alt_pattern_range) : SUI.ValidateIndex(alt_pattern_range, alt_pattern_prompt)];
    }

    protected static int[] nounPattern(boolean random)
    {
        return Noun_Pattern[(random) ? Dice.rRand(noun_pattern_range) : SUI.ValidateIndex(noun_pattern_range, noun_pattern_prompt)];
    }

    protected static int[] verbPattern(boolean random)
    {
        return Verb_Pattern[(random) ? Dice.rRand(verb_pattern_range) : SUI.ValidateIndex(verb_pattern_range, verb_pattern_prompt)];
    }

}
