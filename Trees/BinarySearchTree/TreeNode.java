package Trees.BinarySearchTree;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }


    /**
     *                              15
     *             10                                   20
     *         5        12                      17              29
     *     3      6
     *
     * */
    public static TreeNode getInstance(){
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(12);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(6);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(17);
        root.right.right = new TreeNode(29);

        return root;
    }
}
