    /**
     * .java
     * Author: Keira Pendragon
     * Author Date: 1/22/2023
     * 
     * 
     */
    public class Number extends Words
    {

    private static final int DIGITVALUE = 0;
    private static final int DIGITCLASS = 1;
    private static final int DIGITMAGNITUDE = 3;
    private static final int DIGITDELIMITER = 4;
    
    private static int MAXDIGITS = 36;
    /**
     * Max number of digits a mixed number can contain.
     */
    private static int MAXCOOKEDDIGITS = (MAXDIGITS * 2);
    private static int WHOLENUMBER = 0;
    private static int DECIMALNUMBER = 1;
    private static int FRACTIONNUMBER = 2;

    private static final int[] digit_pattern = {DIGITVALUE, DIGITCLASS, DIGITMAGNITUDE, DIGITDELIMITER};


    public Number()
    {

    }

    public static Word detailWord(int type)
    {
    boolean random = randomWord();
    int digits = selectDigitCount(random);
    String b12 = (random) ? cookedB12(digits) : requestB12ToTranslate(random);
    Word aWord = new Word(type, random, digits, b12);
    return aWord;
    }
    /**
    DIGITVALUE = 0; // # of 12^# being represented
    DIGITCLASS = 1; // whole, fraction or decimal
    DIGITMAGNITUDE = 3; // biggest of three?, middle of three? smallest of three and which!? o.o
    */

    public static String buildWord(Word aWord)
    {
        String nNumber = "";
        // Get any whole number value  translated
        nNumber = (aWord.DelimiterLoc() > 0) ? standardMethod(aWord, true) : "" ;
        // Get any denominator or decimal value (decimals are handled differently...)
        nNumber += (aWord.Delimiter == '/') ? standardMethod(aWord, false) : decimalMethod(aWord);       
        return nNumber;
    }
    
    private static String standardMethod(Word aWord, boolean whole )
    {
        String translate = (whole)? aWord.WholeValue() : aWord.SpareValue();
        String translation = "";
        int spare = translate.length() % 3;
        int trio = translate.length() / 3;
        int digitLimit = translate.length -1;
        int cDigit = 0;
        char delim = (whole) ? '' : aWord.Delimiter();
        
        if(spare == 2)
        {
            translation += nextDigit(intify(translate.charAt(cDigit)), 1, trio + 1, delim);
            cDigit++;
            spare--;
        }
        if(spare == 1)
        {        
            translation += nextDigit(intify(translate.charAt(cDigit)), 0, trio + 1, delim);
            cDigit++;
        }            
        int dX__val;
        int d_Y_val;
        int d__Zval;
        for(trio; trio >= 0; trio--)
        {
            dX__val = intify(translate.charAt(cDigit));
            cDigit++;
            d_Y_val = intify(translate.charAt(cDigit));
            cDigit++;
            d__Zval = intify(translate.charAt(cDigit));
            cDigit++;
            translation += (dX__val!= 0) ? nextDigit(dX__val, 2, trio, delim) + "'" : "";
            translation += (d_Y_val!= 0) ? nextDigit(d_Y_val, 1, trio, delim) + "'"  : "";
            translation += ((d__Zval + d_Y_val + dX__val) != 0) ? nextDigit(d__Zval, 0, trio, delim) + "-" : "";
        }
        if(translation.charAt(translation.length-1) == '-')
        {
            translation = SUI.trimString(translation, 0, translation.length-2);
        }
        return "";
    }
    
    private static String decimalMethod(Word aWord)
    {
        String translate = aWord.SpareValue();
        String translation = "";
        int trio = translate.length / 3;
        int cDigit = 0;
        for(int i = 0; i <= trio; i++)
        {
            dX__val = intify(translate.charAt(cDigit));
            cDigit++;
            d_Y_val = intify(translate.charAt(cDigit));
            cDigit++;
            d__Zval = intify(translate.charAt(cDigit));
            cDigit++;
            translation += (dX__val!= 0) ? nextDigit(dX__val, 2, i, delim) + "'" : "";
            translation += (d_Y_val!= 0) ? nextDigit(d_Y_val, 1, i, delim) + "'"  : "";
            translation += ((d__Zval + d_Y_val + dX__val) != 0) ? nextDigit(d__Zval, 0, i, delim) + "-" : "";
        }
        cDigit -= translate.length();
        if(cDigit == 2)
        {
            translation+= nextDigit(intify(translate.charAt(translate.length() - cDigit)), 2, (trio + 1), delim) + "'";
            cDigit--;
        }
        if(cDigit == 1)
        {
            translation+= nextDigit(intify(translate.charAt(translate.length() - cDigit)), 1, (trio + 1), delim);
        }
        if(translation.charAt(translation.length-1) == '-')
        {
            translation = SUI.trimString(translation, 0, translation.length-2);
        }
            
        return translation;
    }

    private static String nextDigit(int value, int place, int power, char delim)
    {
        int mag = (place == 0) ? power : 0;
        int style = (delim == '') ? 0 : (delim == '/')? 1 : 2;
        return tally_value[value] + digit_class[style] + digit_magnitude[place][mag];
    }


    private static String cookedB12(int digits)
    {
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
            baked += lazy_digits[Dice.rand(((i != 0 && i != (digits - 1)) ? 0 : 1), 11)];
            // If this is where the delimiter should go, drop it after.
            baked += (i == delimiterLoc)? delimiter : "";
        }
        return baked;
    }

}
