/**

* Title: Temp Calculator

* Name: Cameron Hayes

* Date: 28JUN2021

* Description: Temperature calculator

*/
package discussions;

import java.util.Scanner; //import input utility

public class temp_calc {	// begin class 
	public static void main(String[] args) {	// begin main()
		 
		/* Declare the variables. */
		
		Scanner scandouble = new Scanner (System.in); // setup input scanner
		double tempf;	// fahrenheit variable
		double tempc;	// celsius variable
		double miles;	// miles variable
		double km;		// kilometers variable
		
		/* Ask for input. */
        
		System.out.printf("\nEnter miles ran: ");	// prompt for user input for miles
		miles = scandouble.nextDouble(); 	// store miles ran in variable 'miles'
        
       	System.out.printf("\nEnter temperature in Fahrenheit: ");	// prompt for user input for temperature
       	tempf = scandouble.nextDouble(); // store temperature in variable 'tempf'
       	 
       	System.out.println("");		// blank line for spacing
       	System.out.println("Working..."); 	// wait message
       	System.out.println("");		// blank line for spacing
       	
       	/* Do the computations. */
       	  
       	tempc = (tempf - 32) / 1.8;		// convert fahrenheit into celsius
     	  
     	km = miles * 1.60934;		// convert miles to kilometers
       	
       	/* Output the results. */  
       	       	  
       	System.out.println("Wow! You ran " + miles + " miles in " + tempf + " degrees Fahrenheit heat!");	// display user inputs in message 
       	System.out.println("");		// blank line for spacing
       	System.out.println("In metric, thats " + km + " kilometers and " + tempc + " degrees Celsius!");	// display user inputs converted
       	System.out.println("");		// blank line for spacing
       	System.out.println("Keep up the good work!");		// exit line
       	 
       	 System.out.println(""); 
       	 System.out.println("Name: Cameron Hayes" + "\t" + "Date: 28JUN2021"); // print out name, class, date
    	
       	 /* Close out variables */
       	 
       	 scandouble.close(); // Scan close 
       	 
	}	// end of main()
	
}	// end of class 
