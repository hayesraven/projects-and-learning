/**
* Title: Project - MusicCD
* Name: Cameron Hayes
* Date: 13 DEC 2021
* Description: Child MusicCD class, inherits from Media
*/
package project;

import java.util.Calendar;

public class MusicCD extends Media {
    // Attributes
    private int length;

    // Overloaded Constructor
    public MusicCD(int id, String title, int year, boolean rentStatus, int length) {
        super(id, title, year, rentStatus);
        if (length <= 0)
            throw new IllegalMusicCDArgumentException(length);
        this.length = length;
    }

    // Accessors
    public int getLength() {
        return length;
    }

    // Mutators
    public void setLength(int length) {
        this.length = length;
    }

    // override parent's
    @Override
    public double calculateRentalFee() {
        double fee = length * 0.02; // basic fee
        int currYear = Calendar.getInstance().get(Calendar.YEAR);
        if (this.getYear() == currYear)
        fee += 1; // add $1.00 fee
        return fee;
    }

    // toDisplay string
    @Override
    public String toString() {
        return "MusicCD [id=" + getId() + ", title=" + getTitle() + ", year="
        + getYear() + ", length=" + getLength() + "hours" + ", in stock=" + getRentStatus() + "]";
    }
}

