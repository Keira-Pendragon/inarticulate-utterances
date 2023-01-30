/**
 * Cluster.java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * ʥ
 */

import java.util.ArrayList;

public class Cluster
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
    
      	private static final String[] onset_voiceless =
	{
    	"k", "ks", "k" + SHEA, "kf", "k" + THEA, "kh", "kl", "kr", "t", "ts", "t" + SHEA, "tr", "p", "pt", "ps", "p" + SHEA, "pf", "p" + THEA, "pl", "pr",
    	"s", "sk", "st", "sp", "sf", "s" + THEA, "s" + NGEA, "sn", "sm", "sl", "sr", "skr", "str", "spr", "skl", "spl", SHEA, SHEA + "k", SHEA + "t",
    	SHEA + "p", SHEA + "f", SHEA +  THEA, SHEA +  NGEA, SHEA + "n", SHEA + "m", SHEA + "l", SHEA + "r", SHEA + "kr", SHEA + "tr", SHEA + "pr", 
        SHEA + "kl", SHEA + "pl", "f", "fk", "ft", "fp", "fs", "f" + SHEA, "f" + THEA, "f" + NGEA, "fn", "fm", "fl", "fr", THEA, THEA + "k", THEA + "t", 
        THEA + "p", THEA +  NGEA, THEA + "n", THEA + "m", THEA + "r"
	};
    
	private static final String[] onset_neutrals = {NGEA, NGEA + "r", NGEA + "l", "n", "m", "h", "l", "r"};
    
	private static final String[] onset_voiced =
	{
    	"g", "gz", "g" + ZHEA, "gv", "g" + THAG, "gh", "gl", "gr", "d", "dz", "d" + ZHEA, "dr", "b", "bd", "bz", "b" + ZHEA, "bv", "b" + THAG, "bl", "br", "z",
    	"zg", "zd", "zb", "zv", "z" + THAG, "z" + NGEA, "zn", "zm", "zl", "zr", "zgr", "zdr", "zbr", "zgl", "zbl", ZHEA, ZHEA + "g", ZHEA + "d", ZHEA + "b", ZHEA + "v",
    	ZHEA +  THAG, ZHEA +  NGEA, ZHEA + "n", ZHEA + "m", ZHEA + "l", ZHEA + "r", ZHEA + "gr", ZHEA + "dr", ZHEA + "br", ZHEA + "gl", ZHEA + "bl", "v", "vg", "vd", "vb", "vz",
        "v" + ZHEA, "v" + THAG, "v" + NGEA, "vn", "vm", "vl", "vr", THAG, THAG + "g", THAG + "d", THAG + "b", THAG + NGEA, THAG + "n", THAG + "m", THAG + "r"
	};
    
	private static final String[] midword_voiceless =
	{
    	"k", "kt", "kp", "ks", "k" + SHEA, "kf", "k" + THEA, "k" + NGEA, "kn", "km", "kh", "kl", "kr", "t", "tk", "tp", "ts", "t" + SHEA, "tf", "t" + THEA, "t" + NGEA,
    	"tn", "tm", "th", "tl", "tr", "p", "pk", "pt", "ps", "p" + SHEA, "pf", "p" + THEA, "p" + NGEA, "pn", "pm", "ph", "pl", "pr", "s", "sk", "st",
    	"sp", "sf", "s" + THEA, "s" + NGEA, "sn", "sm", "sh", "sl", "sr", SHEA, SHEA + "k", SHEA + "t", SHEA + "p", SHEA + "f", SHEA +  THEA, SHEA +  NGEA, SHEA + "n",
        SHEA + "m", SHEA + "h", SHEA + "l", SHEA + "r", "f", "fk", "ft", "fp", "fs", "f" + SHEA, "f" + THEA, "f" + NGEA, "fn", "fm", "fh", "fl", "fr", THEA, THEA + k",
        THEA + "t", THEA + "p", THEA + "s", THEA + SHEA, THEA + NGEA, THEA + "n", THEA + "m", THEA + "h", THEA + "l", THEA + "r", NGEA, NGEA + "k", NGEA + "t", NGEA + "p",
        NGEA + "s", NGEA + SHEA, NGEA + "f", NGEA + THEA, NGEA + "n", NGEA + "m", NGEA + "h", NGEA + "l", NGEA + "r", "nk", "nt", "np", "ns",
    	"n" + SHEA, "nf", "n" + THEA, "mk", "mt", "mp", "ms", "m" + SHEA, "mf", "m" + THEA, "lk", "lt", "lp", "ls", "l" + SHEA, "lf", "l" + THEA, "rk", "rt", "rp", "rs",
    	"r" + SHEA, "rf", "r" + THEA, "ktr", "kpr", "ksr", "k" + SHEA+ "r", "kfr", "k" + THEA + "r", "tkr", "tpr", "tsr", "t" + SHEA + "r", "tfr", "t" + THEA + "r", 
        "pkr", "ptr", "psr", "p" + SHEA + "r", "pfr", "p" + THEA+ "r", "skr", "str", "spr", "sfr", "s" + THEA + "r", SHEA + "kr", SHEA + "tr", SHEA + "pr", SHEA + "fr", 
        SHEA +  THEA + "r", "fkr", "ftr", "fpr", "fsr", "f" + SHEA + "r", "f" + THEA + "r", THEA + "kr", THEA + "tr", THEA + "pr", THEA + "sr", THEA +  SHEA + "r", 
        "kpl", "ksl", "k" + SHEA + "l", "kfl", "tsl", "tfl", "pkl", "psl", "p" + SHEA + "l", "pfl", "skl", "stl", "spl", "sfl", SHEA + "kl", SHEA + "tl", SHEA + "fl",
        "fkl", "ftl", "fsl", "f" + SHEA + "l", THEA + "kl", THEA + "sl"
	};
    
	private static final String[] midword_neutrals =
	{
    	"r" + NGEA, "rn", "rm", "rh", "rl", "l" + NGEA, "ln", "lm", "lh", "lr", "n" + NGEA, 
        "nm", "nh", "nl", "nr", "m", "m" + NGEA, "mn", "mh", "ml", "mr", "h", "n", "r", "l"
	};
    
	private static final String[] midword_voiced =
	{
    	"g", "gd", "gb", "gz", "g" + ZHEA, "gv", "g" + THAG, "g" + NGEA, "gn", "gm", "gh", "gl", "gr", "d", "dg", "db", "dz", "d" + ZHEA, "dv", "d" + THAG, "d" + NGEA,
        "dn", "dm", "dh", "dl", "dr", "b", "bg", "bd", "bz", "b" + ZHEA, "bv", "b" + THAG, "b" + NGEA, "bn", "bm", "bh", "bl", "br", "z", "zg", "zd", "zb", "zv",
    	"z" + THAG, "z" + NGEA, "zn", "zm", "zh", "zl", "zr", ZHEA, ZHEA + "g", ZHEA + "d", ZHEA + "b", ZHEA + "v", ZHEA +  THAG, ZHEA +  NGEA, ZHEA + "n", ZHEA + "m", 
        ZHEA + "h", ZHEA + "l", ZHEA + "r", "v", "vg", "vd", "vb", "vz", "v" + ZHEA, "v" + THAG, "v" + NGEA, "vn", "vm", "vh", "vl", "vr", THAG, THAG + "g", THAG + "d",
        THAG + "b", THAG + "z", THAG + ZHEA, THAG + NGEA, THAG + "n", THAG + "m", THAG + "h", THAG + "l", THAG + "r", NGEA + "g", NGEA + "d", NGEA + "b", NGEA + "z", 
        NGEA + ZHEA, NGEA + "v", NGEA + THAG, "ng", "nd", "nb", "nz", "n" + ZHEA, "nv", "n" + THAG, "mg", "md", "mb", "mz", "m" + ZHEA, "mv", "m" + THAG, "lg",
    	"ld", "lb", "lz", "l" + ZHEA, "lv", "l" + THAG, "rg", "rd", "rb", "rz", "r" + ZHEA, "rv", "r" + THAG, "gdr", "gbr", "gzr", "g" + ZHEA + "r", "gvr", 
        "g" + THAG + "r", "dgr", "dbr", "dzr", "d" + ZHEA + "r", "dvr", "d" + THAG + "r", "bgr", "bdr", "bzr", "b" + ZHEA + "r", "bvr", "b" + THAG + "r", "zgr", "zdr", 
        "zbr", "zvr", "z" + THAG + "r", ZHEA + "gr", ZHEA + "dr", ZHEA + "br", ZHEA + "vr", ZHEA + THAG + "r", "vgr", "vdr", "vbr", "vzr", "v" + ZHEA + "r", 
        "v" + THAG + "r", THAG + "gr", THAG + "dr", THAG + "br", THAG + "zr", THAG + ZHEA + "r", "gbl", "gzl", "g" + ZHEA + "l", "gvl", "dzl", "dvl", "bgl", "bzl",
    	"b" + ZHEA + "l", "bvl", "zgl", "zdl", "zbl", "zvl", ZHEA + "gl", ZHEA + "dl", ZHEA + "vl", "vgl", "vdl", "vzl", "v" + ZHEA + "l", THAG + "gl", THAG + "zl"
	};
    
	private static final String[] coda_voiceless =
	{
    	"k", "kt", "ks", "k" + SHEA, "kf", "k" + THEA, "t", "ts", "t" + SHEA, "tf", "p", "pt", "ps", "p" + SHEA, "pf", "p" + THEA, "s", "sk", "st", "sp", "sf", "s" + THEA,
    	SHEA, SHEA + "k", SHEA + "t", SHEA + "p", "f", "fk", "ft", "fp", "fs", "f" + SHEA, "f" + THEA, THEA, THEA + "k", THEA + "t", THEA + "p", THEA + "s", THEA + "f", 
        NGEA + "k", NGEA + "t", NGEA + "p", NGEA + "s", NGEA + SHEA, NGEA + "f", NGEA +  THEA, "nk", "nt", "np", "ns", "n" + SHEA, "nf", "n" + THEA, "mk", "mt", "mp", 
        "ms", "m" + SHEA, "mf", "m" + THEA, "lk", "lt", "lp", "ls", "l" + SHEA, "lf", "l" + THEA, "rk", "rt", "rp", "rs", "r" + SHEA, "rf", "r" + THEA
	};
    
	private static final String[] coda_neutrals = {NGEA, "n", "m", "l", "ln", "lm", "r", "rn", "rm", "rl"};
    
	private static final String[] coda_voiced =
	{
    	"g", "gd", "gz", "g" + ZHEA, "gv", "g" + THAG, "d", "dz", "d" + ZHEA, "dv", "b", "bd", "bz", "b" + ZHEA, "bv", "b" + THAG, "z", "zg", "zd", "zb", "zv", 
        "z" + THAG, ZHEA, ZHEA + "g", ZHEA + "d", ZHEA + "b", "v", "vg", "vd", "vb", "vz", "v" + ZHEA, "v" + THAG, THAG, THAG + "g", THAG + "d", THAG + "b", 
        THAG + "z", THAG + "v", NGEA + "g", NGEA + "d", NGEA + "b", NGEA + "z", NGEA + ZHEA, NGEA + "v", NGEA +  THAG, "ng", "nd", "nb", "nz", "n" + ZHEA, "nv",
        "n" + THAG, "mg", "md", "mb", "mz", "m" + ZHEA, "mv", "m" + THAG, "lg", "ld", "lb", "lz", "l" + ZHEA, "lv", "l" + THAG, "rg",
    	"rd", "rb", "rz", "r" + ZHEA, "rv", "r" + THAG
	};

    
    
    private static final String THEA = "\u03B8";
    private static final String ZHEA = "\u02E2";
    private static final String SHEA = "\u02E9";
    private static final String NGEA = "\u014B";
    private static final String THAG = "\u00F0";
 
    private static final String[] all_consonant = {"n", "d", "t", "h", "r", "l", NGEA, "g", "k", "m", "b", "p", "f", "v", THEA, ZHEA, "z", SHEA, "s"};
    
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
    
    private static ArrayList<Consonant> consonant_list;
    
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

    protected static String onsetCluster(int length)
    {
        return retrieveCluster(Onset_Cluster[length], Dice.rand(0, Onset_Cluster[length].length -1));
    }

    protected static String midConstCluster(int length)
    {
        return retrieveCluster(MidConst_Cluster[length], Dice.rand(0, Coda_Cluster[length].length -1));
    }

    protected static String codaCluster(int length)
    {
        return retrieveCluster(Coda_Cluster[length], Dice.rand(0, Coda_Cluster[length].length -1));
    }

    protected static String vowelCluster(int length)
    {
        return retrieveCluster(Vowel_Cluster[length], Dice.rand(0, Vowel_Cluster[length].length -1));
    }

    
    protected static String genusCluster(Word aWord)
    {
        String cluster = genus_primary_vowels[aWord.Genus()];
        int mod = Dice.rand(0, genus_mod_vowels.length -1);
        cluster += (mod == aWord.Genus()) ? "" : genus_mod_vowels[mod];
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
    

