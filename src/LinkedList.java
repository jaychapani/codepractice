
public class LinkedList {

	Node head;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public void push(int data) {

		Node temp = new Node(data);
		temp.next = head;
		head = temp;

	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	Node reverse(Node head, int k) {
		Node current = head;
		Node next = null;
		Node prev = null;

		int count = 0;

		/* Reverse first k nodes of linked list */
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list
		 * starting from current. And make rest of the list as next of first
		 * node
		 */
		if (next != null)
			head.next = reverse(next, k);

		// prev is now head of input list
		return prev;
	}

	public static void main(String[] args) {

		LinkedList list1 = new LinkedList();
		//LinkedList list2 = new LinkedList();

		/*
		 * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
		 */

		list1.push(7);
		list1.push(6);
		list1.push(3);
		list1.push(5);
		list1.push(2);
		list1.push(4);
		list1.push(1);

//		list2.push(14);
//		list2.push(9);
//		list2.push(3);
//		list2.push(1);

		System.out.println("Given Linked List1 ");
		list1.printList();
		//list1.arrangeList(list1.head);
		list1.head = list1.reversLinkedList(list1.head);
		list1.printList();

		//System.out.println("Given Linked List2");
		//list2.printList();

		// list1.head = list1.reverse(list1.head, 3);

		//System.out.println("Merged list");
		//LinkedList l = mergedList(list1.head, list2.head);
		//l.printList();

	}
	
	private Node reversLinkedList(Node head) {
		Node current = head, prev = null, next = null;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		return prev;
	}
	
	private void arrangeList(Node head) {
		Node one = head;
		Node two = head.next;
		Node oneh = one;
		Node twoh = two;

		while (one.next != null && two.next != null) {
			one.next = (one.next).next;
			one = one.next;

			two.next = (two.next).next;
			two = two.next;
		}

		one.next = twoh;
	}

	private static LinkedList mergedList(Node head1, Node head2) {

		LinkedList l = new LinkedList();

		while (head1 != null && head2 != null) {

			if (head1.data <= head2.data) {
				l.push(head1.data);
				head1 = head1.next;
			} else {
				l.push(head2.data);
				head2 = head2.next;
			}
		}

		if (head1 == null) {
			while (head2 != null) {
				l.push(head2.data);
				head2 = head2.next;
			}
		}
		if (head2 == null) {
			while (head1 != null) {
				l.push(head1.data);
				head1 = head1.next;
			}
		}

		l.head = l.reverse(l.head,9);
		
		return l;
	}

}
