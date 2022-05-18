/**
* Title: Project - MovieDVD
* Name: Cameron Hayes
* Date: 13 DEC 2021
* Description: Child MovieDVD class, inherits from Media
*/
package project;

public class MovieDVD extends Media {
    // Attributes
    private double size; // value in MB

    // Overloaded Constructor
    public MovieDVD(int id, String title, int year, boolean rentStatus, double size) {
        super(id, title, year, rentStatus);
        if (size <= 0)
            throw new IllegalMovieDVDArgumentException(size);
        this.size = size;
    }

    // Accessors
    public double getSize() {
        return size;
    }

    // Mutators
    public void setSize(double size) {
        this.size = size;
    }

    // toDisplay string
    @Override
    public String toString() {
        return "MovieDVD [id=" + getId() + ", title=" + getTitle() + ", year="
        + getYear() + ", size=" + getSize() + "MB" + ", in stock=" + getRentStatus() + "]";
    }
}
    
