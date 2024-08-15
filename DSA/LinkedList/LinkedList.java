package DSA.LinkedList;

public class LinkedList {
	private class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}

	}

	private Node first;
	private Node last;
	private int length;

	public LinkedList() {
		first = null;
		last = null;
		length = 0;
	}

	public LinkedList(int value) {
		Node newNode = new Node(value);
		first = last = newNode;
		length = 1;

	}

	public void append(int item) {
		var node = new Node(item);
		if (first == null) {
			first = last = node;
			length = 1;
			return;

		}
		last.next = node;
		last = node;
		length += 1;

	}

	public void prepend(int item) {
		var node = new Node(item);
		if (first == null) {
			first = last = node;
			length = 1;
			return;

		}
		var old_first = first;
		first = node;
		first.next = old_first;
		length += 1;

	}

	public void removeLast() {
		if (first == null) {
			System.out.print("Cant removeLast. " + this.toString());
		}
		// If the list has only one element
		if (first == last) {
			first = last = null;
			length = 0; // Update the length to 0
			return;
		}

		// Traverse the list to find the second-to-last node
		var pre = first;
		while (pre.next != last) {
			pre = pre.next;
		}

		// The pre node is now the second-to-last node
		pre.next = null;
		last = pre; // Update the last pointer
		length--; // Decrement the length
	}

	public void removeFirst() {
		if (first == null) {
			System.out.print("Cant removeFirst. " + this.toString());
		}
		if (first == last) {
			first = last = null;
			length = 0;
			return;
		}
		var current = first;
		first = first.next;
		current = null;
		length--;

	}

	public int get(int index) {
		if (index <= 0 || index > length) {
			return -1;
		}
		Node current = first;
		for (int i = 1; i < index; i++) {
			current = current.next;
		}
		return current.value;
	}

	public String set(int index, int value) {
		if (index <= 0 || index > length) {
			return null;
		}
		Node current = first;
		for (int i = 1; i < index; i++) {
			current = current.next;
		}
		current.value = value;
		return "Value at " + index + " has been changed to " + value;
	}

	public String insert(int index, int value) {
		if (index <= 0 || index > length + 1) {
			return null;
		}
		Node current = first;
		Node prev = first;

		for (int i = 1; i < index; i++) {

			prev = current;
			current = current.next;
		}
		Node newNode = new Node(value); // Create the new node to be inserted

		if (index == 1) {
			prepend(value);
		} else if (index == length + 1) {
			append(value);

		} else {
			prev.next = newNode; // Link the previous node to the new node
			newNode.next = current; // Link the new node to the current node
		}

		length++;
		return "New node with value," + value + " added at " + index;
	}

	public String remove(int index) {
		if (index <= 0 || index > length + 1) {
			return null;
		}
		Node current = first;
		Node prev = first;

		for (int i = 1; i < index; i++) {

			prev = current;
			current = current.next;
		}

		if (index == 1) {
			removeFirst();
		} else if (index == length) {
			removeLast();

		} else {
			prev.next = current.next; // Link the previous node to the new node
		}

		length++;
		return "Node removed added at " + index;
	}

	public void reverse() {
		Node current = first;
		first = last;
		last = current;
		Node prev = null;
		Node next = current.next;
		for (int i = 1; i <= length; i++) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;

		}
	}

	@Override
	public String toString() {
		var current = first;
		var result = new StringBuilder();
		if (first == null) {
			return "Linked List is empty!";
		}
		while (current != null) {
			result.append(current.value);
			if (current.next != null) {
				result.append(" -> ");
			}
			current = current.next;
		}
		return result.toString();
	}

	public int length() {
		return this.length;
	}
}