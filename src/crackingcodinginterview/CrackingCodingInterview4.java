package crackingcodinginterview;

import java.util.ArrayList;
import java.util.List;

class Node {
	int data;
	Node left, right, parent;

	public Node(int item) {
		data = item;
		left = right = null;
		parent = null; // added for in order successor
	}

}

public class CrackingCodingInterview4 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		int a[] = { 20, 8, 22, 4, 12, 10, 14 };

		Node root = createBTree(a);

		System.out.println("-------4.2-------");
		// 4.2 create minimal height tree
		Node root1 = createMinimalHeightTree(a);

		System.out.println("-------4.3-------");
		// 4.3 List of depths
		ArrayList<ArrayList<Node>> lists = new ArrayList<ArrayList<Node>>();
		ArrayList<ArrayList<Node>> result = createLevelLinkedList(root, lists, 0);

		for (ArrayList<Node> n : result) {
			n.forEach(l -> System.out.print(l.data + " "));
			System.out.println();
		}

		System.out.println("-----------------");
		ArrayList<ArrayList<Node>> result1 = createLevelLinkedList2(root);

		for (ArrayList<Node> n : result1) {
			n.forEach(l -> System.out.print(l.data + " "));
			System.out.println();
		}

		System.out.println("-------4.4-------");
		// 4.4 Check balanced

		System.out.println(isBalanced(root));
		System.out.println(isBalanced2(root));

		System.out.println("-------4.6-------");
		// 4.4 In order successor
		System.out.println("In order successor :: " + inOrderSuc(root, 8));

		System.out.println("-------LCA of two Nodes-------");
		System.out.println("LCA of two Nodes :: " + LCA(root, 10, 4).data);

		System.out.println("-------LCA of List of Nodes-------");
		List<Integer> nodeList = new ArrayList<Integer>();
		nodeList.add(4);
		nodeList.add(10);
		nodeList.add(14);
		Node res = LCA(root, nodeList);
		System.out.println("LCA of List of Nodes :: " + (res == null ? "No LCA" : String.valueOf(res.data)));
	}

	private static Node LCA(Node root, List<Integer> nodeList) {

		if (root == null)
			return null;

		if(nodeList.contains(root.data))
			return root;
		
		Node left_lca = LCA(root.left, nodeList);
		Node right_lca = LCA(root.right, nodeList);
		
		if (left_lca != null && right_lca != null)
			return root;

		return left_lca != null ? left_lca : right_lca;
	}

	private static Node LCA(Node root, int n1, int n2) {

		if (root == null)
			return null;

		/*
		 * //This will work for BST if (root.data > n1 && root.data > n2) {
		 * LCA(root.left, n1, n2); } else if (root.data < n1 && root.data < n2) {
		 * LCA(root.right, n1, n2); }
		 */

		if (root.data == n1 || root.data == n2)
			return root;

		Node left_lca = LCA(root.left, n1, n2);
		Node right_lca = LCA(root.right, n1, n2);

		if (left_lca != null && right_lca != null)
			return root;

		return left_lca != null ? left_lca : right_lca;
	}

	private static int inOrderSuc(Node root, int key) {

		while (root != null) {
			if (key == root.data) {
				break;
			} else if (key < root.data) {
				root = root.left;
			} else if (key > root.data) {
				root = root.right;
			}
		}

		if (root == null)
			return Integer.MIN_VALUE;

		if (root.right != null) {
			root = root.right;
			while (root.left != null) {
				root = root.left;
			}
			return root.data;
		} else {
			while (root.parent != null && root.parent.data < root.data) {
				root = root.parent;
			}
			return root.parent != null ? root.parent.data : root.data;
		}
	}

	private static boolean isBalanced2(Node root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}

	private static int checkHeight(Node root) {

		if (root == null)
			return 0;

		int leftHeight = checkHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		int rightHeight = checkHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		int heightDiff = leftHeight - rightHeight;

		if (heightDiff > 1)
			return Integer.MIN_VALUE;
		else
			return Math.max(checkHeight(root.left), checkHeight(root.right)) + 1;
	}

	private static Node createBTree(int[] a) {

		Node root = null;

		for (int i = 0; i < a.length; i++) {
			root = insert(root, a[i], null);
		}

		return root;
	}

	private static Node insert(Node root, int key, Node parent) {

		if (root == null) {
			root = new Node(key);
			root.parent = parent;
			return root;
		}

		if (key <= root.data)
			root.left = insert(root.left, key, root);
		else
			root.right = insert(root.right, key, root);

		return root;
	}

	private static boolean isBalanced(Node root) {

		if (root == null)
			return true;

		int heightDiff = Math.abs(height(root.left) - height(root.right));

		if (heightDiff > 1)
			return false;

		return true;

	}

	private static int height(Node root) {

		if (root == null)
			return 0;

		return Math.max(height(root.left), height(root.right)) + 1;
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

	private static ArrayList<ArrayList<Node>> createLevelLinkedList(Node root, ArrayList<ArrayList<Node>> lists,
			int level) {

		if (root == null)
			return null;

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

		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);

		return lists;
	}

	private static ArrayList<ArrayList<Node>> createLevelLinkedList2(Node root) {

		ArrayList<ArrayList<Node>> result = new ArrayList<ArrayList<Node>>();

		ArrayList<Node> current = new ArrayList<Node>();

		if (root != null) {
			current.add(root);
		}

		while (current.size() > 0) {
			result.add(current);

			ArrayList<Node> parents = current;
			current = new ArrayList<Node>();

			for (Node parent : parents) {
				if (parent.left != null) {
					current.add(parent.left);
				}
				if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}

		return result;
	}
}
