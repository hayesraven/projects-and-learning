/*
* Title: Project - EBook Argument Exception
* Name: Cameron Hayes
* Date: 13 DEC 2021
* Description: User-defined exception
*/
package project;

public class IllegalEBookArgumentException extends IllegalArgumentException {
    /* Attributes */
    private String msg;

    /* Constructors */
    public IllegalEBookArgumentException(int numChapters) {
        msg = "Chapters must be greater than 0";
    }
    
    /* toString method */
    public String toString() {
        return this.getClass().getSimpleName() + ": " + msg;
    }
}

