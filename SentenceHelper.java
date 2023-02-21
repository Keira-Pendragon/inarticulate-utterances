/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

public class SentenceHelper extends WordHelper
{
  private static final int IDEA = 0;
  private static final int THING = 1;
  private static final int ENTITY = 2;
  private static final int PLACE = 3;
  private static final int FILLER = 4;
  private static final int TRAIT = 5;

  private static final int NONPOSS = 0;
  private static final int PARTOF = 1;
  private static final int CLOSETO = 2;
  private static final int OWNS = 3;
  private static final int DIMINTO = 4;
  private static final int TENUOUS = 5;

  private static final int ITHIS = 0;
  private static final int YOU = 1;
  private static final int WEBOTH = 2;
  private static final int THEYTHAT = 3;

  private static final int WISH = 0;
  private static final int DIRECT = 1;
  private static final int INTENTIONAL = 2;
  private static final int PASSIVE = 3;
  private static final int INVOL = 4;

  private static final int TIMELESS = 0;
  private static final int PAST = 1;
  private static final int PRESENT = 2;
  private static final int FUTURE = 3;

  private static final int SINGULAR = 0;
  private static final int PLURAL = 1;  

  private static final int[] sentence_count_range = {1, 500};
  
  private static final int[] word_count_range = {1, 15};
  // Range for sentence options, extends past necessity so that I won't have to increment for awhile if I add more options!
  private static final int[] batch_set_range = {1, 20};

  private static final String sentence_count_prompt = "How many sentences of this type would you like?\n(limit 500)";
  private static final String word_count_prompt = "How many words should be in the sentence?\n(limit 15)";
  private static final String batch_set_prompt = "Choose a Sentence to imitate\n" 
                                      + "1) The cat ran quickly up the tree.\n"
                                      + "2) I can hear you.\n" 
                                      + "3) Did your sister(s) go to the store for groceries?\n"
                                      + "4) Their cat's eyes will see our boss(es)' messy desk.\n"
                                      + "5) Go sit over there.\n"
                                      + "6) Did you want to go to the show later?\n"
                                      + "7) Hunting down dinner.\n"
                                      + "8) It is, perhaps, not as strange as you might think.\n"
                                      + "#) Do you want to break your sister(s)' things?";



  private static final int[] RANDOMINTARRAY  = {-1, -1};
  private static final int RANDOM = -1;

  
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
        SUI.displayTextLn(buildSentence(sayWhat) + ((which >= NOUN && which <= ADHESIVE) ? "" : ".") + "\n");
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
        sayWhat.addWord(AddNoun(ENTITY, THING, SINGULAR, NONPOSS));
        sayWhat.addWord(AddVerb(INTENTIONAL, PAST));
        sayWhat.addWord(ADVERB);
        sayWhat.addWord(ADVERB);
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(AddNoun(THING, PLACE, SINGULAR, NONPOSS));
        break;
      case 2: // I am able to hear you.
        sayWhat.addWord(AddPronoun(ENTITY, ENTITY, NONPOSS, ITHIS, SINGULAR, 1));
        sayWhat.addWord(AddVerb(PASSIVE, PRESENT));
        sayWhat.addWord(ADJECTIVE);
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(AddVerb(PASSIVE, TIMELESS));
        sayWhat.addWord(AddPronoun(ENTITY, ENTITY, NONPOSS, YOU, RANDOM, 1));
        break; 
      case 3: // Did your sister(s) go to the store for groceries? // TODO Add question words o___o
        sayWhat.addWord(AddVerb(PASSIVE, PAST));
        sayWhat.addWord(AddPronoun(ENTITY, ENTITY, CLOSETO, YOU, RANDOM, 1));
        sayWhat.addWord(AddNoun(ENTITY, ENTITY, RANDOM, NONPOSS));
        sayWhat.addWord(AddVerb(INTENTIONAL, PAST));
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(AddNoun(PLACE, THING, SINGULAR, NONPOSS));
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(AddNoun(THING, FILLER, PLURAL, NONPOSS));
        break;
      case 4: // Their cat's eyes will see our boss(es)' messy desk.
        sayWhat.addWord(AddPronoun(ENTITY, IDEA, OWNS, THEYTHAT, RANDOM, 1));
        sayWhat.addWord(AddNoun(ENTITY, THING, SINGULAR, PARTOF));
        sayWhat.addWord(AddNoun(THING, ENTITY, RANDOM, NONPOSS));
        sayWhat.addWord(AddVerb(PASSIVE, FUTURE));
        sayWhat.addWord(AddPronoun(PLACE, TRAIT, DIMINTO, ITHIS, RANDOM, RANDOM));
        sayWhat.addWord(AddNoun(ENTITY, IDEA, RANDOM, RANDOM));
        sayWhat.addWord(ADJECTIVE);
        sayWhat.addWord(AddNoun(THING, PLACE, RANDOM, RANDOM));
        break;
      case 5: // Go sit over there.
        sayWhat.addWord(AddVerb(DIRECT, PRESENT));
        sayWhat.addWord(ADVERB);
        sayWhat.addWord(AddPronoun(PLACE, PLACE, NONPOSS, THEYTHAT, SINGULAR, 1));
        break;
      case 6: //Did you want to go to the show later?
        sayWhat.addWord(AddVerb(PASSIVE, TIMELESS));
        sayWhat.addWord(AddPronoun(ENTITY, ENTITY, NONPOSS, YOU, RANDOM, 1));
        sayWhat.addWord(AddVerb(PASSIVE, TIMELESS));
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(AddVerb(INTENTIONAL, TIMELESS));
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(AddNoun(PLACE, IDEA, SINGULAR, NONPOSS));
        sayWhat.addWord(ADVERB);
        break;
      case 7: // Hunting down Dinner.
        sayWhat.addWord(AddVerb(INTENTIONAL, PRESENT));
        sayWhat.addWord(ADVERB);
        sayWhat.addWord(AddNoun(THING, ENTITY, RANDOM, NONPOSS));
        break;
      case 8: // It is, perhaps, not as strange as you might think.
        sayWhat.addWord(AddPronoun(IDEA, THING, NONPOSS, ITHIS, SINGULAR, 1));
        sayWhat.addWord(AddVerb(PASSIVE, PRESENT));
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(ADVERB);
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(ADJECTIVE);
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(AddPronoun(ENTITY, ENTITY, NONPOSS, YOU, RANDOM, 1));
        sayWhat.addWord(ADVERB);
        sayWhat.addWord(AddVerb(PASSIVE, PRESENT));
        break;
      default: // Do you want to break your sister(s)' things?
        sayWhat.addWord(AddVerb(PASSIVE, FUTURE));
        sayWhat.addWord(AddPronoun(ENTITY, ENTITY, NONPOSS, YOU, RANDOM, 1));
        sayWhat.addWord(AddVerb(WISH, TIMELESS));
        sayWhat.addWord(ADHESIVE);
        sayWhat.addWord(AddVerb(INVOL, FUTURE));
        sayWhat.addWord(AddPronoun(ENTITY, ENTITY, TENUOUS, WEBOTH, RANDOM, 1));
        sayWhat.addWord(AddNoun(RANDOM, RANDOM, RANDOM, PARTOF));
        sayWhat.addWord(AddNoun(RANDOM, RANDOM, RANDOM, NONPOSS));
        break;
    }
    return sayWhat;
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
      sayThis+= (i + 1 == sayWhat.wordCount()) ? "" : " ";
    }
    return sayThis;
  }
}
