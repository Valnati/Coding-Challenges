/******************************
*Given two arrays A and B of equal size, 
*the advantage of A with respect to B is 
*the number of indices i for which A[i] > B[i].
*
*Return any permutation of A that maximizes
*its advantage with respect to B.
*
*This is done by using an index order lookup array
*to route through B, placing A's values in optimal
*indexes according to the lookup. 
*
*The time complexity is O(nlogn) (using two sorts, and two
*total iterations through the arrays).
*
*The space complexity is O(n), as two new arrays of length B
*are made, one index order lookup and one returned solution.
********************************/

import java.util.Arrays;

public class advantageCount {
  
    public static void main(String[] args) {
    	int[] A = {1,2,-1,6,5,2,7,3,1,0};
    	int[] B = {2,3,4,-23,6,3,4,5,7,6};
    	int[] sol = solution(A, B);
    	
    	for(int i: sol) System.out.print(i);
    }
    
    public static int[] solution(int[] A, int[] B) {
    	//simple sort A
    	Arrays.sort(A);
    	//make copy array
    	int[] sol = new int[B.length];
    	//make index-sorted array for lambda sort
    	Integer[] map = new Integer[B.length];
    	//remove nulls
    	for (int i=0;i<map.length;i++) map[i] = i;
    	//reverse sort
    	Arrays.sort(map, (h,j) -> Integer.compare(A[j], B[h]));
    	//set up start and end pointers
    	int start = 0, end = B.length-1;
    	//use index-sorted array as route to check values
    	for (int index: map) {
    		//if a's biggest is larger than b's biggest, use it
    		//otherwise place the smallest, and move used pointer in
    		sol[index] = A[end] > B[index] ? A[end--] : A[start++];
    	}
    	return sol;
    }
}
