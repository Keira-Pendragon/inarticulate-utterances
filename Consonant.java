public class Consonant 
{   
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
