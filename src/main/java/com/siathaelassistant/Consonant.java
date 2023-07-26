package com.siathaelassistant;

public class Consonant 
{
    private boolean allowed_in_onset;
    private boolean allowed_in_mid;
    private boolean allowed_in_coda;
    private String [] allowed_before_in_onset;
    private String [] allowed_before_in_mid;
    private String [] allowed_before_in_coda;

    public Consonant(boolean [] allowed_clusters, String [] onset, String [] midWord, String [] coda)
    {
        if (allowed_clusters == null || allowed_clusters.length != 3) {
            allowed_in_onset = false;
            allowed_in_mid = false;
            allowed_in_coda = false;
        } else {
            allowed_in_onset = allowed_clusters[0];
            allowed_in_mid = allowed_clusters[1];
            allowed_in_coda = allowed_clusters[2];
        }

        allowed_before_in_onset = (onset == null || onset.length == 0) ? new String[] {" "} : onset;
        allowed_before_in_mid = (midWord == null || midWord.length == 0) ? new String[] {" "} : midWord;
        allowed_before_in_coda = (coda == null || coda.length == 0) ? new String[] {" "} : coda;
    }

    public boolean isAllowedOnset()
    {
        return allowed_in_onset;
    }

    public boolean isAllowedMid()
    {
        return allowed_in_mid;
    }

    public boolean isAllowedCoda()
    {
        return allowed_in_coda;
    }

    public String randomOnsetFollower()
    {
        int randomIndex = Dice.rand(0, allowed_before_in_onset.length - 1);
        return allowed_before_in_onset[randomIndex];
    }

    public String randomMidFollower()
    {
        int randomIndex = Dice.rand(0, allowed_before_in_mid.length - 1);
        return allowed_before_in_mid[randomIndex];
    }

    public String randomCodaFollower()
    {
        int randomIndex = Dice.rand(0, allowed_before_in_coda.length - 1);
        return allowed_before_in_coda[randomIndex];
    }

}
