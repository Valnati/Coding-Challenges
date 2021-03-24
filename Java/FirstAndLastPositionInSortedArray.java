/**********************
*Given a sorted array, return the range of the specified
*target value. Must be done within O(logn).
*
*A simple binary search extended to cover the 
*full breadth of a possible value, instead of 
*hunting for the first copy of it.
*
*Time is O(logn), as per usual binary search.
*Space is constant, with an int array length 2
*and 6 int variables made.
*********************/

public class FirstAndLastPositionInSortedArray {

	public static int[] solution(int[] nums, int target) {

        int[] sol = {0,0};
		
		sol[0] = findStartingIndex(nums, target);
		
		sol[1] = findEndingIndex(nums, target);
		
		return sol;
	}
	
	public static int findStartingIndex(int[] nums, int target) {
		int index = -1;
		int midpoint = 0;
		int start = 0;
		int end = nums.length-1;
		
		while (start <= end) {
			midpoint = start + (end-start)/2;
			if (target <= nums[midpoint])
			end = midpoint - 1;
			else start = midpoint +1;
			if (nums[midpoint] == target) index = midpoint;
		}
		return index;
	}
	
	public static int findEndingIndex(int[] nums, int target) {
		int index = -1;
		int midpoint = 0;

		int start = 0;
		int end = nums.length-1;
		
		while (start <= end) {
			midpoint = start + (end-start)/2;
			if (target >= nums[midpoint]) start = midpoint + 1;
			else end = midpoint - 1;
			if (nums[midpoint] == target) index = midpoint;
		}
		return index;
	}
	
	public static void main(String[] args) {
		int[] nums = {6,6,6,6,6,6, 6,6,6,6};
		int[] sol = solution(nums, 6); 
		System.out.println(sol[0] + " " + sol[1]); //returns [0, 9]
		
		int[] nums2 = {5,7,7,8,8,10};
		sol = solution(nums2, 8); 
		System.out.println(sol[0] + " " + sol[1]); //returns [3,4]
	}
}
