package cn.neu.tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    public static void display(TreeNode head) {
        displayCore(head);
        System.out.println();
    }

    private static void displayCore(TreeNode head) {
        if (head != null) {
            System.out.print(head.val);
            if (head.left != null || head.right != null) {
                System.out.print("[");
                displayCore(head.left);
                System.out.print(",");
                displayCore(head.right);
                System.out.print("]");
            }
        }

    }

    public static TreeNode demoTree() {
        TreeNode tree = new TreeNode(8);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        tree.left = node1;
        tree.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;
        return tree;
    }
}
