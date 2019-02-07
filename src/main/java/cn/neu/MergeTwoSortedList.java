package cn.neu;

public class MergeTwoSortedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode solution(ListNode head0, ListNode head1) {
        if (head0 == null)
            return head1;
        else if (head1 == null)
            return head0;
        ListNode head;
        if (head0.val <= head1.val) {
            head = head0;
            head.next = solution(head0.next, head1);
        } else {
            head = head1;
            head.next = solution(head0, head1.next);
        }
        return head;
//        if (head0 == null && head1 == null)
//            return null;
//        ListNode head;
//        if (head0 == null)
//            return head1;
//        else if (head1 == null)
//            return head0;
//        if (head0.val < head1.val)
//            head = head0;
//        else
//            head = head1;
//        while (head0 != null && head1 != null) {
//            ListNode tmp;
//            if (head0.val < head1.val) {
//                tmp = head0;
//                head0 = head0.next;
//                tmp.next = head1;
//            } else {
//                tmp = head1;
//                head1 = head1.next;
//                tmp.next = head0;
//            }
//        }
//        return head;
    }

    public static void main(String[] args) {
        ListNode list0node0 = new ListNode(1);
        ListNode list0node1 = new ListNode(2);
        ListNode list0node2 = new ListNode(4);
//        ListNode list0node3 = new ListNode(7);
        list0node0.next = list0node1;
        list0node1.next = list0node2;
//        list0node2.next = list0node3;

        ListNode list1node0 = new ListNode(1);
        ListNode list1node1 = new ListNode(3);
        ListNode list1node2 = new ListNode(4);
//        ListNode list1node3 = new ListNode(8);
        list1node0.next = list1node1;
        list1node1.next = list1node2;
//        list1node2.next = list1node3;

        ListNode node = solution(list0node0, list1node0);
        while (node != null) {
            System.out.println(node.val + " -> ");
            node = node.next;
        }
    }
}
