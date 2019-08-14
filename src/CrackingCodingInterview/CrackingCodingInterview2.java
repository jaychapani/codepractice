package CrackingCodingInterview;

public class CrackingCodingInterview2 {

	public static void main(String[] args) {

		System.out.println("-------2.1-------");
		//2.3 remove node
		LinkedList l = new LinkedList();
		
		l.push(7);
		l.push(6);
		l.push(5);
		l.push(4);
		LinkedList.Node n = l.push(3);
		l.push(2);
		l.push(1);
		
		l.printLinkedList();
		
		removeNode(n);
		
		l.printLinkedList();
		
		System.out.println("-------***-------");
		//2.3 reverse linked list
		reverseLinkedList(l).printLinkedList();
		
	}
	
	
	private static LinkedList reverseLinkedList(LinkedList l) {
		
		LinkedList.Node cur = l.head;
		LinkedList.Node prev = null;
		LinkedList.Node next = null;
		
		while(cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		
		l.head = prev;	
			
		return l;
		
	}


	private static void removeNode(LinkedList.Node n) {
		
		n.data = n.next.data;
		n.next = n.next.next;
	}
	
	
}

