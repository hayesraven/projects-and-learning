/*
* Title: Project - MovieDVD Argument Exception
* Name: Cameron Hayes
* Date: 13 DEC 2021
* Description: User-defined exception
*/
package project;

public class IllegalMovieDVDArgumentException extends IllegalArgumentException {
    /* Attributes */
    private String msg;

    /* Constructors */
    public IllegalMovieDVDArgumentException(double size) {
        msg = "Size must be greater than 0";
    }
    
    /* toString method */
    public String toString() {
        return this.getClass().getSimpleName() + ": " + msg;
    }
}

