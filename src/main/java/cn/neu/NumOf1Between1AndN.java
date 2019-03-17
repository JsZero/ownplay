package cn.neu;

public class NumOf1Between1AndN {
    /**
     * 1：如果第i位（从低位向高位开始）上的数字是0，那么第i位可能出现1的次数仅由更高位决定（如果没有高位，则视高位为0），等于更高位数字*当前位数的权重10^(i-1)；
     * 2：如果第i位上的数字为1，则第i位上可能出现1的次数不仅受更高位影响还受低位影响（如果没有低位，则视低位为0），等于更高位数字*当前位数的权重10^(i-1) + (低位数字+1)；
     * 3：如果第i位上的数字大于1，则第i位上可能出现1的次数仅由更高位决定（如果没有高位，则视高位为0），等于（更高位数字+1）*当前位数的权重10^(i-1)
     *
     * @param n
     * @return
     */
    private static int numOf1Between1AndN(int n) {
        if (n < 0)
            return 0;
        return numOf1(n, 1);
    }

    private static int numOf1(int n, int x) {

        if (n < 0 || x < 1 || x > 9) {
            return 0;
        }
        int curr, low, temp, high = n, i = 1, total = 0;
        while (high != 0) {
            high = n / (int) Math.pow(10, i); //获取第i位的高位
            temp = n % (int) Math.pow(10, i); //
            curr = temp / (int) Math.pow(10, i - 1); //获取第i位
            low = temp % (int) Math.pow(10, i - 1); //获取第i位的低位
            if (curr == x) { //等于x
                total += high * (int) Math.pow(10, i - 1) + low + 1;
            } else if (curr < x) { //小于x
                total += high * (int) Math.pow(10, i - 1);
            } else { //大于x
                total += (high + 1) * (int) Math.pow(10, i - 1);
            }
            i++;
        }
        return total;
    }

    public static void main(String[] args) {

    }
}
