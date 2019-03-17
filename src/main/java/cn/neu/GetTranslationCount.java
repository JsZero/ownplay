package cn.neu;

public class GetTranslationCount {
    private static int getTranslationCount(int num) {
        String str = "" + num;
        int[] count = new int[str.length()];
        for (int i = str.length() - 1; i >= 0; i--) {
            if (i == str.length() - 1)
                count[i] = 1;
            else {
                count[i] = count[i + 1];
                int digit0 = str.charAt(i) - '0';
                int digit1 = str.charAt(i + 1) - '0';
                int converted = digit0 * 10 + digit1;
                if (converted > 10 && converted < 25) {
                    if (i < str.length() + 2)
                        count[i] += count[i + 2];
                    else
                        count[i] += 1;
                }
            }
        }
        return count[0];
    }

    public static void main(String[] args) {
        System.out.println(getTranslationCount(122584));
    }
}
