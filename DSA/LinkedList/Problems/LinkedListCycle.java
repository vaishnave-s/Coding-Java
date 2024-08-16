/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
		public boolean hasCycle(ListNode head) {
				Set<ListNode> nodesPast = new HashSet<>();
				ListNode current = head;
				while(current!=null){
						if(nodesPast.contains(current))
								return true;
						nodesPast.add(current);
						current=current.next;

				}
				return false;


		}
}