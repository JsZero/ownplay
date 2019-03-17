package cn.neu;

import java.util.Arrays;

public class ArrangeNumInArrayToMin {
    private static void arrangeNumInArrayToMin(int[] sourceArr) {
        if (sourceArr == null || sourceArr.length == 0)
            return;
        if (sourceArr.length == 1)
            System.out.println(sourceArr[0]);
        Integer[] arr = new Integer[sourceArr.length];
        for (int i = 0; i < sourceArr.length; i++) {
            arr[i] = sourceArr[i];
        }
        Arrays.sort(arr, (a, b) -> {
            String str0 = a + "" + b;
            String str1 = b + "" + a;
            return str0.compareTo(str1);
        });
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        arrangeNumInArrayToMin(new int[]{3, 32, 321});
    }
}
