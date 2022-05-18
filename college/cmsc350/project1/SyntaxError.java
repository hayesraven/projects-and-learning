/*
* Title: Project 1 - Syntax Error
* Name: Cameron Hayes
* Date: 27 Mar 2022
* Description: User-defined exception, thrown when invalid input is given
*/
package project1;

public class SyntaxError extends IllegalArgumentException {
    /* Attributes */
    private String msg = "";
    private int i;

    /* Constructors */
    public SyntaxError(String input, String validInputs) {
        for (i = 0; i < input.length(); i++) {
            if (validInputs.contains(Character.toString(input.charAt(i))) == false) {
                msg += Character.toString(input.charAt(i));
            }
        }
    }
    
    /* toString method */
    public String toString() {
        return this.getClass().getSimpleName() + " - The following illegal "
        + "characters were found in your input: " + msg;
    }
}