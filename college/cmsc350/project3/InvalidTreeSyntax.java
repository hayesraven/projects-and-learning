/**
* Title: Project 3 - InvalidTreeSyntax 
* Name: Cameron Hayes
* Date: 30 APR 2022
* Description: Exception Handling for invalid binary tree input
*/
package project3;

public class InvalidTreeSyntax extends IllegalArgumentException {
    /* Attributes */
    private String msg;

    /* Constructors */
    // Used for null/empty input
    public InvalidTreeSyntax(String input) {
        if (input == null)
            msg = "Input cannot be null.";
        else if (input.isBlank())
            msg = "Input cannot have all blank values.";
        else if (input.isEmpty())
            msg = "Input cannot be empty value.";
    }
    // Used for bad character input
    public InvalidTreeSyntax(char c) {
        msg = "'"+ c + "' is an invalid input.";
    }

    // Used for incorrect amount of parentheses
    public InvalidTreeSyntax(int i) {
        msg = "Incorrect number of parentheses, check your input.";
    }

    // Used for no value input
    public InvalidTreeSyntax(int values, char c) {
        if (c == 'x') {
            msg = "You must input at least one alphanumeric value!";
        }
    }
    /* toString method */
    public String toString() {
        return this.getClass().getSimpleName() + ": " + msg;
    }
}

