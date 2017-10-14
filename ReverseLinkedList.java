public class ReverseLinkedList {
	public static void main(String[] args) {
		Node head = new Node(1);
		Node temp1 = new Node(2);
		head.next = temp1;
		Node temp2 = new Node(3);
		temp1.next = temp2;
		Node temp3 = new Node(4);
		temp2.next = temp3;
		Node temp4 = new Node(5);
		temp3.next = temp4;

		showLinkedList(head);
		showLinkedList(reverseLinkedList(head));
	}

	private static void showLinkedList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println(temp);
	}

	private static Node reverseLinkedList(Node head) {
		Node next = null;
		Node previous = null;
		Node current = head;

		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}

	public static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}
}
