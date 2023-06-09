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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var advancedIdx = head;
        for (int i = 0; i < n; ++i) {
            advancedIdx = advancedIdx.next;
        }

        ListNode prev = null;
        var idx = head;
        while (advancedIdx != null) {
            advancedIdx = advancedIdx.next;
            prev = idx;
            idx = idx.next;
        }
        if (prev == null) {
            return head.next;
        } else {
            prev.next = idx.next;
            return head;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}