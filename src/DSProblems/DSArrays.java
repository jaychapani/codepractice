package DSProblems;

import java.util.HashMap;
import java.util.Map;

public class DSArrays {

	public static void main(String[] args) {

		int[] a = { 10, 5, 13, 2, 21, 8, 3, 40, 12, 15, 1 };

		int[] ans = getMaxSeq(a);

		//System.out.println(ans[0] + " to " + ans[1]);

		//System.out.println(reverse(214));
		
		System.out.println(lengthOfLongestSubstring("abcb"));
		
	}

	public static int lengthOfLongestSubstring(String s) {

		boolean[] set = new boolean[256];
        int len = 0;
        int h = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            while(set[c]) {
                set[s.charAt(h)] = false;
                h++;
            }
            len = Math.max(len, i - h + 1);
            set[c] = true;
        }
        return len;
	}

	public static int reverse(int x) {
		System.out.println("Value to reverse is : " + x);
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}

	private static int[] getMaxSeq(int[] a) {

		int u = 0, cnt = 1, max = 1;

		for (int i = 1; i < a.length; i++) {

			if (a[i] >= a[i - 1]) {
				cnt++;
			} else {
				cnt = 1;
			}

			if (cnt >= max) {
				max = cnt;
				u = i;
			}

		}

		return new int[] { u - max + 1, u };
	}

}
