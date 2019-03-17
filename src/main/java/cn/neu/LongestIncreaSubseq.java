package cn.neu;

public class LongestIncreaSubseq {
    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 1, 2, 8};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }

    private static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}
