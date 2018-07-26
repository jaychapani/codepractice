package dsproblems;

public class Solution {
	
	public static void main(String[] args) {
		
		System.out.println("Output: " + longestCommonPrefix(new String[] {"a"}));
	}
	
    public static String longestCommonPrefix(String[] strs) {
        
        if(strs == null || strs.length == 0)
            return "";
        
        root = new TrieNode();

		for (int i = 0; i < strs.length; i++) {
            if(strs[0] == "")
                return "";
			insert(strs[i]);
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
				if(childCnt > 1)
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

		if (hasMoreThanOneChild(t)) {
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
