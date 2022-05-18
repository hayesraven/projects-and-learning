/**
* Title: Project 4 - DFSActions
* Name: Cameron Hayes
* Date: 10 May 2022
* Description: Generic interface for Hierarchy and ParenthesizedList
*/
package project4;

import project4.DirectedGraph.Vertex;

public interface DFSActions {
    // Generic parameters
    void cycleDetect();
	void ascendVertex();
	void descendVertex();
	void processVertex(Vertex v);
}	// End of DFSActions
