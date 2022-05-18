/**
* Title: Project - MediaRentalSystem
* Name: Cameron Hayes
* Date: 13 DEC 2021
* Description: Main method to run media system menu
*/
package project;

import java.util.InputMismatchException;
import java.util.Scanner; // import input utility

public class MediaRentalSystem {
	public static void main(String[] args) { // begin main ()
		/* Declare the variables */
		Scanner scan = new Scanner(System.in); // Scanner
		boolean choice = true; // setup choice variable;
		int option;	// menu choice variable
        String filepath = "";
		Manager media = new Manager();	// instantiates MediaRentalSystem object to run menu options
		
		while (choice) { // will continue looping until choice is set to false 
						// (only happens if user chooses to exit)
			/* Main action, menu options that can be called at the beginning of each loop */
            System.out.println("\nWelcome to the Media Rental System!\nPlease choose from the following options:"); // greeting message
            System.out.println("1. Load Media Objects\n2. Find Media Objects\n3. Rent Media Objects\n4. Manager Options\n9. Exit\n\n"); // menu options
            System.out.println("Enter your selection below:"); // exit option
            try {    
                option = scan.nextInt(); // store choice in option
                scan.nextLine();
                System.out.println(); // added for formatting

                /* Main sections to call methods */
                switch (option) { // switch statement uses option variable for cases

                    case 1: // Load all currently stored media
                        filepath = media.LoadMedia();
                        break; // exits case
    
                    case 2: // Find and retrieve a specific object
                        media.FindMedia();
                        break; // exits case
    
                    case 3: // Rent a media object
                        media.RentMedia(filepath);
                        break; // exits case
                    
                    case 4:
                        System.out.println("Please choose from the following options:\n1. Add media\n2. Remove media");
                        option = scan.nextInt(); // store choice in option
                        
                        try {
                            if (option == 1) {
                                media.AddMedia(filepath);
                            }
                            else if (option == 2) {
                                media.RemoveMedia(filepath);
                            }
                            else {
                                System.out.println("Error: Invalid option selected. Returning to main menu...");
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("ERROR: Input not recognized.");
                        }
                        break;
    
                    case 9: // exit option
                        choice = false; // sets choice to false to break the while loop
                        System.out.println("Thank you for using the media rental system!"); // exit message
                        break; // exits case

                    default: // error handling
                        System.out.println("Error! You have to choose from the above options!"); // error message

                } // end of switch loop
            }
            catch (InputMismatchException e) {
                System.out.println("ERROR: Input not recognized.");
            }
        System.out.println();
		} // end of while loop

		/* Close out variables */
		scan.close(); // close scanner

		/* Required Output */
		System.out.println(""); // Spacing
		System.out.println("Name: Cameron Hayes" + "\t" + "CMIS 242/7382" + "\t" + "Date: 13DEC2021"); // print out name, class, date

	}	// end of main()

}	// end of class
