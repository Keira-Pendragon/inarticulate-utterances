/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

import java.util.ArrayList;


public class Sentence
{
    private ArrayList<Word> word_list;
    private int word_count;
    /**
     * 
     */
    public Sentence()
    {
        word_list = new ArrayList<Word>();
        word_count = 0;
    }

    /**
     * 
     * @param aWord
     */
    public void addWord(Word aWord) 
    {
        word_list.add(aWord);
        word_count++;
    }

    /**
     * 
     * @param which
     * @return
     */
    public Word fetchWord(int which)
    {
        if(word_count > which - 1)
        {
            return word_list.get(which);
        }
        else
        {
            return new Word();
        }
    }

    /**
     * 
     * @return
     */
    public int wordCount()
    {
        return word_count;
    }

}