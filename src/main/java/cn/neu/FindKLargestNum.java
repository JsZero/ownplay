package cn.neu;

import java.util.Arrays;

public class FindKLargestNum {

    public static int findKLargestNum(int[] source, int K) {
        int[] arr = Arrays.copyOf(source, source.length);
        int index = partition(arr, 0, arr.length - 1);
        while (index != K - 1) {
            if (index > K - 1)
                index = partition(arr, 0, index);
            else
                index = partition(arr, index + 1, arr.length - 1);
        }
        return arr[K - 1];
    }

    private static int partition(int[] arr, int start, int end) {
        if (start < 0 || end > arr.length - 1)
            return -1;
        int large = start - 1;
        int index = (start + end) >> 1;
        swap(arr, index, end);
        for (index = start; index <= end; index++) {
            if (arr[index] > arr[end]) {
                large++;
                if (large != index)
                    swap(arr, large, index);
            }
        }
        large++;
        swap(arr, large, end);
        return large;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 9, 5, 6, 4, 7, 8, 0};
        System.out.println(findKLargestNum(arr, 4));
    }
}
