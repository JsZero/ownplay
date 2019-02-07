package cn.neu.tree;

import java.util.Stack;

public class VerifySequenceOfBST {

    private static boolean verifySequenceOfBST(int[] postOrder) {
        if (postOrder == null || postOrder.length == 0)
            return true;
        return verifySequenceOfBSTCore(postOrder, 0, postOrder.length - 1);
    }

    private static boolean verifySequenceOfBSTCore(int[] postOrder, int start, int end) {
        if (start < 0 || start >= end)
            return true;
        int index = start;
        while (index < end) {
            if (postOrder[index] >= postOrder[end])
                break;
            index++;
        }
        int tmp = index;
        while (tmp < end) {
            if (postOrder[tmp] < postOrder[end])
                return false;
            tmp++;
        }
        boolean left = verifySequenceOfBSTCore(postOrder, start, index - 1);
        if (left) {
            if (end - index <= 1)
                return true;
            return verifySequenceOfBSTCore(postOrder, index, end - 1);
        } else
            return false;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 6, 9, 11, 10, 8};
        System.out.println(verifySequenceOfBST(arr));
        arr = new int[]{7, 4, 6, 5};
        System.out.println(verifySequenceOfBST(arr));
    }
}
