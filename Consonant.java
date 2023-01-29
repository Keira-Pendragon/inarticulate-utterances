public class Consonant 
{
    private final String THEA = "\u03B8";
    private final String ZHEA = "\u02E2";
    private final String SHEA = "\u02E9";
    private final String NGEA = "\u014B";
    private final String[] all_consonant = {"n", "d", "t", "h", "r", "l", NGEA, "g", "k", "m", "b", "p", "f", "v", THEA, ZHEA, "z", SHEA, "s"};
    
    private final int ONSET = 0;
    private final int MIDWORD = 1;
    private final int CODA = 2;
    
    private boolean[] cluster_position_enabled;
    private boolean[] procedeable;
    private boolean[] followable;
    private String[][] consonants_preceeding;
    private String[][] consonants_following;
    
    
    private String id;

    public Consonant()
    {

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
