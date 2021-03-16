/***************************
*Given a string array of three words, and a 2d char array
*of a legend to convert each letter to a number, check
*if the resulting first two numbers add to the third number.
*If any number has leading zeroes, or the sum doesn't work, 
*return false. Otherwise, return true.
*
*Solution one builds a hashmap and equation to check.
*It has a time of O(nk), where n is the length of the solution
*array and k is the length of each word in the crypt array.
*N will always be less than the total amount of available characters.
*The space cost is constant, with a hashmap.
*
*Solution two solves in place, using the existing char array as 
*a pseudo hashmap.
*It has a time of O(nk), where n is the length of the solution
*array and k is the length of each word in the crypt array.
*N will always be less than the total amount of available characters.
*The space cost is constant, using existing variables.
*
******************************/
//SOLUTION ONE
boolean isCryptSolution(String[] crypt, char[][] solution) {
    int num1 = 0;
    int num2 = 0;
    int total = 0;
    Map<Character, Integer> sol = new HashMap<>();
    for (int i = 0; i < solution.length; i++) {
        sol.put(solution[i][0], (Integer) Character.getNumericValue(solution[i][1]));
    }
    for (int i = 0; i < crypt.length; i++) {
        if(sol.get(crypt[i].charAt(0)) == 0 && crypt[i].length() > 1) return false;
    }
    for (int i = 0; i < crypt[0].length(); i++) {
        num1 += sol.get(crypt[0].charAt(i));
        num1 *= 10;
    }
    for (int i = 0; i < crypt[1].length(); i++) {
        num2 += sol.get(crypt[1].charAt(i));
        num2 *= 10;
    }
    for (int letter = 0; letter < crypt[2].length(); letter++) {
        total += sol.get(crypt[2].charAt(letter));
        total *= 10;
    }
    
    if (num1 + num2 == total) return true;
    return false;
}

//SOLUTION TWO
boolean isCryptSolution(String[] crypt, char[][] solution) {
    for(char[] arr : solution){
        for(int i = 0; i < crypt.length; i++){
            crypt[i]=crypt[i].replace(arr[0],arr[1]);
        }
        System.out.println(Arrays.toString(crypt));
    }
    
    for(int i = 0; i < crypt.length; i++){
        if(!crypt[i].equals("0")&&crypt[i].startsWith("0"))
            return false;
    }
    
    return Long.parseLong(crypt[0])+Long.parseLong(crypt[1])==Long.parseLong(crypt[2]);
}
