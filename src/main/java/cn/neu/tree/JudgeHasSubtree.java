package cn.neu.tree;

public class JudgeHasSubtree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static boolean solution(TreeNode r0, TreeNode r1) {
        if (r0 == null || r1 == null)
            return false;
        boolean result = false;
        if (r0.val == r1.val) {
            result = isSameTree(r0, r1);
        }
        if (!result)
            result = solution(r0.left, r1);
        if (!result)
            result = solution(r0.right, r1);
        return result;
    }

    private static boolean isSameTree(TreeNode r0, TreeNode r1) {
        if (r1 == null)
            return true;
        if (r0 == null)
            return false;
        if (r0.val == r1.val)
            return isSameTree(r0.left, r1.left) && isSameTree(r0.right, r1.right);
        else
            return false;
    }

    public static void main(String[] args) {
        TreeNode tree0 = new TreeNode(8);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        tree0.left = node1;
        tree0.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;

        TreeNode tree1 = new TreeNode(8);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(2);
        tree1.left = node7;
        tree1.right = node8;
        node8.right = node9;

        System.out.println(solution(tree0, tree1));
    }
}
