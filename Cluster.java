/**
 * Cluster.java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 */

public class Cluster
{
    private static final String[] os_cluster = {"", ""};
    private static final String[] om_cluster = {"", ""};
    private static final String[] ol_cluster = {"", ""};
    private static final String[][] Onset_Cluster = {os_cluster, om_cluster, ol_cluster};
    
    
    private static final String[] ms_cluster = {"", ""};
    private static final String[] mm_cluster = {"", ""};
    private static final String[] ml_cluster = {"", ""};
    private static final String[][] MidConst_Cluster = {ms_cluster, mm_cluster, ml_cluster};
    
    private static final String[] cs_cluster = {"", ""};
    private static final String[] cm_cluster = {"", ""};
    private static final String[] cl_cluster = {"", ""};
    private static final String[][] Coda_Cluster = {cs_cluster, cm_cluster, cl_cluster};
    
    private static final String[] vs_cluster = {"", ""};
    private static final String[] vm_cluster = {"", ""};
    private static final String[] vl_cluster = {"", ""};
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
    
    public Cluster()
    {

    }
}
