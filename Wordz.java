public class Wordz extends Words 
{
    
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

    private static Word whatWord(int type, boolean random, int length, String b12Value, int[] pattern, int possessive, int role, int count, boolean singular, int[] genus, int mood, int tense)
    {
        Word aWord;
        switch (type) 
        {
            case NOUN:
                aWord = new Word(type, random, length, pattern, singular, genus[0], genus[1]);
                break;
            case PRONOUN:
                aWord = new Word(type, random, singular, possessive, genus[0], genus[1], count, role);
                break;
            case ADJECTIVE:
                aWord = new Word(type, random, length, pattern);
                break;
            case VERB:
                aWord = new Word(type, random, length, pattern, mood, tense);
                break;
            case ADVERB:
                aWord = new Word(type, random, length, pattern);
                break;
            case NUMBER:
                aWord = new Word(type, random, b12Value);
                break;        
            default:
                aWord = new Word(type, random, length, pattern);
                break;
        }
        return aWord;
    }

    private static int[] getPattern(int type, boolean random)
    {
        int[] pattern;
        switch (type) {
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
        int length = w.clusterLength();
        switch (cluster) 
        {
            case ONSET:
                c = onsetCluster(length);
                break;
            case MIDCONST:
                c = midConstCluster(length);
                break;
            case CODA:
                c = codaCluster(length);
                break;
            case VOWEL:
                c = vowelCluster(length);
                break;
            case KEYMID:
                c = disambiguateKeyMid(w);
                break;
            case ENDKEY:
                c = disambiguatdEndKey(w);
            default:
                break;
        }
        return c;
    }

    private static String disambiguatdEndKey(Word w)
    {
        String c;
        switch (w.Type()) {
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
                c = vowelCluster(w.clusterLength());
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
                c = vowelCluster(w.clusterLength());
                break;
        }
        return c;
    }


    public static String buildPronoun(Word aWord)
    {        
        return possessivePrefix(aWord.Possessiveness()) + pronounRole(aWord.ConvoRole()) + genusCluster(aWord) 
                + digitValue(aWord.mentionCount()) + ((aWord.isSingular()) ? "" : pluralSuffix());
    }

/**
 * Number Stuff
 */

    public static String buildNumber(Word aWord)
    {
        String nNumber = "";
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
}
