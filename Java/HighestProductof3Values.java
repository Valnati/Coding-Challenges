/******
* Given an array of integers, find the highest possible product
* using three values. Accounts for the cases of all positives,
* all negatives, and two negative values.
*
* Space cost is constant.
* Time cost is O(n) where n is the size of the array.
*
* Uses a greedy approach to track possible max/min at each step.
*******/

public static int highestProductOf3(int[] intArray) {
    if (intArray.length < 3) return 0;
    
    //hold information for later comparison
    int highest2 = intArray[0]*intArray[1];
    int lowest2 = intArray[0]*intArray[1];
    int highest = Math.max(intArray[0], intArray[1]);
    int lowest = Math.min(intArray[0], intArray[1]);
    int highest3 = intArray[0]*intArray[1]*intArray[2];

    for (int i=2; i<intArray.length; i++) {
        int current = intArray[i];
        //Does current value result in a higher final product when 
        //multiplied with the two previous extremes of pairs?
        highest3 = Math.max(Math.max(highest3, highest2 * current), lowest2 * current);
        //Continue this logic for the single value extremes
        highest2 = Math.max(Math.max(highest2, highest* current), lowest * current);

        lowest2 = Math.min(Math.min(lowest2, lowest * current), highest * current);
        //and record the new extreme for the next loop
        highest = Math.max(highest, current);

        lowest = Math.min(lowest, current);
    }
    return highest3;
}
