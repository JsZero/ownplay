package cn.neu;

public class RegularMatch {

    static class Solution {
        /**
         * 牛逼
         *
         * @param text
         * @param pattern
         * @return
         */
        public static boolean isMatch(String text, String pattern) {
            if (pattern.isEmpty()) return text.isEmpty();
            boolean first_match = (!text.isEmpty() &&
                    (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

            if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
                return (isMatch(text, pattern.substring(2)) ||
                        (first_match && isMatch(text.substring(1), pattern)));
            } else {
                return first_match && isMatch(text.substring(1), pattern.substring(1));
            }
        }

        public static boolean isMatchPro(String text, String pattern) {
            return isMatchProCore(text.toCharArray(), pattern.toCharArray());
        }

        /**
         * 错误算法
         * @param str
         * @param pattern
         * @return
         */
        public static boolean isMatchProCore(char[] str, char[] pattern) {
            boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
            dp[0][0] = true;
            for (int j = 1; j < dp[0].length; j++) {
                if (pattern[j - 1] == '*' && j >= 2)
                    dp[0][j] = dp[0][j - 2];
            }
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    //
                    if (pattern[j - 1] == '.' || pattern[j - 1] == str[i - 1])
                        dp[i][j] = dp[i - 1][j - 1];
                    else if (pattern[j - 1] == '*' && i >= 2) {
                        if (pattern[j - 2] != str[i - 1] && pattern[j - 2] != '.')
                            dp[i][j] = dp[i][j - 2];
                        else dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
                    }
                }
            }
            return dp[str.length][pattern.length];
        }

    }

    public static void main(String[] args) {
        System.out.println(Solution.isMatch("aa", "a"));
        System.out.println(Solution.isMatch("aa", "a*"));
        System.out.println(Solution.isMatch("ab", ".*"));
        System.out.println(Solution.isMatch("aab", "c*a*b"));
        System.out.println(Solution.isMatch("mississippi", "mis*is*p*."));
        System.out.println("=====================================");
        System.out.println(Solution.isMatchPro("aa", "a"));
        System.out.println(Solution.isMatchPro("aa", "a*"));
        System.out.println(Solution.isMatchPro("ab", ".*"));
        System.out.println(Solution.isMatchPro("aab", "c*a*b"));
        System.out.println(Solution.isMatchPro("mississippi", "mis*is*ip*."));
        System.out.println(Solution.isMatchPro("aab", "c*a*b"));
    }
}
