/**

* Title: Student Database

* Name: Cameron Hayes

* Date: 01AUG2021

* Description: Stores students' names and their associated grades before outputting them in order and displaying the highest and lowest grade 

*/
package discussions;

import java.util.Scanner; // import input utility

public class student_database { // begin class

	public static void main(String[] args) { // begin main ()

		/* Declare the variables */
		
		Scanner scanInt = new Scanner (System.in); // Scanner for integer input
		Scanner scanStr = new Scanner (System.in); // Scanner for string input
		int[] grades;	// array for storing input values
		String[] students;	// array for storing names
		int student_input;	// store how many students the user wants to input
		int[] highest = new int[2];	// initialize highest array
		int[] lowest = new int[2];	// initialize lowest array		
		
		/* Initial input */
		
		System.out.println("Welcome to the student grader!");	// greeting message
		System.out.println("How many students do you want to enter:  ");	// prompt for number value
		student_input = scanInt.nextInt(); 	// store choice in option
		grades = new int[student_input];	// set up grades array with size student_input
		students = new String[student_input];	// set up students array with size student_input
		
		for (int i = 0; i < student_input; i++) {	// for loop to enter students and grades

			System.out.println("\nStudent " + (i + 1) + ":");	// display current student entry
			System.out.printf("\tEnter student's name: ");	// prompt for name
			students[i] = scanStr.next();	// store name in position at i in students
			students[i] += " " + scanStr.next();	// store name in position at i in students
			System.out.printf("\tEnter student's score (0-100): ");	// prompt for name
			grades[i] = scanInt.nextInt();	// store score in position at i in grades
			
		}	// end of input for loop
		
		/* Do the calculations */ 
		
		highest = find_highest(grades);	// call find_highest method
		lowest = find_lowest(grades);	// call find_lowest method
		
		/* Output */ 
		
		for (int i = 0; i < student_input; i++) {	// for loop for output
			
			System.out.println(students[i] + "\t" + grades[i]);	// print the students name and their grade
			
		}	// end of output for loop
		
		System.out.println(students[highest[1]] + " has the highest score (" + highest[0] + ") and " + students[lowest[1]] + " has the lowest score (" + lowest[0] + ")");	// final output line
		System.out.println();	// formatting
		System.out.println();	// final line to print highest and lowest scores
		
		/* Close out variables */
		
		scanInt.close();	// close scanner
		scanStr.close();	// close integer scanner
		
		/* Required Output */
   		System.out.println(""); //Spacing
   		System.out.println("Name: Cameron Hayes" + "\t" + "Date: 01AUG2021"); // print out name, date
	
	}	// end of main()
	
	public static int[] find_highest(int grades[]) {	// finds the highest grade
		
		int[] highest = new int[2];	// initialize array
		highest[0] = grades[0];	// set highest[0] to the grade stored at grade[0]
		
		for (int i = 1; i < grades.length; i++) {	// for loop to run highest number check throughout array
			
			if (grades[i] > highest[0]) {	// checks if grades[i] is higher than highest
				
				highest[0] = grades[i];	// stores number at grades[i] if it was higher than highest
				highest[1] = i;	// store grade position at highest[1] 
				
			}	// end check for highest grade

		}	// ends highest for loop
		
		return highest;	// returns the highest grade
		
	}	// end of find_highest()
	
	public static int[] find_lowest(int grades[]) {	// finds the lowest grade
		
		int[] lowest = new int[2];	// initialize array
		lowest[0] = grades[0];	// set lowest[0] to the grade stored at grade[0]
		
		for (int i = 1; i < grades.length; i++) {	// for loop to run lowest number check throughout array
			
			if (grades[i] < lowest[0]) {	// checks if grades[i] is lower than lowest
				
				lowest[0] = grades[i];	// stores number at grades[i] if it was higher than highest
				lowest[1] = i;	// store grade position at lowest[1] 
				
			}	// end check for lowest grade

		}	// ends lowest for loop
		
		return lowest;	// returns the lowest grade
		
	} // end of find_lowest()
	
} // end of class
