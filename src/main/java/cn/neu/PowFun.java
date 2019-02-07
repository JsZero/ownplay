package cn.neu;

public class PowFun {
    private static double pow(double base, int exponent) {
        if (base == 0 && exponent < 0)
            return -1;
        if (exponent == 0)
            return 1;
        else if (exponent == 1)
            return base;
        int absExponent = Math.abs(exponent);
        double result = powWithPositive(base, absExponent);
        if (exponent < 0)
            result = 1 / result;
        return result;
    }

    private static double powWithPositive(double base, int absExponent) {
        if (absExponent == 0)
            return 1;
        else if (absExponent == 1)
            return base;
        double result = powWithPositive(base, absExponent >> 1);
        result *= result;
        if ((absExponent & 1) == 1) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
//        int i = 142132;
        System.out.println(pow(2, -4));
    }
}
