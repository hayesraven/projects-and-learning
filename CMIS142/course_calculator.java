/**

* Title: Assignment 3

* Name: Cameron Hayes

* Date: 05JUL2021

* Description: Calculates a student's final course grade, based on user input

*/
package discussions;

import java.util.Scanner; // import input utility

public class assignment3 { // begin class

	public static void main(String[] args) { // begin main ()
		
		/* Declare the variables */
		Scanner scanChar = new Scanner (System.in); // setup character input scanner
		Scanner scanStr = new Scanner (System.in);	// setup string input scanner
		Scanner scanDouble = new Scanner (System.in);	// setup double input scanner
		char prompt;	// prompt answer variable	
		String student;	// student's name variable
		double asgn1;	// assignment 1 grade variable
		double asgn2;	// assignment 2 grade variable
		double exam;	// exam grade variable
		double part;	// participation grade variable
		double finalgrade;	// final course grade variable
		
		/* Initialization */

		System.out.println("Welcome to the grade calculation program!\n");	// greeting message
		System.out.printf("Do you want to enter a student's data? (Yes/No)  ");	// initialization prompt
		prompt = scanChar.next().charAt(0); // store next character into prompt
				
		/* Main output and calculation */
		
		if (prompt == 'y' || prompt == 'Y') { //initialization of primary loop
			
			do { //	start do loop
			
				/* Store user inputs */
			
				System.out.printf("\nEnter student's name: ");	// prompt for student's name
				student = scanStr.nextLine(); // store next string into prompt
				System.out.printf("\nEnter student's grades separated by space: A1 A2 Ex P  "); // store grades into double variables
				asgn1 = scanDouble.nextDouble(); // store assignment 1's grade into asgn1
				asgn2 = scanDouble.nextDouble(); // store assignment 2's grade into asgn2
				exam = scanDouble.nextDouble(); // store the exam grade into exam
				part = scanDouble.nextDouble(); // store the participation grade into part
			
				/* Perform calculations */
			
				finalgrade = (asgn1 + asgn2 + exam + part) / 4; 	// adds all four grades, divides by four for average
			
				/* Final output and user prompt */
			
				System.out.printf("\nStudent Name: " + student + " A1=" + asgn1 + " A2=" + asgn2);	// initial output line
				System.out.println(" Exam=" + exam + " Participation=" + part);	// continuing output
				System.out.println("Final course grade=" + finalgrade + "\n"); // output with final calculated grade
				System.out.printf("Do you want to enter another student's data? (Yes/No) ");	// initialization prompt
				prompt = scanChar.next().charAt(0); // store next character into prompt
			
			} while (prompt == 'y' || prompt == 'Y'); // continues to executes if prompt_answer is true
			
		} // end of primary loop
		
		System.out.println("\nThank you for using the grade calculation program"); // exit message

		/* Close out variables */
		
		scanChar.close();	// close character scanner
		scanStr.close();	// close String scanner
		scanDouble.close();	// close double scanner
		
		/* Required Output */
   		System.out.println(""); //Spacing
   		System.out.println("Name: Cameron Hayes" + "\t" + "CMIS 141/6981" + "\t" + "Date: 10JUL2021"); // print out name, class, date
		
	} // end of main()
	
} // end of class
