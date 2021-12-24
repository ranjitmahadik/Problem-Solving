package DynamicProgramming.Trees;

import java.util.ArrayList;

public class MinimumHeightTrees {
    private static int n = 10;
    private static int[] in = new int[n];
    private static int[] out = new int[n];
    private static ArrayList<Integer>[] tree = new ArrayList[n];

    private static int dfs1(int src, int par) {
        int maxHeight = -1;
        for (int child : tree[src]) {
            if (child != par) {
                maxHeight = Math.max(maxHeight, dfs1(child, src));
            }
        }
        return in[src] = 1 + maxHeight;
    }

    private static void dfs2(int src, int par) {
        int max1 = -1, max2 = -1;
        // find the max two heights.
        for (int child : tree[src]) {
            if (child != par) {
                if (in[child] >= max1) {
                    max2 = max1;
                    max1 = max2;
                } else if (in[child] > max2) {
                    max2 = in[child];
                }
            }
        }


        for (int child : tree[src]) {
            if (child != par) {
                int selectedChildHeight = max1;
                if (selectedChildHeight == in[child]) {
                    // to remove current child
                    selectedChildHeight = max2;
                }

                out[child] = Math.max(1 + out[src], 2 + selectedChildHeight);
                dfs2(child, src);
            }
        }
    }

    /**
     *https://blogarithms.github.io/articles/2019-10/inout-dp-tree
     *
     * */
}
