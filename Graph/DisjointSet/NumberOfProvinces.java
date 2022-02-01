package Graph.DisjointSet;

public class NumberOfProvinces {
    private int[] parent;
    private int[] rank;
    private int provincesCount;

    private void init(int n) {
        parent = new int[n];
        rank = new int[n];
        this.provincesCount = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int v) {
        if (v == parent[v]) return v;
        return parent[v] = find(parent[v]);
    }

    private void union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u != v) {
            if (rank[u] > rank[v]) {
                parent[v] = u;
            } else if (rank[u] < rank[v]) {
                parent[u] = v;
            } else {
                parent[v] = u;
                rank[u]++;
            }
            this.provincesCount--;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected[0].length;
        this.init(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) this.union(i, j);
            }
        }
        return this.provincesCount;
    }
}
