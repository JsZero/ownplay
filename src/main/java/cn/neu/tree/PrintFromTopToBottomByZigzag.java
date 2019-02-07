package cn.neu.tree;

import java.util.Stack;

public class PrintFromTopToBottomByZigzag {

    private static void printFromTopToBottomByZigzag(TreeNode head) {
        if (head == null)
            return;
        Stack<TreeNode> stack0 = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack0.push(head);
        int level = 0;
        Stack<TreeNode> currStack;
        Stack<TreeNode> nextStack;
        while (!stack0.isEmpty() || !stack1.isEmpty()) {
            currStack = (level % 2 == 0) ? stack0 : stack1;
            nextStack = (level % 2 == 0) ? stack1 : stack0;
            while (!currStack.isEmpty()) {
                TreeNode node = currStack.pop();
                System.out.print(node.val + "->");
                if(level%2==0){
                    if (node.left != null) nextStack.push(node.left);
                    if (node.right != null) nextStack.push(node.right);
                }else {
                    if (node.right != null) nextStack.push(node.right);
                    if (node.left != null) nextStack.push(node.left);
                }
            }
            level++;
        }
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.demoTree();
        TreeNode.display(tree);
        printFromTopToBottomByZigzag(tree);
    }
}
