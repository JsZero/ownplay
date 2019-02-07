package cn.neu.string;

import java.util.Stack;

public class Permutation {
    // search for the permutation for str
    // abc acb bac bca cab cba
    private static void permutation(String str) {
        permutationCore(str.toCharArray(), 0);
    }

    private static void permutationCore(char[] arr, int start) {
        if (start == arr.length - 1)
            System.out.println(arr);
        else {
            for (int i = start; i < arr.length; i++) {
                swap(arr, i, start);
                permutationCore(arr, start + 1);
                swap(arr, i, start);
            }
        }
    }

    // search for the combination for the str
    // a b c ab ac bc abc
    private static void combination(String str) {
        Stack<Character> stack = new Stack<>();
        for (int num = 1; num <= str.length(); num++) {
            combinationCore(str.toCharArray(), 0, num, stack);
        }
    }

    private static void combinationCore(char[] chars, int start, int num, Stack<Character> stack) {
        if (0 == num) {
            System.out.println(stack);
            return;
        }
        if (start == chars.length)
            return;
        stack.push(chars[start]);
        combinationCore(chars, start + 1, num - 1, stack);
        stack.pop();
        combinationCore(chars, start + 1, num, stack);

    }

    private static void swap(char[] arr, int a, int b) {
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        permutation("abc");
        System.out.println("=============================");
        combination("abc");
        System.out.println("=============================");
    }
}
