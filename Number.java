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

    public static String buildWord(Word aWord)
    {
        String nNumber = "";
        
        return nNumber;
    }

    private static String nextDigit()
    {
        String aDigit = "";


        return aDigit;
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
