/*
* Title: Week 7 Discussion 
* Name: Cameron Hayes
* Date: 07 DEC 2021
* Description: Demonstrates dynamic binding
*/

package wk7discussion;

import java.util.Scanner;

public class HayesCameron_Wk7Disc {
    public static void main(String[] args) { // begin main ()
        /* Variables */
        int option = 0;
        DessertBuilder dessert = new DessertBuilder();
        Scanner scan = new Scanner(System.in);

        /* Main Action */
        System.out.println("Welcome to the dessert builder!");

        while (option != 2) {
            dessert.mainMenu();
            System.out.println("\nYum! Would you like to make another? (1 for yes, 2 for no)");
            option = scan.nextInt();
        }
        
        /* Cleanup */
        System.out.println("Thank you for using the dessert builder!");

        /* Required Output */
        System.out.println("");
        System.out.println("Name: Cameron Hayes" + "\t" + "CMIS 242/7382" + "\t" + "Date: 07DEC2021"); // print out name, class, date
    
            /* Cleanup */
    scan.close();
    }	// end of main    

}	// end of class
