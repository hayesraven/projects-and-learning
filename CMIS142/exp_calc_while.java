/**

* Title: Exponential Calculator

* Name: Cameron Hayes

* Date: 10JUL2021

* Description: Simple calculator that takes a number and raises it exponentially by a number from 0 to 10 based on input

*/
package discussions;

import java.util.Scanner; //import input utility

public class exp_calc_while {	// begin class 
	public static void main(String[] args) {	// begin main()
		 
		/* Declare the variables. */
		
		Scanner scanint = new Scanner (System.in); // setup input scanner
		int counter;	// counter variable	
		int exponent;	// exponent variable
		int initnum;	// initial number variable
		int answer;		// answer variable
		
		counter = 1;	// initialize counter at 1
		answer = 1; 	// initialize answer at 1
		
		/* Ask for input. */
        
		System.out.printf("\nWhat number would you like to start with?  ");	// prompt for user input for initnum
		initnum = scanint.nextInt(); 	// store initial number in initnum
		
		System.out.printf("\nWhat number would you like to raise it by? (From 0 to 10)  ");	// prompt for user input for exponent
		exponent = scanint.nextInt(); 	// store exponent number in exponent
		
       	/* Close out variables */
      	 
		scanint.close(); // Scan close 
       	 
       	System.out.println("");		// blank line for spacing
       	System.out.println("Calculating..."); 	// wait message
       	System.out.println("");		// blank line for spacing
       	   	     	
       	/* Output the results. */  
       	
       	if (exponent >= 0 && exponent <= 10) { // Checks to see if user input a number from 0 to 10
       		
       		if (exponent == 0) { // Checks to see if exponent is equal to 0
       			
       			System.out.println("Answer: " + initnum + " raised by " + exponent + " is 1.");	// print answer
           		System.out.println(""); //Spacing
           		System.out.println("Name: Cameron Hayes" + "\t" + "CMIS 141/6981" + "\t" + "Date: 10JUL2021"); // print out name, class, date
       			return; // exits if statement
       			
       		}
       		
       		else if (exponent > 0) { // executes as long as exponent is greater than 0
       			
       			while (exponent >= counter) { // initialize while loop, executes until counter is greater than exponent
       				
       				answer *= initnum;	// multiply answer by initnum and store it in answer
       				System.out.println(answer); // prints answer
       				counter++; 	// increment counter
       				
       			}
       			
       			System.out.println(""); //Spacing
       			System.out.println("Answer: " + initnum + " raised by " + exponent + " is " + answer + ".");	// print answer
           		System.out.println(""); //Spacing
           		System.out.println("Name: Cameron Hayes" + "\t" + "CMIS 141/6981" + "\t" + "Date: 10JUL2021"); // print out name, class, date
       			return; // exits if statement
       			
       		}
       		
       	}
       		       	
       	else { // executes if user gives a number outside of accepted range
       		
           	System.out.println("Error! You must input a number between 0 and 10!");	// error message
       		System.out.println(""); // spacing
       		System.out.println("Name: Cameron Hayes" + "\t" + "CMIS 141/6981" + "\t" + "Date: 10JUL2021"); // print out name, class, date
       		return; // exits else statement
       		
       	}
      	 
	}	// end of main()
	
}	// end of class 
