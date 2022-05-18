/**
* Title: Project 2 - Polynomial 
* Name: Cameron Hayes
* Date: 24 APR 2022
* Description: Polynomial object class
*/

package project2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Polynomial implements Iterable<Number[]>, Comparable<Polynomial> {
    /* Class Attributes */
    private Node headNode = null;
    private int i = 0;
    private int sizeNode = 0;
    
    /* Overloaded Constructor */
    public Polynomial (String input) throws InvalidPolynomialSyntax {
        // Variables
        String[] splitPoly = input.split("\\s+");
        Double[] coeInput = new Double[splitPoly.length / 2];
        Integer[] expInput = new Integer[splitPoly.length / 2];
        int j;
        
        // Splits input string into coefficients and exponents
        for (i = 0, j = 0; i < splitPoly.length; i+=2, j++) {
            try {
                coeInput[j] = Double.parseDouble(splitPoly[i]);
            }
            catch (NumberFormatException e) {
                throw new InvalidPolynomialSyntax(splitPoly[i], 'c');
            }
            try {
                expInput[j] = Integer.parseInt(splitPoly[i + 1]);
            }
            catch (NumberFormatException e) {
                throw new InvalidPolynomialSyntax(splitPoly[i + 1], 'e');              
            } 
        }

        // Checks if polynomial is in strictly descending order
        for (i = 1; i < expInput.length; i++) {
            if (expInput[i - 1] < expInput[i]) {
                throw new InvalidPolynomialSyntax('e');
            }
        }

        // Iterates through inputs and creates new nodes
        for(i = 0; i < splitPoly.length / 2; i++) {
            if (coeInput[i] != 0) {
                add(coeInput[i], expInput[i]);
            }
        }
    }

    /* Classes */
    /* Node Class, used for linked list building */
    class Node {
        // Attributes
        private Node next;
        private Number[] combined = new Number[2];

        // Constructor
        Node (Double coefficient, Integer exponent) {
            this.combined[0] = coefficient;
            this.combined[1] = exponent;
            this.next = null;
        }
        // Accessors
        public double getCoefficient() {
            return this.combined[0].doubleValue();
        }
        public int getExponent() {
            return this.combined[1].intValue();
        }
        public Number[] getBoth() {
            return this.combined;
        }
        public Node getNext(){
            return this.next;
        }
    }

    /* myNodeIterator Class, used for iterator through a polynomial */
    class myNodeIterator implements Iterator<Number[]> {
        // Attributes
        private Node currNode;
        private Number[] tempData;

        // Constructor
        public myNodeIterator() {
            currNode = headNode;
        }

        // Accesssors
        public boolean hasNext() {
            return (currNode != null);
        }

        public Number[] next() {
            if (currNode == null) {
                throw new NoSuchElementException();
            }
            tempData = currNode.getBoth();
            currNode = currNode.getNext();
            return tempData;
        }
    }

    /* Methods */
    // Creates new iterator object
    public Iterator<Number[]> iterator() {
        return new myNodeIterator();
    }
    // Retrieves a node
    public Node getNode(int index) {
        return getNode(headNode, 0, index);
    }
    // Retrieves a node, expanded
    public Node getNode(Node node, int current, int index) {
        if (node == null) {
            return null;
        }
        if (index == current){
            return node;
        }
        current++;
        return getNode(node.next, current, index);
    }
    /* compareTo method, used for strong ordering check
    checks if each polynomial is sorted by both the coefficent
    and the exponent */
    public int compareTo(Polynomial o) {
        Node thisNode, otherNode;
        int thisExponent, otherExponent;
        double thisCoefficient,  otherCoefficient;

        for (i = 0; i < o.getSize(); i++) {
            thisNode = this.getNode(i);
            otherNode = o.getNode(i);

            if(thisNode == null || otherNode == null) {
			    return 1;
		    }

            thisExponent = this.getNode(i).getExponent();
            otherExponent = o.getNode(i).getExponent();
            thisCoefficient = this.getNode(i).getCoefficient();
            otherCoefficient = o.getNode(i).getCoefficient();

            if (thisExponent < otherExponent) {
                return 1;
            }
            else if (thisExponent > otherExponent) {
                return -1;
            }
            else if (thisCoefficient < otherCoefficient) {
                return 1; 
            }
            else if (thisCoefficient > otherCoefficient) {
                return -1;
            }
        }
        return 0;
    }
    /* compareTo method, used for weak order check -
    checks if each polynomial is sorted solely by the exponents */
    public int compareTo(Polynomial firstPoly, Polynomial secondPoly) {
        int firstExp;
        int secondExp;

        for (i = 0; i < firstPoly.getSize(); i++) {
            firstExp = firstPoly.getNode(i).getExponent();
            secondExp = secondPoly.getNode(i).getExponent();

            if (firstExp > secondExp) {
                return -1;
            }
            else if (firstExp < secondExp) {
                return 1;
            }
        }
        return 0;
    }

    // Used to add new noodes
    private void add(double coefficient, int exponent) {
		headNode = add(headNode, coefficient, exponent);
		sizeNode++;
	}

    // used to add new nodes, expanded
    private Node add(Node node, double coefficient, int exponent) {
		
		if (node == null) {
			Node newNode = new Node(coefficient, exponent);
			newNode.next = node;
			return newNode;
		}
		else {
			node.next = add(node.next, coefficient, exponent);
			return node;
		}
	}

    // Accessor, return size of linked list
    public int getSize() {
        return sizeNode;
    }

    @Override
    // toString method, prints out polynomial object in standard output
    public String toString() {
        Node tempNode;
        StringBuilder polyOutput = new StringBuilder();

        for (i = 0; i < this.getSize(); i++) {
            tempNode = this.getNode(i);
            double tempCoef = tempNode.getCoefficient();
            int tempExp = tempNode.getExponent();

            if (i != 0) {
                polyOutput.append(" + ");
            }

            if (tempCoef != 0) {
                if (tempExp == 0) {
                    polyOutput.append(tempCoef);
                }
                else if (tempExp > 0) {
                    if (tempExp == 1) {
                        polyOutput.append(tempCoef).append("x");
                    }
                    else {
                        polyOutput.append(tempCoef).append("x^").append(tempExp);
                    }
                }
            }
        }  
        return polyOutput.toString();
    }
}