package dsproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {

		// Map<Integer, Integer> m = new HashMap();

		// int[] nums = new int[] { -2, -5 };

		// System.out.println(Arrays.toString(nums));

		// swap(nums, 0, 1);

		// System.out.println(Arrays.toString(nums));

		// System.out.println(10 ^ 20);

		// System.out.println(maxSubArray(nums));

		System.out.println("Output: " + longestCommonPrefix(new String[] { "abab","aba", "" }));

		// System.out.println("Rotation count :: " + openLock(new String[]
		// {"0201","0101","0102","1212","2002"},"0202"));

		// System.out.println(getColumnNo("ABC"));

		// System.out.println(decodeAtIndex("vk6u5xhq9v",554));
		
		// System.out.println(Arrays.toString(uncommonFromSentences("this is sweet app", "this is sour app")));
		
		//System.out.println(isValid("()"));
	}
	
	public static boolean isValid(String s) {
        if(s.length() < 2)
            return false;
            
        Stack<Character> cs = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++){
            
            Character c = s.charAt(i);
            
            if(c == ')' && cs.pop() != '('){
                return false;
            }else if(c == '}' && cs.pop() != '{'){
                return false;
            }if(c == ']' && cs.pop() != '['){
                return false;
            }else if(c == '(' || c == '{' || c == '['){
                cs.push(c);
            }       
        }
        return cs.empty();
    }

	public static String[] uncommonFromSentences(String A, String B) {

		String[] sa = A.split(" ");

		Map<String, Integer> m = new HashMap<String, Integer>();
		
		for (String s : sa) {
			if (m.get(s) != null) {
				int i = m.get(s);
				m.put(s, ++i);
			} else {
				m.put(s, 1);
			}
		}

		String[] sb = B.split(" ");

		for (String s : sb) {
			if (m.get(s) != null) {
				int i = m.get(s);
				m.put(s, ++i);
			} else {
				m.put(s, 1);
			}
		}

		List<String> sList = new ArrayList<String>();

		for (Map.Entry<String, Integer> entry : m.entrySet()) {
			if (entry.getValue() == 1)
				sList.add(entry.getKey());
		}

		return sList.toArray(new String[0]);
	}

	public static String decodeAtIndex(String s, int k) {

		int len = 0;
		Character c = null;
		int lastCharIndex = 0;

		for (int i = 0; i < s.length(); i++) {

			c = s.charAt(i);
			len++;

			if (c > '0' && c <= '9') {

				len--;
				int x = Character.getNumericValue(c);

				if (len * x <= k) {
					len *= x;
					if (len == k) {
						return Character.toString(s.charAt(lastCharIndex));
					}
				} else {
					i = -1;
				}
			} else {
				lastCharIndex = i;
			}

			if (len == k)
				break;
		}
		return Character.toString(c);
	}

	public static int getColumnNo(String s) {

		int c = 0;
		int col = 0;

		for (int i = 0; i < s.length(); i++) {

			c = s.charAt(i) - 'A' + 1;

			if (i == 0)
				col = c;
			else {
				col = c + col * 26;
			}

		}
		return col;
	}

	private static void swap(int[] nums, int i, int j) {

		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}

	public static int openLock(String[] deadends, String target) {
		Set<String> begin = new HashSet<>();
		Set<String> end = new HashSet<>();
		Set<String> deads = new HashSet<>(Arrays.asList(deadends));
		begin.add("0000");
		end.add(target);
		int level = 0;
		while (!begin.isEmpty() && !end.isEmpty()) {

			System.out.println("===>begin " + begin);
			System.out.println("===>  end " + end);
			System.out.println(" ");
			Set<String> temp = new HashSet<>();
			for (String s : begin) {
				if (end.contains(s))
					return level;
				if (deads.contains(s))
					continue;
				deads.add(s);
				StringBuilder sb = new StringBuilder(s);
				for (int i = 0; i < 4; i++) {
					char c = sb.charAt(i);
					String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
					String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);

					// System.out.println("s1 : " + s1);
					// System.out.println("s2 : " + s2);

					if (!deads.contains(s1))
						temp.add(s1);
					if (!deads.contains(s2))
						temp.add(s2);
				}
			}
			level++;
			begin = end;
			end = temp;
		}
		return -1;
	}

	private static int canCompleteCircuit(int[] gas, int[] cost) {

		if (gas.length != cost.length)
			return -1;

		int startIdx = -1, i = 0;

		while (i < gas.length && gas[i] < cost[i]) {
			i++;
		}

		if (i != gas.length) {
			startIdx = i;
		} else {
			return -1;
		}

		int cur = -1, next = -1;

		cur = startIdx;
		next = cur + 1;
		if (next >= gas.length) {
			next = 0;
		}

		int tank = gas[startIdx];

		while (next != startIdx) {
			tank = tank - cost[cur] + gas[next];
			if (tank < 0) {
				return -1;
			}
			cur++;
			next++;
			if (next >= gas.length) {
				next = 0;
			}
			if (cur >= gas.length) {
				cur = 0;
			}
		}

		tank -= cost[next];

		if (tank > 0) {
			return startIdx;
		} else {
			return -1;
		}
	}

	public static int maxSubArray(int[] A) {

		int n = A.length;
		int[] dp = new int[n];// dp[i] means the maximum subarray ending with A[i];
		dp[0] = A[0];
		int max = dp[0];

		for (int i = 1; i < n; i++) {
			dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
			max = Math.max(max, dp[i]);
		}

		return max;
	}

	public static String longestCommonPrefix(String[] strs) {

		if (strs == null || strs.length == 0)
			return "";

		root = new TrieNode();

		for (int i = 0; i < strs.length; i++) {
			if (strs[i] == "")
				return "";
			insert(strs[i]);
		}

		if(hasMoreThanOneChild(root)) {
			return "";
		}
		
		return search(Character.toString(strs[0].charAt(0)));

	}

	static TrieNode root;
	final static int ALFA_SIZE = 26;

	private static void insert(String s) {

		TrieNode t = root;
		s = s.toLowerCase();

		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			if (t.children[index] == null) {
				t.children[index] = new TrieNode();
			}
			t = t.children[index];
		}
		t.isWordEnd = true;
		t.cnt += 1;
	}

	private static boolean hasMoreThanOneChild(TrieNode t) {

		int childCnt = 0;

		for (int index = 0; index < ALFA_SIZE; index++) {
			if (t != null && t.children[index] != null) {
				childCnt++;
				if (childCnt > 1)
					return true;
			}
		}

		return false;
	}

	private static String search(String s) {

		TrieNode t = searchNode(s);

		if (t == null) {
			return "";
		}

		return longestPrefix(t, s);

	}

	private static String longestPrefix(TrieNode t, String s) {

		if (hasMoreThanOneChild(t) || t.isWordEnd) {
			return s;
		}

		for (int i = 0; i < ALFA_SIZE; i++) {
			if (t.children[i] != null) {
				return longestPrefix(t.children[i], s + Character.toString((char) (i + 'a')));
			}
		}

		return s;
	}

	private static TrieNode searchNode(String s) {

		TrieNode t = root;

		for (int i = 0; i < s.length(); i++) {

			int index = s.charAt(i) - 'a';
			if (t.children[index] == null) {
				return null;
			}
			t = t.children[index];
		}

		return t;
	}
}

class TrieNode {
	final int ALFA_SIZE = 26;
	TrieNode[] children = new TrieNode[ALFA_SIZE];
	boolean isWordEnd;
	int cnt;

	public TrieNode() {
		isWordEnd = false;
		cnt = 0;
		for (int i = 0; i < ALFA_SIZE; i++) {
			children[i] = null;
		}
	}
}
