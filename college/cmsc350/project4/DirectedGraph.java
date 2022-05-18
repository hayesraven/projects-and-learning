/**
* Title: Project 4 - DirectedGraph
* Name: Cameron Hayes
* Date: 10 May 2022
* Description: DirectedGraph class, defines primary object for project
*/
package project4;

import java.util.*;

public class DirectedGraph<V> {
    /* Variables */
    public V startVertex = null;    // "head" of graph
    Set<V> discovered = new HashSet<>();    // Hashset, stores discovered nodes
    Set<V> visited = new HashSet<>();   // Hashset, stores visited nodes
    ParenthesizedList parenVertices = new ParenthesizedList();
    Hierarchy hieraVertices = new Hierarchy();
    LinkedList<Vertex> adjacencyList = new LinkedList<>();

    /* Nested class for vertices that make up graph */
    static class Vertex {
        // Attributes
        private String name;
        private LinkedList<Vertex> edges = new LinkedList<>();
        Vertex next = null;

        // Constructor
        public Vertex(String name) {
            this.name = name;
        }

        // Accessor
        public String getName() {
            return this.name;
        }
    }   // End of nested class Vertex

    /* Recursively perform a depth first search of the directed graph */
    private void depthFirstSearch(V v) {
        // if the vertex has already been discovered, flag a cycle and return
        if (discovered.contains(v)) {
            hieraVertices.cycleDetect();
            parenVertices.cycleDetect();
            return;
        }

        // Else, toString the vertex in both sets of representation
        hieraVertices.processVertex((Vertex) v);
        parenVertices.processVertex((Vertex) v);

        // Mark the vertex as both discovered and visited
        discovered.add(v);
        visited.add(v);

        // Descend 'past' the vertex
        hieraVertices.descendVertex();
        parenVertices.descendVertex();

        // Create a new vertex to track the edges without modifying the original
        Vertex findEdge = findVertex((Vertex) v);

        // Execute if vertex has edges
        if (findEdge != null) {
            // Return a new linked list of all edges associated with that vertex
            LinkedList<V> listVertices = (LinkedList<V>) findEdge.edges;

            // Check all adjacent vertices 
            if (listVertices.isEmpty() == false) {
                for (int i = 0; i < listVertices.size(); i++) {
                    depthFirstSearch(listVertices.get(i));
                }
            }
        }

        // Ascend 'above' the vertex (all adjacent vertices have been searched)
        hieraVertices.ascendVertex();
        parenVertices.ascendVertex();
        
        discovered.remove(v);
    }   // End of recursive depthFirstSearch
    
    /* Search for vertex to determine where to be added */
    public Vertex findVertex(Vertex v) {
        // Look through adjacency linked list and return if a match is found
        for(int i = 0; i < adjacencyList.size(); i++) {
            if (adjacencyList.get(i).name.equals(v.name)) {
                return adjacencyList.get(i);
            }
        }
        // Return null if no node matches the new one
        return null;
    }   // End of findVertex

    /* Add edges to a directed graph */
    public void addEdge(Vertex origVertex, Vertex newVertex) {
        // Go match the vertex
        Vertex temp = findVertex(newVertex);
        // Save off the info
        if(temp != null) {
            newVertex = temp;
        }
        // Add the vertex
        origVertex.edges.add(newVertex);
    }   // End of addEdge

    /* Kick off recursive depth first search using the starting vertex */
    public void depthFirstSearch() {
        // Empty the hash sets before beginning search
        if (discovered.isEmpty() == false) {
            discovered.clear();
        }
        if (visited.isEmpty() == false) {
            visited.clear();
        }
        // Begin recursive search
        depthFirstSearch(startVertex);
    }   // End of depthFirstSearch()

    /* Display any unreachable vertices */
    public void cantReach() {
        // Iterate through adjacency list
        for (int i = 0; i < adjacencyList.size(); i++) {
            Vertex temp = adjacencyList.get(i);
            // Throw error if a vertex cannot be found in the adjacency list
            if (visited.contains(temp) == false) {
                System.out.println(temp.name + " cannot be reached.");
                visited.add((V) temp);
            }
        }
    }   // End of cantReach()
}   // End of DirectedGraph
