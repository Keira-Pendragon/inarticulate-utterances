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
        String newWord = "";

        return newWord;
    }

    private static String nextCluster()
    {
        String aCluster = "";


        return aCluster;
    }


    private static String cookedB12(int digits)
    {
        return "";
    }

}
