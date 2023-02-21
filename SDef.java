/**
 * All the definitions for all the important shit for like, everything everywhere 
 * so I don't have to worry about ending up with conflicting definitions if I make 
 * a clerical error while maintaining the dang thing.
 */

public class SDef 
{
    /**
     * I'd prefer C++ enums, but this will work as a bandage for now...
     */
    // Types of words
    protected static final int NUMBER = 0;
    protected static final int PRONOUN = 1;
    protected static final int NOUN = 2;
    protected static final int ADJECTIVE = 3;
    protected static final int VERB = 4;
    protected static final int ADVERB = 5;
    protected static final int ADHESIVE = 6;
    protected static final int QUERY = 7;
    protected static final int NEGATION = 8;

    
    // cluster length options
    protected static final int SHORT = 0;
    protected static final int MEDIUM = 1;
    protected static final int LONG = 2;
    
    // Cluster types
    protected static final int ONSET = 0;
    protected static final int MIDCONST = 1;
    protected static final int CODA = 2;
    protected static final int VOWEL = 3;
    protected static final int KEYMID = 4;
    protected static final int ENDKEY = 5;
    protected static final int SPAREKEY = 6;
    protected static final int ADKEY = 7;

    // reduce magic numbers, where is the min and max index stored in a range array~
    protected static final int MINDEX = 0;
    protected static final int MAXDEX = 1;


    // i
    protected static final int IDEA = 0;
    // e
    protected static final int THING = 1;
    // a
    protected static final int ENTITY = 2;
    // u
    protected static final int PLACE = 3;
    // o
    protected static final int FILLER = 4;
    // ITHI
    protected static final int TRAIT = 5;
  
    // 
    protected static final int NONPOSSESSIVE = 0;
    // i'
    protected static final int PARTOF = 1;
    // e'
    protected static final int CLOSETO = 2;
    // a'
    protected static final int OWNS = 3;
    // u'
    protected static final int DIMINUATIVETO = 4;
    // o'
    protected static final int TENUOUSLYLINKED = 5;
  
    // s'
    protected static final int ITHIS = 0;
    // n'
    protected static final int YOU = 1;
    // f'
    protected static final int WEBOTH = 2;
    // ZHEA'
    protected static final int THEYTHAT = 3;
  
    // ITHI
    protected static final int WISH = 0;
    // i
    protected static final int DIRECTIVE = 1;
    // a
    protected static final int DELIBERATELY = 2;
    // e
    protected static final int PASSIVELY = 3;
    // u
    protected static final int INVOLUNTARILY = 4;
  
    // e
    protected static final int TIMELESS = 0;
    // i
    protected static final int PAST = 1;
    // a
    protected static final int PRESENT = 2;
    // u
    protected static final int FUTURE = 3;
  
    // 
    protected static final int SINGULAR = 0;
    // ei
    protected static final int PLURAL = 1;  


    protected static final int MAXDIGITS = 36;
    /**
    * Max number of digits a mixed number can contain.
    */
    protected static final int MAXCOOKEDDIGITS = (MAXDIGITS * 2);
    protected static final int WHOLENUMBER = 0;
    protected static final int DECIMALNUMBER = 1;
    protected static final int FRACTIONNUMBER = 2;
    protected static final int[] RANDOMINTARRAY  = {-1, -1};

    protected static final int RANDOM = -1;

}
