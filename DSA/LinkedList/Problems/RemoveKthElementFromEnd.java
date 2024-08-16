/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = null;
		ListNode prev = null;
		ListNode current = head;
		ListNode next = head.next;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;

		}
		newHead = prev;
		return newHead;

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Reverse the list
		ListNode reversedList = reverse(head);

		// If n is 1, remove the first node
		if (n == 1) {
			return reverse(reversedList.next); // Reverse back without the first node
		}

		ListNode prev = reversedList;
		ListNode current = reversedList.next;
		int i = 1;

		// Traverse the reversed list to find the node before the one to be removed
		while (current != null && i < n - 1) {
			prev = current;
			current = current.next;
			i++;
		}

		// Remove the nth node
		if (current != null && current.next != null) {
			prev.next = current.next;
		} else if (current != null && current.next == null) {
			prev.next = null; // If it's the last node, just remove it
		}

		// Reverse the list back to its original order
		return reverse(reversedList);
	}
}