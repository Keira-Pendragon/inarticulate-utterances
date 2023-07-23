/**
 * All the definitions for all the important shit for like, everything everywhere 
 * so I don't have to worry about ending up with conflicting definitions if I make 
 * a clerical error while maintaining the dang thing.
 */
package com.siathaelassistant;
public class SDef 
{
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
    // 1 symbol
    protected static final int SHORT = 0;
    // 1 -2 or 2 symbols
    protected static final int MEDIUM = 1;
    // 2 or 3 symbols
    protected static final int LONG = 2;
    
    // Cluster types
    // opening consonant cluster
    protected static final int ONSET = 0;
    // middle consonant cluster
    protected static final int MIDCONST = 1;
    // closing consonant cluster
    protected static final int CODA = 2;
    // non-coding vowel
    protected static final int VOWEL = 3;
    // mid coding vowel
    protected static final int KEYMID = 4;
    // end coding vowel
    protected static final int ENDKEY = 5;
    // specialized coding vowel
    protected static final int SPAREKEY = 6;
    // ad(verb/jective) coding vowel
    protected static final int ADKEY = 7;

    // reduce magic numbers, where is the min and max index stored in a range array~
    protected static final int MINDEX = 0;
    protected static final int MAXDEX = 1;


    // i - indicates a noun is an idea in the final position in a midkey vowel cluster
    protected static final int IDEA = 0;
    // e - indicates a noun is an object in the final position in a midkey vowel cluster
    protected static final int THING = 1;
    // a - indicates a noun is an entity (like a person) in the final position in a midkey vowel cluster
    protected static final int ENTITY = 2;
    // u - indicates a noun is a place in the final position in a midkey vowel cluster
    protected static final int PLACE = 3;
    // o - indicates a noun-form word is neither an adjective nor a noun in the final position in a midkey vowel cluster
    protected static final int FILLER = 4;
    // ITHI - indicates a noun-form word is actually an adjective in the final position in a midkey vowel cluster
    protected static final int TRAIT = 5;
  
    //  - whitespace before a pronoun or noun indicates that it is not possessive.
    protected static final int NONPOSSESSIVE = 0;
    // i' - indicates the thing possessed is part of the associated (pro)noun. Literally or metaphorically.
    // ie: my eyes, my lover
    protected static final int PARTOF = 1;
    // e' - indicates that the thing possessed is close to or important to the (pro)noun. Like a friend.
    protected static final int CLOSETO = 2;
    // a' - indicates the posssessed thing is 'Owned' by the (pro)noun. My hat, my car.
    // doesn't have to be strictly literal - ie - my employee, my child, my apprentice.
    // indicates a dominant relationship to the other thing.
    protected static final int OWNS = 3;
    // u' - indicates a submissive relationship - my boss, the car's owner.
    protected static final int DIMINUATIVETO = 4;
    // o' - indicates a threadbare link between the things - my former classmate, my estranged cousin, my homework
    protected static final int TENUOUSLYLINKED = 5;
  
    // Pronoun coding consonants
    // s' - indicates the pronoun that would take the place of "I" or "this"
    protected static final int ITHIS = 0;
    // n' - indicates the pronoun that would take the place of "you"
    protected static final int YOU = 1;
    // f' - indicates the pronoun that would take the place of "you and I"
    protected static final int WEBOTH = 2;
    // ZHEA' - indicates the pronoun that would take the place of "they" or "that"
    protected static final int THEYTHAT = 3;
  
    // mid key coding verb vowels
    // ITHI - indicates that a verb is unrealized, or desired "I'd like to go to the beach" for example
    protected static final int WISH = 0;
    // i - indicates that a verb is a directive or command "go feed the cat"
    protected static final int DIRECTIVE = 1;
    // a - indicates that a verb is intentional "I jumped over the log"
    protected static final int DELIBERATELY = 2;
    // e - indicates that a verb just Was - "I stared distractedly into space"
    protected static final int PASSIVELY = 3;
    // u - indicates a verb that was decidedly unintentional "I tripped over their shoe"
    protected static final int INVOLUNTARILY = 4;
  
    // an end key coding verb vowel
    // e - indicating that there is not a time associated with the verb
    protected static final int TIMELESS = 0;
    // i - indicating that the verb already happened
    protected static final int PAST = 1;
    // a - indicating that the verb is actively happening
    protected static final int PRESENT = 2;
    // u - indicating the verb has yet to happen
    protected static final int FUTURE = 3;
  
    // - nouns ending in a consonant are singular
    protected static final int SINGULAR = 0;
    // ei - nouns ending in ei are plural (usually, with a few noteable exceptions)
    protected static final int PLURAL = 1;  


    // The Voiced-ness of consonants
    // for consonants that are explicitly voiced (for example: k, t, p, s, f)
    protected static final int VOICELESS = 0;
    // for consonants that do not have counterparts that are differently voiced (for example: r, h, l)
    // also for the nasalized versions of voiced/voiceless consonants (for example, n, m and NG)
    protected static final int NEUTRAL = 1;
    // for consonants that are explicitly voiceless (for example g, d, b, z, v)
    protected static final int VOICED = 2;


    // The max number of digits I've explicitly worked out a functional number system for.
    protected static final int MAXDIGITS = 36;
    //Max number of digits a mixed number can contain.
    protected static final int MAXCOOKEDDIGITS = (MAXDIGITS * 2);
    // indicates a number is a whole number
    protected static final int WHOLENUMBER = 0;
    // indicates that a number is a decimal number
    protected static final int DECIMALNUMBER = 1;
    // indicates a number is a fraction
    protected static final int FRACTIONNUMBER = 2;

    // indicates an array who's values need to be determined randomly at certain times
    protected static final int[] RANDOMINTARRAY  = {-1, -1};
    // indicates a value that needs to be determined randomly at certain times.
    protected static final int RANDOM = -1;

}
