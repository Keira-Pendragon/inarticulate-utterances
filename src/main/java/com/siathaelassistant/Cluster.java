/**
 * Cluster.java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * An assortment of clusters and related accessors. 
 * ʥ
 */
package com.siathaelassistant;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.yaml.snakeyaml.constructor.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cluster extends SDef
{  
    // the codes work in codespaces for the symbols I want
    private static final String ZHEA = "\u0291";
    private static final String ITHI = "\u026A";

    // short vowel clusters
    private static final String[] vs_cluster = {"i", "e", "a", "u", "o", ITHI};
    // mixed length vowel clusters
    private static final String[] vm_cluster = {"i", "ei", "ai", "ui", "oi", ITHI + "i",
                                                "i", "e", "a", "u", "o", ITHI,
                                                "ie", "e", "ae", "ue", "oe", ITHI + "e",
                                                "ia", "ea", "a", "ua", "oa", ITHI + "a",
                                                "i", "e", "a", "u", "o", ITHI,
                                                "iu", "eu", "au", "u", "ou", ITHI + "u",
                                                "io", "eo", "ao", "uo", "o", ITHI + "o",
                                                "i", "e", "a", "u", "o", ITHI,
                                                "i" + ITHI, "e" + ITHI, "a" + ITHI, "u" + ITHI, "o" + ITHI, ITHI};
    // "long" vowel clusters
    private static final String[] vl_cluster = {"ei", "ai", "ui", "oi", ITHI + "i", 
                                                "ie", "ae", "ue", "oe", ITHI + "e",
                                                "ia", "ea", "ua", "oa", ITHI + "a",
                                                "iu", "eu", "au", "ou", ITHI + "u",
                                                "io", "eo", "ao", "uo", ITHI + "o",
                                                "i" + ITHI, "e" + ITHI, "a" + ITHI, "u" + ITHI, "o" + ITHI};
    // all misc use vowel clusters
    private static final String[][] Vowel_Cluster = {vs_cluster, vm_cluster, vl_cluster};
    
    // primary meaning indicators for the genus key of nouns.
    // i: ideas, e: objects, a: entities, u: places
    private static final String[] genus_primary_vowels = {"i", "e", "a", "u"};
    // modifier for the genus key of nouns.
    // o and y indicate traits or other less specific modifiers. i, e, a, and u indicate the noun is also somewhat related to an idea, thing, entity or place.
    private static final String[] genus_mod_vowels = {"i", "e", "a", "u", "o", ITHI};
    
    // indicates possession "" = not possessive; i' = part of the noun, "my eye!"; e' = something dear to, "my best friend"; 
    // a' = possession of, "my hat"; u' inverse of a', "my boss", "the dog's person" etc; o' = distant or unwanted association, "my estranged sibling", etc.
    private static final String[] posession_vowels = {"", "i'", "e'", "a'", "u'", "o'"};
    
    // Possibly need to review and update these.... Represent numeric value, as described by their counterparts in lazy digits...
    private static final String[] tally_consonants = {"p", "n", "f", "t", "d", "l", "r", "ɕ", "d" + ZHEA, "k", "m", "b"};
    private static final String[] lazy_digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B"};
    
    // Indicates the role of a pronoun, s' = speaker (I) or 'this', n' = listener (You), f' = both speaker and listener ie, "you and I."; 
    // ʑ' = neither speaker or listener (she, he, they), or 'that'.
    // Note, the 'gender' system in siathael indicates what kind of Noun a pronoun indicates, not their role in reproduction.... 
    // ie: n'an = You - a person. s'en - this - an object. ʑ'un - that - a place.
    private static final String[] pronoun_role = {"s'", "n'", "f'", ZHEA + "'"};
    
    // indicates plurality - in a pronoun ʑ'anei means they as in more than one other person. where ʑ'an is just one person.
    // s'anei would be "we" as in "I and my other friends were wondering if you'd like to join us."
    // n'anei would be "y'all" as in "Could I join ya'll?"
    // f'anei would be we, plural, as in "you and I and our assembled friends should go now, if we want to get good seats."
    private static final String plural_suffix = "ei";
    
    // Verb "mood". y = "I wish I could go", "I'd like to go" or "would you like to go?"
    // i = "Go get that.", "Could you get that for me?"
    // a indicates intentional action - "I knocked on the door to get your attention."
    // e indicates passive actions - "my heart is still beating..."
    // u indicated involuntary actions - "I tripped over my cat. I swear they're an assassin!"
    private static final String[] verb_mood = {ITHI, "i", "a", "e", "u"};
    // the time tense of the verb, timeless, past, present and future
    private static final String[] verb_tense = {"e", "i", "a", "u"};

    // key vowels for adjectives and adverbs.
    private static final String[] ad_key = {"i" + ITHI, "e" + ITHI, "a" + ITHI, "u" + ITHI, "o" + ITHI, ITHI};
    // key vowels for all other types of words
    private static final String[] spare_key = {"io", "eo", "ao", "uo", "o", ITHI + "o"};
    // the vowel key indicating if a digit is in the whole portion of a number, a denominator, 
    // or a decimal (or whatever a value between 0 and 1 is called in a base 12 system....
    private static final String[] digit_class = {ITHI, "ia", "o"};
    // marks the "tens" or "hundreds" place (as well as the 10 thousands, 100 thousands and so on.
    private static final String[][] digit_magnitude = {tally_consonants, {"s"}, {ZHEA}};
    // delimiters to place between 144s, 12s and 1s, and between 1s and 144s, as it were....
    private static final String[] digit_delimiter = {"'", "-", ""};
    
    // A list array of consnant objects
    private static List<Consonant> consonants;
    boolean signalReady;

    public Cluster()
    {
        
    }

    public Cluster(String yamlFilePath) 
    {
        consonants = new ArrayList<>();
        signalReady= false;
        Yaml yaml = new Yaml();
        try {
            File file = new File(yamlFilePath);
            InputStream inputStream = new FileInputStream(file);
            Map<String, List<Map<String, Object>>> yamlMap = (Map<String, List<Map<String, Object>>>) yaml.load(inputStream);

            for (Map<String, Object> letterMap : yamlMap.get("letters")) 
            {
                String letter = (String) letterMap.get("letter");
                int flavor = (Integer) letterMap.get("flavor");
                boolean[] allowedClusters = new boolean[]
                {
                    (Boolean) letterMap.get("canAppearInOnset"),
                    (Boolean) letterMap.get("canAppearInMidWord"),
                    (Boolean) letterMap.get("canAppearInCoda")
                };
                String[] onset = ((List<String>) letterMap.get("allowedBeforeInOnset")).toArray(new String[0]);
                String[] midWord = ((List<String>) letterMap.get("allowedBeforeInMidWord")).toArray(new String[0]);
                String[] coda = ((List<String>) letterMap.get("allowedBeforeInCoda")).toArray(new String[0]);

                Consonant consonant = new Consonant(letter, flavor, allowedClusters, onset, midWord, coda);
                consonants.add(consonant);
            }
            signalReady = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    String isReady()
    {
        return (signalReady)? "Clusters Initialized" : "Clusters initialization aborted.";
    }

    /**
     * returns the appropriate digit indicator. 
     * @param ofThree which of three digits in a trio  ie 2A4 2 is the 3rd of three, A is the second, and 4 is the first, all indexed for 0 of course.
     * @param magnitude for 2 and A in our example the magnitude would be 0. As it would be for 4 in this case, but if the number were 2A4000, the magnitude 
     *        would increase by one, accordingly to how many trios beyond the first the active trio was.
     * @return
     */
    protected static String digitCoda(int ofThree, int magnitude)
    {
        return digit_magnitude[ofThree][magnitude];
    }
    
    /**
     * returns the vowel cluster for the indicated style of number (whole/numerator, decimal, or denominator)
     * @param type 0 for whole, 1 for denominator, 2 for decimal
     * @return the correct vowel key.
     */
    protected static String digitKey(int type)
    {
        return digit_class[type];
    }

    /**
     * Retrieve the actual value representation for the digit, 0 through 11 (aka B)
     * @param value what is the value of the digit?
     * @return the consonant (or consonant cluster) representing that amount.
     */
    protected static String digitValue(int value)
    {
        return tally_consonants[value];
    }
    /**
     * Very lazy way to get the base 12 representation of 0 to 11.
     * @param index the base 10 value of the base 12 digit.
     * @return the digit 0 to B
     */
    protected static String lazyDigit(int index)
    {
        return lazy_digits[index];
    }

    /**
     * Grab the correct delimiter for the digit
     * Do I even actually use this?
     * @param loc which delim
     * @return the delim
     */
    protected static String digitDelimiter(int loc)
    {
        return digit_delimiter[loc];
    }
    
    /**
     * retrieve the value at an index for a given array
     * @param cluster the cluster array to grab from
     * @param index the index for grabbing
     * @return the cluster grabbed
     */
    protected static String retrieveCluster(String[] cluster, int index)
    {
        return cluster[index];
    }


    /**
     * Select a random vowel cluster of an appropriate length.
     * @param length 1, 1 to 2, or 2 letter vowel clusters?
     * @return the selected cluster.
     */
    protected static String vowelCluster(int length)
    {
        return retrieveCluster(Vowel_Cluster[length], Dice.rand(0, Vowel_Cluster[length].length -1));
    }

    /**
     * Grab a random or specified genus cluster for a noun or pronoun based on the information in a given Word object
     * @param aWord The word to get the details of.
     * @return the genus key vowel cluster
     */
    protected static String genusCluster(Word aWord)
    {
        int mod = (aWord.RandomGenus()) ? Dice.rand(0, genus_mod_vowels.length -1) : aWord.GenusModifier();
        String cluster = genus_mod_vowels[mod];
        
        cluster += genus_primary_vowels[aWord.PrimaryGenus()];
        if(cluster.length() == 2 && (cluster.charAt(0) == cluster.charAt(1)))
        {
            cluster = cluster.charAt(0) + "";
        }
        return cluster;
    }

    /**
     * Grab the vowel representing the tense case of a verb
     * @param tense which tense
     * @return the correct vowel
     */
    protected static String tenseVowel(int tense)
    {
        return verb_tense[tense];
    }

    /**
     * Grab the vowel for the mood of a verb
     * @param mood which mood
     * @return the correct vowel
     */
    protected static String moodVowel(int mood)
    {
        return verb_mood[mood];
    }

    /**
     * This function takes the numeric representation of the kind of possessiveness of a noun/pronoun
     * and selects the appropriate coding vowel for said possessiveness to return.
     * @param mine - type of possession for noun/pronoun
     * @return appropriate representative symbol
     */
    protected static String possessivePrefix(int mine)
    {
        return posession_vowels[mine];
    }

    /**
     * returns a consonant indicating the 'role' of the pronoun, indicating, for example "I", "You", "We", or "They"
     * @param who
     * @return
     */
    protected static String pronounRole(int who)
    {
        return pronoun_role[who];
    }

    /**
     * Simply returns the cluster that indicates a noun or pronoun is plural
     * @return
     */
    protected static String pluralSuffix()
    {
        return plural_suffix;
    }

    /**
     * Selects a vowel cluster appropriate for an adverb or adjective.
     * @return
     */
    protected static String adVowel()
    {
        return ad_key[Dice.rand(0, ad_key.length -1)];
    }
    
    /**
     * Selects a vowel cluster appropriate for words that are not nouns, verbs, adjectives, numbers, pronouns or adverbs.
     * @return
     */
    protected static String spareVowel()
    {
        return spare_key[Dice.rand(0, spare_key.length -1)];
    }
    
    /**
     * Returns a randomly selected onset consonant cluster of a given length (1, 2, or 3 characters long) 
     * and given 'style' (voiced/voiceless or neutral)
     * @param length
     * @param style
     * @return
     */
    protected static String OnsetCluster(int length, int style)
    {
        String onset = "";
        Consonant first = consonants.get(Dice.rand(0, consonants.size() - 1));
        if(!first.isAllowedOnset())
        {
            while(!first.isAllowedOnset())
            {
                first = consonants.get(Dice.rand(0, consonants.size() - 1));
            }
        }
        onset += first.Phenome();
        if(length >= 1)
        {
            String letter = first.randomOnsetFollower();
            onset += (letter.equals(" "))? "" : letter;
            if(length > 1)
            {
                Consonant second = new Consonant(" ", 0, null, null, null , null);
                for(Consonant consonant: consonants)
                {
                    if (consonant.Phenome().equals(letter)) 
                    {
                        second = consonant;
                        break;
                    }
                }
                letter = second.randomOnsetFollower();
                onset  += (letter.equals(" "))? "" : letter;
            }
        }
        return onset;
    }


    /**
     * Returns a randomly selected mid-word consonant cluster of a given length (1, 2, or 3 characters long) 
     * and given 'style' (voiced/voiceless or neutral)
     * @param length
     * @param style
     * @return
     */
    protected static String MidWordCluster(int length, int style)
    {
        String midWord = "";
        Consonant first = consonants.get(Dice.rand(0, consonants.size() - 1));
        if(!first.isAllowedMid() || first.Flavor()!= style)
        {
            while(!first.isAllowedMid() || first.Flavor()!= style)
            {
                first = consonants.get(Dice.rand(0, consonants.size() - 1));
            }
        }
        midWord += first.Phenome();
        if(length >= 1)
        {
            String letter = first.randomMidFollower();
            midWord += (letter.equals(" "))? "" : letter;
            if(length > 1)
            {
                Consonant second = new Consonant(" ", 0, null, null, null , null);
                for(Consonant consonant: consonants)
                {
                    if (consonant.Phenome().equals(letter)) 
                    {
                        second = consonant;
                        break;
                    }
                }
                letter = second.randomMidFollower();
                midWord += (letter.equals(" "))? "" : letter;
            }
        }
        return midWord;    
    } 

    /**
     * Returns a randomly selected coda consonant cluster of a given length (1, 2, or 3 characters long) 
     * and given 'style' (voiced/voiceless or neutral)
     * @param length
     * @param style
     * @return
     */
    protected static String CodaCluster(int length, int style)
    {
        String coda = "";
        Consonant first = consonants.get(Dice.rand(0, consonants.size() - 1));
        if(!first.isAllowedCoda() || first.Flavor()!= style)
        {
            while(!first.isAllowedCoda() || first.Flavor()!= style)
            {
                first = consonants.get(Dice.rand(0, consonants.size() - 1));
            }
        }
        coda += first.Phenome();
        if(length >= 1)
        {
            String letter = first.randomCodaFollower();
            coda += (letter.equals(" "))? "" : letter;
            if(length > 1)
            {
                Consonant second = new Consonant(" ", 0, null, null, null , null);
                for(Consonant consonant: consonants)
                {
                    if (consonant.Phenome().equals(letter)) 
                    {
                        second = consonant;
                        break;
                    }
                }
                letter = second.randomCodaFollower();
                coda += (letter.equals(" "))? "" : letter;
            }
        }
        return coda;  
    }
}
