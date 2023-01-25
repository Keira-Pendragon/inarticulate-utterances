    /**
     * .java
     * Author: Keira Pendragon
     * Author Date: 1/22/2023
     * 
     * 
     */

    public class Words extends Cluster
    {
    protected static final int NUMBER = 0;
    protected static final int PRONOUN = 1;
    protected static final int NOUN = 2;
    protected static final int ADJECTIVE = 3;
    protected static final int VERB = 4;
    protected static final int ADVERB = 5;
    protected static final int ADHESIVE = 6;

    protected static final int ONSET = 0;
    protected static final int VOWEL = 1;
    protected static final int MIDCONST = 2;
    protected static final int KEYMID = 3;
    protected static final int CODA = 4;
    protected static final int ENDKEY = 5;

    protected static final int[] a0_pattern = {ENDKEY};
    protected static final int[] a1_pattern = {ONSET, ENDKEY};
    protected static final int[] a2_pattern = {VOWEL, MIDCONST, ENDKEY};
    protected static final int[] a3_pattern = {KEYMID, MIDCONST, VOWEL};
    protected static final int[] a4_pattern = {ONSET, VOWEL, MIDCONST, ENDKEY};
    protected static final int[] a5_pattern = {ONSET, KEYMID, MIDCONST, VOWEL};
    protected static final int[] a6_pattern = {VOWEL, MIDCONST, VOWEL, MIDCONST, ENDKEY};
    protected static final int[] a7_pattern = {VOWEL, MIDCONST, KEYMID, MIDCONST, VOWEL};
    protected static final int[] a8_pattern = {ONSET, VOWEL, MIDCONST, VOWEL, MIDCONST, ENDKEY};
    protected static final int[] a9_pattern = {ONSET, VOWEL, MIDCONST, KEYMID, MIDCONST, VOWEL};
    protected static final int[] v0_pattern = {KEYMID, MIDCONST, ENDKEY};
    protected static final int[] v1_pattern = {ONSET, KEYMID, MIDCONST, ENDKEY};
    protected static final int[] v2_pattern = {VOWEL, MIDCONST, KEYMID, MIDCONST, ENDKEY};
    protected static final int[] v3_pattern = {ONSET, VOWEL, MIDCONST, KEYMID, MIDCONST, ENDKEY};
    protected static final int[] n0_pattern = {KEYMID, CODA};
    protected static final int[] n1_pattern = {ONSET, KEYMID, CODA};
    protected static final int[] n2_pattern = {VOWEL, MIDCONST, KEYMID, CODA};
    protected static final int[] n3_pattern = {ONSET, VOWEL, MIDCONST, KEYMID, CODA};

    protected static final String a0_name = "EndKey\n";
    protected static final String a1_name = "Onset + EndKey\n";
    protected static final String a2_name = "Vowel + MidConst + EndKey\n";
    protected static final String a3_name = "KeyMid + MidConst + Vowel\n";
    protected static final String a4_name = "Onset + Vowel + MidConst + EndKey\n";
    protected static final String a5_name = "Onset + KeyMid + MidConst + Vowel\n";
    protected static final String a6_name = "Vowel + MidConst + Vowel + MidConst + EndKey\n";
    protected static final String a7_name = "Vowel + MidConst + KeyMid + MidConst + Vowel\n";
    protected static final String a8_name = "Onset + Vowel + MidConst + Vowel + MidConst + EndKey\n";
    protected static final String a9_name = "Onset + VOWEL + MidConst + KeyMid + MidConst + Vowel\n";
    protected static final String v0_name = "KeyMid + MidConst + EndKey\n";
    protected static final String v1_name = "Onset + KeyMid + MidConst + EndKey\n";
    protected static final String v2_name = "Vowel + MidConst + KeyMid + MidConst + EndKey\n";
    protected static final String v3_name = "Onset + Vowel + MidConst + KeyMid + MidConst + EndKey";
    protected static final String n0_name = "KeyMid + Coda\n";
    protected static final String n1_name = "Onset + KeyMid + Coda\n";
    protected static final String n2_name = "Vowel + MidConst + KeyMid + Coda\n";
    protected static final String n3_name = "Onset + Vowel + MidConst + KeyMid + Coda";


    protected static final int[][] Verb_Pattern = {v0_pattern, v1_pattern, v2_pattern, v3_pattern};
    protected static final int[][] Noun_Pattern = {n0_pattern, n1_pattern, n2_pattern, n3_pattern};
    protected static final int[][] Alt_Pattern = {a0_pattern, a1_pattern, a2_pattern, a3_pattern, a4_pattern, 
                                                  a5_pattern, a6_pattern, a7_pattern, a8_pattern, a9_pattern, 
                                                  v0_pattern, v1_pattern, v2_pattern, v3_pattern, 
                                                  n0_pattern, n1_pattern, n2_pattern, n3_pattern};
                                                  
    protected static final int[] alt_pattern_range = {0, 17};
    protected static final int[] noun_pattern_range = {0, 3};
    protected static final int[] verb_pattern_range = {0, 3};    
    protected static final int[] genus_primary_range = {0, 3};
    protected static final int[] genus_mod_range = {0, 4};
    protected static final int[] role_range = {0, 3};
    protected static final int[] possessive_range = {0, 4};
    protected static final int[] noun_count_range = {1, 11};
    protected static final int[] mood_range = {0, 5};
    protected static final int[] tense_range = {0, 3};
    protected static final int[] cluster_length_range = {0, 2};
    protected static final int[] digit_count_range = {1, 66};
    protected static final int[] word_type_range = {0, 6};

    // \n1) Concepts\n2) Objects\n3) Entities\n4) Places\n5) Traits or Qualities\n6) Actions
    protected static final String g0_prompt = "Should this concept relate to\n1) Standard Concept\n2) Objects\n3) Entities\n4) Places\n5) Traits or Qualities\n6) Actions";
    protected static final String g1_prompt = "Should this Object relate to\n1) Concepts\n2) Standard Object\n3) Entities\n4) Places\n5) Traits or Qualities\n6) Actions";
    protected static final String g2_prompt = "Should this entity be denoted by \n1) Concepts\n2) Objects\n3) Standard Entity\n4) Places\n5) Traits or Qualities\n6) Actions";
    protected static final String g3_prompt = "Should this place be associated with\n1) Concepts\n2) Objects\n3) Entities\n4) Standard Place\n5) Traits or Qualities\n6) Actions";

    protected static final String random_prompt = "Would you like the word to be random?\n1) yes\n2) no";
    protected static final String singular_prompt = "Is the word Singular?\n1) yes\n2) no";
    protected static final String genus_primary_prompt = "What is the primary genus of the noun?\n1) Concept\n2) Thing\n3) Entity\n4) Place";
    protected static final String [] genus_mod_prompt = {g0_prompt, g1_prompt, g2_prompt, g3_prompt};
    protected static final String tense_prompt = "How does this action relate to time?\n1) Timeless\n2) Past\n3) Present\n4) Future";
    protected static final String mood_prompt = "Is this action a\n1) Request or Wish\n2) Directive\n3) Voluntary\n4) Passive\n5) Unwilling";
    protected static final String role_prompt = "Is this pronoun\n1) The speaker\n2) The Lisener\n3) Both\n4) Neither";
    protected static final String possessive_prompt = "Is this noun posessive?\n1) no\n2) part of\n3) dear to\n4) owned by\n5) diminuiative to\n6) loosely associated";
    protected static final String noun_count_prompt = "Is there more than one of this specific pronoun in the context?\n1) no\n#) Yes, this is the nth of the same (n: 2 to 11)";
    protected static final String digit_count_prompt = "How many digits should the random number have?\n(Limit 33 for whole, 66 for mixed)";
    protected static final String b12_prompt = "Enter the base 12 number to translate\n(Valid Values include 0-9, 'A', 'a', 'B', 'b', ',', '.', '/')\n(Max digits 66 if '.' or '/' divide them to a max of 33 on either side)";
    protected static final String cluster_length_prompt = "How long should the clusters be?\n1) Short\n2) Average\n3) Long";
    protected static final String word_type_prompt = "What type of word should be generated?\n1) Number\n2) Pronoun\n3) Noun\n4) Adjective\n5) Verb\n6) Adverb\n7) Adhesive";
    protected static final String alt_pattern_prompt = "Which pattern should the word follow?\n1) " + a0_name + "2) " + a1_name + "3) " + a2_name + "4) " + a3_name + "5) " + a4_name + "6) " 
                                                                                                    + a5_name + "7) " + a6_name + "8) " + a7_name + "9) " + a8_name + "10) " + a9_name + "11) " 
                                                                                                    + v0_name + "12) " + v1_name + "13) " + v2_name + "14) " + v3_name + "\n15) " 
                                                                                                    + n0_name + "16) " + n1_name + "17) " + n2_name + "18) " + n3_name;
                                                                                                  
    protected static final String noun_pattern_prompt = "Which pattern should the word follow?\n1) " + n0_name + "2) " + n1_name + "3) " + n2_name + "4) " + n3_name;
    protected static final String verb_pattern_prompt = "Which pattern should the word follow?\n1) " + v0_name + "2) " + v1_name + "3) " + v2_name + "4) " + v3_name;



    public Words()
    {

    }

    public static String TypePrompt()
    {
        return word_type_prompt;
    }

    public static int[] TypeRange()
    {
      return word_type_range;
    }

    protected static boolean randomWord()
    {
      return SUI.ValidateAgreement(random_prompt);
    }
      

    protected static String randomCluster(String[] clusters)
    {
      return clusters[Dice.rand(0, clusters.length-1)];
    }

    protected static int[] selectComplexGenus(boolean random)
    {
        int primary = selectGenus(random);
        int modifier = selectGenusMod(primary, random);
        int[] complex = {primary, modifier};
        return complex;
    }

    protected static int selectGenusMod(int primary, boolean random)
    {
      return (random)? Dice.rRand(genus_mod_range) : SUI.ValidateIndex(genus_mod_range, genus_mod_prompt[primary]);
    }


    protected static int selectGenus(boolean random)
    {
      return (random) ? Dice.rRand(genus_primary_range) : SUI.ValidateIndex(genus_primary_range, genus_primary_prompt);
    }

    protected static int selectRole(boolean random)
    {
      return (random) ? Dice.rRand(role_range) : SUI.ValidateIndex(role_range, role_prompt);
    }


    protected static int selectTense(boolean random)
    {
      return (random) ? Dice.rRand(tense_range) : SUI.ValidateIndex(tense_range, tense_prompt);
    }


    protected static int selectMood(boolean random)
    {
      return (random) ? Dice.rRand(mood_range) : SUI.ValidateIndex(mood_range, mood_prompt);
    }


    protected static int selectClusterLength(boolean random)
    {
      return (random) ? Dice.rRand(cluster_length_range) : SUI.ValidateIndex(cluster_length_range, cluster_length_prompt);
    }


    protected static int selectPossessiveness(boolean random)
    {
      return (random) ? Dice.rRand(possessive_range) : SUI.ValidateIndex(possessive_range, possessive_prompt);
    }


    protected static int selectNounCount(boolean random)
    {
      return (random) ? Dice.rRand(noun_count_range) : SUI.ValidateInt(noun_count_range, noun_count_prompt);
    }

    protected static int selectDigitCount()
    {
      return SUI.ValidateInt(digit_count_range, digit_count_prompt);
    }

    protected static String requestB12ToTranslate(boolean random)
    {
      SUI.displayTextLn(b12_prompt);
      return SUI.ValidateB12();
    }  

    protected static boolean singularWord(boolean random)
    {
      return (random) ? Dice.coinToss() : SUI.ValidateAgreement(singular_prompt);
    }

    protected static int clusterLength(boolean random)
    {
      return (random) ? Dice.rRand(cluster_length_range) : SUI.ValidateInt(cluster_length_range, cluster_length_prompt);
    }

    protected static int[] altPattern(boolean random)
    {
      return Alt_Pattern[(random) ? Dice.rRand(alt_pattern_range) : SUI.ValidateIndex(alt_pattern_range, alt_pattern_prompt)];
    }

    protected static int[] nounPattern(boolean random)
    {
      return Noun_Pattern[(random) ? Dice.rRand(noun_pattern_range) : SUI.ValidateIndex(noun_pattern_range, noun_pattern_prompt)];
    }

    protected static int[] verbPattern(boolean random)
    {
      return Verb_Pattern[(random) ? Dice.rRand(verb_pattern_range) : SUI.ValidateIndex(verb_pattern_range, verb_pattern_prompt)];
    }

    }
