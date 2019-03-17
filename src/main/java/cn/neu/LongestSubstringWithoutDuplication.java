package cn.neu;

import java.util.Arrays;

public class LongestSubstringWithoutDuplication {
    private static int longestSubstringWithoutDuplication(String str) {
        int curLength = 0;
        int maxLength = 0;
        int[] position = new int[26];
        Arrays.fill(position, -1);
        for (int i = 0; i < str.length(); i++) {
            int preIndex = position[str.charAt(i) - 'a'];
            if (preIndex < 0 || i - preIndex > curLength)
                curLength++;
            else {
                if (curLength > maxLength)
                    maxLength = curLength;
                curLength = i - preIndex;

            }
            position[str.charAt(i) - 'a'] = i;

        }
        if (curLength > maxLength)
            maxLength = curLength;
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDuplication("abcdef"));
    }
}
