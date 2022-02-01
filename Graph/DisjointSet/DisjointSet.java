package Graph.DisjointSet;

public class DisjointSet {

    /***
     *  In-short : Disjoint set counts numbers of disconnected components in graph.
     *
     * */
    static abstract class UnionFind {
        protected int[] parent;

        public UnionFind(int n) {
            System.out.println("--------------" + this.getClass().getSimpleName() + "-------------------");
            parent = new int[n];
            this.init();
        }

        private void init() {
            for (int i = 0; i < parent.length; i++) parent[i] = i;
        }

        protected void show() {
            for (int i = 0; i < parent.length; i++) {
                System.out.print(parent[i] + " ");
            }
            System.out.println();
        }

        protected void isConnected(int u, int v) {
            System.out.println("isConnected {" + u + "," + v + "} = " + (find(u) == find(v)));
        }

        protected abstract void union(int u, int v);

        protected abstract int find(int u);
    }

    /**
     * Union => O(~N)
     * Find  => O(N)
     */
    static class QuickUnion extends UnionFind {
        public QuickUnion(int n) {
            super(n);
        }

        @Override
        protected void union(int u, int v) {
            int uParent = find(u);
            int vParent = find(v);
            if (uParent != vParent) {
                parent[vParent] = uParent;
            }
        }

        @Override
        protected int find(int u) {
            if (parent[u] == u) return u;
            return find(parent[u]);
        }
    }


    /**
     * Union => O(N) per query.
     * Find  => O(1)
     */
    static class QuickFind extends UnionFind {
        public QuickFind(int n) {
            super(n);
        }

        @Override
        protected void union(int u, int v) {
            int uParent = find(u);
            int vParent = find(v);
            if (uParent != vParent) {
                for (int i = 0; i < parent.length; i++) {
                    if (parent[i] == vParent) {
                        parent[i] = uParent;
                    }
                }
            }
        }

        @Override
        protected int find(int u) {
            return parent[u];
        }
    }


    static class UnionByRank extends UnionFind {
        private int[] rank;

        public UnionByRank(int n) {
            super(n);
            rank = new int[n];
            this.initRank();
        }

        private void initRank() {
            for (int i = 0; i < rank.length; i++) {
                rank[i] = 1;
            }
        }

        @Override
        protected void union(int u, int v) {
            int uParent = find(u);
            int vParent = find(v);
            if (uParent != vParent) {
                if (rank[uParent] > rank[vParent]) {
                    parent[vParent] = uParent;
                } else if (rank[vParent] > rank[uParent]) {
                    parent[uParent] = vParent;
                } else {
                    parent[vParent] = uParent;
                    rank[uParent] += 1;
                }
            }
        }

        @Override
        protected int find(int u) {
            while (u != parent[u]) u = parent[u];
            return u;
        }
    }

    static class UnionByRankOptimization extends UnionFind {
        private int[] rank;

        public UnionByRankOptimization(int n) {
            super(n);
            rank = new int[n];
            this.initRank(n);
        }

        private void initRank(int n) {
            for (int i = 0; i < n; i++) rank[i] = 1;
        }

        @Override
        protected void union(int u, int v) {
            int uParent = find(u);
            int vParent = find(v);
            if (rank[uParent] > rank[vParent]) {
                parent[vParent] = uParent;
            } else if (rank[vParent] > rank[uParent]) {
                parent[uParent] = vParent;
            } else {
                parent[vParent] = uParent;
                rank[uParent]++;
            }
        }

        @Override
        protected int find(int u) {
            if (u == parent[u]) return u;
            return parent[u] = find(parent[u]);
        }
    }


    private static void quickUnionFind(UnionFind unionFind) {
        unionFind.union(1, 2);
        unionFind.union(2, 5);
        unionFind.union(5, 6);
        unionFind.union(6, 7);
        unionFind.union(3, 8);
        unionFind.union(8, 9);
//        unionFind.union(1, 3);
        unionFind.isConnected(1, 5);
        unionFind.isConnected(5, 7);
        unionFind.isConnected(4, 9);
        unionFind.show();
    }

    public static void main(String[] args) {
        quickUnionFind(new QuickFind(10));
        quickUnionFind(new QuickUnion(10));
        quickUnionFind(new UnionByRank(10));
        quickUnionFind(new UnionByRankOptimization(10));
    }

}
