/**

* Title: Shape Producer

* Name: Cameron Hayes

* Date: 16JUL2021

* Description: Produces either a triangle or a diamond that varies in size based on user input

*/
package discussions;

import java.util.Scanner; // import input utility

public class shape_builder { // begin class

	public static void main(String[] args) { // begin main ()

		/* Declare the variables */
		Scanner scanDouble = new Scanner (System.in);	// setup double input scanner
		double rows;	// triangle rows variable
		double sideLength;	// diamond side length variable
		double option; // option variable
		double space; // space variable
		
		/* Initialization */

		System.out.println("Welcome to the shape printer!\n");	// greeting message
		System.out.println("Please choose from the following options what shape you would like to print (e.g, 1 or 2):");	// initialization prompt
		System.out.println("1. Triangle");	// triangle option
		System.out.println("2. Diamond");	// diamond option
		option = scanDouble.nextDouble(); 	// store choice in option
				
		/* Main output and calculation */
		
		if (option == 1) {	// initialization of first option loop 
		
			System.out.println("Enter how many rows tall you'd like your triangle:");	// prompt user for input
			rows = scanDouble.nextDouble(); 	// store choice in rows

			// builds rows while rowCount is equal to or less than rows
			for (int rowCount = 1; rowCount <= rows; rowCount++) {	// for loop to build triangle, iterates per row
				
				// prints "#" as long as hashCount is equal to or less than rowCount
				for (int hashCount = 1; hashCount <= rowCount; hashCount++) { // for loop to build row
					
					System.out.printf("# ");	// print character to build row
					
				}	// end of nested for loop
				
				System.out.println();	// go to next row
				
			}	// end of nested for loop	
			
		} // end of first option loop 
		
		else if (option == 2) {	// initialization of second option loop 
			
			System.out.println("Enter how many characters long you'd like the sides of your diamond:");	// prompt user for input
			sideLength = scanDouble.nextDouble();	// store choice in sideLength
			
			space = sideLength - 1;	// space initialization for top half of diamond
			
			/* The diamond printer is split into two primary for loops that utilize multiple nested for loops; 
			 * the first one builds rows for the top half of the diamond, while the second one builds the bottom half*/
			
			for (int rowCount = 1; rowCount <= sideLength; rowCount++) {	// iterates until top two "sides" are built
				// prints spaces while hash is equal to or less than space
				for (int hash = 1; hash <= space; hash++) {	// for loop to add spaces until a character can be printed
					
					System.out.print("  ");	// prints a space
					
				}	// end of nested for loop
				
				space--; // decrements space to account for increasing amount of characters needed in each row
				
				for (int hash = 1; hash <= (rowCount * 2) - 1; hash++) { // for loop to add as many characters as necessary for row
					
					System.out.print("# ");	// prints characters when necessary
					
				}	// end of nested for loop
				
				System.out.println();	// goes to next row
				
			}	// end of top half for loop
			
			space = 1; // space initialization for bottom half of diamond
			
			for (int rowCount = 1; rowCount <= (sideLength - 1); rowCount++) {	// iterates until bottom two "sides" are built and diamond is completed
				
				for (int hash = 1; hash <= space; hash++) { // for loop to add spaces until a character can be printed
				
					System.out.print("  ");	// prints a space
				
				}	// end of nested for loop
				
				space++; // increments space to account for decresing amount of characters needed in each row
				
				for (int hash = 1; hash <= ((sideLength - rowCount) * 2) - 1; hash++) { // for loop to add as many characters as necessary for row
					
					System.out.print("# "); // prints characters when necessary
					
				}	// end of nested for loop
				
				System.out.println();	// goes to next row
				
			}	// end of bottom half for loop
			
		} // end of second option loop
		
		else { // executes if user gives a number other than 1 or 2
       		
           	System.out.println("Error! You have to choose 1 or 2!");	// error message
		}
			
		System.out.println("\nThank you for using the shape printer!"); // exit message

		/* Close out variables */
		
		// scanChar.close();	// close character scanner
		// scanStr.close();	// close String scanner
		scanDouble.close();	// close double scanner
		
		/* Required Output */
   		System.out.println(""); //Spacing
   		System.out.println("Name: Cameron Hayes" + "\t" + "Date: 16JUL2021"); // print out name, class, date
		
	} // end of main()
	
} // end of class
