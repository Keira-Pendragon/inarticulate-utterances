/**
 * Cluster.java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * ʥ
 */
public class Cluster
{
    private static final String[] os_cluster = {"n", "d", "t", "h", "r", "l", "ŋ", "g", "k", "m", "b", "p", "f", "v", "θ", "ʑ", "z", "ɕ", "s"};
    private static final String[] om_cluster = {"sn", "dr", "tr", "h", "r", "l", "ŋ", "gr", "kr", "m", "br", "pr", "fr", "vl", "θr", "ʑr", "zr", "ɕr", "sr"};
    private static final String[] ol_cluster = {"n", "zdr", "str", "h", "r", "l", "ŋ", "zgr", "skr", "m", "zbr", "spr", "sfr", "zvl", "sθr", "ʑ", "z", "ɕ", "s"};
    private static final String[][] Onset_Cluster = {os_cluster, om_cluster, ol_cluster};
    
    
    private static final String[] ms_cluster = {"n", "d", "t", "h", "r", "l", "ŋ", "g", "k", "m", "b", "p", "f", "v", "θ", "ʑ", "z", "ɕ", "s"};
    private static final String[] mm_cluster = {"nr", "db", "tk", "h", "rn", "lr", "ŋk", "gn", "kt", "mb", "bn", "pt", "fl", "vd", "θp", "ʑd", "zg", "ɕt", "sk"};
    private static final String[] ml_cluster = {"ntr", "dgr", "tkr", "h", "rtn", "lkr", "ŋkr", "gvr", "ktl", "mbd", "bdr", "ptr", "fkl", "vdn", "θtn", "ʑdr", "zgr", "ɕtn", "str"};
    private static final String[][] MidConst_Cluster = {ms_cluster, mm_cluster, ml_cluster};
    
    private static final String[] cs_cluster = {"n", "d", "t", "r", "l", "ŋ", "g", "k", "m", "b", "p", "f", "v", "θ", "ʑ", "z", "ɕ", "s"};
    private static final String[] cm_cluster = {"nt", "dz", "ts", "rk", "lt", "ŋg", "gz", "kt", "mp", "bz", "pt", "ft", "vd", "θt", "ʑd", "zg", "ɕt", "sk"};
    private static final String[] cl_cluster = {"nts", "d", "t", "rks", "lts", "ŋgz", "g", "kts", "mps", "b", "pts", "fts", "vdz", "θts", "ʑ", "z", "ɕ", "sts"};
    private static final String[][] Coda_Cluster = {cs_cluster, cm_cluster, cl_cluster};
    
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
    
    private static final String[] posession_vowels = {"i", "e", "a", "u", "o"};
    
    private static final String[] tally_consonants = {"p", "n", "f", "t", "d", "l", "r", "sh", "j", "k", "m", "b"};
    
    private static final String[] pronoun_role = {"s", "n", "f", "zh"};
    
    private static final String plural = "ei";
    
    private static final String[] verb_mood = {"y", "i", "a", "e", "u"};
    private static final String[] verb_tense = {"e", "i", "a", "u"};

    private static final String[] ad_key = {"iy", "ey", "ay", "uy", "oy", "y"};
    private static final String[] spare_key = {"io", "eo", "ao", "uo", "o", "yo"};
    
    private static final String[] digit_class = {"y", "ia", "o"};
    private static final String[][] digit_magnitude = {{"p"}, {"s"}, tally_consonants};
    private static final String[] digit_delimiter = {"'", "-", ""};
    
    public Cluster()
    {

    }
    
    protected static String retrieveCluster(String[] cluster, int index)
    {
        return cluster[index];
    }
}
