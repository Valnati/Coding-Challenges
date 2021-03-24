package Tests;

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
			System.out.println("Start: " + start + "    MID: " + midpoint + "    END: " + end );
			if (nums[midpoint] == target) index = midpoint;
		}
		return index;
	}
	
	public static void main(String[] args) {
		int[] nums = {6,6,6,6,6,6, 6,6,6,6};
		int[] sol = solution(nums, 6); 
		System.out.println(sol[0] + " " + sol[1]);
		
		int[] nums2 = {5,7,7,8,8,10};
		sol = solution(nums2, 8); 
		System.out.println(sol[0] + " " + sol[1]);
	}
	
	
	
	//public static int coolerSolution() {
		/*
		class Solution {
		    int findLeft(int nums[],int target){
		        int l=0,r=nums.length-1;
		        while(l<=r){
		            int m=l+(r-l)/2;
		            if(nums[m]>=target) r=m-1;
		            else l=m+1;
		        }
		        return r+1<nums.length && nums[r+1]==target ? r+1 : -1;
		    }
		     int findRight(int nums[],int target){
		        int l=0,r=nums.length-1;
		        while(l<=r){
		            int m=l+(r-l)/2;
		            if(nums[m]<=target) l=m+1;
		            else r=m-1;
		        }
		        return l-1>=0 && nums[l-1]==target ? l-1 : -1;
		    }
		    public int[] searchRange(int[] nums, int target) {
		        int left=findLeft(nums,target);
		        int right=findRight(nums,target);
		        return new int[]{left,right};
		    }
		}
		****/
	}
}
