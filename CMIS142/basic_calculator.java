/**

* Title: Assignment 2

* Name: Cameron Hayes

* Date: 05JUL2021

* Description: Prompt a user for two integers and perform an operation on them

*/
package discussions;

import java.util.Scanner; // import input utility

public class HayesCameron_Asgn2 { // begin class

	public static void main(String[] args) { // begin main ()
		/* Declare the variables */
		
		Scanner scanChar = new Scanner (System.in); // setup character input scanner
		Scanner scanInt = new Scanner (System.in);	// setup integer input scanner
		int firstInt;	// first integer variable
		int secondInt;	// second integer variable
		double firstDouble; 	// first double variable
		double secondDouble; 	// second double variable
		double answer;	// answer variable
		char operator; 	// character operator variable
		
		/* Prompt for user input */
		/* Asks the user to input two numbers, separated by a space, and then asks for an operator */
		
		System.out.printf("\nEnter two integer numbers separated by space: "); // prompt user for two integers separated by a space
		firstInt = scanInt.nextInt(); // store first integer into firstInt
		secondInt = scanInt.nextInt(); // store second integer into secondInt
		
		firstDouble = firstInt;	//converts the first integer to a double for division purposes
		secondDouble = secondInt;	//converts the second integer to a double for division purposes
		
		System.out.printf("\nEnter operation symbol (+, -, *, or /): "); // prompt user for operator
		operator = scanChar.next().charAt(0); // store next character into operator
		
		System.out.println(""); 	// insert blank line
		System.out.println("Working..."); 	// insert wait message
		System.out.println(""); 	// insert blank line
		
		/* Main output and calculation */

		switch (operator) { // switch statement uses operator variable for cases
		
			case '+':	// executes addition
				
				answer = firstDouble + secondDouble; // calculates result
				System.out.println("Evaluation: " + firstInt + " + " + secondInt + " = " + answer); // outputs results to user
				break;	// exits case
			
			case '-':	// executes subtraction
				
				answer = firstDouble - secondDouble; // calculates result
				System.out.println("Evaluation: " + firstInt + " - " + secondInt + " = " + answer); // outputs results to user
				break;	// exits case
				
			case '*':	// executes multiplication
				
				answer = firstDouble * secondDouble; // calculates result
				System.out.println("Evaluation: " + firstInt + " * " + secondInt + " = " + answer); // outputs results to user
				break;	// exits case
				
			case '/':	// executes division
				
				answer = firstDouble / secondDouble; // calculates result
				System.out.println("Evaluation: " + firstInt + " / " + secondInt + " = " + answer); // outputs results to user
				break;	// exits case
				
			default:	// error handling
				
				System.out.println("You didn't enter a valid operator!"); // error message
		
		}	// close switch
		
		/* Close out variables */
		
		scanChar.close(); // close character scanner
		scanInt.close(); // close int scanner
		
		/* Required Output */
   		System.out.println(""); //Spacing
   		System.out.println("Name: Cameron Hayes" + "\t" + "CMIS 141/6981" + "\t" + "Date: 05JUL2021"); // print out name, class, date
		
	} // end of main()
	
} // end of class
