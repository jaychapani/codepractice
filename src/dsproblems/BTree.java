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

		Node root = new Node(20);

		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);

		int a[] = new int[] { 3, 4, 5, 6, 7, 1, 8 };

		Node root1 = new Node(2);

		for (int i = 0; i < a.length; i++) {
			insertBST(root1, a[i]);
		}

		printInorder(root1);


		//printCousin(root, root.left.left);

		// printCousin(root, root.left.left);

		// System.out.println(isMirror(root, root));

		// printLevelOrder(root);

		// System.out.println(height(root));
		//printKthSmallestElement(root,3);

		//btToDll(root);
		
	}

    static Node head  = null;
	
	private static Node btToDll(Node root) {

		Stack<Node> s = new Stack<Node>();
		Node current = root;
		Node prev = null;

		while (current != null || !s.isEmpty()) {

			while (current != null) {
				s.push(current);
				current = current.left;
			}

			current = s.pop();

			if (head == null) {
				head = current;
				current.left = null;
			} else {
				prev.right = current;
				current.left = prev;
			}

			prev = current;
			current = current.right;
		}

		return head;
	}

	private static int printKthSmallestElement(Node root, int k) {
		
		System.out.println("debug:: data :: " + (root != null ? root.data : "NULL") + " k::" + k);
		
		if (root == null || k == Integer.MIN_VALUE)
			return k;

		k = printKthSmallestElement(root.left, k);
		k--;
		if (k == 0) {
			System.out.println(root.data);
			return Integer.MIN_VALUE;
		}
		if (k < 0) {
			System.out.println("No such node exists!!");
		}

		k = printKthSmallestElement(root.right, k);

		return k;
	}

	private static void printCousin(Node root, Node n) {

		if (root == null) {
			System.out.println("No Cousins!!!");
		}

		Node current = null;

		Queue<Node> q = new LinkedList<Node>();
		boolean found = false;
		q.add(root);

		int size = 0;

		while (!q.isEmpty() && !found) {

			size = q.size();
			while (size-- > 0) {

				current = q.poll();

				if (current.left == n || current.right == n) {
					found = true;
				} else {
					if (current.left != null) {
						q.add(current.left);
					}
					if (current.right != null) {
						q.add(current.right);
					}
				}
			}
		}

		if (q.size() == 0)
			System.out.println("No Cousins!!!");

		while (!q.isEmpty()) {
			System.out.print(q.poll().data + " ");
		}

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
		
		while (true) {
			if (data <= current.data) {

				if (current.left == null) {
					current.left = new Node(data);
					return;
				}
				
				current = current.left;

			} else {

				if (current.right == null) {
					current.right = new Node(data);
					return;
				}
				
				current = current.right;
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
