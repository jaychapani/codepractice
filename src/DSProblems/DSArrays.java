package DSProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DSArrays {

	public static void main(String[] args) {

		int[] a = { 10, 5, 13, 2, 21, 8, 3, 40, 12, 15, 1 };

		int[] ans = getMaxSeq(a);

		// System.out.println(ans[0] + " to " + ans[1]);

		// System.out.println(reverse(214));

		// System.out.println(lengthOfLongestSubstring("abcb"));

		// System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));

		// System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
		
		System.out.println(String.format("%02d",Integer.parseInt(Integer.toBinaryString(0))));

	}

	public static int trap(int[] height) {
		int a = 0;
		int b = height.length - 1;
		int max = 0;
		int leftmax = 0;
		int rightmax = 0;
		while (a <= b) {
			leftmax = Math.max(leftmax, height[a]);
			rightmax = Math.max(rightmax, height[b]);
			if (leftmax < rightmax) {
				max += (leftmax - height[a]); // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be
												// stored
				a++;
			} else {
				max += (rightmax - height[b]);
				b--;
			}
		}
		return max;
	}

	public static int search(int[] nums, int target) {

		if (nums.length == 0)
			return -1;
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[right]) {
				if (nums[mid] < target && nums[right] >= target)
					left = mid + 1;
				else
					right = mid;
			} else {
				if (nums[mid] >= target && nums[left] <= target)
					right = mid;
				else
					left = mid + 1;
			}
		}
		return nums[left] == target ? left : -1;
	}

	public static int lengthOfLongestSubstring(String s) {

		boolean[] set = new boolean[256];
		int len = 0;
		int h = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			while (set[c]) {
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
