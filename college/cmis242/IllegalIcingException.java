/*
* Title: Week 7 Discussion 
* Name: Cameron Hayes
* Date: 07 DEC 2021
* Description: User-defined exception
*/

package wk7discussion;

public class IllegalIcingException extends IllegalArgumentException {
    /* Attributes */
    private String msg;

    /* Constructor */
    public IllegalIcingException(String icing) {
        if (icing == null)
            msg = "Icing cannot be null";
        else if (icing.isBlank())
            msg = "Icing cannot have all blank values";
        else if (icing.isEmpty())
            msg = "Icing cannot be empty value";
    }
    
    /* toString method */
    public String toString() {
        return this.getClass().getSimpleName() + ": " + msg;
    }

}
