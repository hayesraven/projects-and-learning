/**
* Title: Project 2 - Main 
* Name: Cameron Hayes
* Date: 24 APR 2022
* Description: Main Execution Class for Polynomial Project
*/

package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class Main {
    // Variables
    private static int i; 
    public static List<Polynomial> polyList = new ArrayList<>();
	public Polynomial[] polyArray;

    // Allows user to choose input file and then reads and captures polynomials for further use
    public static ArrayList<String> splitFile() {
        // Variables
        ArrayList<String> inputList = new ArrayList<>();
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
    }

    // Used to print out polynomials
    private static void printPolys() {
        for (i = 0; i < polyList.size(); i++) {
            System.out.println(polyList.get(i).toString());
        }
    }

    /* Uses the "compareTo" method within the Polynomial Class
     to check if the polynomials are listed in strong order */
    private static boolean strongOrderCheck() {
        for (int i = 0; i < polyList.size(); i++) {
            if (polyList.size() == (i + 1)) {
                continue;
            }
            if ((polyList.get(i).compareTo(polyList.get(i+1))) < 0) {
                return false;
            }
        }
        return true;
    }

    /* Calls the checkSorted method within the OrderedList Class
     to check if the polynomials are listed in weak order */
    private static boolean weakOrderCheck() {
        return OrderedList.checkSorted(polyList);
    }

    // Main Execution
    public static void main(String[] args) {
        try {
            // Grabs the requested file and splits the ingested arrays into an array list
            ArrayList<String> splitInput = splitFile();

            // Iterates through the array list and creates a new Polynomial object for each
            for (i = 0; i < splitInput.size(); i++) {
                Polynomial poly = new Polynomial(splitInput.get(i));
                polyList.add(poly);
            }
            // Main output, print the polynomials ingested and run the strong and weak order checks
            System.out.println("Now printing the ingested polynomials...");
            printPolys();
            System.out.println("\nPolynomial Input is in Strong Order: " + strongOrderCheck());
            System.out.println("Polynomial Input is in Weak Order: " + weakOrderCheck());
            System.out.println("\nThanks for letting me look at these polynomials!");
        }
        // Executes if an exception is thrown, if polynomials have invalid syntax
        catch (InvalidPolynomialSyntax error) {
            System.out.println(error.toString());
        }    
    } 
}
