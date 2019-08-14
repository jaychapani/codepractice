package CrackingCodingInterview;

public class LinkedList{
	
	Node head;
	
	class Node{
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	public Node push(int data) {
		
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
		
		return temp;
	}
	
	public void printLinkedList() {
		
		Node temp = head;
		
		while(temp!= null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
}