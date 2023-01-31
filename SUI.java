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

    private static final int MINDEX = 0;
    private static final int MAXDEX = 1;
    private static final int MAXDIGITS = 36;
    //private static final int MAXMIXEDDIGITS = MAXDIGITS * 2;
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
        selectionPrompt(request);
        int input = getIntifiedUserInput();
        return (input >= range[MINDEX] && input <= range[MAXDEX]) ? input : (input > range[MINDEX]) ? range[MINDEX] : range[MAXDEX];
    }
    /**
     * 
     */
    public static int ValidateIndex(int [] range, String request)
    {
        selectionPrompt(request);
        int input = getIntifiedUserInput() - 1;
        return (input >= range[MINDEX] && input <= range[MAXDEX]) ? input : (input > range[MINDEX]) ? range[MINDEX] : range[MAXDEX];
    }

    /**
     * 
    */
    public static String ValidateB12(String prompt)
    {
        SUI.displayTextLn(prompt);
        String input = getUserInput();
        char c;
        String validatedB12 = "";
        int whole = 0;
        int spare = 0;
        boolean foundDel = false;
        int delLoc = -1;
        for(int i = 0; i < input.length(); i++)
        {
            c = input.charAt(i);
            if(c >= '0' && c <= '9')
            {
                validatedB12 += c;
                whole += (!foundDel && whole < MAXDIGITS) ? 1 : 0;
                spare += (foundDel && spare < MAXDIGITS) ? 1 : 0;
            }
            else if(c == 'A' || c == 'a')
            {
                validatedB12 += 'A';
                whole += (!foundDel && whole < MAXDIGITS) ? 1 : 0;
                spare += (foundDel && spare < MAXDIGITS) ? 1 : 0;
            }
            else if(c == 'B' || c == 'b')
            {
                validatedB12 += 'B';
                whole += (!foundDel && whole < MAXDIGITS) ? 1 : 0;
                spare += (foundDel && spare < MAXDIGITS) ? 1 : 0;
            }
            else if(c == '/' || c == '.' && !foundDel && (i != (input.length() -1)))
            {
                foundDel = true;
                delLoc = i;
                validatedB12 += c + "";
            }
            else if(c == ',')
            {

            }
            else
            {
                errorMessage(base12_error_message, (c + ""), (c < 0) ? "0": "B");
                validatedB12 += (c < 0) ? '0': 'B';
            }
        }
        validatedB12 = snipErrantZeros(validatedB12, delLoc);
        return validatedB12;
    }

    public static String trimString(String s, int min, int max)
    {
        return s.substring(min, max);
    }

    private static String snipErrantZeros(String review, int delLoc)
    {
        String wholeVal = "";
        String spareVal = "";
        boolean done = false;

        int step = -1;
        char c;
        boolean foundGood = false;
        while(step < review.length() && !done)
        {
            step++;
            c = review.charAt(step);
            if(c != '0' || foundGood)
            {
                wholeVal += c;
                foundGood = true;
            }
            if(c == '/' || c == '.' )
            {
                done = true;
            }            
        }
        foundGood = false;
        int spare = review.length();
        while(spare > step)
        {
            spare--;
            c = review.charAt(spare);
            if(c != 0 || foundGood)
            {
                spareVal += c;
                foundGood = true;
            }
        }
        return wholeVal + spareVal;
    }


    public static boolean ValidateAgreement(String prompt)
    {
        selectionPrompt(prompt);
        String input = getUserInput();
        return userAgrees(input);         
    }

    private static boolean userAgrees(String input)
    {
        return (match(input, "yes") || match(input, "y") || match(input, "1"));
    }

    private static boolean match(String input, String check)
    {
        return input.compareToIgnoreCase(check) == 0;
    }

    /**
     * 
    */
    private static void errorMessage(String expected, String input, String resolution)
    {
        displayTextLn("Error expected " + expected + ". Received " + input + ". Resolving to " + resolution);
    }


    /**
     * 
    */
    public static void displayTextLn(String display)
    {
        System.out.println(display);
    }
    
    /**
     * 
    */
    public static void selectionPrompt(String display)
    {
        System.out.print("\n" + display + selection_prompt);
    }
}
