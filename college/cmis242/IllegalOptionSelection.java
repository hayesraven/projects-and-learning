/*
* Title: Week 7 Discussion 
* Name: Cameron Hayes
* Date: 07 DEC 2021
* Description: User-defined exception
*/

package wk7discussion;

public class IllegalOptionSelection extends IllegalArgumentException {
    /* Attributes */
    private String msg;

    /* Constructor */
    public IllegalOptionSelection(int option) {

        if (option == 0)
            msg = "You must pick an option!";
        else if ((option < 1) || (option > 2))
            msg = "You must pick 1 or 2!";

    }
    
    /* toString method */
    public String toString() {
        return this.getClass().getSimpleName() + ": " + msg;
    }

}
