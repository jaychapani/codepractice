import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TriTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Trie t = new Trie();
		t.insert("Amaze");
		t.insert("Amazed");
		t.insert("Amazon");
		t.insert("Amazonian");
		t.insert("dog");
		t.insert("cat");
		t.insert("apple");
		t.insert("Apples");

		System.out.println(t.search("amazo"));

	}

}

class TrieNode {
	char c;
	HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	boolean isLeaf;

	public TrieNode() {
	}

	public TrieNode(char c) {
		this.c = c;
	}
}

class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		
		word = word.toLowerCase();
		
		HashMap<Character, TrieNode> children = root.children;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			TrieNode t;
			if (children.containsKey(c)) {
				t = children.get(c);
			} else {
				t = new TrieNode(c);
				children.put(c, t);
			}

			children = t.children;

			// set leaf node
			if (i == word.length() - 1)
				t.isLeaf = true;
		}
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode t = searchNode(word);

		if (t == null) {
			System.out.println("No words found!!");
			return false;
		} else if (t.isLeaf && t.children.isEmpty()) {
			System.out.println(word);
			System.out.println("No further words found!!");
			return true;
		} else {
			printSuggestion(t, word);
			return true;
		}
	}

	public static void printSuggestion(TrieNode t, String prefix) {

		if (t.isLeaf) {
			System.out.println(prefix);
		}
		if (t.children.isEmpty()) {
			return;
		}

		HashMap<Character, TrieNode> children = t.children;

		Iterator it = children.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			printSuggestion((TrieNode) pair.getValue(), prefix + pair.getKey());
			it.remove();
		}
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		if (searchNode(prefix) == null)
			return false;
		else
			return true;
	}

	public TrieNode searchNode(String str) {
		Map<Character, TrieNode> children = root.children;
		TrieNode t = null;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (children.containsKey(c)) {
				t = children.get(c);
				children = t.children;
			} else {
				return null;
			}
		}

		return t;
	}
}