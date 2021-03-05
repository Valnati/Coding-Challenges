/*******
* Given an integer array, remove the stated value
* and return the length of the array.
* Solution uses two pointers to pass over unwanted values
* and find all wanted values, leaving cruft at the array's end.
* Time cost is O(n), where n is the size of the array.
* Space cost is constant.
*/

public int removeElement(int[] nums, int val) {
    //receive will wait for a wanted number
    int receive = 0;
    //find will hunt for a wanted number
    for (int find = 0; find<nums.length; find++) {
        //this number is wanted
        if (nums[find]!=val) {
            //it is placed at the receive spot
            nums[receive]=nums[find];
            //and receive moves up
            receive++;
        } //if number is not wanted, find will move until it gets a wanted number
        //then it will copy the array into the receive slot, overwriting the unwanted number
        //and receive will move to the next slot
    }
    //every number find skipped is ignored in receive's final value, so receive is the new array length
    return receive;
}
