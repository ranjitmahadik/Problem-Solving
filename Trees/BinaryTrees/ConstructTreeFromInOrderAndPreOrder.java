package Trees.BinaryTrees;

public class ConstructTreeFromInOrderAndPreOrder {

    private static TreeNode construct(int[] inorder, int[] preorder, int inLo, int inHi, int preLo, int preHi) {

        if (inLo > inHi || preLo > preHi) return null;

        TreeNode currentNode = new TreeNode();
        currentNode.data = preorder[preLo];

        // now lets find current node in inOrder list. inorder { L Data R};
        int currentNodeIndex = -1;
        for (int i = inLo; i <= inHi; i++) {
            if (inorder[i] == currentNode.data) {
                currentNodeIndex = i;
                break;
            }
        }

        int nodeInLeftSubtree = currentNodeIndex - inLo;

        currentNode.left = construct(inorder, preorder, inLo, currentNodeIndex - 1, preLo + 1, preLo + nodeInLeftSubtree);
        currentNode.right = construct(inorder, preorder, currentNodeIndex + 1, inHi, preLo + nodeInLeftSubtree + 1, preHi);


        return currentNode;
    }


    static int currentNodeIndex = 0;
    private static TreeNode construct(int[] in, int[] pre, int lo, int hi) {
        if (lo > hi) return null;

        TreeNode currentNode = new TreeNode();
        currentNode.data = pre[currentNodeIndex];
        currentNodeIndex++;

        int i = lo;
        for (; i <= hi; i++) {
            if (currentNode.data == in[i]) {
                break;
            }
        }

        currentNode.left = construct(in, pre, lo, i - 1);
        currentNode.right = construct(in, pre, i + 1, hi);

        return currentNode;
    }

    public static void main(String[] args) {
        int[] in = {30, 20, 40, 10, 50, 60};
        int[] pre = {10, 20, 30, 40, 50, 60};
        TreeNode node = construct(in, pre, 0, in.length - 1);
        TreeOperations.levelOrderTraversal(node);
    }
}
