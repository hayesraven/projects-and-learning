/*
* Title: Project - Media Argument Exception
* Name: Cameron Hayes
* Date: 13 DEC 2021
* Description: User-defined exception
*/
package project;

public class IllegalMediaArgumentException extends IllegalArgumentException {
    /* Attributes */
    private String msg;

    /* Constructors */
    public IllegalMediaArgumentException(int year) {
        msg = "You must input a valid year";
    }

    public IllegalMediaArgumentException(String title) {
        if (title == null)
            msg = "Title cannot be null";
        else if (title.isBlank())
            msg = "Title cannot have all blank values";
        else if (title.isEmpty())
            msg = "Title cannot be empty value";
    }
    
    /* toString method */
    public String toString() {
        return this.getClass().getSimpleName() + ": " + msg;
    }
}

