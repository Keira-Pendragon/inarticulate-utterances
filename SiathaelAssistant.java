/**
 * .java
 * Author: Keira Pendragon
 * Author Date: 1/22/2023
 * 
 * 
 */

public class  SiathaelAssistant
{
  // To ask the user what they want to generate
  private static final String helper_prompt = "Do you want to\n1) Build words?\n2) Build Sentences?\n3) Batch Build Preset Sentences?";
  private static final int[] helper_range = {1, 3};
  // To ask the user if they want to keep going with building things.
  private static final String more_time_prompt = "Would you like to build more?\n1) Yes\n2) No";

  public static void main(String[] args) 
  {
    int helperSelection;
    boolean moreTime = true;
    while(moreTime)
    {
      helperSelection = SUI.ValidateInt(helper_range, helper_prompt);
      if(helperSelection == 1)
      {
        WordHelper.helperLoop();
      }
      else if (helperSelection == 2)
      {
        SentenceHelper.helperLoop();
      }
      else
      {
        SentenceHelper.BatchBuild();
      }

      moreTime = SUI.ValidateAgreement(more_time_prompt);
    }
  }
}
