/**
* Title: Project - Media
* Name: Cameron Hayes
* Date: 13 DEC 2021
* Description: Parent Media class
*/
package project;

public abstract class Media {
    // Attributes
    private int id;
    private String title;
    private int year; // validate that 4 digits
    private boolean rentStatus;
    
    // Overloaded Constructor
    public Media(int id, String title, int year, boolean rentStatus) {
        if (title == null || title.isBlank() || title.isEmpty())
            throw new IllegalMediaArgumentException(title);
        if (year <= 0)
            throw new IllegalMediaArgumentException(year);
        this.id = id;
        this.title = title;
        this.year = year;
        this.rentStatus = rentStatus;
    }
    
    // Accessors
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
    public boolean getRentStatus() {
        return rentStatus;
    }

    // Mutators
    public void setTitle(String title) {
        this.title = title;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setRentStatus(boolean rentStatus) {
        this.rentStatus = rentStatus;
    }

    // Calculate rental fee; for generic media it is flat fee $3.50
    public double calculateRentalFee() {
        return 3.50;
    }
        
}
