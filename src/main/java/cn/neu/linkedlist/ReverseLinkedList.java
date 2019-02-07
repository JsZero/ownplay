package cn.neu.linkedlist;

public class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode solution(ListNode head) {
        ListNode reverseHead = null;
        ListNode preNode = null;
        ListNode currNode = head;
        while (currNode != null) {
            ListNode nextNode = currNode.next;
            if (nextNode == null)
                reverseHead = currNode;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        return reverseHead;
    }

    public static void main(String[] args) {

    }
}
