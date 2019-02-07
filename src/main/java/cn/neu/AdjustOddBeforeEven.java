package cn.neu;

import java.util.Arrays;

public class AdjustOddBeforeEven {

    private static int[] solution(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int begin = 0;
        int end = arr.length - 1;
        while (begin < end) {
            while (begin < end && (arr[begin] & 1) == 1)
                begin++;
            while (begin < end && (arr[end] & 1) == 0)
                end--;
            if (begin < end) {
                int tmp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = tmp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 21, 9, 15, 2, 3, 4, 5, 6, 7, 8};
        int[] res = solution(arr);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
