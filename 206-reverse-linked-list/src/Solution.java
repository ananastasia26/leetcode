class Solution {
    /* iterative
    public ListNode reverseList(ListNode head) {
        var prevNode = null;
        var currentNode = head;

        while(currentNode != null) {
            var newNode = new ListNode(currentNode.val);
            newNode.next = prevNode;

            prevNode = newNode;
            currentNode = currentNode.next;
        }

        return prevNode;
    }
    */

    // recursive

    private ListNode startNode;
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        var lastNode = reverse(head);
        lastNode.next = null;

        return startNode;
    }

    public ListNode reverse(ListNode head) {
        if(head.next == null) {
            startNode = head;
            return head;
        }
        var prevNode = reverse(head.next);
        prevNode.next = head;

        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}

