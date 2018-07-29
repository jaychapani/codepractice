package dsproblems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class Node {
	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}

public class BTree {

	public static void main(String[] args) {

		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(4);
		root.right.right = new Node(3);

		int a[] = new int[] { 2, 3, 4, 5, 6, 7, 1, 8 };

		Node root1 = null;
		
		for (int i = 0; i < a.length; i++) {
			root1 = insertBSTRec(root1, a[i]);
		}

		printInorder(root1);

		// System.out.println(isMirror(root, root));

		// printLevelOrder(root);

		// System.out.println(height(root));

	}

	private static Node insertBSTRec(Node root, int data) {

		if (root == null) {
			root = new Node(data);
			return root;
		}

		if (data <= root.data) {
			root.left = insertBSTRec(root.left, data);
		}
		if (data > root.data) {
			root.right = insertBSTRec(root.right, data);
		}

		return root;
	}

	private static void insertBST(Node root, int data) {

		Node current = root;
		Node parent;

		while (true) {
			parent = current;
			if (data <= current.data) {

				current = current.left;

				if (current == null) {
					parent.left = new Node(data);
					return;
				}

			} else {

				current = current.right;

				if (current == null) {
					parent.right = new Node(data);
					return;
				}
			}
		}

	}

	private static void printInorder(Node root) {

		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

	private static boolean isMirror(Node root1, Node root2) {

		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		return (root1.data == root2.data && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left));
	}

	private static void printLevelOrder(Node root) {

		int h = height(root);

		for (int i = 1; i <= h; i++) {
			printLevel(root, i);
		}

	}

	private static void printLevel(Node root, int level) {
		if (root == null)
			return;

		if (level == 1) {
			System.out.println(root.data);
		} else if (level > 1) {
			printLevel(root.left, level - 1);
			printLevel(root.right, level - 1);
		}

	}

	private static int height(Node root) {

		if (root == null) {
			return 0;
		} else {
			int l = height(root.left);
			int r = height(root.right);

			return (Math.max(l, r) + 1);
		}
	}

}
