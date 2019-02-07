package cn.neu;

public class FindKthFromEnd {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode solution(ListNode head, int k) {
        if (head == null && k <= 0)
            return null;
        ListNode p1 = new ListNode(0);
        ListNode p2 = new ListNode(0);
        p1.next = head;
        p2.next = head;
        while (k > 0 && p1 != null) {
            k--;
            p1 = p1.next;
        }
        if (p1 == null)
            return null;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(0);
        ListNode pointer = list;
        for (int i = 1; i < 10; i++) {
            pointer.next = new ListNode(i);
            pointer = pointer.next;
        }

        ListNode start = list;
        while (start != null) {
            System.out.print(start.val + " -> ");
            start = start.next;
        }
        System.out.println();

        start = list;
        ListNode solution = solution(start, 1);

        System.out.println(solution.val);

    }
}
