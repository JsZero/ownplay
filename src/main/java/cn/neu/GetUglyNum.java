package cn.neu;

public class GetUglyNum {
    private static int getUglyNum(int num) {
        int[] nums = new int[num];
        nums[0] = 1;
        int pos2 = 0;
        int pos3 = 0;
        int pos5 = 0;
        for (int i = 1; i < num; i++) {
            int minVal = min(2 * nums[pos2], 3 * nums[pos3], 5 * nums[pos5]);
            nums[i] = minVal;
            while (minVal >= 2 * nums[pos2]) {
                pos2++;
            }
            while (minVal >= 3 * nums[pos3]) {
                pos3++;
            }
            while (minVal >= 5 * nums[pos5]) {
                pos5++;
            }
        }

        return nums[num - 1];
    }

    private static int min(int a, int b, int c) {
        return a < b ? (a < c ? a : c) : (b < c ? b : c);
    }

    private static int getUglyNumElse(int num) {
        int count = 0;
        int number = 1;
        while (count < num) {
            if (isUglyNum(number)) {
                count++;
                if (count == num) {
                    break;
                }
            }
            number++;
        }

        return number;
    }

    private static boolean isUglyNum(int num) {
        while (num % 2 == 0)
            num /= 2;
        while (num % 3 == 0)
            num /= 3;
        while (num % 5 == 0)
            num /= 5;
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(getUglyNum(150));
        System.out.println(getUglyNumElse(150));
    }
}
