package cn.neu.linkedlist;

public class EntryNodeOfLoopInLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode solution(ListNode node) {
        if (node == null)
            return null;
        int len = getLoopLen(node);
        System.out.println("[the len of loop is " + len + "]");
        if (len == -1) {
            System.out.println("input list has no loop");
            return null;
        }
        return getLoopEntry(node, len);
    }

    private static int getLoopLen(ListNode node) {
        ListNode p1 = new ListNode(0);
        ListNode p2 = p1;
        p1.next = node;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2)
                break;
        }
        if (p2.next == null || p2.next.next == null)
            return -1;
        int len = 1;
        p1 = p1.next;
        while (p1 != p2) {
            p1 = p1.next;
            len += 1;
        }
        return len;
    }

    private static ListNode getLoopEntry(ListNode node, int len) {
        ListNode p1 = new ListNode(0);
        p1.next = node;
        ListNode p2 = p1;
        while (len-- > 0) {
            p2 = p2.next;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;

        int count = 20;
        ListNode start = node1;
        while (count > 0 && start != null) {
            System.out.print(start.val + " -> ");
            count--;
            start = start.next;
        }
        System.out.println();

        ListNode res = solution(node1);
        System.out.println(res != null ? res.val : "null");
    }
}
