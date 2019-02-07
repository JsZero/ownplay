package cn.neu;

public class RemoveNthFromEnd {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode node = new ListNode(0);
            node.next = head;
            ListNode p = node, q = node;
            while (n >= 0 && q != null) {
                q = q.next;
                n--;
            }
            while (q != null) {
                p = p.next;
                q = q.next;
            }
            p.next = p.next.next;
            return node.next;
        }
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        ListNode pointer = list;
        while (pointer != null) {
            System.out.println(pointer.val + " -> ");
            pointer = pointer.next;
        }

        Solution.removeNthFromEnd(list, 2);

        pointer = list;
        while (pointer != null) {
            System.out.println(pointer.val + " -> ");
            pointer = pointer.next;
        }

    }
}
