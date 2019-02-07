package cn.neu;

import java.util.Arrays;

public class QuickSort {
    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int index = partition(arr, start, end);
            quickSort(arr, start, index);
            quickSort(arr, index + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        if (arr.length == 0 || start < 0 || end > arr.length - 1)
            return -1;
        int index = (start + end) >> 1;
        swap(arr, index, end);
        int small = start - 1;
        for (index = start; index <= end; index++) {
            if (arr[index] < arr[end]) {
                small++;
                if (small < index) {
                    swap(arr, small, index);
                }
            }
        }
        small++;
        swap(arr, small, end);
        return small;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 9, 5, 6, 4, 7, 8, 0};
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] arrRet = sort(arr);
        for (int i : arrRet) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}