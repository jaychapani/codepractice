package CrackingCodingInterview;

import java.util.Arrays;

public class CrackingCodingInterview1 {

	public static void main(String[] args) {

		// 1.6 string compression
		System.out.println(printCompressedString("aaabbbbcccccca"));
		
		//1.7 rotate matrix
		int[][] mat = { {0,1,2,3},
						{10,11,12,13},
						{20,21,22,23},
						{30,31,32,33}
					  };
		
		System.out.println(Arrays.deepToString(rotate(mat)));
	}

	private static String printCompressedString(String str) {

		char prevc = str.charAt(0);
		StringBuilder s = new StringBuilder();

		int count = 0;

		for (char c : str.toCharArray()) {
			if (prevc == c) {
				count++;
			} else {
				s.append(prevc);
				s.append(count);
				count = 1;
			}
			prevc = c;
		}
		
		s.append(prevc);
		s.append(count);

		if (s.length() >= str.length()) {
			return str;
		} else {

			return s.toString();
		}
	}

	private static Object[] rotate(int[][] mat) {
		
		int n = mat.length;
		for(int layer = 0; layer <= n/2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			
			for(int i=first; i<last; i++) {
				
				int offset = i - first;
				int top = mat[first][i];
				
				//top <- left
				mat[first][i] = mat[last - offset][first];
				
				//left <- bottom
				mat[last - offset][first] = mat[last][last - offset];
				
				//bottom <- right
				mat[last][last - offset] = mat[i][last];
				
				//right <- top
				mat[i][last] = top;
			}
		}
		
		return mat;
	}
}
