package cn.neu;

// 开始回溯法
public class PathInMatrix {

    public static boolean hasPath(String[][] matrix, String str) {
        if (matrix == null)
            return false;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int pathLen = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
//                System.out.println("[" + row + "," + col + "]");
                if (hasPathCore(matrix, visited, str, row, col, pathLen) == str.length())
                    return true;
            }
        }
        return false;
    }

    private static int hasPathCore(String[][] matrix, boolean[][] visited, String str, int row, int col, int pathLen) {
//        System.out.println(pathLen);
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length)
            return -1;

        if (matrix[row][col].equals(str.charAt(pathLen) + "") && !visited[row][col]) {
            visited[row][col] = true;
            pathLen++;
            if (pathLen == str.length() || hasPathCore(matrix, visited, str, row - 1, col, pathLen) == str.length() ||
                    hasPathCore(matrix, visited, str, row, col - 1, pathLen) == str.length() ||
                    hasPathCore(matrix, visited, str, row + 1, col, pathLen) == str.length() ||
                    hasPathCore(matrix, visited, str, row, col + 1, pathLen) == str.length()) {
                return str.length();
            }
        }
        return -1;
    }

    public static void testFun(int num) {
        num++;
        System.out.println(num);
    }

    public static void main(String[] args) {
        String[][] strs = {{"a", "b", "t", "g"}, {"c", "f", "c", "s"}, {"j", "d", "e", "h"}};
        System.out.println(hasPath(strs, "bfcd"));
//        boolean[][] visited = new boolean[strs.length][strs[0].length];
//        for (String[] str : strs) {
//            for (int j = 0; j < strs[0].length; j++) {
//                System.out.print(str[j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("================");
//        for (int i = 0; i < visited.length; i++) {
//            for (int j = 0; j < visited[i].length; j++) {
//                System.out.print(visited[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
