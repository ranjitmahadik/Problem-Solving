package Trees;


import java.util.ArrayList;

public class BinaryUpLifting {
    private ArrayList<Integer>[] graph;
    private int[][] parent;
    private int[] level;
    private int n, logOfTree;

    private void buildTree() {
        this.n = 7;
        this.graph = new ArrayList[n + 1];
        this.logOfTree = (int) Math.ceil((Math.log(n) / Math.log(2)));
        this.parent = new int[n + 1][logOfTree + 1];
        this.level = new int[n + 1];

        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        graph[1].add(2);
        graph[1].add(3);

        graph[2].add(4);
        graph[2].add(5);

        graph[4].add(6);
        graph[4].add(7);
    }

    private void dfs(int src, int par, int lvl) {
        level[src] = lvl;
        parent[src][0] = par;

        for (int i = 1; i <= logOfTree; i++) {
            parent[src][i] = parent[parent[src][i - 1]][i - 1];
        }

        for (int child : graph[src]) {
            if (child != par) {
                dfs(child, src, lvl + 1);
            }
        }
    }

    private void display() {
        for (int i = 0; i <= n; i++) {
            System.out.print("child[" + i + "] : ");
            for (int j = 0; j <= logOfTree; j++) {
                System.out.print(parent[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int query(int u, int v) {
        // always consider dept[v] to be greater than dept[u].
        if (u == v) return u;
        else if (level[u] > level[v]) return query(v, u);

        // move v to the u's level.
        while (level[u] != level[v]) {
            v = parent[v][0];
        }

        if (u == v) return u;

        while (u != v) {
            u = parent[u][0];
            v = parent[v][0];
        }
        return v;
    }

    private int queryOptimized(int u, int v) {
        // always consider dept[v] to be greater than dept[u].
        if (u == v) return u;
        else if (level[u] > level[v]) return query(v, u);


        int difference = level[v] - level[u];

        // move v to the u's level.
        for (int i = logOfTree; i >= 0; i--) {
            if ((difference & (1 << i)) > 0) {
                v = parent[v][i];
            }
        }

        if (u == v) return u;

        for (int i = logOfTree; i >= 0; i--) {
            if (parent[u][i] != parent[v][i]) {
                u = parent[u][i];
                v = parent[v][i];
            }
        }

        return v;
    }

    public static void main(String[] args) {
        BinaryUpLifting binaryUpLifting = new BinaryUpLifting();
        binaryUpLifting.buildTree();
        binaryUpLifting.dfs(1, 0, 0);
        int res = binaryUpLifting.queryOptimized(6, 5);
        System.out.println("LCA is : " + res);
        binaryUpLifting.display();
    }
}
