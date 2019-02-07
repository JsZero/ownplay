package cn.neu.linkedlist;

import java.util.Objects;

class LinkedList {
    private Node head = null;
    private int length;

    public void addNode(Node node) {
        if (head == null) {
            head = new Node();
            length = 0;
        }
        Node pos = head;
        while (pos.getNext() != null) {
            pos = pos.getNext();
        }
        pos.next = node;
        length += 1;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void display() {
        for (Node node = head; node != null; node = node.getNext()) {
            System.out.print(node + " -> ");
            System.out.println();
        }
    }

    public void setLength(int length) {
        this.length = length;
    }

    static class Node {
        int value;
        Node next = null;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(Node next) {
            this.next = next;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + (next != null ? next.getClass() + "@" + next.hashCode() : null) +
                    '}';
        }
    }
}

/**
 * 时间复杂度需要是 O（1）
 */
public class DeleteNodeInLinkedList {

    public static void deleteNodeInLinkedList(LinkedList.Node head, LinkedList.Node node) {
        if (node.getNext() != null && node != head) {

        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        LinkedList.Node node = new LinkedList.Node(2);
        ll.addNode(new LinkedList.Node(9));
        ll.addNode(new LinkedList.Node(2));
        ll.addNode(new LinkedList.Node(5));
        ll.addNode(new LinkedList.Node(7));
        ll.addNode(node);
        ll.addNode(new LinkedList.Node(3));
        System.out.println("==================");
        System.out.println(ll.getLength());
        ll.display();
        System.out.println("==================");

        System.out.println(ll.getLength());
        ll.display();
    }
}
