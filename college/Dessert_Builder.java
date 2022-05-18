/*
* Title: Week 5 Discussion 
* Name: Cameron Hayes
* Date: 22 NOV 2021
* Description: Demonstrates polymorphism, overloading, and overriding
*/

package wk5discussion;

public class Dessert_Builder {
    public static void main(String[] args) { // begin main ()
        /* Uses default constructor for pie */
        Pie pie1 = new Pie();
        System.out.print("DEFAULT: " + pie1.toString() + "\n");
        
        /* Uses overloaded constructor for pie*/
        Pie pie2 = new Pie(4, 6, 1.5, "apple");
        System.out.print("OVERLOADED: " + pie2.toString() + "\n");
        
        /* Uses default constructor for cake */
        Cake cake1 = new Cake();
        System.out.print("DEFAULT: " + cake1.toString() + "\n");
    
        /* Uses overloaded constructor for cake */
        Cake cake2 = new Cake(2, 3.5, 3.5, "buttercream");
        System.out.print("OVERLOADED: " + cake2.toString() + "\n");

        /* Demonstrate overloaded method */
        System.out.println("");
        System.out.print("This is using the double method of 'setMilk()': " + cake2.getMilk()); // first call passed a double, return it here
        cake2.setMilk(4);   // pass setMilk() an int now
        System.out.print("\nThis is using the integer method of 'setMilk()': " + cake2.getMilk()); // first call passed a double, return it here
        System.out.println("");

        /* Required Output */
        System.out.println("");
        System.out.println("Name: Cameron Hayes" + "\t" + "CMIS 242/7382" + "\t" + "Date: 22NOV2021"); // print out name, class, date
    
    }	// end of main
}	// end of class
