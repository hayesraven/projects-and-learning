/**
* Title: Week 6 Discussion - Pie
* Name: Cameron Hayes
* Date: 30 NOV 2021
* Description: Child class of Dessert
*/

package wk7discussion;

public class Pie extends Dessert {	// begin Pie subclass
    /* Local attributes */
	private String fruit;

	/* Default constructor */
	public Pie() {
		this.fruit = "cherry";
	}
    
	/* Overloaded Constructor */
    public Pie(int eggs, double sugar, double milk, String fruit) {
    	super(eggs, sugar, milk);

		if (fruit == null || fruit.isBlank() || fruit.isEmpty())
		throw new IllegalFruitException(fruit);

		this.fruit = fruit;
    }
	
	/* Accessors */
	public String getFruit() {
        return this.fruit;
    }

	/* Mutators */
	public void setFruit(String fruit) {
		this.fruit = fruit;
	} 

	/* Abstract */
	public void setBakingTime(int eggs){
		this.minutes = eggs * 15;
	}

	/* to String method */
	public String toString() {
		return "You're making a pie with " + this.fruit + "." + super.toString();
	}
}	// end of subclass
