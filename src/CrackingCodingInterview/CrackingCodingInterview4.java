package CrackingCodingInterview;

import java.util.ArrayList;

class Node {
	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}

}

public class CrackingCodingInterview4 {

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

		System.out.println("-------4.2-------");
		// 4.2 create minimal height tree
		Node root = createMinimalHeightTree(a);

		
		ArrayList<ArrayList<Node>> lists = new ArrayList<ArrayList<Node>>(); 
		createLevelLinkedList(root, lists, 0);
	}

	private static Node createMinimalHeightTree(int[] a) {
		return createMinimalHeightTree(a, 0, a.length - 1);
	}

	private static Node createMinimalHeightTree(int[] a, int start, int end) {

		if (end < start)
			return null;

		int mid = (start + end) / 2;

		Node root = new Node(a[mid]);

		root.left = createMinimalHeightTree(a, start, mid - 1);
		root.right = createMinimalHeightTree(a, mid + 1, end);

		return root;
	}

	private static void createLevelLinkedList(Node root, ArrayList<ArrayList<Node>> lists, int level) {

		if (root == null)
			return;

		ArrayList<Node> list = null;
		if (lists.size() == level) { // Level not contained in list
			list = new ArrayList<Node>();
			/*
			 * Levels are always traversed in order. So, if this is the first time we've
			 * visited level i, we must have seen levels 0 through i - 1. We can therefore
			 * safely add the level at the end.
			 */
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		
		list.add(root);
		
		createLevelLinkedList(root.left,lists,level+1);
		createLevelLinkedList(root.right,lists,level+1);
	}
}
