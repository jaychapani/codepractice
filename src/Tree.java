import java.util.Hashtable;

public class Tree {

	public static void main(String[] args) {

		Node root = new Node(30);

		// int a[] = new int[] { 15, 45, 20, 25, 32, 50, 55 };
		//
		// for (int i : a) {
		//
		// insertNodeBST(root, i);
		// }

		root.left = new Node(10);
		root.right = new Node(25);
		root.left.left = new Node(8);
		root.left.right = new Node(45);
		root.right.left = new Node(32);
		root.right.right = new Node(55);

		// System.out.println("LCA :: " + findLCA(root,32,45).data);
		//
		// System.out.println("Succesor ::" + getSuccesor(root.right));
		//
		// System.out.println("Boundary traversal");
		//
		// System.out.print(root.data + " ");
		//
		// printLeft(root.left);
		// printLeaf(root.left);
		// printLeaf(root.right);
		// printRight(root.right);

		// System.out.println("InOrder Successor :: " + getIOSucc(root,
		// 25).data);

		// System.out.println("In Order Traversal :: ");
		// inOrderTrav(root);
		// System.out.println("\nKth smallest element :: ");
		// kthSmallElement(root);

		System.out.println((3 ^ 5) + " - " + (5 ^ 6) + " - " + (3 ^ 6));

		morrisTrav(root);
		correctTreeSwap(root);
		System.out.println("");
		morrisTrav(root);

	}

	private static void correctTreeSwap(Node root) {

		Node prev, current, ptr = null, first = null, last = null;

		if (root == null)
			return;

		current = prev = root;

		while (current != null) {
			if (current.left == null) {
				if (ptr != null && current.data < ptr.data) {
					if (first == null)
						first = ptr;
					else
						last = current;
				}
				ptr = current;
				// System.out.print(current.data + " ");
				current = current.right;
			} else {
				prev = current.left;
				while (prev.right != null && prev.right != current) {
					prev = prev.right;
				}
				if (prev.right == null) {
					prev.right = current;
					current = current.left;
				} else {
					prev.right = null;
					if (ptr != null && current.data < ptr.data) {
						if (first == null)
							first = ptr;
						else
							last = current;
					}
					ptr = current;
					// System.out.print(current.data + " ");
					current = current.right;
				}
			}
		}

		int tmp;
		if (first != null && last != null) {
			tmp = first.data;
			first.data = last.data;
			last.data = tmp;
		} else if (first != null) {
			tmp = first.data;
			first.data = first.right.data;
			first.right.data = tmp;
		}
	}

	private static void morrisTrav(Node root) {

		Node prev, current;

		if (root == null)
			return;

		current = root;

		while (current != null) {
			if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {
				prev = current.left;
				while (prev.right != null && prev.right != current) {
					prev = prev.right;
				}
				if (prev.right == null) {
					prev.right = current;
					current = current.left;
				} else {
					prev.right = null;
					System.out.print(current.data + " ");
					current = current.right;
				}
			}
		}

	}

	static int k = 5;

	private static void kthSmallElement(Node root) {
		if (root == null)
			return;

		if (k > 0) {
			kthSmallElement(root.left);
		}
		k = k - 1;
		if (k == 0) {
			System.out.print(root.data + " ");
			return;
		} else if (k < 0) {
			System.out.print("No such element");
		}
		if (k > 0) {
			kthSmallElement(root.right);
		}
	}

	private static void inOrderTrav(Node root) {
		if (root == null)
			return;

		inOrderTrav(root.left);
		System.out.print(root.data + " ");
		inOrderTrav(root.right);
	}

	private static Node getIOSucc(Node root, int data) {
		return getIOSuccUtil(root, data, new Node(Integer.MIN_VALUE));
	}

	private static Node getIOSuccUtil(Node root, int data, Node max) {
		if (root == null) {
			return max;
		}

		if (max.data < root.data)
			max = root;

		if (data == root.data) {
			if (root.right == null)
				return max;
			else
				return getSuccesor(root.right);
		} else if (data < root.data) {
			return getIOSuccUtil(root.left, data, max);
		} else {
			return getIOSuccUtil(root.right, data, max);
		}
	}

	private static Node getSuccesor(Node root) {

		while (root.left != null) {
			root = root.left;
		}

		return root;
	}

	private static void printLeft(Node root) {

		if (root != null) {
			if (root.left != null) {
				System.out.print(root.data + " ");
				printLeft(root.left);
			} else if (root.right != null) {
				System.out.print(root.data + " ");
				printLeft(root.right);
			}
		}

	}

	private static void printLeaf(Node root) {

		if (root != null) {
			printLeaf(root.left);

			if (root.left == null && root.right == null) {
				System.out.print(root.data + " ");
			}

			printLeaf(root.right);
		}

	}

	private static void printRight(Node root) {

		if (root != null) {
			if (root.right != null) {
				printRight(root.right);
				System.out.print(root.data + " ");
			} else if (root.left != null) {
				printRight(root.left);
				System.out.print(root.data + " ");
			}
		}
	}

	public static void insertNodeBST(Node root, int data) {

		Node current = root;
		Node parent;

		while (true) {
			parent = current;
			if (data < current.data) {
				current = current.left;
				parent.lcount++;
				if (current == null) {
					parent.left = new Node(data);
					return;
				}
			} else if (data > current.data) {
				current = current.right;
				parent.rcount++;
				if (current == null) {
					parent.right = new Node(data);
					return;
				}
			}
		}
	}

	public static int Pathlength(Node root, int n1) {
		if (root != null) {
			int x = 0;
			if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0 || (x = Pathlength(root.right, n1)) > 0) {
				return x + 1;

			}
			return 0;
		}
		return 0;
	}

	public static Node findLCA(Node root, int n1, int n2) {

		while (root != null) {
			if (root.data > n1 && root.data > n2) {
				root = root.left;
			} else if (root.data < n1 && root.data < n2) {
				root = root.right;
			} else {
				break;
			}

			// if (root.data >= n1 && root.data <= n2) {
			// return root;
			// }
		}

		return root;
	}

	public static int findDistance(Node root, int n1, int n2) {
		int x = Pathlength(root, n1) - 1;
		int y = Pathlength(root, n2) - 1;
		Node lca = findLCA(root, n1, n2);
		int z = Pathlength(root, lca.data);

		return x + y - (2 * z);
	}

}

class Node {
	int data;
	Node left;
	Node right;
	int lcount = 0;
	int rcount = 0;

	public Node() {
	}

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.lcount = 0;
	}
}