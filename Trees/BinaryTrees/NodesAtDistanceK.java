package Trees.BinaryTrees;

import util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NodesAtDistanceK {
    private static Map<TreeNode, TreeNode> lookup = new HashMap();

    private static void dfs(TreeNode currentNode, TreeNode parent) {
        if (currentNode == null) return;

        lookup.put(currentNode, parent);
        dfs(currentNode.left, currentNode);
        dfs(currentNode.right, currentNode);
    }

    private static void printKDistanceAwayNodes(TreeNode root, final int K) {
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        boolean[] vis = new boolean[20];
        q.add(new Pair<>(root, 0));
        vis[root.data] = true;

        while (!q.isEmpty()) {
            TreeNode currentNode = q.peek().getFirst();
            int currentK = q.peek().getSecond();
            q.poll();

            if (currentK < K && currentNode != null) {
                if (currentNode.left != null && !vis[currentNode.left.data]) {
                    q.add(new Pair<>(currentNode.left, currentK + 1));
                    vis[currentNode.left.data] = true;
                }
                if (currentNode.right != null && !vis[currentNode.right.data]) {
                    q.add(new Pair<>(currentNode.right, currentK + 1));
                    vis[currentNode.right.data] = true;
                }
                TreeNode currentNodeParent = lookup.get(currentNode);
                if (currentNodeParent != null && !vis[currentNodeParent.data]) {
                    q.add(new Pair<>(currentNodeParent, currentK + 1));
                    vis[currentNodeParent.data] = true;
                }
            }
            if (currentK == K) System.out.println(currentNode.data + " ");
        }

    }

//    private static void printKDistanceAwayNodes(TreeNode root, final int K) {
//        Queue<Pair> q = new LinkedList<>();
//        boolean[] visited = new boolean[20];
//        q.add(new Pair(root, 0));
//
//        while (!q.isEmpty()) {
//            Pair currentNodePair = q.poll();
//            TreeNode currentNode = currentNodePair.root;
//            int currentNodeLevel = currentNodePair.stateCount;
//            // handle current node children's.
//            if (currentNodeLevel < K && currentNode != null) {
//                visited[currentNode.data] = true;
//                if (currentNode.left != null && !visited[currentNode.left.data])
//                    q.add(new Pair(currentNode.left, currentNodeLevel + 1));
//                if (currentNode.right != null && !visited[currentNode.right.data])
//                    q.add(new Pair(currentNode.right, currentNodeLevel + 1));
//                TreeNode parentNode = lookup.get(currentNode);
//                if (parentNode != null && !visited[parentNode.data]) q.add(new Pair(parentNode, currentNodeLevel + 1));
//            }
//            if (currentNodeLevel == K) {
//                System.out.print(currentNode + " ");
//            }
//        }
//    }


    private static void findNodesAtKDistance(TreeNode root, final int K, int lvl) {
        if (root == null || lvl > K) return;
        if (lvl == K) System.out.print(root.data + " ");
        findNodesAtKDistance(root.left, K, lvl + 1);
        findNodesAtKDistance(root.right, K, lvl + 1);
    }

    private static int findNodesKDistanceAway(TreeNode root, int target, final int K) {
        if (root == null) return -1;

        if (root.data == target) {
            findNodesAtKDistance(root, K, 0);
            return 1;
        }
        int left = findNodesKDistanceAway(root.left, target, K);
        int right = findNodesKDistanceAway(root.right, target, K);

        if (left == K || right == K) System.out.print(root.data + " ");

        if (left != -1) {
            int newKDistance = K - left;
            findNodesAtKDistance(root.right, newKDistance, 1);
            return left + 1;
        }

        if (right != -1) {
            int newKDistance = K - right;
            findNodesAtKDistance(root.left, newKDistance, 1);
            return right + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getInstance4();
//        dfs(root, null);
//        printKDistanceAwayNodes(root.left, 2);
////        for (Map.Entry<TreeNode, TreeNode> keyVal : lookup.entrySet()) {
////            System.out.println("Node : " + keyVal.getKey() + " Parent : " + keyVal.getValue());
////        }

        findNodesKDistanceAway(root, 4, 2);

    }
}
