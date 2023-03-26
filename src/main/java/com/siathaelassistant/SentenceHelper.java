/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */
package com.siathaelassistant;
public class SentenceHelper extends WordHelper
{
  private static final int[] sentence_count_range = {1, 500};

  private static final int[] word_count_range = {1, 15};
  // Range for sentence options, extends past necessity so that I won't have to increment for awhile if I add more options!
  private static final int[] batch_set_range = {0, 20};

  private static final String sentence_count_prompt = "How many sentences of this type would you like?\n(limit 500)";
  private static final String word_count_prompt = "How many words should be in the sentence?\n(limit 15)";
  private static final String batch_set_prompt = "Choose a Sentence to imitate\n" 
                                      + "0) Surprise Me!\n"
                                      + "1) The cat ran quickly up the tree.\n"
                                      + "2) I can hear you.\n" 
                                      + "3) Did your sister(s) go to the store for groceries?\n"
                                      + "4) Their cat's eyes will see our boss(es)' messy desk.\n"
                                      + "5) Go sit over there.\n"
                                      + "6) Did you want to go to the show later?\n"
                                      + "7) Hunting down dinner.\n"
                                      + "8) It is, perhaps, not as strange as you might think.\n"
                                      + "9) Do you want to break your sister(s)' things?";


  
  public SentenceHelper()
  {

  }

  /**
   * 
   */
  public static void helperLoop()
  {
    boolean onceMore = true;
    int sentenceCount;
    Sentence sayWhat;
    while(onceMore)
    {
      sayWhat = detailSentence();
      sentenceCount = SUI.ValidateInt(sentence_count_range, sentence_count_prompt);
      for(int i = 0; i < sentenceCount; i++)
      {
        SUI.displayTextLn(buildSentence(sayWhat) + ".\n");
      }
      SUI.displayTextLn("Sentence batch Complete.");
      onceMore = SUI.ValidateAgreement("Would you like to build more sentences?\n1) yes\n2) No");
    }
  }

  public static int getBatchType()
  {
    return SUI.ValidateInt(batch_set_range, batch_set_prompt);
  }


  public static void BatchBuild()
  {
    int which;
    boolean onceMore = true;
    int sentenceCount = 500;
    Sentence sayWhat;

    while(onceMore)
    {
      which = SentenceHelper.getBatchType();
      sayWhat = BatchSentence(which);
      for(int i = 0; i < sentenceCount; i++)
      {
        SUI.displayTextLn(buildSentence(sayWhat) + ".");
      }
      SUI.displayTextLn("Sentence batch Complete.");
      onceMore = SUI.ValidateAgreement("Would you like to build more sentences?\n1) yes\n2) No");
    }
  }

  /**
   * 
   * @return
   */
  private static Sentence detailSentence()
  {
    int wordCount = SUI.ValidateInt(word_count_range, word_count_prompt);
    Sentence sayWhat = new Sentence();
    for(int i = 0; i < wordCount; i++)
    {
      sayWhat.addWord(detailWord());
    }
    return sayWhat;
  }

  private static Sentence BatchSentence(int which)
  {
    Sentence sayWhat = new Sentence();
    switch (which) {
      case 1: // Cat clambered quickly up the tree.
        sayWhat.addWord(AddNoun(ENTITY, THING, SINGULAR, NONPOSSESSIVE));
        sayWhat.addWord(AddVerb(DELIBERATELY, PAST));
        sayWhat.addWord(ADVERB);
        sayWhat.addWord(ADVERB);
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(AddNoun(THING, PLACE, SINGULAR, NONPOSSESSIVE));
        break;
      case 2: // I am able to hear you.
        sayWhat.addWord(AddPronoun(ENTITY, ENTITY, NONPOSSESSIVE, ITHIS, SINGULAR, 1));
        sayWhat.addWord(AddVerb(PASSIVELY, PRESENT));
        sayWhat.addWord(ADJECTIVE);
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(AddVerb(PASSIVELY, TIMELESS));
        sayWhat.addWord(AddPronoun(ENTITY, ENTITY, NONPOSSESSIVE, YOU, RANDOM, 1));
        break; 
      case 3: // Did your sister(s) go to the store for groceries?
        sayWhat.addWord(AddPronoun(ENTITY, ENTITY, CLOSETO, YOU, RANDOM, 1));
        sayWhat.addWord(AddNoun(ENTITY, ENTITY, RANDOM, NONPOSSESSIVE));
        sayWhat.addWord(AddQuery(true));
        sayWhat.addWord(AddVerb(DELIBERATELY, PAST));
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(AddNoun(PLACE, THING, SINGULAR, NONPOSSESSIVE));
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(AddNoun(THING, FILLER, PLURAL, NONPOSSESSIVE));
        break;
      case 4: // Their cat's eyes will see our boss(es)' messy desk.
        sayWhat.addWord(AddPronoun(ENTITY, IDEA, OWNS, THEYTHAT, RANDOM, 1));
        sayWhat.addWord(AddNoun(ENTITY, THING, SINGULAR, PARTOF));
        sayWhat.addWord(AddNoun(THING, ENTITY, RANDOM, NONPOSSESSIVE));
        sayWhat.addWord(AddVerb(PASSIVELY, FUTURE));
        sayWhat.addWord(AddPronoun(PLACE, TRAIT, DIMINUATIVETO, ITHIS, RANDOM, RANDOM));
        sayWhat.addWord(AddNoun(ENTITY, IDEA, RANDOM, RANDOM));
        sayWhat.addWord(ADJECTIVE);
        sayWhat.addWord(AddNoun(THING, PLACE, RANDOM, RANDOM));
        break;
      case 5: // Go sit over there.
        sayWhat.addWord(AddVerb(DIRECTIVE, PRESENT));
        sayWhat.addWord(ADVERB);
        sayWhat.addWord(AddPronoun(PLACE, PLACE, NONPOSSESSIVE, THEYTHAT, SINGULAR, 1));
        break;
      case 6: //Did you want to go to the show later?
        sayWhat.addWord(AddPronoun(ENTITY, ENTITY, NONPOSSESSIVE, YOU, RANDOM, 1));
        sayWhat.addWord(AddQuery(true));
        sayWhat.addWord(AddVerb(PASSIVELY, TIMELESS));
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(AddVerb(DELIBERATELY, TIMELESS));
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(AddNoun(PLACE, IDEA, SINGULAR, NONPOSSESSIVE));
        sayWhat.addWord(ADVERB);
        break;
      case 7: // Hunting down Dinner.
        sayWhat.addWord(AddVerb(DELIBERATELY, PRESENT));
        sayWhat.addWord(ADVERB);
        sayWhat.addWord(AddNoun(THING, ENTITY, RANDOM, NONPOSSESSIVE));
        break;
      case 8: // It is, perhaps, not as strange as you might think.
        sayWhat.addWord(AddPronoun(IDEA, IDEA, NONPOSSESSIVE, ITHIS, SINGULAR, 1));
        sayWhat.addWord(AddVerb(PASSIVELY, PRESENT));
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(AddNegation(false, 1));
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(ADJECTIVE);
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(AddPronoun(ENTITY, ENTITY, NONPOSSESSIVE, YOU, RANDOM, 1));
        sayWhat.addWord(ADVERB);
        sayWhat.addWord(AddVerb(PASSIVELY, PRESENT));
        break;
      case 9:
        sayWhat.addWord(AddPronoun(ENTITY, ENTITY, NONPOSSESSIVE, YOU, RANDOM, 1));
        sayWhat.addWord(AddDoubt(true));
        sayWhat.addWord(AddVerb(WISH, TIMELESS));
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(AddVerb(INVOLUNTARILY, FUTURE));
        sayWhat.addWord(AddPronoun(ENTITY, ENTITY, TENUOUSLYLINKED, WEBOTH, RANDOM, 1));
        sayWhat.addWord(AddNoun(RANDOM, RANDOM, RANDOM, PARTOF));
        sayWhat.addWord(AddNoun(RANDOM, RANDOM, RANDOM, NONPOSSESSIVE));
      default: // Do you want to break your sister(s)' things?
        sayWhat = weightedRandomSentence(sayWhat);
        break;
    }
    return sayWhat;
  }

  private static Sentence weightedRandomSentence(Sentence sayWhat)
  {
    int w = Dice.weight();
    // weighted randomization for the number of words in the sentence.
    int wordCount = (w < 60)? (Dice.rand(3, 7)) : (w < 97)? ((Dice.coinToss())? 2 : 8) : (w < 99)? Dice.rand(9, 12) : 1;
    for(int i = 0; i < wordCount; i++)
    {
      sayWhat.addWord(weightedRandomWord());
    }
    return sayWhat;
  }

  private static Word weightedRandomWord()
  {
    int weight = Dice.weight(144);
    int selection = (weight < 5)? NUMBER : (weight < 20)? PRONOUN : (weight < 25)? NEGATION :
                    (weight < 35)? QUERY : (weight < 50)? ADJECTIVE : (weight < 65)? ADVERB :
                    (weight < 80)? ADHESIVE : (weight < 110)? VERB : NOUN;
    Word w;
    switch (selection) {
      case NUMBER:        
        w = weightedDigitCount();
        break;
      case PRONOUN:
        w = weightedPronoun();
        break;
      case NOUN:
        w = weightedNoun();
        break;
      case VERB:
        w = weightedVerb();
        break;
      case ADJECTIVE:
        w = new Word(ADJECTIVE, RANDOMINTARRAY, RANDOM, weightedStyle(Dice.weight()));
        break;
      case ADVERB:
        w = new Word(ADVERB, RANDOMINTARRAY, RANDOM, weightedStyle(Dice.weight()));
        break;
      case ADHESIVE:
        w = new Word(ADHESIVE, RANDOMINTARRAY, RANDOM, weightedStyle(Dice.weight()));
        break;
      case QUERY:
        w = new Word(Dice.coinToss(), Dice.coinToss());
        break;
      case NEGATION:
        w = new Word(Dice.coinToss(), RANDOM);
        break;
      default:
        w = weightedRandomWord();
        break;
    }
    return w;
  }



  private static Word weightedDigitCount()
  {
    int we = Dice.weight();
        int dig = (we > 70) ? 1 : (we < 89)? 2 : (we < 99)? 3 : Dice.rand(0, 12);
    return new Word("" + RANDOM, dig);
  }

  // int genus, int mod, int singularity, int possession, int mention, int role
  private static Word weightedPronoun()
  {
    int g = weightedGenus(Dice.weight());
    int gm = weightedMod(Dice.weight());
    int s = weightedSingularity(Dice.weight());
    int p = weightedPossession(Dice.weight());
    int m = weightedMention(Dice.weight());
    int r = weightedRole(Dice.weight(), g);
    return new Word(g, gm, s, p, m, r);
  }

  private static int weightedGenus(int w)
  {
    return (w < 50)? THING : (w < 70)? PLACE : (w < 90)? IDEA : ENTITY;    
  }

  private static int weightedMod(int w)
  {
    return (w < 40)? THING : (w < 60)? IDEA : (w < 70)? ENTITY : (w < 80)? PLACE : (w < 93)? TRAIT : FILLER;
  }

  private static int weightedSingularity(int w)
  {
    return (w < 90)? SINGULAR : PLURAL;
  }

  private static int weightedPossession(int w)
  {
    return (w < 70)? NONPOSSESSIVE : (w < 60)? OWNS : (w < 75)? PARTOF : (w < 86)? CLOSETO : (w < 98)? TENUOUSLYLINKED : DIMINUATIVETO;
  }

  private static int weightedMention(int w)
  {
    return (w < 90)? 1 : (w < 98)? 2 : Dice.rand(1, 11);
  }

  private static int weightedRole(int w, int genus)
  {
    int role;
    if(genus != ENTITY)
    {
      role = (Dice.coinToss())? ITHIS : THEYTHAT;
    }
    else
    {
      role = (w < 25) ? ITHIS : (w < 50) ? YOU : (w < 75) ? WEBOTH : THEYTHAT;
    }

    return role;
  }

  
  private static int weightedMood(int w)
  {
    return (w < 10) ? WISH : (w < 20) ? DIRECTIVE :
           (w < 55) ? DELIBERATELY : (w < 85) ? PASSIVELY : INVOLUNTARILY;
  }

  private static int weightedTense(int w)
  {
    return (w < 25) ? TIMELESS : (w < 50) ? PAST :
           (w < 75) ? PRESENT : FUTURE;
  }

  private static int weightedStyle(int w)
  {
    return (w < 50)? VOICELESS : (w < 70)? NEUTRAL : (w < 85)? VOICED : RANDOM;
  }


  // int primaryGenus, int genusMod, int[] nPattern, int cLength, int nSingular, int nPossessive, int style
  private static Word weightedNoun()
  {
    int g = weightedGenus(Dice.weight());
    int gm = weightedMod(Dice.weight());
    int[] pa = RANDOMINTARRAY;
    int l = RANDOM;
    int sin = weightedSingularity(Dice.weight());
    int po = weightedPossession(Dice.weight());
    int st = weightedStyle(Dice.weight());
    return new Word(g, gm, pa, l, sin, po, st);
  }

  // int mood, int tense, int[] vPattern, int cLength, int cStyle
  private static Word weightedVerb()
  {
    int m = weightedMood(Dice.weight());
    int t = weightedTense(Dice.weight());
    int s = weightedStyle(Dice.weight());
    return new Word(m, t, RANDOMINTARRAY, RANDOM, s);
  }

  private static Word AddNegation(boolean negativeConnotation, int degree)
  {
    return new Word(negativeConnotation, degree);
  }

  private static Word AddDoubt(boolean wordPart)
  {
    return new Word(true, wordPart);
  }
  
  private static Word AddQuery(boolean wordPart)
  {
    return new Word(false, wordPart);
  }

  private static Word AddNoun(int genus, int mod, int singular, int possessiveness)
  {
    return new Word(genus, mod, RANDOMINTARRAY, RANDOM, singular, possessiveness, RANDOM);
  }

  private static Word AddVerb(int mood, int tense)
  {
    return new Word(mood, tense, RANDOMINTARRAY, RANDOM, RANDOM);
  }

  private static Word AddPronoun(int genus, int mod, int possession, int role, int singularity, int mention)
  {
    return new Word(genus, mod, singularity, possession, mention, role);
  }

  /**
   * 
   * @param sayWhat
   * @return
   */
  private static String buildSentence(Sentence sayWhat)
    {
    String sayThis = "";
    for(int i = 0; i < sayWhat.wordCount(); i++)
    {
      sayThis+= fetchWord(sayWhat.fetchWord(i));
      sayWhat.fetchWord(i).refreshWord();      
      sayThis+= (sayWhat.fetchWord(i).Type() == QUERY || (i + 1 == sayWhat.wordCount())) ? "" : " ";
    }
    return sayThis;
  }
}
