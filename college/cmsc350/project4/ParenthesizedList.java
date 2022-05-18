/**
* Title: Project 4 - ParenthesizedList
* Name: Cameron Hayes
* Date: 10 May 2022
* Description: Parenthesized class, builds a parenthesized view of the directed graph
*/
package project4;

import project4.DirectedGraph.Vertex;

public class ParenthesizedList implements DFSActions {
	// Variables
	static String parenString = "(";
	int level = 0;

	// Detect cycles
	@Override
	public void cycleDetect() {
		parenString += "*";
	}

	// Ascend level
	@Override
	public void ascendVertex() {
		parenString += ")";
	}

	// Descend level
	@Override
	public void descendVertex() {
		parenString += "(";
	}

	// Process vertices and add them into the string
    @Override
    public void processVertex(Vertex v) {
        parenString = parenString + " " + v.getName() + " ";
    }
    
	// toString method, gets rid of erroneous parentheses from descend/ascend actions
	@Override
	public String toString() {
		parenString = parenString.replace("(*)", "*");
		parenString = parenString.replace("()", "");
		parenString += ")";
		return parenString;
	}
}	// End of ParenthesizedList
