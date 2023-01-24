/**
 * SUI.java
 * Custom interface management to unify the process across all Siathael classes
 * 
 * Author: Keira Pendragon
 * Author Date: 1/14/2023
 */

 import java.util.Scanner;

 public class SUI 
 {
 
    private static final int MIN = 0;
    private static final int MAX = 1;
     /**
      * 
      */
     private static Scanner myScanner = new Scanner(System.in);
     // Added to the end of every selection making prompt
     private static String selection_prompt = "\nSelection:";
     /**
      * 
      */
     private static String base12_error_message = "0 - 9, A/a, B/b, '/',  '.' or ','";
     /**
      * 
      */
     private static String base10_error_message = "a digit value between 0 and 9";
 
     public SUI()
     {
 
     }
     /**
      * getUserInput() Single method for extracting user input in a consistent way
      * Sanitize elsewhere.
      * @return the line of user input acquired.
      */
     public static String getUserInput()
     {
         return myScanner.nextLine();
     }
 
     /**
      * Collect and convert user input to int.
      * @return
      */
     public static int getIntifiedUserInput()
     {
         String intMe = getUserInput();
         int intified = 0;
         char c;
         for(int i = 0; i < intMe.length(); i++)
         {
             c = intMe.charAt(i);
             if(c >= '0' && c <= '9')
             {
                 intified = (intified * 10) + (c - '0');
             }
             else
             {
                 errorMessage(base10_error_message, (c + ""), (c < 0) ? "0" : "9");
                 intified = (intified * 10) + ((c < 0) ? 0 : 9);
             }
         }
         return intified;
     }   
 
     /**
      * 
      */
     public static int ValidateInt(int [] range, String request)
     {
         displayText(request + selection_prompt);
         int input = getIntifiedUserInput();
         return (input >= range[MIN] && input <= range[MAX]) ? input : (input > range[MIN]) ? range[MIN] : range[MAX];
     }
    /**
     * 
     */
    public static int ValidateIndex(int [] range, String request)
    {
        displayText(request + selection_prompt);
        int input = getIntifiedUserInput();
        return (input >= range[MIN] && input <= range[MAX]) ? input : (input > range[MIN]) ? range[MIN] : range[MAX];
    }
 
     /**
      * 
      */
     public static String ValidateB12()
     {
         String input = getUserInput();
         char c;
         String validatedB12 = "";
         for(int i = 0; i < input.length(); i++)
         {
             c = input.charAt(i);
             if(c >= '0' && c <= '9' || c == ',' || c == '/' || c == '.')
             {
                 validatedB12 += c;
             }
             else if(c == 'A' || c == 'a')
             {
                 validatedB12 += 'A';
             }
             else if(c == 'B' || c == 'b')
             {
                 validatedB12 += 'B';
             }
             else
             {
                 errorMessage(base12_error_message, (c + ""), (c < 0) ? "0": "B");
                 validatedB12 += (c < 0) ? '0': 'B';
             }
         }
         return validatedB12;
     }
  
     public static boolean ValidateAgreement(String prompt)
     {
        displayText(prompt);
        String input = getUserInput();
        return (input == "1" || input == "yes");         
     }
 
     /**
      * 
      */
     private static void errorMessage(String expected, String input, String resolution)
     {
         displayText("Error expected " + expected + ". Received " + input + ". Resolving to " + resolution);
     }

 
     /**
      * 
      */
     public static void displayText(String display)
     {
         System.out.println(display);
     }
 }
