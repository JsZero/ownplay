package cn.neu.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintFromTopToBottomByLine {
    private static void printFromTopToBottomByLine(TreeNode head) {
        if (head == null)
            return;
        Queue<TreeNode> tree = new LinkedList<>();
        tree.offer(head);
        int numOfCurr = 1;
        int numOfNext = 0;
        while (!tree.isEmpty()) {
            TreeNode node = tree.poll();
            numOfCurr--;
            if (numOfCurr == 0)
                System.out.println(node.val);
            else
                System.out.print(node.val);
            if (node.left != null) {
                numOfNext++;
                tree.offer(node.left);
            }
            if (node.right != null) {
                numOfNext++;
                tree.offer(node.right);
            }
            if (numOfCurr == 0) {
                numOfCurr = numOfNext;
                numOfNext = 0;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.demoTree();
        TreeNode.display(tree);
        printFromTopToBottomByLine(tree);
    }
}
