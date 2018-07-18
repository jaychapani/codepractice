import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bonetrousle {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		int[] a = { 44, 5, 33, 22, 765, 43, 53, 12, 57, 97 };

		// first section gets the Knuth's interval sequence (very efficient)
		int h = 1;
		while (h <= a.length / 3) {
			h = 3 * h + 1; // h is equal to highest sequence of h<=length/3
							// (1,4,13,40...)
		}

		// next section
		while (h > 0) { // for array of length 10, h=4

			// similar to insertion sort below
			for (int i = 0; i < a.length; i++) {

				int temp = a[i];
				int j;

				for (j = i; j > h - 1 && a[j - h] >= temp; j = j - h) {
					a[j] = a[j - h];
				}
				a[j] = temp;
			}
			h = (h - 1) / 3;
		}
		
		System.out.println(Arrays.toString(a));
	}

	public String[] largestItemAssociation(String[][] itemAssociation) {
		// WRITE YOUR CODE HERE

		Map<String, Integer> map = new HashMap<String, Integer>();
		int groupKey = 1;

		for (int i = 0; i < itemAssociation.length; i++) {
			for (int j = 0; j < itemAssociation[j].length; j++) {

				if (map.get(itemAssociation[i][j]) != null) {
					map.put(itemAssociation[i][j], map.get(itemAssociation[i][j]));
				} else {
					map.put(itemAssociation[i][j], groupKey);
					groupKey++;
				}
			}
		}

		for (Map.Entry<String, Integer> e : map.entrySet()) {
			System.out.println("Key = " + e.getKey() + "val = " + e.getValue());
		}

		return new String[] {};

	}

	private static void printBoxes(long n, long k, int b) {
		long boxes[] = new long[b];

		for (int i = 0; i < b; i++) {
			boxes[i] = i + 1;
		}

		int index = b - 1;

		while (Arrays.stream(boxes).sum() != n) {

			if (index < 0) {
				System.out.println("-1");
				return;
			}

			boxes[index]++;
			if (boxes[index] == k) {
				index--;
				k--;
			} else if (boxes[index] > k) {
				System.out.println("-1");
				return;
			}
		}

		// System.out.println(Arrays.toString(boxes));
		String output = "";
		for (long l : boxes) {
			output = output + l + " ";
		}
		System.out.println(output.trim());
	}

}
