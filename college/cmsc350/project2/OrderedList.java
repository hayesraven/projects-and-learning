
/**
* Title: Project 2 - OrderedList 
* Name: Cameron Hayes
* Date: 24 APR 2022
* Description: OrderedList Class, used for checking weak order sorting
*/

package project2;

import java.util.List;

public class OrderedList {

    // Iterates through list of Polynomial objects and calls the bigger checkSorted method
    public static boolean checkSorted(List<Polynomial> polyList) {
        for (int i = 0; i < (polyList.size() - 1); i++) {
            Polynomial currPoly = polyList.get(i);
                
            if (checkSorted(polyList, currPoly) == false) {
                return false;
            }
        }
        return true;
    }
    // Uses list of polys and "current" poly to compare for weak ordering
    private static boolean checkSorted(List<Polynomial> polyList, Polynomial currPoly) {
        Polynomial nextPoly = polyList.get(polyList.indexOf(currPoly) + 1);

        if (nextPoly != null) {
            int tempInt = currPoly.compareTo(currPoly, nextPoly);

            if (tempInt > 0) {
                return true;
            }
        }
        return false;
    }   
}
