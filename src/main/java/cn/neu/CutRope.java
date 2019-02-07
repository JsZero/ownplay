package cn.neu;

public class CutRope {

    public static int maxProductAfterCutting_DynamicPlanning(int length) {
        if (length < 2)
            return 0;
        else if (length == 2)
            return 1;
        else if (length == 3)
            return 2;
        int[] product = new int[length + 1];
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;
        for (int i = 4; i < length + 1; i++) {
            int max = 0;
            for (int j = 1; j <= (i >> 1); j++) {
                int tmp = product[j] * product[i - j];
                if (max < tmp)
                    max = tmp;
            }
            product[i] = max;
        }
//        for (int i = 0; i < product.length; i++) {
//            System.out.println("[" + i + "," + product[i] + "]");
//        }
        return product[length];
    }

    public static int maxProductAfterCutting_Greedy(int length) {
        if (length < 2)
            return 0;
        else if (length == 2)
            return 1;
        else if (length == 3)
            return 2;
        int numOf3 = length / 3;
        if (length % 3 == 1) {
            numOf3 -= 1;
        }
        int numOf2 = (length - 3 * numOf3) / 2;
        return (int) (Math.pow(3, numOf3)) * (int) (Math.pow(2, numOf2));
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(maxProductAfterCutting_DynamicPlanning(100));
        System.out.println(maxProductAfterCutting_Greedy(100));
    }
}
