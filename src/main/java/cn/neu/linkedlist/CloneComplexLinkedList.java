package cn.neu.linkedlist;

public class CloneComplexLinkedList {
    private static ComplexListNode cloneComplexLinkedList(ComplexListNode head) {
        cloneNodes(head);
        connectSiblingNodes(head);
        return reconnectNodes(head);
    }

    private static void cloneNodes(ComplexListNode head) {
        if (head == null)
            return;
        ComplexListNode node = head.next;
        ComplexListNode cloneHead = new ComplexListNode(head.val);
        head.next = cloneHead;
        cloneHead.next = node;
        cloneNodes(node);
    }

    private static void connectSiblingNodes(ComplexListNode head) {

        ComplexListNode cloneHead = head.next;
        if (head.sibling != null)
            cloneHead.sibling = head.sibling.next;
        if (cloneHead.next != null)
            connectSiblingNodes(cloneHead.next);
    }

    private static ComplexListNode reconnectNodes(ComplexListNode head) {
        if (head == null)
            return null;
        ComplexListNode cloneHead = head.next;
        ComplexListNode node = cloneHead;
        while (head.next != null) {
            head.next = node.next;
            head = node;
            node = node.next;
        }
        return cloneHead;
    }

    private static void display(ComplexListNode head) {
        while (head != null) {
            System.out.println(
                    "[val: " + head.val + ",next: " + (head.next != null ? head.next.val : "null") + ", sibling: " + (head.sibling != null ? head.sibling.val : "null") + "] ->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ComplexListNode head = new ComplexListNode(0);
        ComplexListNode node0 = new ComplexListNode(2);
        ComplexListNode node1 = new ComplexListNode(1);
        ComplexListNode node2 = new ComplexListNode(3);
        ComplexListNode node3 = new ComplexListNode(4);
        head.next = node0;
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        head.sibling = node1;
        node0.sibling = node3;
        node2.sibling = node0;
        // display original complex linked list
        display(head);
        System.out.println("===================");
        // clone&display new complex linked list
        ComplexListNode cloneHead = cloneComplexLinkedList(head);

        display(cloneHead);
        System.out.println("===================");

        // display original complex linked list
        display(head);
        System.out.println("===================");

        // judge are they equal or not
        System.out.println(head == cloneHead);
    }

    private static class ComplexListNode {
        int val;
        ComplexListNode next;
        ComplexListNode sibling;

        ComplexListNode(int val) {
            this.val = val;
        }
    }
}
