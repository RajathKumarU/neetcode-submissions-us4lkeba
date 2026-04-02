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
    public void reorderList(ListNode head) {

        ListNode start = head;
        ListNode mid = head;
        ListNode last = head;

        while (last !=null && last.next!=null) {
            mid = mid.next;
            last = last.next.next;
        }

        ListNode secHalf = reverseList(mid.next);
        mid.next = null;
        
        head = mergeTwoLists(start, secHalf);

    }

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while (list1 != null && list2 != null) {
            node.next = list1;
            list1 = list1.next;
            node = node.next;

            node.next = list2;
            list2 = list2.next;
            node = node.next;
        }

        if(list1 == null) {
            node.next = list2;
        } else {
            node.next = list1;
        }

        return dummy.next;

    }
}
