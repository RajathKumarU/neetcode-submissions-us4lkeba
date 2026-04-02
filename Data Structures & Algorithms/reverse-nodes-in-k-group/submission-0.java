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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode prevMain = head;
        ListNode dummy = new ListNode(0);
        ListNode dummyStart = dummy;

        ListNode cur = head;
        boolean end = false;
        while (cur != null && !end) {
            ListNode prev = null;
            boolean hasKElem = hasKElements(cur, k);

            for (int i=0;i<k && hasKElem;i++) {
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }

            if(hasKElem) {
                dummy.next = prev;
                dummy = prevMain;
                prevMain = cur;
            } else {
                end = true;
                dummy.next = cur;
            }
        }

        return dummyStart.next;
        
    }

    public boolean hasKElements(ListNode head, int len) {
        int k = len;
        ListNode tmp = head;

        while (k > 0 && tmp != null) {
            tmp = tmp.next;
            k--;
        }

        return k==0?true:false;

    }
}
