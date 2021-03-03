import java.util.HashMap;
import java.util.Map;

public class firstNotRepeatingCharacter {

/***
 * Given a string s consisting of small English letters, 
 * find and return the first instance of a non-repeating 
 * character in it. If there is no such character, return '_'.
 * 
 * Original answer used Hashmap
 * also consider simple array, so position is saved inherently
 * 
 * The space cost is constant.
 * The time cost is O(n) where n is the size of the String array.
 * Specifically, we iterate through it once to form the Map,
 * and a second time to check for non-repeating characters.
 * 
 * @param s
 * @return
 */
	
    public static void main (String[] args) {
        String a = "I am a string with many duplicates";
        System.out.println(firstNotRepeatingCharacter(a));
    }

	public static char firstNotRepeatingCharacter(String s) {
	    if (s.length()==1) return s.charAt(0);
	    if (s.length() <= 0) return '_';
	    Map<Character, Integer> knownChars = new HashMap<>();
	    for (int i = 0; i < s.length(); i++) {
			if (knownChars.containsKey(s.charAt(i))) {
				knownChars.merge(s.charAt(i), 1, Integer::sum);
			} else knownChars.put(s.charAt(i), 1);
	    }
		for (int i= 0; i < s.length(); i++) {
			if (knownChars.get(s.charAt(i)) == 1) return s.charAt(i);
	    }
	    return '_';
	}
}
