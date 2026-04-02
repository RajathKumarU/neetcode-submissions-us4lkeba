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
    public ListNode mergeKLists(ListNode[] lists) {

        int len = lists.length;
        int k = len;
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        int[] isEmpty = new int[len];

        while (k > 0) {
            ListNode small = new ListNode(9999);
            int smallIdx = -1;
            for (int i=0;i<len;i++) {
                if(lists[i] != null && lists[i].val <= small.val) {
                    small = lists[i];
                    smallIdx = i;
                }
            }

            dummy.next = small;
            lists[smallIdx] = lists[smallIdx].next;
            dummy = dummy.next;

            if(lists[smallIdx] == null && isEmpty[smallIdx] == 0) {
                isEmpty[smallIdx] = 1;
                k--;
            }
        }

        return res.next;

    }
}
