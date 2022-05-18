/**
* Title: Week 6 Discussion - Dessert 
* Name: Cameron Hayes
* Date: 30 NOV 2021
* Description: Dessert class, acts as parents to Pie and Cake
*/
package wk7discussion;

public abstract class Dessert {	// begin Dessert class
    /* Local attributes */
	private int eggs;
    private double sugar;
    protected double milk;
    protected int minutes;
	
    /* Default Constructor */
    public Dessert() {
        this.eggs = 2;
        this.sugar = 3.5;    
        this.milk = 3;
    }   

	/* Overloaded Constructor */
    public Dessert(int eggs, double sugar, double milk) {
    	if (icing == null || icing.isBlank() || icing.isEmpty())
			throw new IllegalIcingException(icing);
        
        this.eggs = eggs;
    	this.sugar = sugar;    
    	this.milk = milk;
    }
	
	/* Accessors */
    public int getEggs() {
        return this.eggs;
    }
    public double getSugar() {
        return this.sugar;
    }
    public double getMilk() {  
        return this.milk;
    }
    public int getMinutes() {
        return this.minutes;
    }
	
	/* Mutators */
    public void setEggs(int eggs) {
        this.eggs = eggs;
    }
    public void setSugar(double sugar) {
        this.sugar = sugar;
    }
    public void setMilk(double milk) {  // double version of method to demonstrate method overloading
        this.milk = milk;
    }
    public void setMilk(int milk) { // int version of method to demonstrate method overloading
        this.milk = milk;
    }

    /* Abstract method */
	public abstract void setBakingTime(int eggs);

    /* Display */
    public String toString() {
		return " You'll need " + this.eggs + " eggs, " + this.sugar + " tbsp of sugar, and " + this.milk + " cups of milk.";			
	}
}	// end of class

