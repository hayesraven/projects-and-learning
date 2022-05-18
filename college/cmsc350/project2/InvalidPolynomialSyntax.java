/**
* Title: Project 2 - InvalidPolynomialSyntax 
* Name: Cameron Hayes
* Date: 24 APR 2022
* Description: Exception Handling for invalid polynomial input
*/

package project2;

public class InvalidPolynomialSyntax extends IllegalArgumentException {
        /* Attributes */
        private String msg;

        /* Constructors */
        // Used for bad coefficient or exponent input
        public InvalidPolynomialSyntax(String badInput, char c) {
            if (c == 'c'){
                msg = badInput + " is not a valid coefficient.";
            }
            if (c == 'e'){
                msg = badInput + " is not a valid exponent.";
            }
        }

        // Used for bad polynomial ordering (i.e., exponent 4 is after exponent 2)
        public InvalidPolynomialSyntax(char c) {
            if (c == 'e') {
                msg = "Polynomial input was not in descending order.";
            }
        }

        /* toString method */
        public String toString() {
            return this.getClass().getSimpleName() + ": " + msg;
        }
}
