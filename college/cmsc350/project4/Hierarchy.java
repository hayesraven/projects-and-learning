/**
* Title: Project 4 - Hierarchy
* Name: Cameron Hayes
* Date: 10 May 2022
* Description: Hierarchy class, builds a hierarchical view of the directed graph
*/
package project4;

import project4.DirectedGraph.Vertex;

public class Hierarchy implements DFSActions {
	/* Variables */
	static String hierString = "";
	int level = 0;

	// Detect cycle action
	@Override
	public void cycleDetect() {
		hierString += " * ";
	}

	// Ascend in level 
	@Override
	public void ascendVertex() {
		level--;
	}

	// Descend in level
	@Override
	public void descendVertex() {
		level++;
	}

	// Process vertices, uses level to determin indent
	@Override
	public void processVertex(Vertex v) {
		hierString += "\n";

		for (int i = 0; i < level; i++) {
			hierString += "\t";
		}

		hierString += v.getName();
	}

	// toString method
	@Override
	public String toString() {
		return hierString;
	}  
}	// End of Hierarchy
