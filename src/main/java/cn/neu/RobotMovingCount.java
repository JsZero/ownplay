package cn.neu;

public class RobotMovingCount {

    public static void main(String[] args) {
        int limit = 10;
        int count = movingCount(limit, 100, 100);
        System.out.println(count);
    }

    private static int movingCount(int limit, int rowsLimit, int colsLimit) {
        boolean[][] visited = new boolean[rowsLimit][colsLimit];

        int res = movingCountCore(limit, rowsLimit, colsLimit, visited, 0, 0);

        System.out.println("========================");
        for (int i = 0; i < rowsLimit; i++) {
            for (int j = 0; j < colsLimit; j++) {
                if (visited[i][j])
                    System.out.println("[" + i + "," + j + "]");
            }
        }
        System.out.println("========================");

        return res;
    }

    private static int movingCountCore(int limit, int rowsLimit, int colsLimit, boolean[][] visited, int row, int col) {
        int count = 0;
        System.out.println("check [" + row + "," + col + "]");
        if (check(limit, rowsLimit, colsLimit, visited, row, col)) {
            visited[row][col] = true;
            int up = movingCountCore(limit, rowsLimit, colsLimit, visited, row - 1, col);
            int left = movingCountCore(limit, rowsLimit, colsLimit, visited, row, col - 1);
            int down = movingCountCore(limit, rowsLimit, colsLimit, visited, row + 1, col);
            int right = movingCountCore(limit, rowsLimit, colsLimit, visited, row, col + 1);
            count = 1 + up + left + down + right;
        }
        return count;
    }

    private static boolean check(int limit, int rowsLimit, int colsLimit, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row >= rowsLimit || col >= colsLimit || getDigitSum(row, col) > limit || visited[row][col])
            return false;
        System.out.println("[" + row + "," + col + "]");
        return true;
    }

    private static int getDigitSum(int row, int col) {
        int sum = 0;
        while (row != 0) {
            int left = row % 10;
            sum += left;
            row = row / 10;
        }
        while (col != 0) {
            int left = col % 10;
            sum += left;
            col = col / 10;
        }
        return sum;
    }
}
