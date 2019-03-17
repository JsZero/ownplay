package cn.neu;

public class GetMavValueOfPresent {
    private static int getMavValueOfPresent(int[][] values) {
        if (values == null)
            return 0;
//        int[][] maxValues = new int[values.length][values[0].length];
        int[] maxValues = new int[values[0].length];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                int left = 0;
                int up = 0;
                if (j > 0)
//                    left = maxValues[i][j - 1];
                    left = maxValues[j - 1];
                if (i > 0)
//                    up = maxValues[i - 1][j];
                    up = maxValues[j];
//                maxValues[i][j] = Math.max(left, up) + values[i][j];
                maxValues[j] = Math.max(left, up) + values[i][j];

            }
        }
//        int maxValue = maxValues[values.length - 1][values[0].length - 1];
        int maxValue = maxValues[values[0].length - 1];
        return maxValue;
    }

    public static void main(String[] args) {
        int[][] values = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        System.out.println(getMavValueOfPresent(values));
    }
}
