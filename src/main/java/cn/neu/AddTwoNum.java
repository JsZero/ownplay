package cn.neu;


public class AddTwoNum {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode node = new ListNode(0);
            ListNode pos = node;
            ListNode p1=l1,p2=l2;
            int carry = 0;
            while(p1!=null&&p2!=null){
                int value1 = p1!=null?p1.val:0;
                int value2 = p2!=null?p2.val:0;
                int res = carry+value1+value2;
                if(pos==null)
                    pos = new ListNode(res%10);
                pos.val = res%10;
                pos = pos.next;
                carry = res/10;
                p1 = p1.next;
                p2 = p2.next;
            }
            return node;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

//        while (l1 != null) {
//            System.out.println(l1.val + " -> ");
//            l1 = l1.next;
//        }
//        System.out.println("================");
//        while (l2 != null) {
//            System.out.println(l2.val + " -> ");
//            l2 = l2.next;
//        }
//        System.out.println("================");

        ListNode listNode = Solution.addTwoNumbers(l1, l2);
        if (listNode == null)
            System.out.println("is null");
        while (listNode != null) {
            System.out.println(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }
}
