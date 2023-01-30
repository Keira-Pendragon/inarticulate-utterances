public class Consonant 
{   
    
    /*  
    private static final String[] onset_voiceless = 
    {
        "k", "ks", "kɕ", "kf", "kθ", "kh", "kl", "kr", "t", "ts", "tɕ", "tr", "p", "pt", "ps", "pɕ", "pf", "pθ", "pl", "pr", 
        "s", "sk", "st", "sp", "sf", "sθ", "sŋ", "sn", "sm", "sl", "sr", "skr", "str", "spr", "skl", "spl", "ɕ", "ɕk", "ɕt", 
        "ɕp", "ɕf", "ɕθ", "ɕŋ", "ɕn", "ɕm", "ɕl", "ɕr", "ɕkr", "ɕtr", "ɕpr", "ɕkl", "ɕpl", "f", "fk", "ft", "fp", "fs", "fɕ", 
        "fθ", "fŋ", "fn", "fm", "fl", "fr", "θ", "θk", "θt", "θp", "θŋ", "θn", "θm", "θr"
    };
    
    private static final String[] onset_neutrals = {"ŋ", "ŋr", "ŋl", "n", "m", "h", "l", "r"};
    
    private static final String[] onset_voiced = 
    {
        "g", "gz", "gʑ", "gv", "gð", "gh", "gl", "gr", "d", "dz", "dʑ", "dr", "b", "bd", "bz", "bʑ", "bv", "bð", "bl", "br", "z", 
        "zg", "zd", "zb", "zv", "zð", "zŋ", "zn", "zm", "zl", "zr", "zgr", "zdr", "zbr", "zgl", "zbl", "ʑ", "ʑg", "ʑd", "ʑb", "ʑv", 
        "ʑð", "ʑŋ", "ʑn", "ʑm", "ʑl", "ʑr", "ʑgr", "ʑdr", "ʑbr", "ʑgl", "ʑbl", "v", "vg", "vd", "vb", "vz", "vʑ", "vð", "vŋ", "vn", 
        "vm", "vl", "vr", "ð", "ðg", "ðd", "ðb", "ðŋ", "ðn", "ðm", "ðr"
    };
    
    private static final String[] midword_voiceless = 
    {
        "k", "kt", "kp", "ks", "kɕ", "kf", "kθ", "kŋ", "kn", "km", "kh", "kl", "kr", "t", "tk", "tp", "ts", "tɕ", "tf", "tθ", "tŋ", 
        "tn", "tm", "th", "tl", "tr", "p", "pk", "pt", "ps", "pɕ", "pf", "pθ", "pŋ", "pn", "pm", "ph", "pl", "pr", "s", "sk", "st", 
        "sp", "sf", "sθ", "sŋ", "sn", "sm", "sh", "sl", "sr", "ɕ", "ɕk", "ɕt", "ɕp", "ɕf", "ɕθ", "ɕŋ", "ɕn", "ɕm", "ɕh", "ɕl", "ɕr", 
        "f", "fk", "ft", "fp", "fs", "fɕ", "fθ", "fŋ", "fn", "fm", "fh", "fl", "fr", "θ", "θk", "θt", "θp", "θs", "θɕ", "θŋ", "θn", 
        "θm", "θh", "θl", "θr", "ŋ", "ŋk", "ŋt", "ŋp", "ŋs", "ŋɕ", "ŋf", "ŋθ", "ŋn", "ŋm", "ŋh", "ŋl", "ŋr", "nk", "nt", "np", "ns", 
        "nɕ", "nf", "nθ", "mk", "mt", "mp", "ms", "mɕ", "mf", "mθ", "lk", "lt", "lp", "ls", "lɕ", "lf", "lθ", "rk", "rt", "rp", "rs", 
        "rɕ", "rf", "rθ", "ktr", "kpr", "ksr", "kɕr", "kfr", "kθr", "tkr", "tpr", "tsr", "tɕr", "tfr", "tθr", "pkr", "ptr", "psr", "pɕr", 
        "pfr", "pθr", "skr", "str", "spr", "sfr", "sθr", "ɕkr", "ɕtr", "ɕpr", "ɕfr", "ɕθr", "fkr", "ftr", "fpr", "fsr", "fɕr", "fθr", 
        "θkr", "θtr", "θpr", "θsr", "θɕr", "kpl", "ksl", "kɕl", "kfl", "tsl", "tfl", "pkl", "psl", "pɕl", "pfl", "skl", "stl", "spl", 
        "sfl", "ɕkl", "ɕtl", "ɕfl", "fkl", "ftl", "fsl", "fɕl", "θkl", "θsl"
    };
    
    private static final String[] midword_neutrals = 
    {
        "rŋ", "rn", "rm", "rh", "rl", "lŋ", "ln", "lm", "lh", "lr", "nŋ", "nm", "nh", "nl", "nr", "m", "mŋ", "mn", "mh", "ml", "mr", "h", "n", "r", "l"
    };
    
    private static final String[] midword_voiced = 
    {
        "g", "gd", "gb", "gz", "gʑ", "gv", "gð", "gŋ", "gn", "gm", "gh", "gl", "gr", "d", "dg", "db", "dz", "dʑ", "dv", "dð", "dŋ", "dn",
        "dm", "dh", "dl", "dr", "b", "bg", "bd", "bz", "bʑ", "bv", "bð", "bŋ", "bn", "bm", "bh", "bl", "br", "z", "zg", "zd", "zb", "zv",
        "zð", "zŋ", "zn", "zm", "zh", "zl", "zr", "ʑ", "ʑg", "ʑd", "ʑb", "ʑv", "ʑð", "ʑŋ", "ʑn", "ʑm", "ʑh", "ʑl", "ʑr", "v", "vg", "vd",
        "vb", "vz", "vʑ", "vð", "vŋ", "vn", "vm", "vh", "vl", "vr", "ð", "ðg", "ðd", "ðb", "ðz", "ðʑ", "ðŋ", "ðn", "ðm", "ðh", "ðl", "ðr",
        "ŋg", "ŋd", "ŋb", "ŋz", "ŋʑ", "ŋv", "ŋð", "ng", "nd", "nb", "nz", "nʑ", "nv", "nð", "mg", "md", "mb", "mz", "mʑ", "mv", "mð", "lg",
        "ld", "lb", "lz", "lʑ", "lv", "lð", "rg", "rd", "rb", "rz", "rʑ", "rv", "rð", "gdr", "gbr", "gzr", "gʑr", "gvr", "gðr", "dgr", "dbr",
        "dzr", "dʑr", "dvr", "dðr", "bgr", "bdr", "bzr", "bʑr", "bvr", "bðr", "zgr", "zdr", "zbr", "zvr", "zðr", "ʑgr", "ʑdr", "ʑbr", "ʑvr",
        "ʑðr", "vgr", "vdr", "vbr", "vzr", "vʑr", "vðr", "ðgr", "ðdr", "ðbr", "ðzr", "ðʑr", "gbl", "gzl", "gʑl", "gvl", "dzl", "dvl", "bgl",
        "bzl", "bʑl", "bvl", "zgl", "zdl", "zbl", "zvl", "ʑgl", "ʑdl", "ʑvl", "vgl", "vdl", "vzl", "vʑl", "ðgl", "ðzl"
    };
    
    private static final String[] coda_voiceless = 
    {
        "k", "kt", "ks", "kɕ", "kf", "kθ", "t", "ts", "tɕ", "tf", "p", "pt", "ps", "pɕ", "pf", "pθ", "s", "sk", "st", "sp", "sf", "sθ",
        "ɕ", "ɕk", "ɕt", "ɕp", "f", "fk", "ft", "fp", "fs", "fɕ", "fθ", "θ", "θk", "θt", "θp", "θs", "θf", "ŋk", "ŋt", "ŋp", "ŋs", "ŋɕ",
        "ŋf", "ŋθ", "nk", "nt", "np", "ns", "nɕ", "nf", "nθ", "mk", "mt", "mp", "ms", "mɕ", "mf", "mθ", "lk", "lt", "lp", "ls", "lɕ", "lf",
        "lθ", "rk", "rt", "rp", "rs", "rɕ", "rf", "rθ"
    };
    
    private static final String[] coda_neutrals = {"ŋ", "n", "m", "l", "ln", "lm", "r", "rn", "rm", "rl"};
    
    private static final String[] coda_voiced = 
    {
        "g", "gd", "gz", "gʑ", "gv", "gð", "d", "dz", "dʑ", "dv", "b", "bd", "bz", "bʑ", "bv", "bð", "z", "zg", "zd", "zb", "zv", "zð", "ʑ",
        "ʑg", "ʑd", "ʑb", "v", "vg", "vd", "vb", "vz", "vʑ", "vð", "ð", "ðg", "ðd", "ðb", "ðz", "ðv", "ŋg", "ŋd", "ŋb", "ŋz", "ŋʑ", "ŋv", "ŋð",
        "ng", "nd", "nb", "nz", "nʑ", "nv", "nð", "mg", "md", "mb", "mz", "mʑ", "mv", "mð", "lg", "ld", "lb", "lz", "lʑ", "lv", "lð", "rg", 
        "rd", "rb", "rz", "rʑ", "rv", "rð”
    };*/
    private final int ONSET = 0;
    private final int MIDWORD = 1;
    private final int CODA = 2;
    
    private boolean[] position_enabled;
    private boolean[] leader;
    private boolean[] follower;
    private String[][] leads;
    private String[][] follows;
    
    
    private String id;

    public Consonant(String name, boolean[] locEnabled, boolean[] isLeader, boolean[] isFollower, String[][] leadsWhat, String[][] followsWhat)
    {
        position_enabled = locEnabled;
        leader = isLeader;
        follower = isFollower;
        leads = leadsWhat;
        follows = followsWhat;         
    }
    
    public boolean ClusterEnabled(int which)
    {
        return cluster_position_enabled[which];
    }
    public boolean Proceedable(int where)
    {
        return procedeable[where];
    }
    public boolean Followable(int where)
    {
        return followable[where];
    }
    
    public String getCluster(int length, int position)
    {
        boolean spareLeads = Dice.CoinToss();
        String o = (Procedeable(position) && (length == 3 || (length == 2 && spareLeads))? consonants_proceding[position][Dice.rand(0, consonants_proceding[position].length() -1)] : "";
        String m = id;
        String c = (Followable(position) && (length == 3 || (length == 2 && !spareLeads))? consonants_following[position][Dice.rand(0, consonants_following[position].length() -1)] : "";
        return o + m + c;            
    }
           
}
