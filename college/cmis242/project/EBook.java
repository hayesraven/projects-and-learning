/**
* Title: Project - EBook
* Name: Cameron Hayes
* Date: 13 DEC 2021
* Description: Child EBook class, inherits from Media
*/
package project;

import java.util.Calendar;

public class EBook extends Media {
    // Attributes
    private int numChapters;
    
    // Overloaded Constructor
    public EBook(int id, String title, int year, boolean rentStatus, int numChapters) {
        super(id, title, year, rentStatus);
        if (numChapters <= 0)
            throw new IllegalEBookArgumentException(numChapters);
        this.numChapters = numChapters;
    }

    // Accessors
    public int getNumChapters() {
        return numChapters;
    }

    // Mutators
    public void setNumChapters(int numChapters) {
        this.numChapters = numChapters;
    }
    
    // override parent's
    @Override
    public double calculateRentalFee() {
        double fee = numChapters * 0.10; // basic fee
        int currYear = Calendar.getInstance().get(Calendar.YEAR);
        if (this.getYear() == currYear)
        fee += 1; // add $1.00 fee
        return fee;
    }

    // toDisplay string
    @Override
    public String toString() {
    return "EBook [id=" + getId() + ", title=" + getTitle()
    + ", year=" + getYear() + ", chapters=" + getNumChapters() + ", in stock=" + getRentStatus() + "]";
    }
}
