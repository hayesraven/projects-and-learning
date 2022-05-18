/*
* Title: Week 7 Discussion 
* Name: Cameron Hayes
* Date: 07 DEC 2021
* Description: User-defined exception
*/

package wk7discussion;

public class IllegalFruitException extends IllegalArgumentException {
    /* Attributes */
    private String msg;

    /* Constructor */
    public IllegalFruitException(String icing) {
        if (icing == null)
            msg = "Fruit cannot be null";
        else if (icing.isBlank())
            msg = "Fruit cannot have all blank values";
        else if (icing.isEmpty())
            msg = "Fruit cannot be empty value";
    }
    
    /* toString method */
    public String toString() {
        return this.getClass().getSimpleName() + ": " + msg;
    }

}
