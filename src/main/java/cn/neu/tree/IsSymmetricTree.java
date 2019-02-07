package cn.neu.tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetricTree {

    public static boolean isSymmetricTreeRecur(TreeNode node) {
        if (node == null)
            return true;
        return isSymmetricTreeRecur(node, node);
    }

    public static boolean isSymmetricTreeRecur(TreeNode node0, TreeNode node1) {
        if (node0 == null && node1 == null)
            return true;
        if (node0 == null || node1 == null)
            return false;
        if (node0.val == node1.val) {
            return isSymmetricTreeRecur(node0.left, node1.right) && isSymmetricTreeRecur(node0.right, node1.left);
        }
        return false;
    }

    /**
     * 精髓在于两点
     * 1、第一次压入两次头结点
     * 2、左右反着压入
     *
     * @param node
     * @return
     */
    public static boolean isSymmetricTreeItera(TreeNode node) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(node);
        treeNodes.add(node);
        TreeNode node0;
        TreeNode node1;
        while (!treeNodes.isEmpty()) {
            node0 = treeNodes.poll();
            node1 = treeNodes.poll();
            if (node0 == null && node1 == null)
                continue;
            else if (node0 == null || node1 == null)
                return false;
            if (node0.val == node1.val) {
                treeNodes.add(node0.left);
                treeNodes.add(node1.right);
                treeNodes.add(node0.right);
                treeNodes.add(node1.left);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        tree.left = node1;
        tree.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
//        node6.right = new TreeNode(7);
        TreeNode.display(tree);
        System.out.println(isSymmetricTreeItera(tree));

    }

}
