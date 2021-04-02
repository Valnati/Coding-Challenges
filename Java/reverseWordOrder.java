/*************************
*Given a char array, reverse the 
*words' order in place.
*
*Approach opts to reverse the
*entire array, then search for individual words.
*
*Time complexity is O(n), where the array is 
*iterated through twice total.
*Space complexity is constant.
***************************/


public class reverseWordOrder {
	public static void solution(char[] message) {
	    reverseChar(message, 0, message.length-1);
	    
	    for(int wordstart = 0; wordstart < message.length; wordstart++) {
	        int space = wordstart;
	        while(space < message.length && message[space] != ' ') space++;
	        reverseChar(message, wordstart, space-1);
	        wordstart = space;
	    }
	}

	public static void reverseChar(char[] message, int left, int right) {
		while(left < right) {
			char temp = message[left];
			message[left] = message[right];
			message[right] = temp;
			left++;
			right--;
		}
	}
	
	public static void main (String[] args) {
        final char[] sample = "ground higher to move must we".toCharArray();
        solution(sample);
        for(char i : sample) System.out.print(i);
        //prints "we must move to higher ground"
	}
}
