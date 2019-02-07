package cn.neu.stack;

import java.util.Stack;

public class IsPopOrder {

    private static boolean isPopOrder(int[] pushOrder, int[] popOrdedr) {
        int len = pushOrder.length;
        int pos0 = 0;
        int pos1 = 0;
        Stack<Integer> stack = new Stack<>();
        while (pos1 < len) {
            while (stack.isEmpty() || popOrdedr[pos1] != stack.peek()) {
                if (pos0 >= len)
                    return false;
                stack.push(pushOrder[pos0++]);
            }
            stack.pop();
            pos1++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushOrder = {1, 2, 3, 4, 5};
        int[] popOrder = {4, 5, 3, 2, 1};
        System.out.println(isPopOrder(pushOrder, popOrder));
    }
}
