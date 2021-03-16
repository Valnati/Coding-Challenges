/****************************
*Given a 2d char array, see if the current solution could be 
*a valid sudoku puzzle. This approach uses a Hashset
*and the fact the adding to the HashSet returns a boolean value
*to check if there are duplicate numbers.
*
*Time is constant, or O(n^2), where n is the constant size 9 of the puzzle.
*Space is constant, as a hashset is needed each time.
***************************//

package Tests;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuCheck {
	public static boolean sudokuChecker(char sudoku[][]) {
			
		Set<String> set = new HashSet<String>();
		
		for (int row = 0; row<9; row++) {
			for(int col = 0; col<9; col++) {
				if(sudoku[row][col] != '.' && !set.add(sudoku[row][col] + " in row " + row)) {
					return false;
				}
				if(sudoku[row][col] != '.' && !set.add(sudoku[row][col] + " in column " + row)) {
					return false;
				}
				if(sudoku[row][col] != '.' && !set.add(sudoku[row][col] + " in square " + row/3 + col/3)) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main (String[] args) {
		char[][] sudoku = 
			   {{'.', '.', '.', '1', '4', '.', '.', '2', '.'},
				{'.', '.', '6', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '1', '.', '.', '.', '.', '.', '.'},
				{'.', '6', '7', '.', '.', '.', '.', '.', '9'},
				{'.', '.', '.', '.', '.', '.', '8', '1', '.'},
				{'.', '3', '.', '.', '.', '.', '.', '.', '6'},
				{'.', '.', '.', '.', '.', '7', '.', '.', '.'},
				{'.', '.', '.', '5', '.', '.', '.', '7', '.'}};
		System.out.println(sudokuChecker(sudoku)); //returns true
		char[][] sudoku2 = 
			   {{'.', '.', '.', '1', '4', '.', '.', '2', '.'},
				{'.', '.', '6', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
				{'.', '.', '1', '.', '.', '.', '.', '.', '.'},
				{'.', '6', '7', '.', '.', '.', '.', '.', '9'},
				{'.', '.', '.', '.', '.', '.', '8', '1', '.'},
				{'.', '3', '.', '.', '.', '.', '.', '.', '6'},
				{'.', '.', '.', '.', '.', '7', '.', '.', '.'},
				{'.', '.', '.', '5', '.', '.', '7', '7', '.'}};
		System.out.println(sudokuChecker(sudoku2)); //returns false, last row has two 7s


	}
}
