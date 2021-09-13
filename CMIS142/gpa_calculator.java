/**

* Title: GPA Calculator

* Name: Cameron Hayes

* Date: 28JUN2021

* Description: Prompt a user for their ID and class/grade information
* and calculate what their new overall GPA will be based on class credits
* and class GPA

*/
package discussions;

import java.util.Scanner; // import input utility

public class gpa_calculator { // begin class

	public static void main(String[] args) { // begin main ()
		
		/* Declare the variables */
		
		Scanner scandouble = new Scanner (System.in); // setup double input scanner
		Scanner scanint = new Scanner (System.in);	// setup integer input scanner
		int studentID; 	// student ID variable
		double classGPA; 	// current class GPA variable
		int classCredits; 	// current class credit variable
		double currentOverallGPA; 	// current overall GPA variable
		int currentOverallCredits; 	// current overall credits variable
		double newOverallGPA; 	// new overall GPA variable
		
		/* Prompt for user input */
		
		System.out.printf("\nEnter your student ID: "); // prompt user for student ID
		studentID = scanint.nextInt(); // store next integer into 'studentID'
		
		System.out.printf("\nEnter current class GPA (i.e, 2.9): "); // prompt user for current class GPA
		classGPA = scandouble.nextDouble(); // store next double into 'classGPA'
		
		System.out.printf("\nHow many credits is your current class worth (i.e, 3)? "); // prompt user for current class credit 
		classCredits = scanint.nextInt(); // store next integer into 'classCredits'
		
		System.out.printf("\nWhat's your overall  GPA (i.e, 3.4)? "); // prompt user for current overall GPA 
		currentOverallGPA = scandouble.nextDouble(); // store next double into 'currentOverallGPA'
		
		System.out.printf("\nFinally, how many credits do you currently have (i.e, 24)? "); // prompt user for current overall credits
		currentOverallCredits = scanint.nextInt(); // store next integer into 'currentOverallCredits'
		
		System.out.println(""); 	// insert blank line
		System.out.println("Working..."); 	// insert wait message
		System.out.println(""); 	// insert blank line
		
		/* Do the computations */
		
		/* Takes both the class and overall GPA, multiplies them by their respective credit amount (class vs. overall),
		 * then divides them by the sum of the two credit variables and stores the result in 'newOverallGPA'
		 */
		newOverallGPA = ((classGPA * classCredits) + (currentOverallGPA * currentOverallCredits)) / (classCredits + currentOverallCredits);
		
		/* Output the results */

		System.out.println("STUDENT DATA"); 	// insert header
		System.out.println(""); 	// insert blank line	
		
		// Main body of output
		
		System.out.println("Student ID: " + studentID); 	// Output studentID
		System.out.println("Current class GPA: " + classGPA); 	// Output classGPA
		System.out.println("Current class credits: " + classCredits); 	// Output classCredits
		System.out.println("Current overall GPA: " + currentOverallGPA); 	// Output currentOverallGPA
		System.out.println("Current overall credits: " + currentOverallCredits); 	// Output currentOverallCredits
		System.out.println(""); 	// insert blank line
		System.out.println("New GPA: " + newOverallGPA); 	// Output newOverallGPA
		System.out.println(""); 	// insert blank line
		
		/* Close out variables */
		
		scandouble.close(); // close double scanner
		scanint.close(); // close integer scanner
		
	} // end of main()
	
} // end of class
