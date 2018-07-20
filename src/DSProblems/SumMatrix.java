package DSProblems;

import java.util.Arrays;

public class SumMatrix {

	public static void main(String[] args) {
		int[][] input = { { 9, 1, 1, 6, 9, 1, 4, 8, 5, 3, 2, 5, 9, 4, 4 },
				{ 7, 1, 6, 6, 3, 6, 9, 3, 3, 7, 0, 9, 3, 0, 1 }, { 9, 2, 6, 7, 3, 7, 0, 7, 8, 1, 6, 7, 0, 7, 5 },
				{ 0, 3, 3, 3, 4, 2, 9, 4, 8, 5, 4, 5, 0, 9, 0 }, { 4, 3, 1, 4, 4, 4, 5, 0, 6, 9, 5, 7, 8, 7, 5 },
				{ 4, 7, 1, 4, 6, 5, 4, 0, 1, 9, 0, 1, 8, 6, 0 }, { 6, 8, 5, 9, 7, 8, 3, 6, 7, 5, 5, 1, 0, 4, 4 },
				{ 1, 6, 2, 9, 8, 2, 5, 9, 7, 4, 9, 9, 7, 5, 5 }, { 9, 1, 9, 9, 0, 9, 5, 6, 4, 9, 4, 4, 9, 9, 9 },
				{ 4, 1, 5, 3, 1, 5, 9, 0, 2, 4, 1, 2, 8, 4, 3 } };
		int sum = 34;
		int[][] output = new int[input.length][input[0].length];

		if (findPath(input, output, sum, 0, 0))
			System.out.println(Arrays.deepToString(output));
		
	 /*[ [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
		 [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
		 [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
		 [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
		 [1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
		 [0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
		 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
		 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
		 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
		 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0] ] */

		
		// PrintMatrix.printMatrix(output);
	}

	public static boolean findPath(int[][] matrix, int[][] output, int sum, int r, int c) {
		System.out.println("Row: " + r + ", Col: " + c + " Target: " + sum);
		output[r][c] = 1;
		if (sum - matrix[r][c] == 0) {
			return true;
		} else if (sum - matrix[r][c] < 0) {
			output[r][c] = 0;
			return false;
		}

		if (r + 1 < matrix.length && output[r + 1][c] != 1) {
			boolean bottom = findPath(matrix, output, sum - matrix[r][c], r + 1, c);
			if (bottom)
				return bottom;
		}
		if (r - 1 > -1 && output[r - 1][c] != 1) {
			boolean top = findPath(matrix, output, sum - matrix[r][c], r - 1, c);
			if (top)
				return top;
		}
		if (c - 1 > -1 && output[1][c - 1] != 1) {
			boolean left = findPath(matrix, output, sum - matrix[r][c], r, c - 1);
			if (left)
				return left;
		}
		if (c + 1 < matrix[0].length && output[r][c + 1] != 1) {
			boolean right = findPath(matrix, output, sum - matrix[r][c], r, c + 1);
			if (right)
				return right;
		}

		output[r][c] = 0;
		return false;
	}
}