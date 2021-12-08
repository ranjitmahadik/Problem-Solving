package Trees.BinaryTrees;

import java.util.*;

public class ViewsOfTree {
    private static void findRightView(TreeNode root) {
        Map<Integer, ArrayList<Integer>> lookup = new HashMap();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            TreeNode currentNode = currentPair.root;
            int currentNodeLevel = currentPair.stateCount;

            if (lookup.containsKey(currentNodeLevel)) {
                ArrayList<Integer> arr = lookup.get(currentNodeLevel);
                arr.add(currentNode.data);
                lookup.put(currentNodeLevel, arr);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(currentNode.data);
                lookup.put(currentNodeLevel, arr);
            }

            if (currentNode.left != null) queue.add(new Pair(currentNode.left, currentNodeLevel + 1));
            if (currentNode.right != null) queue.add(new Pair(currentNode.right, currentNodeLevel + 1));
        }

        for (Map.Entry<Integer, ArrayList<Integer>> map : lookup.entrySet()) {
            ArrayList<Integer> arrayList = map.getValue();
            int lastItem = arrayList.get(arrayList.size() - 1);
            System.out.print(lastItem + " ");
        }

    }

    private static void findRightViewOptimized(TreeNode root) {
        Map<Integer, Integer> lookups = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            TreeNode currentNode = currentPair.root;
            int currentNodeLevel = currentPair.stateCount;

            lookups.put(currentNodeLevel, currentNode.data);

            if (currentNode.left != null) queue.add(new Pair(currentNode.left, currentNodeLevel + 1));
            if (currentNode.right != null) queue.add(new Pair(currentNode.right, currentNodeLevel + 1));
        }
        for (int vals : lookups.values()) {
            System.out.print(vals + " ");
        }
    }

    private static void findRightViewSpaceOptimized(TreeNode root, int level, ArrayList<Integer> ans) {
        if (root == null) return;
        if (level == ans.size()) {
            ans.add(root.data);
        }
        findRightViewSpaceOptimized(root.right, level + 1, ans);
        findRightViewSpaceOptimized(root.left, level + 1, ans);
    }

    private static void rightViews(TreeNode root) {
//        findRightViewOptimized(root);
        ArrayList<Integer> ans = new ArrayList<>();
        findRightViewSpaceOptimized(root, 0, ans);
        for (int i : ans) System.out.print(i + " ");
    }


    private static void findLeftView(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair currentPair = q.poll();
            TreeNode currentNode = currentPair.root;
            int currentLevel = currentPair.stateCount;
            if (!map.containsKey(currentLevel)) {
                map.put(currentLevel, currentNode.data);
            }

            if (currentNode.left != null) q.add(new Pair(currentNode.left, currentLevel + 1));
            if (currentNode.right != null) q.add(new Pair(currentNode.right, currentLevel + 1));
        }
        for (int val : map.values())
            System.out.print(val + " ");
    }

    private static void findLeftViewSpaceOptimized(TreeNode root, int level, ArrayList<Integer> ans) {
        if (root == null) return;
        if (ans.size() == level) ans.add(root.data);
        findLeftViewSpaceOptimized(root.left, level + 1, ans);
        findLeftViewSpaceOptimized(root.right, level + 1, ans);
    }

    private static void leftViews(TreeNode root) {
        findLeftView(root);
        System.out.println();
        ArrayList<Integer> ans = new ArrayList<>();
        findLeftViewSpaceOptimized(root, 0, ans);
        for (int i : ans) System.out.print(i + " ");
    }


    private static void findTopView(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair currentPair = q.poll();
            TreeNode currentNode = currentPair.root;
            int currentBar = currentPair.stateCount;

            if (!map.containsKey(currentBar)) map.put(currentBar, currentNode.data);

            if (currentNode.left != null) q.add(new Pair(currentNode.left, currentBar - 1));
            if (currentNode.right != null) q.add(new Pair(currentNode.right, currentBar + 1));
        }

        for (int i : map.values()) System.out.print(i + " ");
    }

    private static void findBottomView(TreeNode root){
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair currentPair = q.poll();
            TreeNode currentNode = currentPair.root;
            int currentBar = currentPair.stateCount;

            map.put(currentBar, currentNode.data);

            if (currentNode.left != null) q.add(new Pair(currentNode.left, currentBar - 1));
            if (currentNode.right != null) q.add(new Pair(currentNode.right, currentBar + 1));
        }

        for (int i : map.values()) System.out.print(i + " ");
    }

    public static void main(String[] args) {
//        TreeNode root = TreeNode.getInstance2();
//        rightViews(root);
//        leftViews(root);
//        findTopView(root);
//        findBottomView(root);

    }
}
