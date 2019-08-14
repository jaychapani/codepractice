package dsproblems;

public class TrieTreeArray {

	public final static int ALFA_SIZE = 26;

	static class TrieNode {
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

	static TrieNode root;

	public static void insert(String s) {

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

	private static boolean hasChildren(TrieNode t) {

		boolean hasChildren = false;

		for (int index = 0; index < ALFA_SIZE; index++) {
			if (t != null && t.children[index] != null) {
				hasChildren = true;
				break;
			}
		}

		return hasChildren;
	}
	
	private static boolean hasMoreThanOneChild(TrieNode t) {

		int childCnt = 0;

		for (int index = 0; index < ALFA_SIZE; index++) {
			if (t != null && t.children[index] != null) {
				childCnt++;
				if(childCnt > 1)
					return true;
			}
		}

		return false;
	}

	private static void search(String s) {

		TrieNode t = searchNode(s);

		if (t == null) {
			System.out.println("No word found!!");
			return;
		}

		// smartSuggest(t, s);
		
		longestPrefix(t, s);

	}

	private static void longestPrefix(TrieNode t, String s) {

		if (hasMoreThanOneChild(t)) {
			System.out.println(s);
			return;
		}

		for (int i = 0; i < ALFA_SIZE; i++) {
			if (t.children[i] != null) {
				longestPrefix(t.children[i], s + Character.toString((char) (i + 'a')));
			}
		}

	}

	private static void smartSuggest(TrieNode t, String s) {

		if (t.isWordEnd) {
			System.out.println(s);
		}

		if (!hasChildren(t)) {
			return;
		}

		for (int i = 0; i < ALFA_SIZE; i++) {
			if (t.children[i] != null) {
				smartSuggest(t.children[i], s + Character.toString((char) (i + 'a')));
			}
		}

	}

	public static TrieNode searchNode(String s) {

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

	public static MaxOccur m = new MaxOccur();

	public static MaxOccur maxCount(TrieNode t, String s) {

		if (m.num < t.cnt) {
			m.num = t.cnt;

			if (t.isWordEnd) {
				m.val = s;
			}

		}

		for (int i = 0; i < ALFA_SIZE; i++) {
			if (t.children[i] != null) {
				m = maxCount(t.children[i], s + Character.toString((char) (i + 'a')));
			}
		}

		return m;
	}

	static class MaxOccur {
		int num;
		String val;

		public String toString() {
			return "The word that occurs most is : " + this.val + " \n" + "No of times: " + this.num;
		}
	}

	public static void main(String[] args) {

		String keys[] = { "flow","flower","flag" };

		root = new TrieNode();

		for (int i = 0; i < keys.length; i++) {
			insert(keys[i]);
		}

		search(Character.toString(keys[0].charAt(0)));

		// System.out.println(maxCount(root, "").toString());
	}

}
