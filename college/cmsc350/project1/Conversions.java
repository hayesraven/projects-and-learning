/**
* Title: Project 1 - Conversion
* Name: Cameron Hayes
* Date: 24 Mar 2022
* Description: Conversion class, maintains methods for the conversion
*/
package project1;

import java.util.*;

public class Conversions {
    /* Variables */
    private String tmpToken, tmpStr, outStr;
    private int tmpInt;
    private Stack<String> oprStack = new Stack<String>();
    private Stack<String> revStack = new Stack<String>();
    private ArrayList<String> listTokens = new ArrayList<String>();

    /* Default Constructor */
    public Conversions () {

    }

    /* Converts prefix string to postfix */
    public String ConvPreToPost(String preFixExpIn) {
        /* Variables */
        cleanUp();  // Cleans up/resets variables
        listTokens = stringTokenizer(preFixExpIn);  // Creates an arraylist with the operators and operands to be converted

        /* Main Action */ 
        // Pushes all tokens onto the reversal stack
        for (tmpInt = 0; tmpInt < listTokens.size(); tmpInt++) {
            revStack.push(listTokens.get(tmpInt));
        }

        // Uses the reversal stack to build the proper stack
        while (revStack.isEmpty() == false) {
            tmpToken = revStack.pop();
            /* If the element is a number, drops it onto the stack;
            if the element is an operator, grabs two operands 
            and the operator and drops them onto the stack */
            if (isNumeric(tmpToken)) {
                oprStack.push(tmpToken);
            }
            else if (isOperator(tmpToken.charAt(0))) {
                tmpStr = oprStack.pop() + " " + oprStack.pop() + " " + tmpToken;
                oprStack.push(tmpStr);
                tmpStr = "";
            }
        }
        // Uses the proper stack to build the return string
        while (oprStack.isEmpty() == false) {
            outStr = outStr + oprStack.pop() + " ";
        }
        return outStr.trim();
    }

    /* Converts postfix string to prefix */
    public String ConvPostToPre(String postFixExpIn) {
        /* Variables */
        cleanUp();
        listTokens = stringTokenizer(postFixExpIn);
        
        // Uses the stack to create the expression similar to above
        for (tmpInt = 0; tmpInt < listTokens.size(); tmpInt++) {
            tmpToken = listTokens.get(tmpInt);
            
            if (isNumeric(tmpToken)) {
                oprStack.push(tmpToken);
            }
            else if (isOperator(tmpToken.charAt(0))) {
                tmpStr += oprStack.pop();
                tmpStr = tmpToken + " " + oprStack.pop() + " " + tmpStr;
                oprStack.push(tmpStr);
                tmpStr = "";
            }
        }
        while (oprStack.isEmpty() == false) {
            outStr = outStr + oprStack.pop() + " ";
        }
        return outStr.trim();
    }

    /* Method to determine if the string element is a number or not */
    public boolean isNumeric(String string) {   
        int i = 0;
        /* Checks if the string is empty or null */
        if (string == null || string == "") {
            return false;
        }
        /* Checks if the string is a number or not */
        try {
            i = Integer.parseInt(string);
            return true;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }

    /* Method to determine if the string element is an operator */
    public boolean isOperator(Character character) {          
        /* Checks if the string is a operator or not */
        if (character == '+' || character == '-' || character == '/' || character == '*') {
            return true;
        }
        return false;
    }   

    /* Tokenizer method */
    public ArrayList<String> stringTokenizer(String string) {
        /* Prep the variables */
        cleanUp();

        string += "."; // Adds an "end" to the string to more easily grab multi-digit operands

        /* Loops through string and builds out an arraylist with individual "tokens" */
        for (tmpInt = 0; tmpInt < string.length(); tmpInt++) {
            if (Character.isDigit(string.charAt(tmpInt))) {
                tmpStr += string.charAt(tmpInt);
            }
            if (isOperator(string.charAt(tmpInt)) || string.charAt(tmpInt) == ' ' || string.charAt(tmpInt) == '.') {
                if (tmpStr.length() > 0) {
                    listTokens.add(tmpStr);
                    tmpStr = "";
                }
                if (isOperator(string.charAt(tmpInt))) {
                    listTokens.add(Character.toString(string.charAt(tmpInt)));
                }
            }
        }
        return listTokens;
    }

    /* Cleanup method */
    public void cleanUp() {
        tmpToken = "";
        tmpStr = "";
        outStr = "";
        tmpInt = 0;
        oprStack.clear();
        revStack.clear();
        listTokens.clear();
    }
}
