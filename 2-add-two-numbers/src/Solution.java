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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overflow = 0;

        var startNodeRes = new ListNode();
        var prevListNode = startNodeRes;

        var currentNode1 = l1;
        var currentNode2 = l2;

        while(!(currentNode1 == null && currentNode2 == null && overflow == 0)) {
            var currentValue = overflow + getSafelyValueFromNode(currentNode1) + getSafelyValueFromNode(currentNode2);

            overflow = currentValue / 10;
            currentValue = currentValue % 10;

            var newNode = new ListNode(currentValue);
            prevListNode.next = newNode;
            prevListNode = newNode;

            currentNode1 = getSafelyNextNode(currentNode1);
            currentNode2 = getSafelyNextNode(currentNode2);
        }

        return startNodeRes.next;
    }

    private int getSafelyValueFromNode(ListNode node) {
        return node != null ? node.val : 0;
    }

    private ListNode getSafelyNextNode(ListNode node) {
        return node != null ? node.next : null;
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