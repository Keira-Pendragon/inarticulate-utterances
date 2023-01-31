/**
 * Cluster.java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * ʥ
 */


public class Cluster
{  
    protected static final int NUMBER = 0;
    protected static final int PRONOUN = 1;
    protected static final int NOUN = 2;
    protected static final int ADJECTIVE = 3;
    protected static final int VERB = 4;
    protected static final int ADVERB = 5;
    protected static final int ADHESIVE = 6;


    protected static final int VOICED = 0;
    protected static final int NEUTRAL = 1;
    protected static final int VOICELESS = 2;
    
    
    protected static final int SHORT = 0;
    protected static final int MEDIUM = 1;
    protected static final int LONG = 2;
    
    
    protected static final int ONSET = 0;
    protected static final int MIDCONST = 1;
    protected static final int CODA = 2;
    protected static final int VOWEL = 3;
    protected static final int KEYMID = 4;
    protected static final int ENDKEY = 5;
    protected static final int SPAREKEY = 6;
    protected static final int ADKEY = 7;

    
    protected static final int MINDEX = 0;
    protected static final int MAXDEX = 1;

    private static final String THEA = "\u03B8";
    private static final String ZHEA = "\u02E2";
    private static final String SHEA = "\u02E9";
    private static final String NGEA = "\u014B";
    private static final String THAG = "\u00F0";

    private static final String[] ovl_s = {"k", "t", "p", "s", SHEA, "f", THEA}; 
    private static final String[] ovl_m = 
    {
        "ks", "k" + SHEA, "kf", "k" + THEA, "kh", "kl", "kr", "ts", "t" + SHEA, "tr", "pt", "ps", "p" + SHEA, "pf", "p" + THEA, "pl", 
        "pr", "sk", "st", "sp", "sf", "s" + THEA, "s" + NGEA, "sn", "sm", "sl", "sr", SHEA + "k", SHEA + "t", SHEA + "p", SHEA + "f", 
        SHEA + THEA + "", SHEA + NGEA + "", SHEA + "n", SHEA + "m", SHEA + "l", SHEA + "r", "fk", "ft", "fp", "fs", "f" + SHEA, "f" + 
        THEA, "f" + NGEA, "fn", "fm", "fl", "fr", THEA + "k", THEA + "t", THEA + "p", THEA + NGEA + "", THEA + "n", THEA + "m", THEA + "r"
    };
    private static final String[] ovl_l = 
    {
        "skr", "str", "spr", "skl", "spl", SHEA + "kr", SHEA + "tr", SHEA + "pr", SHEA + "kl", SHEA + "pl"
    };
    private static final String[][] onset_voiceless = {ovl_s, ovl_m, ovl_l};

    private static final String[] on_s = {NGEA, "n", "m", "h", "l", "r"}; 
    private static final String[] on_m = {NGEA, NGEA + "r", NGEA + "l", "n", "m", "h", "l", "r"}; 
    private static final String[] on_l = {NGEA + "r", NGEA + "l"}; 

    private static final String[][] onset_neutral = {on_s, on_m, on_l};

    private static final String[] ov_s = {"g", "d", "b", "z", ZHEA, "v", THAG};
    private static final String[] ov_m = 
    {
        "gz", "g" + ZHEA, "gv", "g" + THAG, "gh", "gl", "gr", "dz", "d" + ZHEA, "dr", "bd", "bz", "b" + ZHEA, "bv", "b" + THAG, 
        "bl", "br", "zg", "zd", "zb", "zv", "z" + THAG, "z" + NGEA, "zn", "zm", "zl", "zr", ZHEA + "g", ZHEA + "d", ZHEA + "b", 
        ZHEA + "v", ZHEA + THAG, ZHEA + NGEA + "", ZHEA + "n", ZHEA + "m", ZHEA + "l", ZHEA + "r", "vg", "vd", "vb", "vz", "v" + ZHEA, 
        "v" + THAG, "v" + NGEA, "vn", "vm", "vl", "vr", THAG + "g", THAG + "d", THAG + "b", THAG + NGEA + "", THAG + "n", THAG + "m", 
        THAG + "r" }; 
    private static final String[]ov_l = 
    { 
        "zgr", "zdr", "zbr", "zgl", "zbl", ZHEA + "gr", ZHEA + "dr", ZHEA + "br", ZHEA + "gl", ZHEA + "bl"
    }; 
    private static final String[][] onset_voiced = {ov_s, ov_m, ov_l};

    private static final String[][][] onset_clusters = {onset_voiceless, onset_neutral, onset_voiced};

    private static final String[] mvl_s = {"k", "t", "p", "s", SHEA, "f", THEA}; 
    private static final String[] mvl_m = 
    { 
        "kt", "kp", "ks", "k" + SHEA, "kf", "k" + THEA, "k" + NGEA, "kn", "km", "kh", "kl", "kr", "tk", "tp", "ts", "t" + SHEA, "tf", 
        "t" + THEA, "t" + NGEA, "tn", "tm", "th", "tl", "tr", "pk", "pt", "ps", "p" + SHEA, "pf", "p" + THEA, "p" + NGEA, "pn", "pm", 
        "ph", "pl", "pr", "sk", "st", "sp", "sf", "s" + THEA, "s" + NGEA, "sn", "sm", "sh", "sl", "sr", SHEA + "k", SHEA + "t", 
        SHEA + "p", SHEA + "f", SHEA + THEA + "", SHEA + NGEA + "", SHEA + "n", SHEA + "m", SHEA + "h", SHEA + "l", SHEA + "r", "fk", 
        "ft", "fp", "fs", "f" + SHEA, "f" + THEA, "f" + NGEA, "fn", "fm", "fh", "fl", "fr", THEA + "k", THEA + "t", THEA + "p", 
        THEA + "s", THEA + SHEA, THEA + NGEA + "", THEA + "n", THEA + "m", THEA + "h", THEA + "l", THEA + "r", NGEA + "k", NGEA + "t", 
        NGEA + "p", NGEA + "s", NGEA + SHEA, NGEA + "f", NGEA + THEA, NGEA + "n", NGEA + "m", NGEA + "h", NGEA + "l", NGEA + "r", "nk", 
        "nt", "np", "ns", "n" + SHEA, "nf", "n" + THEA, "mk", "mt", "mp", "ms", "m" + SHEA, "mf", "m" + THEA, "lk", "lt", "lp", "ls", 
        "l" + SHEA, "lf", "l" + THEA, "rk", "rt", "rp", "rs", "r" + SHEA, "rf", "r" + THEA
    };
    private static final String[] mvl_l = 
    {
        "ktr", "kpr", "ksr", "kɕr", "kfr", "k " + THEA + "r", "tkr", "tpr", "tsr", "tɕr", "tfr", "t " + THEA + "r", "pkr", "ptr", "psr", 
        "pɕr", "pfr", "p " + THEA + "r", "skr", "str", "spr", "sfr", "s " + THEA + "r", SHEA + "kr", SHEA + "tr", SHEA + "pr", 
        SHEA + "fr", SHEA + THEA + "r", "fkr", "ftr", "fpr", "fsr", "fɕr", "f " + THEA + "r", THEA + "kr", THEA + "tr", THEA + "pr", 
        THEA + "sr", THEA + "ɕr", "kpl", "ksl", "kɕl", "kfl", "tsl", "tfl", "pkl", "psl", "pɕl", "pfl", "skl", "stl", "spl", "sfl", 
        SHEA + "kl", SHEA + "tl", SHEA + "fl", "fkl", "ftl", "fsl", "fɕl", THEA + "kl", THEA + "sl"
    };
    private static final String[][] midword_voiceless = {mvl_s, mvl_m, mvl_l};

    private static final String[] mn_s = {NGEA, "n", "m", "h", "l", "r"};
    private static final String[] mn_m = 
    {
        NGEA, "r" + NGEA, "rn", "rm", "rh", "rl", "l" + NGEA, "ln", "lm", "lh", "lr", "n" + NGEA, "nm", "nh", "nl", "nr", "m", 
        "m" + NGEA, "mn", "mh", "ml", "mr", "h", "n", "r", "l"
    };
    private static final String[] mn_l = 
    {
        "r" + NGEA, "rn", "rm", "rh", "rl", "l" + NGEA, "ln", "lm", "lh", "lr", "n" + NGEA, "nm", "nh", "nl", "nr", "m" + NGEA, "mn", 
        "mh", "ml", "mr"
    };
    private static final String[][] midword_neutral = {mn_s, mn_m, mn_l};

    private static final String[] mv_s = {"g", "d", "b", "z", ZHEA, "v", THAG};
    private static final String[] mv_m = 
    {
        "gd", "gb", "gz", "g" + ZHEA, "gv", "g" + THAG, "g" + NGEA, "gn", "gm", "gh", "gl", "gr", "dg", "db", "dz", "d" + ZHEA, "dv", 
        "d" + THAG, "d" + NGEA, "dn", "dm", "dh", "dl", "dr", "bg", "bd", "bz", "b" + ZHEA, "bv", "b" + THAG, "b" + NGEA, "bn", "bm", 
        "bh", "bl", "br", "zg", "zd", "zb", "zv", "z" + THAG, "z" + NGEA, "zn", "zm", "zh", "zl", "zr", ZHEA + "g", ZHEA + "d", 
        ZHEA + "b", ZHEA + "v", ZHEA + THAG, ZHEA + NGEA + "", ZHEA + "n", ZHEA + "m", ZHEA + "h", ZHEA + "l", ZHEA + "r", "vg", "vd", 
        "vb", "vz", "v" + ZHEA, "v" + THAG, "v" + NGEA, "vn", "vm", "vh", "vl", "vr", THAG + "g", THAG + "d", THAG + "b", THAG + "z", 
        THAG + ZHEA + "", THAG + NGEA + "", THAG + "n", THAG + "m", THAG + "h", THAG + "l", THAG + "r", NGEA + "g", NGEA + "d", 
        NGEA + "b", NGEA + "z", NGEA + ZHEA, NGEA + "v", NGEA + THAG, "ng", "nd", "nb", "nz", "n" + ZHEA, "nv", "n" + THAG, "mg", 
        "md", "mb", "mz", "m" + ZHEA, "mv", "m" + THAG, "lg", "ld", "lb", "lz", "l" + ZHEA, "lv", "l" + THAG, "rg", "rd", "rb", "rz", 
        "r" + ZHEA, "rv", "r" + THAG,
    };
    private static final String[] mv_l = 
    {
        "gdr", "gbr", "gzr", "g " + ZHEA + "r", "gvr", "g " + THAG + "r", "dgr", "dbr", "dzr", "d " + ZHEA + "r", "dvr", 
        "d " + THAG + "r", "bgr", "bdr", "bzr", "b " + ZHEA + "r", "bvr", "b " + THAG + "r", "zgr", "zdr", "zbr", "zvr", 
        "z " + THAG + "r", ZHEA + "gr", ZHEA + "dr", ZHEA + "br", ZHEA + "vr", ZHEA + " " + THAG + "r", "vgr", "vdr", "vbr", 
        "vzr", "v " + ZHEA + "r", "v " + THAG + "r", THAG + "gr", THAG + "dr", THAG + "br", THAG + "zr", THAG + ZHEA + "r", 
        "gbl", "gzl", "g " + ZHEA + "l", "gvl", "dzl", "dvl", "bgl", "bzl", "b " + ZHEA + "l", "bvl", "zgl", "zdl", "zbl", 
        "zvl", ZHEA + "gl", ZHEA + "dl", ZHEA + "vl", "vgl", "vdl", "vzl", "v " + ZHEA + "l", THAG + "gl", THAG + "zl" 
    };
    private static final String[][] midword_voiced = {mv_s, mv_m, mv_l};
    private static final String[][][] midword_clusters = {midword_voiceless, midword_neutral, midword_voiced};

    private static final String[] cvl_s = {"k", "t", "p", "s", SHEA, "f", THEA};
    private static final String[] cvl_m = 
    {
        "k", "kt", "ks", "k" + SHEA, "kf", "k" + THEA, "t", "ts", "t" + SHEA, "tf", "p", "pt", "ps", "p" + SHEA, "pf", "p" + THEA, 
        "s", "sk", "st", "sp", "sf", "s" + THEA, SHEA, SHEA + "k", SHEA + "t", SHEA + "p", "f", "fk", "ft", "fp", "fs", "f" + SHEA, 
        "f" + THEA, THEA, THEA + "k", THEA + "t", THEA + "p", THEA + "s", THEA + "f", NGEA + "k", NGEA + "t", NGEA + "p", NGEA + "s", 
        NGEA + SHEA, NGEA + "f", NGEA + THEA, "nk", "nt", "np", "ns", "n" + SHEA, "nf", "n" + THEA, "mk", "mt", "mp", "ms", "m" + SHEA, 
        "mf", "m" + THEA, "lk", "lt", "lp", "ls", "l" + SHEA, "lf", "l" + THEA, "rk", "rt", "rp", "rs", "r" + SHEA, "rf", "r" + THEA 
    };
    private static final String[] cvl_l = 
    {
        "kt", "ks", "k" + SHEA, "kf", "k" + THEA, "ts", "t" + SHEA, "tf", "pt", "ps", "p" + SHEA, "pf", "p" + THEA, "sk", 
        "st", "sp", "sf", "s" + THEA, SHEA + "k", SHEA + "t", SHEA + "p", "fk", "ft", "fp", "fs", "f" + SHEA, "f" + THEA, 
        THEA + "k", THEA + "t", THEA + "p", THEA + "s", THEA + "f", NGEA + "k", NGEA + "t", NGEA + "p", NGEA + "s", NGEA + SHEA, 
        NGEA + "f", NGEA + THEA, "nk", "nt", "np", "ns", "n" + SHEA, "nf", "n" + THEA, "mk", "mt", "mp", "ms", "m" + SHEA, "mf", 
        "m" + THEA, "lk", "lt", "lp", "ls", "l" + SHEA, "lf", "l" + THEA, "rk", "rt", "rp", "rs", "r" + SHEA, "rf", "r" + THEA 
    };
    private static final String[][] coda_voiceless = {cvl_s, cvl_m, cvl_l};



    private static final String[] cn_s = {NGEA, "n", "m", "l", "r"};
    private static final String[] cn_m = {NGEA, "n", "m", "l", "ln", "lm", "r", "rn", "rm", "rl"};
    private static final String[] cn_l = {"ln", "lm", "rn", "rm", "rl"};
    private static final String[][] coda_neutral = {cn_s, cn_m, cn_l};

    private static final String[] cv_s = {"g", "d", "b", "z", ZHEA, "v", THAG};
    private static final String[] cv_m = 
    {
        "g", "gd", "gz", "g" + ZHEA, "gv", "g" + THAG, "d", "dz", "d" + ZHEA, "dv", "b", "bd", "bz", "b" + ZHEA, "bv", 
        "b" + THAG, "z", "zg", "zd", "zb", "zv", "z" + THAG, ZHEA, ZHEA + "g", ZHEA + "d", ZHEA + "b", "v", "vg", "vd", 
        "vb", "vz", "v" + ZHEA, "v" + THAG, THAG, THAG + "g", THAG + "d", THAG + "b", THAG + "z", THAG + "v", NGEA + "g", 
        NGEA + "d", NGEA + "b", NGEA + "z", NGEA + ZHEA, NGEA + "v", NGEA + THAG, "ng", "nd", "nb", "nz", "n" + ZHEA, "nv", 
        "n" + THAG, "mg", "md", "mb", "mz", "m" + ZHEA, "mv", "m" + THAG, "lg", "ld", "lb", "lz", "l" + ZHEA, "lv", "l" + THAG, 
        "rg", "rd", "rb", "rz", "r" + ZHEA, "rv", "r" + THAG
    };
    private static final String[] cv_l = 
    {
        "gd", "gz", "g" + ZHEA, "gv", "g" + THAG, "dz", "d" + ZHEA, "dv", "bd", "bz", "b" + ZHEA, "bv", "b" + THAG, "zg", "zd", 
        "zb", "zv", "z" + THAG, ZHEA + "g", ZHEA + "d", ZHEA + "b", "vg", "vd", "vb", "vz", "v" + ZHEA, "v" + THAG, THAG + "g", 
        THAG + "d", THAG + "b", THAG + "z", THAG + "v", NGEA + "g", NGEA + "d", NGEA + "b", NGEA + "z", NGEA + ZHEA, NGEA + "v", 
        NGEA + THAG, "ng", "nd", "nb", "nz", "n" + ZHEA, "nv", "n" + THAG, "mg", "md", "mb", "mz", "m" + ZHEA, "mv", "m" + THAG, 
        "lg", "ld", "lb", "lz", "l" + ZHEA, "lv", "l" + THAG, "rg", "rd", "rb", "rz", "r" + ZHEA, "rv", "r" + THAG
    };
    private static final String[][] coda_voiced = {cv_s, cv_m, cv_l};

    private static final String[][][] coda_clusters = {coda_voiceless, coda_neutral, coda_voiced};
       
    private static final String[] vs_cluster = {"i", "e", "a", "u", "o", "y"};
    private static final String[] vm_cluster = {"i", "ei", "ai", "ui", "oi", "yi",
                                                "i", "e", "a", "u", "o", "y",
                                                "ie", "e", "ae", "ue", "oe", "ye",
                                                "ia", "ea", "a", "ua", "oa", "ya",
                                                "i", "e", "a", "u", "o", "y",
                                                "iu", "eu", "au", "u", "ou", "yu",
                                                "io", "eo", "ao", "uo", "o", "yo",
                                                "i", "e", "a", "u", "o", "y",
                                                "iy", "ey", "ay", "uy", "oy", "y"};
    
    private static final String[] vl_cluster = {"ei", "ai", "ui", "oi", "yi", 
                                                "ie", "ae", "ue", "oe", "ye",
                                                "ia", "ea", "ua", "oa", "ya",
                                                "iu", "eu", "au", "ou", "yu",
                                                "io", "eo", "ao", "uo", "yo",
                                                "iy", "ey", "ay", "uy", "oy"};
    private static final String[][] Vowel_Cluster = {vs_cluster, vm_cluster, vl_cluster};
    
    private static final String[] genus_primary_vowels = {"i", "e", "a", "u"};
    private static final String[] genus_mod_vowels = {"i", "e", "a", "u", "o", "y"};
    
    private static final String[] posession_vowels = {"", "i'", "e'", "a'", "u'", "o'"};
    
    private static final String[] tally_consonants = {"p", "n", "f", "t", "d", "l", "r", "ɕ", "j", "k", "m", "b"};
    private static final String[] lazy_digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B"};
    
    private static final String[] pronoun_role = {"s'", "n'", "f'", "ʑ'"};
    
    private static final String plural_suffix = "ei";
    
    private static final String[] verb_mood = {"y", "i", "a", "e", "u"};
    private static final String[] verb_tense = {"e", "i", "a", "u"};

    private static final String[] ad_key = {"iy", "ey", "ay", "uy", "oy", "y"};
    private static final String[] spare_key = {"io", "eo", "ao", "uo", "o", "yo"};
    
    private static final String[] digit_class = {"y", "ia", "o"};
    private static final String[][] digit_magnitude = {tally_consonants, {"s"}, {"ʑ"}};
    private static final String[] digit_delimiter = {"'", "-", ""};
    
    
    public Cluster()
    {
        
    }

    protected static String digitCoda(int ofThree, int magnitude)
    {
        return digit_magnitude[ofThree][magnitude];
    }
    
    protected static String digitKey(int type)
    {
        return digit_class[type];
    }

    protected static String digitValue(int value)
    {
        return tally_consonants[value];
    }
    protected static String lazyDigit(int index)
    {
        return lazy_digits[index];
    }

    protected static String digitDelimiter(int loc)
    {
        return digit_delimiter[loc];
    }
    
    protected static String retrieveCluster(String[] cluster, int index)
    {
        return cluster[index];
    }


    protected static String vowelCluster(int length)
    {
        return retrieveCluster(Vowel_Cluster[length], Dice.rand(0, Vowel_Cluster[length].length -1));
    }

    
    protected static String genusCluster(Word aWord)
    {
        String cluster = genus_primary_vowels[aWord.Genus()[0]];
        int mod = Dice.rand(0, genus_mod_vowels.length -1);
        cluster += (mod == aWord.Genus()[1]) ? "" : genus_mod_vowels[mod];
        return cluster;
    }

    protected static String tenseVowel(int tense)
    {
        return verb_tense[tense];
    }

    protected static String moodVowel(int mood)
    {
        return verb_mood[mood];
    }

    protected static String possessivePrefix(int mine)
    {
        return posession_vowels[mine];
    }

    protected static String pronounRole(int who)
    {
        return pronoun_role[who];
    }

    protected static String pluralSuffix()
    {
        return plural_suffix;
    }

    protected static String adVowel()
    {
        return ad_key[Dice.rand(0, ad_key.length -1)];
    }
    
    protected static String spareVowel()
    {
        return spare_key[Dice.rand(0, spare_key.length -1)];
    }
    
    protected static String OnsetCluster(int length, int style)
    {
      return onset_clusters[style][length][Dice.rand(0, onset_clusters[style][length].length-1)];
    }
    protected static String MidWordCluster(int length, int style)
    {
      return midword_clusters[style][length][Dice.rand(0, midword_clusters[style][length].length-1)];
    }    
    protected static String CodaCluster(int length, int style)
    {
      return coda_clusters[style][length][Dice.rand(0, midword_clusters[style][length].length-1)];
    }
}
