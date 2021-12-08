package Trees.BinaryTrees;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = right = null;
    }



    @Override
    public String toString() {
        return String.valueOf(data);
    }

    public TreeNode() {
    }

    /**
     * 15
     * 10       9
     * 2    1   7     12
     */
    public static TreeNode getInstance() {
        TreeNode treeNode = new TreeNode(15);
        treeNode.left = new TreeNode(10);
        treeNode.right = new TreeNode(9);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(7);
        treeNode.right.right = new TreeNode(12);
        return treeNode;
    }


    /**
     * 15
     * 10       9
     * 2    1   7     12
     * 3     11
     * 8    4
     */
    public static TreeNode getInstance1() {
        TreeNode treeNode = new TreeNode(15);
        treeNode.left = new TreeNode(10);
        treeNode.right = new TreeNode(9);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(7);
        treeNode.right.right = new TreeNode(12);
        treeNode.left.left.left = new TreeNode(3);
        treeNode.left.left.right = new TreeNode(11);
        treeNode.left.left.left.left = new TreeNode(8);
        treeNode.left.left.left.right = new TreeNode(4);

        return treeNode;
    }


    /**
     * 15
     * 10       9
     * 2    1   7     12
     * 3     11
     * 8    4
     * 13
     * 14
     */
    public static TreeNode getInstance2() {
        TreeNode treeNode = new TreeNode(15);
        treeNode.left = new TreeNode(10);
        treeNode.right = new TreeNode(9);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(7);
        treeNode.right.right = new TreeNode(12);
        treeNode.left.left.left = new TreeNode(3);
        treeNode.left.left.right = new TreeNode(11);
        treeNode.left.left.left.left = new TreeNode(8);
        treeNode.left.left.left.right = new TreeNode(4);

        treeNode.left.left.left.left.left = new TreeNode(13);
        treeNode.left.left.left.left.left.right = new TreeNode(14);


        return treeNode;
    }

    /**
     * 1
     * 2        2
     * 3     4   4    3
     */

    public static TreeNode getInstance3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        return root;
    }

    /**
     *                  1
     *            2             3
     *       4        5     6       7
     *  8       9
     *
     * */
    public static TreeNode getInstance4() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        return root;
    }
}
