/***
*For a given array,
*Find the first duplicate number, and return it.
*
*Uses a HashMap and light dynamic programming
*to store the positions of values.
*
* The space cost is constant.
* The time cost is O(n), where n is the size of the int array.
* It is iterated through once to form the HashMap.
* 
* Likely there is a way without hashmap?
*/

int firstDuplicate(int[] a) {
    if (a.length > 1) {
        HashMap knownNum = new HashMap<>(); //key will be literal integer value, value will be position
        knownNum.put(a[0], a);
        for (int i=1; i < a.length; i++) {
            if (knownNum.containsKey(a[i])) {
                return a[i];
            } else {
                knownNum.put(a[i], i);
            }
        }
        return -1;
    }
    else return -1;
}
//a main function for running in an IDE
	public static void main (String[] args) {
		int[] a = {2, 1, 3, 5, 3, 2};
		System.out.println(firstDuplicate(a));
	}
}
