import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class isSumPossible {
	//Given an array of numbers and a value, 
	//return whether it's possible for two numbers
	//to sum to the given value. Each number
	//can only be used once.

    //Approach one uses a hashmap, counting occurences of each number.
    //Approach two uses a hashset, and does not store this information.
  
	public static boolean isSumPossibleHashMap(int[] a, int k) {
    
		HashMap<Integer, Integer> values = new HashMap<>();
		//key is number, value is occurrence
		
		for (int i: a) {
			if (values.containsKey(i)) values.put(i, values.get(i) + 1);
			else values.put(i, 0);
		}
		
		for (int i: a) {
            if (values.containsKey(k-i)) {
				if (k/i != 2 || k/i == 2 && values.get(k-i) >= 2) return true;
			}
		}
		return false;
	}
	
    public boolean isSumPossibleHashSet() {
  		HashSet<Integer> val = new HashSet<>();
    
  		for (int i: a) {
			if (val.contains(k - a[i])) return true;
			val.add(a[i]);
		}
		return false;  
    }
  
	public static void main (String[] args) {
		int[] unordered = {60, 33, 50, 99, 11, 50, 33, 6, 2, 3, 3, 45};
		boolean approachOne = isSumPossibleHashMap(unordered, 100);
		boolean approachTwo = isSumPossibleHashSet(unordered, 100);
    
		System.out.println(approachOne); //returns true (because of 50 and 50)
		System.out.println(approachOne); //return true (because of 50 and 50)
    }
}
