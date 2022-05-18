/**
* Title: Project 4 - Main 
* Name: Cameron Hayes
* Date: 10 May 2022
* Description: Main execution for directed graph project
*/
package project4;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import project4.DirectedGraph.Vertex;

public class Main {
    /* Variables */
    public static DirectedGraph<Object> newGraph = new DirectedGraph<>();

    /* Allows user to choose input file and then reads and captures vertices for further use */
    public static ArrayList<String> splitFile() {
        // Variables
        ArrayList<String> inputList = new ArrayList<String>();
        JFileChooser filePicker = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        filePicker.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int choice = filePicker.showOpenDialog(null);

        // Executes if the user selects a file and clicks open
        if (choice == JFileChooser.APPROVE_OPTION) {
            File inputFile;
            Scanner scanFile = null;

            while(true) {
                try {
                    inputFile = filePicker.getSelectedFile();
                    scanFile = new Scanner(inputFile);
                    scanFile.hasNextLine();
                    inputFile.isFile();
                    break;
                }
                // Throws an exception if the file chosen doesn't not exist
                catch (FileNotFoundException error) {
                    JOptionPane.showMessageDialog(null, "File not found!");
                }
                // Throws an exeception if the file chosen is empty
                catch (NoSuchElementException error) {
                    JOptionPane.showMessageDialog(null, "File is empty!");
                }
                finally {
                    scanFile = scanFile.reset();
                }
            }

            // Iterates through file and ingests input, terminating on newlines
            while(scanFile.hasNextLine()) {
                String inputLine = scanFile.nextLine();
                inputList.add(inputLine);
            }
            scanFile.close();
        }
        // Executes if the user clicks cancel in the dialog box
        else if (choice == JFileChooser.CANCEL_OPTION) {
            System.out.println("Cancelled!");
            System.exit(0);
        }
        return inputList;
    }   // End of splitFile()

    /* Iterates through the input file and builds a graph */
    public static void buildGraph(ArrayList<String> input) {
        // Variables
        try {
            String inputStr = "";
            // Add the vertices
            for (int i = 0; i < input.size(); i++) {
                // Grab line of input from array, split the line, 
                // and add the first one as the "head"
                inputStr = input.get(i);
                String[] edges = inputStr.split(" ");
                Vertex vertex = new Vertex(edges[0]);

                // Similar to head check of linked list
                if (newGraph.startVertex == null) {
                    newGraph.startVertex = vertex;
                }

                // Only add vertex if not already entered
                if (newGraph.adjacencyList.contains(vertex) == false) {
                    // Iterate to last vertex before adding if not start
                    if (vertex != newGraph.startVertex) {
                        Vertex prevVertex = newGraph.adjacencyList.getLast();
                        prevVertex.next = vertex;
                    }
                    newGraph.adjacencyList.add(vertex);
                }
            }
            // Clean out the input string and start your edge building at the start
            inputStr = "";
            Vertex vertex = (Vertex) newGraph.startVertex;

            // Add the edges
            for (int i = 0; i < input.size(); i++) {
                inputStr = input.get(i);
                String[] edges = inputStr.split(" ");

                // Move through each set of edge strings and add the edges
                for (int j = 1; j < edges.length; j++) {
                    Vertex temp = new Vertex(edges[j]);
                    newGraph.addEdge(vertex, temp);
                }
                // Move to next vertex
                vertex = vertex.next;
            }
        }
        // Catch any weird array issues
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: " + e);
            System.exit(0);
        }
    }   // End of buildGraph()

    /* Main Action */
    public static void main(String[] args) {
        // Take in a file and build a directed graph from the input
        ArrayList<String> vertexList = splitFile();
        buildGraph(vertexList);

        // Conduct the search
        newGraph.depthFirstSearch();

        // Print the representations
        System.out.println("Hierarchical View:" + newGraph.hieraVertices.toString() + "\n");
        System.out.println("Parenthesized View: \n" + newGraph.parenVertices.toString() + "\n");

        // Print any unreachable vertices
        newGraph.cantReach();
    }   // End of main
}
