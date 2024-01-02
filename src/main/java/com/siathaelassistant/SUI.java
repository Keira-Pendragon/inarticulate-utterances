/**
 * SUI.java
 * Custom interface management to unify the process across all Siathael classes
 * 
 * Author: Keira Pendragon
 * Author Date: 1/14/2023
 */
package com.siathaelassistant;
import java.util.Scanner;

public class SUI extends SDef
{
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

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_DARK_ORANGE = "\u001B[38;5;166m"; // Closest to Dark Orange 1
    private static final String ANSI_DARK_GREEN = "\u001B[32m"; // Dark Green 1
    private static final String ANSI_DARK_CYAN = "\u001B[36m"; // Dark Cyan 1
    private static final String ANSI_DARK_BLUE = "\u001B[34m"; // Dark Blue 1
    private static final String ANSI_DARK_PURPLE = "\u001B[38;5;54m"; // Closest to Dark Purple 1
    private static final String ANSI_DARK_MAGENTA = "\u001B[38;5;162m"; // Dark Magenta 1
    private static final String ANSI_PINK = "\u001B[38;5;213m"; // Pink
    private static final String ANSI_YELLOW = "\u001B[38;5;220m"; // Yellow
  
    private static final String[] Ansi_Colorizer = {ANSI_RESET, ANSI_DARK_PURPLE, ANSI_DARK_BLUE, ANSI_DARK_CYAN, ANSI_DARK_MAGENTA, ANSI_DARK_GREEN, ANSI_DARK_ORANGE, ANSI_PINK, ANSI_YELLOW};


    private static final String HTML_RESET = "</span>";
    private static final String BLACK_COLOR = "<span style=\"color:#000000\">";
    private static final String ORANGE_COLOR = "<span style=\"color:#FF8C00\">";
    private static final String GREEN_COLOR = "<span style=\"color:#6aa84f\">";
    private static final String CYAN_COLOR = "<span style=\"color:#45818e\">";
    private static final String BLUE_COLOR = "<span style=\"color:#3d85c6\">";
    private static final String PURPLE_COLOR = "<span style=\"color:#674ea7\">";
    private static final String MAGENTA_COLOR = "<span style=\"color:#a64d79\">";
    private static final String PINK_COLOR = "<span style=\"color:#a64d79\">";
    private static final String YELLOW_COLOR = "<span style=\"color:#ff00ce\">";

    private static final String[] Colorizer = {BLACK_COLOR, PURPLE_COLOR, BLUE_COLOR, CYAN_COLOR, MAGENTA_COLOR, GREEN_COLOR, ORANGE_COLOR, PINK_COLOR, YELLOW_COLOR};
    public SUI()
    {

    }
    /**
     * 
     * @return
     */
    public static String getUserInput()
    {
        return myScanner.nextLine();
    }

    /**
     * 
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
     * @param range
     * @param request
     * @return
     */
    public static int ValidateInt(int [] range, String request)
    {
        selectionPrompt(request);
        int input = getIntifiedUserInput();
        return (input >= range[MINDEX] && input <= range[MAXDEX]) ? input : (input > range[MINDEX]) ? range[MINDEX] : range[MAXDEX];
    }
    /**
     * 
     * @param range
     * @param request
     * @return
     */
    public static int ValidateIndex(int [] range, String request)
    {
        selectionPrompt(request);
        int input = getIntifiedUserInput() - 1;
        return (input >= range[MINDEX] && input <= range[MAXDEX]) ? input : (input > range[MINDEX]) ? range[MINDEX] : range[MAXDEX];
    }

    /**
     * 
     * @param prompt
     * @return
     */
    public static String ValidateB12(String prompt)
    {
        displayTextLn(prompt);
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
            switch (c) {
                case '0': case '1': case '2': case '3': case '4': 
                case '5': case '6': case '7': case '8': case '9':
                case 'A': case 'a': case 'B': case 'b':
                    validatedB12 += Character.toUpperCase(c);
                    whole += (!foundDel && whole < MAXDIGITS) ? 1 : 0;
                    spare += (foundDel && spare < MAXDIGITS) ? 1 : 0;
                    break;
                case '/': case '.':
                    if (!foundDel && (i != (input.length() - 1))) {
                        foundDel = true;
                        delLoc = i;
                        validatedB12 += c;
                    }
                    break;
                case ',':
                    break;
                default:
                    errorMessage(base12_error_message, (c + ""), (c < 0) ? "0" : "B");
                    validatedB12 += (c < 0) ? '0' : 'B';
            }
        }
        validatedB12 = snipErrantZeros(validatedB12, delLoc);
        return validatedB12;
    }

    /**
     * 
     * @param s
     * @param min
     * @param max
     * @return
     */
    public static String trimString(String s, int min, int max)
    {
        return s.substring(min, max);
    }

    /**
     * 
     * @param review
     * @param delLoc
     * @return
     */
    private static String snipErrantZeros(String review, int delLoc)
    {
        String wholeVal = "";
        String spareVal = "";
        boolean done = false;

        int step = -1;
        char c;
        boolean foundGood = false;
        while(step < review.length() -1 && !done)
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
        int spare = review.length() -1;
        while(spare > step)
        {            
            c = review.charAt(spare);
            if(c != 0 || foundGood)
            {
                spareVal = c + spareVal;
                foundGood = true;
            }
            spare--;
        }
        if(wholeVal.isEmpty())
        {
            wholeVal+= "0";
        }

        return wholeVal + spareVal;
    }

    /**
     * 
     * @param prompt
     * @return
     */
    public static boolean ValidateAgreement(String prompt)
    {
        selectionPrompt(prompt);
        String input = getUserInput();
        return userAgrees(input);         
    }

    /**
     * 
     * @param input
     * @return
     */
    private static boolean userAgrees(String input)
    {
        return input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y") || input.equals("1");
    }


    /**
     * 
     * @param expected
     * @param input
     * @param resolution
     */
    private static void errorMessage(String expected, String input, String resolution)
    {
        displayTextLn("Error expected " + expected + ". Received " + input + ". Resolving to " + resolution);
    }

    /**
     * 
     * @param display
     */
    public static void displayTextLn(String display)
    {
        System.out.println(display);
    }
    
    /**
     * 
     * @param display
     */
    public static void selectionPrompt(String display)
    {
        System.out.print("\n" + display + selection_prompt);
    }

    public static void colorizeWord(String word, int type, String delim)
    {
        System.out.print(Ansi_Colorizer[type] + word + ANSI_RESET + delim);
    }

    public static String colorizeWord(String word, int wordType) {
        if (wordType >= 0 && wordType < Colorizer.length) {
            return Colorizer[wordType] + word + HTML_RESET;
        } else {
            return word; // If the word type is out of the range of the Colorizer array, return the word without any color.
        }
    }
}
