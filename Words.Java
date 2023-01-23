public class Words
{
    protected static final int NUMBER = 0;
    protected static final int PRONOUN = 1;
    protected static final int NOUN = 2;
    protected static final int ADJECTIVE = 3;
    protected static final int VERB = 4;
    protected static final int ADVERB = 5;
    protected static final int UMBRELLA = 6;

    protected static final int ONSET = 0;
    protected static final int VOWEL = 1;
    protected static final int MIDCONST = 2;
    protected static final int KEYMID = 3;
    protected static final int CODA = 3;
    protected static final int ENDKEY = 5;

    protected static final int[] a0_pattern = {ENDKEY};
    protected static final int[] n0_pattern = {KEYMID, CODA};
    protected static final int[] a1_pattern = {ONSET, ENDKEY};
    protected static final int[] v0_pattern = {KEYMID, MIDCONST, ENDKEY};
    protected static final int[] v1_pattern = {ONSET, KEYMID, MIDCONST, ENDKEY};
    protected static final int[] v2_pattern = {VOWEL, MIDCONST, KEYMID, MIDCONST, ENDKEY};
    protected static final int[] v3_pattern = {ONSET, VOWEL, MIDCONST, KEYMID, MIDCONST, ENDKEY};
    protected static final int[] n1_pattern = {ONSET, KEYMID, CODA};
    protected static final int[] n2_pattern = {VOWEL, MIDCONST, KEYMID, CODA};
    protected static final int[] n3_pattern = {ONSET, VOWEL, MIDCONST, KEYMID, CODA};
    protected static final int[] a2_pattern = {VOWEL, MIDCONST, ENDKEY};
    protected static final int[] a3_pattern = {KEYMID, MIDCONST, VOWEL};
    protected static final int[] a4_pattern = {ONSET, VOWEL, MIDCONST, ENDKEY};
    protected static final int[] a5_pattern = {ONSET, KEYMID, MIDCONST, VOWEL};
    protected static final int[] a6_pattern = {VOWEL, MIDCONST, VOWEL, MIDCONST, ENDKEY};
    protected static final int[] a7_pattern = {VOWEL, MIDCONST, KEYMID, MIDCONST, VOWEL};
    protected static final int[] a8_pattern = {CODA, VOWEL, MIDCONST, VOWEL, MIDCONST, ENDKEY};
    protected static final int[] a9_pattern = {CODA, VOWEL, MIDCONST, KEYMID, MIDCONST, VOWEL};


    protected static final int[][] Verb_Pattern = {v0_pattern, v1_pattern, v2_pattern, v3_pattern};
    protected static final int[][] Noun_Pattern = {n0_pattern, n1_pattern, n2_pattern, n3_pattern};
    protected static final int[][] Alt_Pattern = {a0_pattern, a1_pattern, a2_pattern, a3_pattern, a4_pattern, 
                                                  a5_pattern, a6_pattern, a7_pattern, a8_pattern, a9_pattern, 
                                                  v0_pattern, v1_pattern, v2_pattern, v3_pattern, 
                                                  n0_pattern, n1_pattern, n2_pattern, n3_pattern};
    public Words()
    {

    }
}