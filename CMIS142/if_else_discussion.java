/**

* Title: If Else Discussion

* Name: Cameron Hayes

* Date: 05JUL2021

* Description: Asks for user input to determine if they need to eat, demonstrates if else competency

*/
package discussions;

import java.util.Scanner; //import input utility

public class if_else_discussion {	// begin class 
	public static void main(String[] args) {	// begin main()
		 
		/* Declare the variables. */
		
		Scanner scanint = new Scanner (System.in); // setup input scanner
		int hours;	// hours variable	
		
		/* Ask for input. */
        
		System.out.printf("\nHow many hours has it been since you last ate? (Round up!) ");	// prompt for user input for hours
		hours = scanint.nextInt(); 	// store hours since last meal in variable 'hours'
		
       	/* Close out variables */
      	 
		scanint.close(); // Scan close 
       	 
       	System.out.println("");		// blank line for spacing
       	System.out.println("Calculating..."); 	// wait message
       	System.out.println("");		// blank line for spacing
       	   	     	
       	/* Output the results. */  
       	
       	if (hours > 0) { // Checks to see if user input a number greater than 0
       		
       		if (hours >= 4 && hours < 72) { // Checks to see if user input is 4 or greater but less than 72 
       			
       			System.out.println("Wow! You ate " + hours + " hours ago! You must be hungry!");	// print first line of message
       			System.out.println("Go ahead and have a healthy meal!"); // prints second line of message
           		System.out.println(""); //Spacing
           		System.out.println("Name: Cameron Hayes" + "\t" + "Date: 05JUL2021"); // print out name, class, date
       			return; // exits if statement
       			
       		}
       		
       		else if (hours >= 72) { // Checks to see if user input is equal to or greater than 72 
       			
       			System.out.println("Oh no! You last ate " + hours + " hours ago! That's not healthy!");	// print first line of message
       			System.out.println("You should consult a medical professional!"); // prints second line of message
           		System.out.println(""); //Spacing
           		System.out.println("Name: Cameron Hayes" + "\t" + "Date: 05JUL2021"); // print out name, class, date
       			return; // exits else if statement
       			
       		}
       		
       		else { // Executes if hours entered is more than zero but less than four
       			
       			System.out.println("You just ate " + hours + " hours ago! You should wait.");	// print message
           		System.out.println(""); //Spacing
           		System.out.println("Name: Cameron Hayes" + "\t" + "Date: 05JUL2021"); // print out name, class, date
       			return; // exits else statement
       			
       		}
       		
       	}
       	
       	else { // executes if user gives a number equal to or less than 0
       		
           	System.out.println("Error! You must input a number greater than 0!");	// error message
       		System.out.println(""); //Spacing
       		System.out.println("Name: Cameron Hayes" + "\t" + "Date: 05JUL2021"); // print out name, class, date
       		return; // exits else statement
       		
       	}
      	 
	}	// end of main()
	
}	// end of class 
