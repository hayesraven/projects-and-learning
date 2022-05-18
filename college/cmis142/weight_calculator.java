/**

* Title: Conversion and weight calculator

* Name: Cameron Hayes

* Date: 25JUL2021

* Description: Set of calculations, including lbs to kg, in to cm, and BMI calculator
		Utilizes methods to call calculations

*/
package discussions;

import java.util.Scanner; // import input utility

public class weight_calculator { // begin class

	public static void main(String[] args) { // begin main ()

		/* Declare the variables */
		Scanner scanInt = new Scanner (System.in);	// setup double input scanner
		Scanner scanDouble = new Scanner (System.in);	// setup double input scanner
		boolean choice = true;	// setup choice variable;
		int option;	// setup integer variable
		double weight_lbs;	// setup weight_lbs variable
		double weight_kg;	// setup weight_kg variable
		double height_in;	// setup height_in variable
		double height_cm;	// setup height_cm variable
		double BMI_val;	// setup BMI variable
		
		/* Initialization */

		System.out.println("Welcome to the BMI calculator!\n");	// greeting message
				
		/* Main output and calculation */
				
		while (choice) {	// will continue looping until choice is set to false (only happens if user chooses to exit)
			
			System.out.println("Please choose from the following options:  ");	// initialization prompt
			System.out.println("1. Convert lbs to kg");	// weight conversion option
			System.out.println("2. Convert height from in to cm");	// height conversion option
			System.out.println("3. BMI calculation"); // BMI calculator option
			System.out.println("4. Exit"); // exit option
			option = scanInt.nextInt(); 	// store choice in option
			System.out.println();	// added for formatting
			
			/* Main sections to call methods */
			
			switch (option) { // switch statement uses option variable for cases
			
				case 1:	// executes weight conversion
					/* Input */
					System.out.println("Please enter your weight in lbs:  ");	// prompt user for weight
					weight_lbs = scanDouble.nextDouble();	// store next double into weight_lbs
					
					/* Output */
					weight_kg = weight_conversion(weight_lbs);	// call weight_conversion method and pass it weight_lbs
					System.out.println("Your weight in kilograms is " + weight_kg  + "\n");	// exit message
					break;	// exits case
			
				case 2:	// executes height conversion
					/* Input */
					System.out.println("Please enter your height in inches:  ");	// prompt user for height
					height_in = scanDouble.nextDouble();	// store next double into height_in
					
					/* Output */
					height_cm = height_conversion(height_in);	// call height_conversion method and pass it height_in
					System.out.println("Your height in centimeters is " + height_cm + "\n");	// exit message
					break;	// exits case
				
				case 3:	// executes BMI calculator
					/* Input */			
					System.out.println("Please enter your weight in kilograms:  ");	// prompt user for weight
					weight_kg = scanDouble.nextDouble();	// store next double into weight_kg
					System.out.println("Please enter your height in centimeters:  ");	// prompt user for height
					height_cm = scanDouble.nextDouble();	// store next double into height_cm
					
					/* Output */
					BMI_val = BMI_calc(weight_kg,height_cm);	// call BMI_calc method and pass it weight_kg and height_cm
					
					/* The next block of if statements compare the BMI_val to established BMI categories and 
					 * display a different message depending on what category the user's inputs fall into */
					if (BMI_val < 18.5) {	// designates BMI_val as underweight
						
						System.out.println("Your BMI is " + BMI_val + ", which means you are considered underweight.\n");
					
					}
					else if (BMI_val >= 18.5 && BMI_val <= 24.99) {		// designates BMI_val as normal weight
						
						System.out.println("Your BMI is " + BMI_val + ", which means you are considered normal weight.\n");
					
					}
					else if (BMI_val >= 25 && BMI_val <= 29.99) {	// designates BMI_val as overweight

						System.out.println("Your BMI is " + BMI_val + ", which means you are considered overweight.\n");
					
					}
					else if (BMI_val > 30) {	// designates BMI_val as obese

						System.out.println("Your BMI is " + BMI_val + ", which means you are considered obese.\n");

					}
	
					break;	// exits case
				
				case 4:	// exits loop
					
					choice = false;	// sets choice to false to break the while loop
					System.out.println("Thank you for using the BMI calculator!");	// exit message
					break;	// exits case
				
				default:	// error handling
				
					System.out.println("Error! You have to choose from the above options!"); // error message
				
			}	// end of switch loop
		
		}	// end of while loop
		
		/* Close out variables */
		
		scanDouble.close();	// close double scanner
		scanInt.close();	// close integer scanner
		
		/* Required Output */
   		System.out.println(""); //Spacing
   		System.out.println("Name: Cameron Hayes" + "\t" + "\t" + "Date: 25JUL2021"); // print out name, date
		
	} // end of main()
	
	public static double weight_conversion(double weight_lbs) {	// weight conversion method
		
		double weight_kg = weight_lbs * 0.45;	// calculation to convert weight from lbs to kg
		return weight_kg;	// return result
		
	}	// end of weight_conversion()
	
	public static double height_conversion(double height_in) {	// height conversion method
		
		double height_cm = height_in * 2.54;	// calculation to convert height from in to cm
		return height_cm;	// return result
		
	}	// end of height_conversion()
	
	public static double BMI_calc(double weight_kg,double height_cm) {	// BMI Calculator
		
		double BMI_val = (weight_kg / height_cm / height_cm) * 10000;	// calculation for BMI
		return BMI_val;	// return result
		
	}	// end of height_conversion()
	
} // end of class
