/**
 * Author: Keira Pendragon
 * Date: 7/25/2023
 * 
 * An object class for storing information for generating clusters of consonants 
 * based on their position within the word and their phonetic properties
 */

package com.siathaelassistant;

public class Consonant 
{
    // What letter this actually is.
    private String phenome;
    // voiceless, voiced or 'neutral'
    private int flavor;
    // whether the letter can appear on its own in the 
    // onset of a word
    private boolean allowed_in_onset;
    // middle of a word
    private boolean allowed_in_mid;
    // coda of a word
    private boolean allowed_in_coda;

    // what letters are able to be used following this letter in the 
    // onset of a word
    private String [] allowed_before_in_onset;
    // middle of a word
    private String [] allowed_before_in_mid;
    // coda of a word
    private String [] allowed_before_in_coda;

    
    /**
     * Constructor for consnants
     * @param letter
     * @param flavour
     * @param allowed_clusters
     * @param onset
     * @param midWord
     * @param coda
     */
    public Consonant(String letter, int flavour, boolean [] allowed_clusters, String [] onset, String [] midWord, String [] coda)
    {
        phenome = (letter.length() > 0)? letter : " ";
        flavor = flavour;
        if (allowed_clusters == null || allowed_clusters.length != 3) 
        {
            allowed_in_onset = false;
            allowed_in_mid = false;
            allowed_in_coda = false;
        } 
        else 
        {
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

    public String Phenome()
    {
        return phenome;
    }

    public int Flavor()
    {
        return flavor;
    }

/********************************************************************************************
 * Randomly select one of the letters that can follow this letter in a word based on location
 ********************************************************************************************/


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
