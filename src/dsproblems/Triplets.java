package dsproblems;

import java.util.HashMap;
import java.util.Map;

public class Triplets {

	static int cnt1 = 0;
	static int cnt2 = 0;
	
	public static void main(String[] args) {

		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

		printTriplets(a);
		
		System.out.println("cnt1: " + cnt1 + " cnt2: " + cnt2);
	}

	private static void printTriplets(int[] a) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < a.length; i++) {
			map.put(a[i] * a[i], a[i]);
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				cnt1++;
				if (map.containsKey((a[i] * a[i]) + (a[j] * a[j]))) {
					System.out.println("(" + a[i] + ", " + a[j] + ", " + map.get((a[i] * a[i]) + (a[j] * a[j])) + ")");
				}
			}
		}

		for(int i = 0; i < a.length; i++) {
			a[i]  = a[i] * a[i];
		}
		
		
		for(int i = a.length - 1; i >= 2; i--) {
			
			int l = 0;
			int r = i - 1;
			
			while(l < r) {
				cnt2++;
				if(a[i] == a[l] + a[r]) {
					System.out.println("(" + Math.sqrt(a[l]) + ", " + Math.sqrt(a[r]) + ", " + Math.sqrt(a[i]) + ")");
					break;
				}else if(a[l] + a[r] < a[i]) {
					l++;
				}else {
					r--;
				}
			}
		}
			
	}

}
