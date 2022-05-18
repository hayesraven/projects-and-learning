/*
* Title: Week 6 Discussion 
* Name: Cameron Hayes
* Date: 30 NOV 2021
* Description: Demonstrates dynamic binding
*/

package wk7discussion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DessertBuilder {

    DessertBuilder() {

    }

    public void mainMenu () {
        Scanner scan = new Scanner(System.in);
        Dessert myDessert = null;
        int option, eggs, fruit, icing;
        double sugar, milk;

        /* Main Action */
        System.out.println("How many eggs do you want?");
        eggs = scan.nextInt();
        System.out.println("How much sugar do you want?");
        sugar = scan.nextDouble();
        System.out.println("How much milk do you want?");
        milk = scan.nextDouble();
        System.out.println("Please enter 1 for a Pie or 2 for a Cake!");

        /* Try/Catch block, catch mismatched input into the scanner */
        try {   // occurs if user inputs a valid integer
            option = scan.nextInt();
            System.out.println();

            switch(option){
                case 1:
                    System.out.println("What kind of fruit do you want?\n1. Apple\n2. Cherry\n3. None");
                    fruit = scan.nextInt();

                    if (fruit == 3) {
                        myDessert = new Pie(eggs,sugar,milk,"");
                    }
                    else if (fruit == 1) {
                        myDessert = new Pie(eggs,sugar,milk,"apple");
                    }
                    else if (fruit == 2) {
                        myDessert = new Pie(eggs,sugar,milk,"cherry");
                    }
                    
                    System.out.println(myDessert.toString());
                    break;
    
                case 2:
                    System.out.println("What kind of icing do you want?\n1. Buttercream\n2. Cream cheese\n3. None");
                    icing = scan.nextInt();

                    if (icing == 3) {
                        myDessert = new Cake(eggs,sugar,milk,"");
                    }
                    else if (icing == 1) {
                        myDessert = new Cake(eggs,sugar,milk,"apple");
                    }
                    else if (icing == 2) {
                        myDessert = new Cake(eggs,sugar,milk,"cherry");
                    }

                    System.out.println(myDessert.toString());
                    break;
    
                default:
                    System.out.println("You didn't pick 1 or 2!");
                    break;
            }
        }
        catch (InputMismatchException e) {  // occurs if the user inputs any besides an integer
            System.out.println("You didn't pick a number!");
        }
    }
}
