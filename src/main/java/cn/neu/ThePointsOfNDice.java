package cn.neu;

public class ThePointsOfNDice {
    public static final int MAX_VALUE = 3;

    private static void printProbability(int number) {
        if (number < 1)
            return;
        int maxSum = number * MAX_VALUE;
        int[] pProbabilities = new int[maxSum - number + 1];
        Probability(number, pProbabilities);
        double total = Math.pow(MAX_VALUE, number);
        for (int i = number; i <= maxSum; ++i) {
            double ratio = pProbabilities[i - number] / total;
            System.out.println(i + ":\t" + ratio);
        }
    }

    private static void Probability(int number, int[] pProbabilities) {
        for (int i = 1; i <= MAX_VALUE; ++i) {
            Probability(number, number, i, pProbabilities);
        }
    }

    private static void Probability(int original, int current, int sum, int[] pProbabilities) {
        if (current == 1) {
            pProbabilities[sum - original]++;
        } else {
            for (int i = 1; i < MAX_VALUE; ++i) {
                Probability(original, current - 1, i + sum, pProbabilities);
            }
        }
    }

    public static void main(String[] args) {
        printProbability(2);
    }
}
