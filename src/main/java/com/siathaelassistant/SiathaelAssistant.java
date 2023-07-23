/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023 
 * 
 * This class serves as the main entry point for the Siathael language generator.
 * It presents a menu to the user and executes the chosen functionality.
 * 
 * The user can choose to:
 * 0) Batch build words
 * 1) Build individual words
 * 2) Build sentences
 * 3) Batch build preset sentences
 * 
 * After executing the chosen functionality, the user is asked if they want to continue.
 * If they choose to continue, the menu is presented again.
 */

package com.siathaelassistant;
public class  SiathaelAssistant
{
  // Prompt to ask the user what they want to generate
  private static final String helper_prompt = "Do you want to\n0) Batch Build Words?\n1) Build Words?\n2) Build Sentences?\n3) Batch Build Preset Sentences?";
  // The valid input options for the helper to be selected.
  private static final int[] helper_range = {0, 3};
  // Prompt to ask the user if they want to keep going with building things
  private static final String more_time_prompt = "Would you like to build more?\n1) Yes\n2) No";

  public enum MenuOption 
  {
    BATCH_BUILD_WORDS,
    BUILD_WORDS,
    BUILD_SENTENCES
  }
  
  /**
   * The main method for the SiathaelAssistant class.
   * It presents a menu to the user and executes the chosen functionality.
   * After executing the chosen functionality, the user is asked if they want to continue.
   * If they choose to continue, the menu is presented again.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) 
  {
      int helperSelection;
      boolean moreTime = true;
      while(moreTime)
      {
          // Get the user's choice
          helperSelection = SUI.ValidateInt(helper_range, helper_prompt);
          // Execute the chosen functionality
          while (true) {
              switch (MenuOption.values()[helperSelection]) 
              {
                  case BATCH_BUILD_WORDS:
                      WordHelper.batchHelperLoop();  // Batch build words
                      break;
                  case BUILD_WORDS:
                      WordHelper.helperLoop();  // Build individual words
                      break;
                  case BUILD_SENTENCES:
                      SentenceHelper.helperLoop();  // Build sentences
                      break;
                  default:
                      SentenceHelper.BatchBuild();  // Batch build preset sentences
                      break;
              }
              break;
          }
          // Ask the user if they want to continue
          moreTime = SUI.ValidateAgreement(more_time_prompt);
      }
  }
}
