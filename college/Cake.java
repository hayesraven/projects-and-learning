/**
* Title: Week 5 Discussion - Cake 
* Name: Cameron Hayes
* Date: 22 NOV 2021
* Description: Child class of Dessert
*/

package wk5discussion;

public class Cake extends Dessert {	// begin Cake subclass
    /* Local attributes */
	private String icing;
	
	/* Default Constructor */
	public Cake() {
		this.icing = "cream cheese";
	}
    
	/* Overloaded Constructor */
    public Cake(int eggs, double sugar, double milk, String icing) {
    	super(eggs, sugar, milk);
		this.icing = icing;
    }
	
	/* Accessors */
	public String getIcing() {
        return this.icing;
    }

	/* Mutators */
	public void setIcing(String icing) {
		this.icing = icing;
	} 

    /* Abstract method */
	public void setBakingTime(int eggs){
		this.minutes = eggs * 15;
	}

	/* to String method */
	public String toString() {
		return "You're making a cake with " + this.icing + " icing." + super.toString();
	}
}	// end of subclass