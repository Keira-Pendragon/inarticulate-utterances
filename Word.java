/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

public class Word
{

    
    private boolean type_is_random;
    private boolean all_is_random;
    private boolean pattern_is_random;
    private boolean length_is_random;
    private boolean style_is_random;
    
    private boolean value_is_random;
    
    private boolean tense_is_random;
    private boolean mood_is_random;
    
    private boolean genus_is_random;
    private boolean singularity_is_random;
    private boolean possession_is_random;
    private boolean count_is_random;
    private boolean role_is_random;
    
    
    private int word_type;
    
    private String siathael_word;
    private String english_translation;
    
    private int word_length;
    private int consonant_style;
    private int [] word_pattern;
    
    private boolean word_is_singular;
    private int posessive_style;
    private int mention_count;
    private int scope_role;
    private int[] word_genus;
    
    private int verb_mood;
    private int verb_tense;
    
    private int [] digit_count;
    private String word_base12Digits;
    private String[] digit_value;
    private char delimiter;
    


    public Word()
    {

    }
    
    public boolean isSingular()
    {
        return (singularity_is_random) ? Dice.CoinToss() : word_is_singular;
    }
    
    private void setType(int type)
    {
        
    }
    private void setType(boolean random)
    {
        word_type = Dice.rand(0, 6);
    }
        
    public int Type()
    {
        return word_type;
    }

}
