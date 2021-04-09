package linkedlist.easy;

import linkedlist.ListNode;

/**
 * LeetCode Problem: 92
 */
public class ReverseList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode n1 = null;
        ListNode n2 = null;
        ListNode prev = null;
        ListNode next = null;
        ListNode temp = head;
        int ctr = 1;

        //find first and prev node
        while (temp != null && ctr != left) {
            prev = temp;
            temp = temp.next;
            ctr++;
        }
        n1 = temp;

        //find node 2
        temp = head;
        ctr = 1;
        while (temp != null && ctr != right) {
            temp = temp.next;
        }
        n2 = temp;
        if(n1 == null || n2 == null) {
            return null;
        }
        next = n2.next;
        reverseList(n1, n2);

        n1.next = next;
        prev.next = n2;
        return head;
    }

    private void reverseList(ListNode n1, ListNode n2) {
        ListNode prev = null;
        ListNode curr = n1;

        while (prev != n2) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
    }
}
