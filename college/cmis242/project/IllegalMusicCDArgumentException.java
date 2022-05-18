/*
* Title: Project - MusicCD Argument Exception
* Name: Cameron Hayes
* Date: 13 DEC 2021
* Description: User-defined exception
*/
package project;

public class IllegalMusicCDArgumentException extends IllegalArgumentException {
    /* Attributes */
    private String msg;

    /* Constructors */
    public IllegalMusicCDArgumentException(int length) {
        msg = "Length must be greater than 0";
    }
    
    /* toString method */
    public String toString() {
        return this.getClass().getSimpleName() + ": " + msg;
    }
}

