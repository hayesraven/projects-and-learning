/**
* Title: Project - Manager
* Name: Cameron Hayes
* Date: 13 DEC 2021
* Description: primary methods used to provide functionality
*/
package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Manager {
    /* Variables */
    private String type, title, filepath;
    private int id, year, numChapters, length, tmpInt, option;
    private double size;
    private boolean rentStatus, tmpBool;
    private Scanner mediaFile;
    private Scanner scan = new Scanner(System.in);

    ArrayList<Media> mediaShelf = new ArrayList<Media>( );

    /* Default Constructor */
    public Manager () {

    }

    /* Loads media database from specified file and populates arraylist */
    public String LoadMedia() {
        // User specifies file
        System.out.println("Enter the filepath that you wish to load the media from:");
        filepath = scan.nextLine();
        System.out.println();
        // Calls Read method to populate arraylist
        Read(filepath);
        return filepath;
    }   // End of LoadMedia

    /* Finds media object based on title*/
    public void FindMedia() {
        // User inputs title of media they would like to find
        System.out.println("What title would you like to find?");
        title = scan.nextLine();

        // If a media database is not loaded, will throw user back to main menu
        if (mediaShelf.isEmpty()) {
            System.out.println("You'll need to load a media database first.");
        }
        else {
            Media tmpMedia = null;
            System.out.println("Now printing all media with that name...");
            // Loops through arraylist and lists all media objects with user-specified title
            for (int i = 0; i < mediaShelf.size(); i++) {
                tmpMedia = mediaShelf.get(i);
                if (tmpMedia.getTitle().equals(title)) {
                    System.out.println(tmpMedia.toString());
                }      
            }
        }
        System.out.println();
        return;
    }   // End of FindMedia
    
    /* Rent a media object */
    public void RentMedia(String filepath2) {

        System.out.println("Please enter the ID of the item you would like to rent:");
        id = scan.nextInt();
        scan.nextLine();

        // If a media database is not loaded, will throw user back to main menu
        if (mediaShelf.isEmpty()) {
            System.out.println("You'll need to load a media database first.");
        }
        else {
            Media tmpMedia = null;
            // Loops through arraylist and finds media object that matches user-specified ID
            for (int i = 0; i < mediaShelf.size(); i++) {
                tmpMedia = mediaShelf.get(i);
                if (tmpMedia.getId() == id) {   // Executes if match is found
                    if (tmpMedia.getRentStatus() == false) {    // Executes if media is already rented
                        System.out.println("It appears that we don't have that in stock!");
                        return;
                    }
                    else if (tmpMedia.getRentStatus() == true) {    // Executes if media is in stock
                        mediaShelf.remove(i);
                        tmpMedia.setRentStatus(false);
                        mediaShelf.add(tmpMedia);
                        mediaShelf.trimToSize();
                        System.out.println("Media successfully rented. Your rental price is: " 
                            + mediaShelf.get(mediaShelf.size()-1).calculateRentalFee());    // Print rental fee
                        Write(filepath);
                        return;
                    }
                }      
            }
            // Executes if user inputs an ID that isn't reflected in the database
            System.out.println("It doesn't appear like we have that item at all.");
        }
        return;
    }   // End of RentMedia

    /* Add media objects to arraylist, can overwrite existing files to store database in or create new ones */
    public void AddMedia(String filepath) {
        // Variables 
    	tmpBool = true;

    	// Main Action
        while (tmpBool) {
    	    System.out.println("What type of media do you want to add?\n1. EBook\n2. MovieDVD\n3. MusicCD");
		    option = scan.nextInt();
		    scan.nextLine();
		    System.out.println("Please enter the title: ");
		    title = scan.nextLine();
            System.out.println("Please enter the year it was released: ");
		    year = scan.nextInt();
            scan.nextLine();
            id = this.IdGen();
            rentStatus = true;
		
		    switch (option) { // switch statement uses option variable for cases

			    case 1: // Creates an EBook object
                    try {
                        System.out.println("Please enter how many chapters the ebook has:");
                        numChapters = scan.nextInt();
                        scan.nextLine();

                        /* Creates the object and adds it to the arraylist */
                        Media mediaEBook = new EBook(id,title,year,rentStatus,numChapters);
                        mediaShelf.add(mediaEBook);
                        mediaShelf.trimToSize();
                    }
                    catch (IllegalMediaArgumentException e) {
                        System.out.println("\nInvalid input, try again "+ e.getMessage()+e.toString());
                    }
                    catch (IllegalEBookArgumentException e) {
                        System.out.println("\nInvalid input, try again "+ e.getMessage()+e.toString());
                    }
                    catch (InputMismatchException e) {
                        System.out.println("ERROR: Input not recognized.");
                    }
                    break;

			    case 2: // Creates a MovieDVD object
                    try {
                        System.out.println("Please enter how big the movie is (MB):");
                        size = scan.nextDouble();
                        scan.nextLine();

                        /* Creates the object and adds it to the arraylist */
                        Media mediaMovie = new MovieDVD(id,title,year,rentStatus,size);
                        mediaShelf.add(mediaMovie);
                        mediaShelf.trimToSize();
                    }
                    catch (IllegalMediaArgumentException e) {
                        System.out.println("\nInvalid input, try again "+ e.getMessage()+e.toString());
                    }
                    catch (IllegalMovieDVDArgumentException e) {
                        System.out.println("\nInvalid input, try again "+ e.getMessage()+e.toString());
                    }
                    catch (InputMismatchException e) {
                        System.out.println("ERROR: Input not recognized.");
                    }
                    break;

                case 3: // Creates a MusicCD object
                    try {
                        System.out.println("Please enter how long the CD is (hours):");
                        length = scan.nextInt();
                        scan.nextLine();

                        /* Creates the object and adds it to the arraylist */
                        Media mediaMusic = new MusicCD(id,title,year,rentStatus,length);
                        mediaShelf.add(mediaMusic);
                        mediaShelf.trimToSize();
                    }
                    catch (IllegalMediaArgumentException e) {
                        System.out.println("\nInvalid input, try again "+ e.getMessage()+e.toString());
                    }
                    catch (IllegalMovieDVDArgumentException e) {
                        System.out.println("\nInvalid input, try again "+ e.getMessage()+e.toString());
                    }
                    catch (InputMismatchException e) {
                        System.out.println("ERROR: Input not recognized.");
                    }
                    break;
				
			    default: // error handling
				    System.out.println("Error! Input not allowed"); // error message		
		    }
            // gives users the option to continue adding objects
            try {
                System.out.println("Would you like to add another item?\n1. Yes\n2. No");
                tmpInt = scan.nextInt();
                scan.nextLine();
            
                if (tmpInt == 1) {
                    tmpBool = true;
                }
                else if (tmpInt == 2) {
                    tmpBool = false;
                }
                else {
                    System.out.println("ERROR: Invalid option selected.");
                    tmpBool = false;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("ERROR: Input not recognized.");
                tmpBool = false;
            }
        }	
        System.out.println("Enter the filepath that you wish to save the media to:");
        filepath = scan.nextLine();
        Write(filepath);
    }   // End of AddMedia

    /* Remove media objects from arraylist, can overwrite existing files to store database in or create new ones */
    public void RemoveMedia(String filepath) {
        // Variables
        tmpInt = 0;
        
        // Main Action
        try {
            System.out.println("Please enter the ID of the media you wish to remove:");
            tmpInt = scan.nextInt();
            scan.nextLine();
            // Executes if arraylist is empty
            if (mediaShelf.isEmpty()) {
                System.out.println("You'll need to load a media database first.");
            }
            else {
                Media tmpMedia = null;
                // Loops through arraylist until it finds a match, removes the matching object,
                // and then updates the database file
                for (int i = 0; i < mediaShelf.size(); i++) {
                    tmpMedia = mediaShelf.get(i);
                    if (tmpMedia.getId() == tmpInt) {
                        mediaShelf.remove(i);
                        System.out.println("Media successfully removed.");
                        System.out.println("Enter the filepath that you wish to save the updated list to:");
                        filepath = scan.nextLine();
                        Write(filepath); 
                        return;
                    }
                }
                // Executes if no media object ID matches user specified ID
                System.out.println("ERROR: Media not found.");
            }    
        }
        catch (InputMismatchException e) {
            System.out.println("ERROR: Input not recognized.");
        }
    }   // End of RemoveMedia

    /* ID Generator for Media Objects */
    public int IdGen() {
    	// Method variables
        tmpInt = 100;
        // Main Action
        if (mediaShelf.isEmpty()) {
            return tmpInt;
        }
        else {            
            for (int i = 0; i < mediaShelf.size(); i++) {
                if (mediaShelf.get(i).getId() >= tmpInt) {
                    tmpInt += 1;
                }
            }      
        return tmpInt;  
        }
    }   // End of IdGen

    private void Write(String filepath) { 
		// Write content of MediaShelf ArrayList<> to file.
		try {
	        FileOutputStream fos = new FileOutputStream(filepath, false);  // Write to (not append)
	      
	        PrintWriter pw = new PrintWriter(fos);
	        Media tmpMedia = null;

	        for (int i = 0; i < mediaShelf.size(); i++) {
	    	    tmpMedia = mediaShelf.get(i);
	    	    id = tmpMedia.getId();
                title = tmpMedia.getTitle();
                year = tmpMedia.getYear();
                rentStatus = tmpMedia.getRentStatus(); 
                type = tmpMedia.getClass().getSimpleName();

                switch(type) {
                    
                    case "EBook":
                        numChapters = ((EBook) tmpMedia).getNumChapters();
                        pw.print(type + "," + id + "," + title + "," + year 
                        + "," + rentStatus + "," + numChapters + "\n");
                        break;

                    case "MovieDVD":
                        size = ((MovieDVD) tmpMedia).getSize();
                        pw.print(type + "," + id + "," + title + "," + year 
                        + "," + rentStatus + "," + size + "\n");
                        break;

                    case "MusicCD":
                        length = ((MusicCD) tmpMedia).getLength();
                        pw.print(type + "," + id + "," + title + "," + year 
                        + "," + rentStatus + "," + length + "\n");
                        break;

                    default:
                        System.out.println("ERROR: Issue in writing media");
                        break;  
                    }
	        }  
        // Release the resources associated with media.txt
	    pw.close( );
	    }
        catch(FileNotFoundException fnfe) {
	        System.out.println("Unable to find media.txt");
	    }
        return;
	}   //End of Write
		
	private void Read(String filepath)  {
		// Write content of BookShelf ArrayList<> from file.
		try {
			mediaFile = new Scanner(new File(filepath));
            
            // Flush the arraylist
            mediaShelf.clear();   
	        
            while (mediaFile.hasNext()) {    // test for the end of the file
	            String input = mediaFile.nextLine();
	            StringTokenizer mediaString = new StringTokenizer(input, "," );
	            type = mediaString.nextToken();
	            id = Integer.parseInt(mediaString.nextToken());
	            title = mediaString.nextToken();
                year = Integer.parseInt(mediaString.nextToken());
                rentStatus = Boolean.parseBoolean(mediaString.nextToken());

	            try {

                    switch(type) {
                        
                        case "EBook":
                            numChapters = Integer.parseInt(mediaString.nextToken());
                            EBook ebook = new EBook(id,title,year,rentStatus,numChapters);
                            mediaShelf.add(ebook);
                            break;

                        case "MovieDVD":
                            size = Double.parseDouble(mediaString.nextToken());
                            MovieDVD movie = new MovieDVD(id,title,year,rentStatus,size);
                            mediaShelf.add(movie);
                            break;

                        case "MusicCD":
                            length = Integer.parseInt(mediaString.nextToken());
                            MusicCD music = new MusicCD(id,title,year,rentStatus,length);
                            mediaShelf.add(music);
                            break;

                        default:
                            System.out.println("ERROR: Issue in reading media");
                            break;          
	                }
	            }
	            catch (NumberFormatException nfe) {
	            	 System.out.println("Error in media record: " + input +"; media ignored.");
	            }
	        }
            // Gives the user to list the contents of the arraylist to the screen
            try {
                System.out.println("Would you like to list the media?\n1. Yes\n2. No");
                tmpInt = scan.nextInt();
                scan.nextLine();
            
                switch(tmpInt) {
    
                    case 1:
                        Media tmpMedia = null;
                        for (int i = 0; i < mediaShelf.size(); i++) {
                            tmpMedia = mediaShelf.get(i);
                            System.out.println(tmpMedia.toString());
                        }	
                        break;
    
                    case 2:
                        System.out.println("Returning to main menu...\n");
                        break;
    
                    default:
                        System.out.println("ERROR: You didn't select yes or no. Returning to main menu...\n");
                        break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("ERROR: Invalid input. Returning to main menu...\n");
            }
    	}
        catch (FileNotFoundException fnfe){
            System.out.println("Unable to find media record");
            return;
        }
        // Clean Up
        finally {
            try {
                mediaFile.close();
            }
            catch (NullPointerException e) {
                return;
            }     
        }
        return;   
	}   // End of Read
}
