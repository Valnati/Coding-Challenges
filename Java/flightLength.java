/**********************
*Given an int array of movie Lengths, 
*and a total flight time, find two
*movies that exactly add up to the flight time.
*
*Uses a Set to dynamically add values as they 
*are checked.
*
*Time complexity of O(n), iterating through array once.
*Space complexity is O(n), the length of the array.
**********************/
package Tests;

import java.util.HashSet;
import java.util.Set;

public class flightLengths {

	    public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength) {

	        if (movieLengths.length == 0 || flightLength <= 0) return false;
	        // determine if two movies add up to the flight length
	        Set<Integer> lengths = new HashSet<>();
	        
	        for(int i = 0; i<movieLengths.length; i++) {
	            if (lengths.contains(flightLength - movieLengths[i])) {
	            	return true;
	            }
	            else lengths.add(movieLengths[i]);
	        }
	        return false;
	    }
	    
	    public static void main (String[] args) {
	    	int[] movieLengths = {46, 50, 66, 12, 77, 33, 82};
	    	int flightLength = 112;
	    	boolean result = canTwoMoviesFillFlight(movieLengths, flightLength);
	    	System.out.println(result); //prints true, 46 and 66
	    	flightLength = 100;
	    	result = canTwoMoviesFillFlight(movieLengths, flightLength);
	    	System.out.println(result); //prints false, 50 counted once
	    }
}
