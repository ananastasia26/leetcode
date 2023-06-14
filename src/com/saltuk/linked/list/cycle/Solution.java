package com.saltuk.linked.list.cycle;

/**
 * 141-linked-list-cycle
 */

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
        if(less3Node(head)) {
            return false;
        }

        var slowPointer = head;
        var fastPointer = head.next.next;

        while(true) {
            if (slowPointer == fastPointer) {
                return true;
            }

            if (less3Node(fastPointer)) {
                return false;
            }

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
    }

    private boolean less3Node(ListNode head) {
        return head == null || head.next == null|| head.next.next == null;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}