//Given an array and a maximum value the array may hold
//the array is sorted in linear, or O(2n) time.
//This requires a maximum in the array, which could be found
//through another iteration to get the max value.

import java.util.Arrays;

public class SortScores {

    public static int[] sortScores(int[] unsortedArray, int maxValue) {

        int[] valueTotals = new int[maxValue];
        int[] orderedArray = new int[unsortedArray.length];
        
        for (int i = 0; i < unsortedArray.length; i++) {
            valueTotals[unsortedArray[i]] += 1;
        }
        
        int counter = 0;
        for (int j = valueTotals.length - 1; j >= 0; j--) {
            while (valueTotals[j] > 0) {
                orderedArray[counter] = j;
                valueTotals[j] --;
                counter++;
            }
        }

        return orderedArray;
    }
    
	public static void main (String[] args) {
		int[] unordered = {60, 33, 50, 99, 1, 33, 67, 2, 3, 3, 45};
		int[] ordered = sortScores(unordered, 100);
		System.out.println(Arrays.toString(ordered));
    //output: [99, 67, 60, 50, 45, 33, 33, 3, 3, 2, 1]
	}
}
