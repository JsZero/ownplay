package cn.neu.tree;

public class ConstructTreeWithPreInOrder {
    private static TreeNode constructTreeWithPreInOrder(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null)
            return null;
        if (preOrder.length == 0 || preOrder.length != inOrder.length)
            return null;
        return constructTreeWithPreInOrderCore(preOrder, 0, preOrder.length - 1,
                inOrder, 0, inOrder.length - 1);
    }

    private static TreeNode constructTreeWithPreInOrderCore(
            int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        System.out.println("[" + preStart + "," + preEnd + "," + inStart + "," + inEnd + "]");
        int val = preOrder[preStart];
        TreeNode root = new TreeNode(val);
        if (preStart == preEnd) {
            if (inStart == inEnd)
                return root;

        }
        TreeNode left = null;
        TreeNode right = null;
        if (preStart < preEnd) {
            int index = inStart;
            while (index < inEnd) {
                if (inOrder[index] == val)
                    break;
                index++;
            }
            int leftLen = index - preStart;
            if (leftLen > 0)
                left = constructTreeWithPreInOrderCore(preOrder, preStart + 1, preStart + leftLen, inOrder, inStart, index - 1);
            if (preEnd - preStart > leftLen)
                right = constructTreeWithPreInOrderCore(preOrder, preStart + leftLen + 1, preEnd, inOrder, index + 1, inEnd);
        }
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = constructTreeWithPreInOrder(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        TreeNode.display(node);
    }
}
