/**
 * Cluster.java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * An assortment of clusters and related accessors. 
 * ʥ
 */
package com.siathaelassistant;

public class Cluster extends SDef
{  
    // work in codespaces for the symbols I want
    private static final String THEA = "\u03B8";
    private static final String ZHEA = "\u0291";
    private static final String SHEA = "\u0255";
    private static final String NGEA = "\u014B";
    private static final String THAG = "\u00F0";
    private static final String ITHI = "\u026A";

    // onset voiceless short clusters
    private static final String[] ovl_s = {"k", "t", "p", "s", SHEA, "f", THEA}; 
    // onset voiceless mid-length clusters
    private static final String[] ovl_m = 
    {
        "ks", "k" + SHEA, "kf", "k" + THEA, "kh", "kl", "kr", "ts", "t" + SHEA, "tr", "pt", "ps", "p" + SHEA, "pf", "p" + THEA, "pl", 
        "pr", "sk", "st", "sp", "sf", "s" + THEA, "s" + NGEA, "sn", "sm", "sl", "sr", SHEA + "k", SHEA + "t", SHEA + "p", SHEA + "f", 
        SHEA + THEA, SHEA + NGEA, SHEA + "n", SHEA + "m", SHEA + "l", SHEA + "r", "fk", "ft", "fp", "fs", "f" + SHEA, "f" + 
        THEA, "f" + NGEA, "fn", "fm", "fl", "fr", THEA + "k", THEA + "t", THEA + "p", THEA + NGEA, THEA + "n", THEA + "m", THEA + "r"
    };
    // onset voiceless long clusters
    private static final String[] ovl_l = 
    {
        "skr", "str", "spr", "skl", "spl", SHEA + "kr", SHEA + "tr", SHEA + "pr", SHEA + "kl", SHEA + "pl"
    };
    // all onset voiceless clusters
    private static final String[][] onset_voiceless = {ovl_s, ovl_m, ovl_l};

    //onset neutral short clusters
    private static final String[] on_s = {NGEA, "n", "m", "h", "l", "r"}; 
    //onset neutral mid-length clusters
    private static final String[] on_m = {NGEA, NGEA + "r", NGEA + "l", "n", "m", "h", "l", "r"}; 
    //onset neutral long clusters
    private static final String[] on_l = {NGEA + "r", NGEA + "l"}; 

    // all onset neutral clusters
    private static final String[][] onset_neutral = {on_s, on_m, on_l};

    //onset voiced short clusters
    private static final String[] ov_s = {"g", "d", "b", "z", ZHEA, "v", THAG};
    //onset voiced mid-length clusters
    private static final String[] ov_m = 
    {
        "gz", "g" + ZHEA, "gv", "g" + THAG, "gh", "gl", "gr", "dz", "d" + ZHEA, "dr", "bd", "bz", "b" + ZHEA, "bv", "b" + THAG, 
        "bl", "br", "zg", "zd", "zb", "zv", "z" + THAG, "z" + NGEA, "zn", "zm", "zl", "zr", ZHEA + "g", ZHEA + "d", ZHEA + "b", 
        ZHEA + "v", ZHEA + THAG, ZHEA + NGEA, ZHEA + "n", ZHEA + "m", ZHEA + "l", ZHEA + "r", "vg", "vd", "vb", "vz", "v" + ZHEA, 
        "v" + THAG, "v" + NGEA, "vn", "vm", "vl", "vr", THAG + "g", THAG + "d", THAG + "b", THAG + NGEA, THAG + "n", THAG + "m", 
        THAG + "r" 
    }; 
    //onset voiced long clusters
    private static final String[]ov_l = 
    { 
        "zgr", "zdr", "zbr", "zgl", "zbl", ZHEA + "gr", ZHEA + "dr", ZHEA + "br", ZHEA + "gl", ZHEA + "bl"
    }; 
    // all onset voiced clusters
    private static final String[][] onset_voiced = {ov_s, ov_m, ov_l};

    // all onset clusters
    private static final String[][][] onset_clusters = {onset_voiceless, onset_neutral, onset_voiced};

    // midword consonant clusters
    // voiceless
    // short
    private static final String[] mvl_s = {"k", "t", "p", "s", SHEA, "f", THEA}; 
    // medium
    private static final String[] mvl_m = 
    { 
        "kt", "kp", "ks", "k" + SHEA, "kf", "k" + THEA, "k" + NGEA, "kn", "km", "kh", "kl", "kr", "tk", "tp", "ts", "t" + SHEA, "tf", 
        "t" + THEA, "t" + NGEA, "tn", "tm", "th", "tl", "tr", "pk", "pt", "ps", "p" + SHEA, "pf", "p" + THEA, "p" + NGEA, "pn", "pm", 
        "ph", "pl", "pr", "sk", "st", "sp", "sf", "s" + THEA, "s" + NGEA, "sn", "sm", "sh", "sl", "sr", SHEA + "k", SHEA + "t", 
        SHEA + "p", SHEA + "f", SHEA + THEA, SHEA + NGEA, SHEA + "n", SHEA + "m", SHEA + "h", SHEA + "l", SHEA + "r", "fk", 
        "ft", "fp", "fs", "f" + SHEA, "f" + THEA, "f" + NGEA, "fn", "fm", "fh", "fl", "fr", THEA + "k", THEA + "t", THEA + "p", 
        THEA + "s", THEA + SHEA, THEA + NGEA, THEA + "n", THEA + "m", THEA + "h", THEA + "l", THEA + "r", NGEA + "k", NGEA + "t", 
        NGEA + "p", NGEA + "s", NGEA + SHEA, NGEA + "f", NGEA + THEA, NGEA + "h", NGEA + "l", NGEA + "r", "nk", 
        "nt", "np", "ns", "n" + SHEA, "nf", "n" + THEA, "mk", "mt", "mp", "ms", "m" + SHEA, "mf", "m" + THEA, "lk", "lt", "lp", "ls", 
        "l" + SHEA, "lf", "l" + THEA, "rk", "rt", "rp", "rs", "r" + SHEA, "rf", "r" + THEA
    };
    // long
    private static final String[] mvl_l = 
    {
        "ktr", "kpr", "ksr", "kɕr", "kfr", "k" + THEA + "r", "tkr", "tpr", "tsr", "tɕr", "tfr", "t" + THEA + "r", "pkr", "ptr", "psr", 
        "pɕr", "pfr", "p" + THEA + "r", "skr", "str", "spr", "sfr", "s" + THEA + "r", SHEA + "kr", SHEA + "tr", SHEA + "pr", 
        SHEA + "fr", SHEA + THEA + "r", "fkr", "ftr", "fpr", "fsr", "fɕr", "f" + THEA + "r", THEA + "kr", THEA + "tr", THEA + "pr", 
        THEA + "sr", THEA + "ɕr", "kpl", "ksl", "kɕl", "kfl", "tsl", "tfl", "pkl", "psl", "pɕl", "pfl", "skl", "stl", "spl", "sfl", 
        SHEA + "kl", SHEA + "tl", SHEA + "fl", "fkl", "ftl", "fsl", "fɕl", THEA + "kl", THEA + "sl"
    };
    // all voiceless mid-word clusters
    private static final String[][] midword_voiceless = {mvl_s, mvl_m, mvl_l};

    // neutral
    // short
    private static final String[] mn_s = {NGEA, "n", "m", "h", "l", "r"};
    // medium
    private static final String[] mn_m = 
    {
        NGEA, "r" + NGEA, "rn", "rm", "rh", "rl", "l" + NGEA, "ln", "lm", "lh", "lr", "nm", "nh", "nl", "nr", "m", 
        "m" + NGEA, "mn", "mh", "ml", "mr", "h", "n", "r", "l"
    };
    // long
    private static final String[] mn_l = 
    {
        "r" + NGEA, "rn", "rm", "rh", "rl", "l" + NGEA, "ln", "lm", "lh", "lr", "nm", "nh", "nl", "nr", "m" + NGEA, "mn", 
        "mh", "ml", "mr"
    };
    // all midword neutral clusters
    private static final String[][] midword_neutral = {mn_s, mn_m, mn_l};

    // voiced
    // short
    private static final String[] mv_s = {"g", "d", "b", "z", ZHEA, "v", THAG};
    // medium
    private static final String[] mv_m = 
    {
        "gd", "gb", "gz", "g" + ZHEA, "gv", "g" + THAG, "g" + NGEA, "gn", "gm", "gh", "gl", "gr", "dg", "db", "dz", "d" + ZHEA, "dv", 
        "d" + THAG, "d" + NGEA, "dn", "dm", "dh", "dl", "dr", "bg", "bd", "bz", "b" + ZHEA, "bv", "b" + THAG, "b" + NGEA, "bn", "bm", 
        "bh", "bl", "br", "zg", "zd", "zb", "zv", "z" + THAG, "z" + NGEA, "zn", "zm", "zh", "zl", "zr", ZHEA + "g", ZHEA + "d", 
        ZHEA + "b", ZHEA + "v", ZHEA + THAG, ZHEA + NGEA, ZHEA + "n", ZHEA + "m", ZHEA + "h", ZHEA + "l", ZHEA + "r", "vg", "vd", 
        "vb", "vz", "v" + ZHEA, "v" + THAG, "v" + NGEA, "vn", "vm", "vh", "vl", "vr", THAG + "g", THAG + "d", THAG + "b", THAG + "z", 
        THAG + ZHEA, THAG + NGEA, THAG + "n", THAG + "m", THAG + "h", THAG + "l", THAG + "r", NGEA + "g", NGEA + "d", 
        NGEA + "b", NGEA + "z", NGEA + ZHEA, NGEA + "v", NGEA + THAG, "ng", "nd", "nb", "nz", "n" + ZHEA, "nv", "n" + THAG, "mg", 
        "md", "mb", "mz", "m" + ZHEA, "mv", "m" + THAG, "lg", "ld", "lb", "lz", "l" + ZHEA, "lv", "l" + THAG, "rg", "rd", "rb", "rz", 
        "r" + ZHEA, "rv", "r" + THAG
    };
    // long
    private static final String[] mv_l = 
    {
        "gdr", "gbr", "gzr", "g" + ZHEA + "r", "gvr", "g" + THAG + "r", "dgr", "dbr", "dzr", "d" + ZHEA + "r", "dvr", 
        "d" + THAG + "r", "bgr", "bdr", "bzr", "b" + ZHEA + "r", "bvr", "b" + THAG + "r", "zgr", "zdr", "zbr", "zvr", 
        "z" + THAG + "r", ZHEA + "gr", ZHEA + "dr", ZHEA + "br", ZHEA + "vr", ZHEA + THAG + "r", "vgr", "vdr", "vbr", 
        "vzr", "v" + ZHEA + "r", "v" + THAG + "r", THAG + "gr", THAG + "dr", THAG + "br", THAG + "zr", THAG + ZHEA + "r", 
        "gbl", "gzl", "g" + ZHEA + "l", "gvl", "dzl", "dvl", "bgl", "bzl", "b" + ZHEA + "l", "bvl", "zgl", "zdl", "zbl", 
        "zvl", ZHEA + "gl", ZHEA + "dl", ZHEA + "vl", "vgl", "vdl", "vzl", "v" + ZHEA + "l", THAG + "gl", THAG + "zl" 
    };
    // all voiced midword consonant clusters
    private static final String[][] midword_voiced = {mv_s, mv_m, mv_l};
    // all midword consonant clusters
    private static final String[][][] midword_clusters = {midword_voiceless, midword_neutral, midword_voiced};

    // Coda Consonant Clusters
    // Voiceless
    // short
    private static final String[] cvl_s = {"k", "t", "p", "s", SHEA, "f", THEA};
    // medium
    private static final String[] cvl_m = 
    {
        "k", "kt", "ks", "k" + SHEA, "kf", "k" + THEA, "t", "ts", "t" + SHEA, "tf", "p", "pt", "ps", "p" + SHEA, "pf", "p" + THEA, 
        "s", "sk", "st", "sp", "sf", "s" + THEA, SHEA, SHEA + "k", SHEA + "t", SHEA + "p", "f", "fk", "ft", "fp", "fs", "f" + SHEA, 
        "f" + THEA, THEA, THEA + "k", THEA + "t", THEA + "p", THEA + "s", THEA + "f", NGEA + "k", NGEA + "t", NGEA + "p", NGEA + "s", 
        NGEA + SHEA, NGEA + "f", NGEA + THEA, "nk", "nt", "np", "ns", "n" + SHEA, "nf", "n" + THEA, "mk", "mt", "mp", "ms", "m" + SHEA, 
        "mf", "m" + THEA, "lk", "lt", "lp", "ls", "l" + SHEA, "lf", "l" + THEA, "rk", "rt", "rp", "rs", "r" + SHEA, "rf", "r" + THEA 
    };
    // long
    private static final String[] cvl_l = 
    {
        "kt", "ks", "k" + SHEA, "kf", "k" + THEA, "ts", "t" + SHEA, "tf", "pt", "ps", "p" + SHEA, "pf", "p" + THEA, "sk", 
        "st", "sp", "sf", "s" + THEA, SHEA + "k", SHEA + "t", SHEA + "p", "fk", "ft", "fp", "fs", "f" + SHEA, "f" + THEA, 
        THEA + "k", THEA + "t", THEA + "p", THEA + "s", THEA + "f", NGEA + "k", NGEA + "t", NGEA + "p", NGEA + "s", NGEA + SHEA, 
        NGEA + "f", NGEA + THEA, "nk", "nt", "np", "ns", "n" + SHEA, "nf", "n" + THEA, "mk", "mt", "mp", "ms", "m" + SHEA, "mf", 
        "m" + THEA, "lk", "lt", "lp", "ls", "l" + SHEA, "lf", "l" + THEA, "rk", "rt", "rp", "rs", "r" + SHEA, "rf", "r" + THEA 
    };
    // all voiceless coda clusters
    private static final String[][] coda_voiceless = {cvl_s, cvl_m, cvl_l};


    // Neutral
    // short
    private static final String[] cn_s = {NGEA, "n", "m", "l", "r"};
    // medium
    private static final String[] cn_m = {NGEA, "n", "m", "l", "ln", "lm", "r", "rn", "rm", "rl"};
    // long
    private static final String[] cn_l = {"ln", "lm", "rn", "rm", "rl"};
    // all neutral consonant coda clusters
    private static final String[][] coda_neutral = {cn_s, cn_m, cn_l};

    // Voiced
    // short
    private static final String[] cv_s = {"g", "d", "b", "z", ZHEA, "v", THAG};
    // medium
    private static final String[] cv_m = 
    {
        "g", "gd", "gz", "g" + ZHEA, "gv", "g" + THAG, "d", "dz", "d" + ZHEA, "dv", "b", "bd", "bz", "b" + ZHEA, "bv", 
        "b" + THAG, "z", "zg", "zd", "zb", "zv", "z" + THAG, ZHEA, ZHEA + "g", ZHEA + "d", ZHEA + "b", "v", "vg", "vd", 
        "vb", "vz", "v" + ZHEA, "v" + THAG, THAG, THAG + "g", THAG + "d", THAG + "b", THAG + "z", THAG + "v", NGEA + "g", 
        NGEA + "d", NGEA + "b", NGEA + "z", NGEA + ZHEA, NGEA + "v", NGEA + THAG, "ng", "nd", "nb", "nz", "n" + ZHEA, "nv", 
        "n" + THAG, "mg", "md", "mb", "mz", "m" + ZHEA, "mv", "m" + THAG, "lg", "ld", "lb", "lz", "l" + ZHEA, "lv", "l" + THAG, 
        "rg", "rd", "rb", "rz", "r" + ZHEA, "rv", "r" + THAG
    };
    // long
    private static final String[] cv_l = 
    {
        "gd", "gz", "g" + ZHEA, "gv", "g" + THAG, "dz", "d" + ZHEA, "dv", "bd", "bz", "b" + ZHEA, "bv", "b" + THAG, "zg", "zd", 
        "zb", "zv", "z" + THAG, ZHEA + "g", ZHEA + "d", ZHEA + "b", "vg", "vd", "vb", "vz", "v" + ZHEA, "v" + THAG, THAG + "g", 
        THAG + "d", THAG + "b", THAG + "z", THAG + "v", NGEA + "g", NGEA + "d", NGEA + "b", NGEA + "z", NGEA + ZHEA, NGEA + "v", 
        NGEA + THAG, "ng", "nd", "nb", "nz", "n" + ZHEA, "nv", "n" + THAG, "mg", "md", "mb", "mz", "m" + ZHEA, "mv", "m" + THAG, 
        "lg", "ld", "lb", "lz", "l" + ZHEA, "lv", "l" + THAG, "rg", "rd", "rb", "rz", "r" + ZHEA, "rv", "r" + THAG
    };
    // all voiced consonant coda clusters
    private static final String[][] coda_voiced = {cv_s, cv_m, cv_l};

    // all coda clusters
    private static final String[][][] coda_clusters = {coda_voiceless, coda_neutral, coda_voiced};
     
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
    private static final String[] pronoun_role = {"s'", "n'", "f'", "ʑ'"};
    
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
    private static final String[] spare_key = {"i" + ITHI, "e" + ITHI, "a" + ITHI, "u" + ITHI, "o" + ITHI, ITHI};
    // key vowels for all other types of words
    private static final String[]  ad_key = {"io", "eo", "ao", "uo", "o", ITHI + "o"};
    // the vowel key indicating if a digit is in the whole portion of a number, a denominator, 
    // or a decimal (or whatever a value between 0 and 1 is called in a base 12 system....
    private static final String[] digit_class = {ITHI, "ia", "o"};
    // marks the "tens" or "hundreds" place (as well as the 10 thousands, 100 thousands and so on.
    private static final String[][] digit_magnitude = {tally_consonants, {"s"}, {"ʑ"}};
    // delimiters to place between 144s, 12s and 1s, and between 1s and 144s, as it were....
    private static final String[] digit_delimiter = {"'", "-", ""};
    
    // is this actually necessary?
    public Cluster()
    {
        
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
     * 
     * @param mine
     * @return
     */
    protected static String possessivePrefix(int mine)
    {
        return posession_vowels[mine];
    }

    /**
     * 
     * @param who
     * @return
     */
    protected static String pronounRole(int who)
    {
        return pronoun_role[who];
    }

    /**
     * 
     * @return
     */
    protected static String pluralSuffix()
    {
        return plural_suffix;
    }

    /**
     * 
     * @return
     */
    protected static String adVowel()
    {
        return ad_key[Dice.rand(0, ad_key.length -1)];
    }
    
    /**
     * 
     * @return
     */
    protected static String spareVowel()
    {
        return spare_key[Dice.rand(0, spare_key.length -1)];
    }
    
    /**
     * 
     * @param length
     * @param style
     * @return
     */
    protected static String OnsetCluster(int length, int style)
    {
      return onset_clusters[style][length][Dice.rand(0, onset_clusters[style][length].length-1)];
    }
    /**
     * 
     * @param length
     * @param style
     * @return
     */
    protected static String MidWordCluster(int length, int style)
    {
      return midword_clusters[style][length][Dice.rand(0, midword_clusters[style][length].length-1)];
    }    
    /**
     * 
     * @param length
     * @param style
     * @return
     */
    protected static String CodaCluster(int length, int style)
    {
      return coda_clusters[style][length][Dice.rand(0, coda_clusters[style][length].length-1)];
    }
}
