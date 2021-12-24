package DynamicProgramming.Trees;

import java.util.ArrayList;

public class TreeDistanceI {
    private static int n = 10;
    private static ArrayList<Integer>[] tree = new ArrayList[n];
    private static int[] in = new int[n];
    private static int[] out = new int[n];

    static {
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
    }

    private static int dfs(int src, int par) {
        int maxHeight = -1;
        for (int child : tree[src]) {
            if (child != par) {
                maxHeight = Math.max(maxHeight, dfs(child, src));
            }
        }
        return in[src] = maxHeight + 1;
    }

    private static void addEdge(int u, int v) {
        tree[u].add(v);
        tree[v].add(u);
    }

    private static void dfs2(int src, int par) {
        int max1 = -1, max2 = -1;
        for (int child : tree[src]) {
            if (child != par) {
                if (in[child] >= max1) {
                    max2 = max1;
                    max1 = in[child];
                } else if (in[child] > max2) {
                    max2 = in[child];
                }
            }
        }

        for (int child : tree[src]) {
            if (child != par) {
                int using = max1;
                if (max1 == in[child]) using = max2;

                out[child] = Math.max(out[src] + 1, 2 + using);
                dfs(child, src);
            }
        }
    }

    public static void main(String[] args) {
        addEdge(1, 2);
        addEdge(1, 3);
        dfs(1, 0);
        dfs2(1, 0);
        for (int i = 0; i < 10; i++) {
            System.out.println(Math.max(in[i],out[i]));
        }
    }
}
