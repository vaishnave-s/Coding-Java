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
	public ListNode middleNode(ListNode head) {
		ListNode current = head;
		int i = 0;
		int mid_i = 0;
		while (current.next != null) {
			current = current.next;
			i += 1;

		}
		i += 1;
		if (i % 2 != 0)
			mid_i = (int) Math.ceil((double) i / 2);
		else
			mid_i = (int) Math.ceil((double) i / 2) + 1;
		current = head;

		for (int n = 1; n <= i; n++) {
			if (n == mid_i) {
				return current;
			}

			else {
				current = current.next;

			}

		}

		return head;
	}
}