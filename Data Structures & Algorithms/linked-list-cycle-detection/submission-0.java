/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {

        boolean cycle = false;
        Set<ListNode> visitedSet = new HashSet<>();
        while (head != null) {
            if(visitedSet.contains(head)) {
                return true;
            } else {
                visitedSet.add(head);
            }

            head = head.next;
        }

        return false;
        
    }
}
