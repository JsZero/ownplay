package cn.neu;

public class NumOf1 {

    /**
     * 遍历次数为二进制的位数
     *
     * @param n
     * @return
     */
    private static int numOf1CommonSolution(int n) {
        int flag = 1;
        int count = 0;
        while (flag > 0) {
            if ((n & flag) != 0) {
                count += 1;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 遍历次数为数字二进制中1的个数
     *
     * @param n
     * @return
     */
    private static int numOf1AwesomeSolution(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(0b10000000000000000000000000000000));
        System.out.println(Integer.toBinaryString(-0));
        System.out.println(Integer.toBinaryString(-8364328));
        System.out.println(numOf1CommonSolution(-8364328));
        System.out.println(numOf1AwesomeSolution(-8364328));
    }
}
