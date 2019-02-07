package cn.neu.tree;

public class MirrorOfBinTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode mirrorOfBinTree(TreeNode p) {
        if (p == null)
            return null;
        TreeNode head = p;
        exchangeSubTree(p);
        return head;
    }

    private static void exchangeSubTree(TreeNode curr) {
        if (curr != null) {
            TreeNode tmp = curr.left;
            curr.left = curr.right;
            curr.right = tmp;
            exchangeSubTree(curr.left);
            exchangeSubTree(curr.right);
        }

    }

    private static void display(TreeNode head) {
        if (head != null) {
            System.out.print(head.val);
            if (head.left != null || head.right != null) {
                System.out.print("[");
                display(head.left);
                System.out.print(",");
                display(head.right);
                System.out.print("]");
            }
        }

    }

    public static void main(String[] args) {
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

        display(tree);
        System.out.println();

        tree = mirrorOfBinTree(tree);

        display(tree);
        System.out.println();

    }
}
