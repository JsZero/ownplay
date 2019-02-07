package cn.neu.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintFromTopToBottom {

    private static void printFromTopToBottomIter(TreeNode head) {
        if (head == null)
            return;
        Queue<TreeNode> tree = new LinkedList<>();
        tree.offer(head);
        while (!tree.isEmpty()) {
            TreeNode node = tree.poll();
            System.out.print(node.val);
            if (node.left != null) tree.offer(node.left);
            if (node.right != null) tree.offer(node.right);
        }
        System.out.println();
    }

    private static void printFromTopToBottomRecu(TreeNode head) {

    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.demoTree();
        TreeNode.display(tree);
        printFromTopToBottomIter(tree);
    }
}
