package Graph.Basics;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversals {
    static class Graph {
        int v;
        List<Integer>[] graph;

        public Graph(int v) {
            this.v = v;
            graph = new LinkedList[v];
        }

        private void init(int u) {
            if (this.graph[u] == null) this.graph[u] = new LinkedList<>();
        }

        public void addEdge(int u, int v) {
            this.init(u);
            this.init(v);
            this.graph[u].add(v);
            this.graph[v].add(u);
        }

        public void addEdge(int u, int v, boolean isUnDirected) {
            if (isUnDirected) {
                this.init(v);
                this.graph[v].add(u);
            }
            this.init(u);
            this.graph[u].add(v);
        }
    }

    private static void bfs(Graph g, int src) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[g.v];
        int[] dist = new int[g.v];
        int[] par = new int[g.v];

        Arrays.fill(dist, 0);
        q.add(src);
        vis[src] = true;
        par[src] = src;

        while (!q.isEmpty()) {
            int srcNode = q.poll();
            System.out.print(srcNode + " => ");
            for (int child : g.graph[srcNode]) {
                if (vis[child]) continue;
                vis[child] = true;
                dist[child] = dist[srcNode] + 1;
                par[child] = srcNode;
                q.offer(child);
            }
        }
        System.out.println();
        for (int i = 0; i < g.v; i++) {
            System.out.println("Node " + i + " has distance " + dist[i] + " from Node " + src);
        }

    }

    private static void dfs(Graph g, int src, int par, boolean[] vis) {
        System.out.print(src + " ");
        vis[src] = true;
        for (int child : g.graph[src]) {
            if (!vis[child] || par != child) {
                dfs(g, child, src, vis);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(1, 2);
        g.addEdge(1, 0);
        g.addEdge(2, 3);
        g.addEdge(0, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        bfs(g, 1);
        boolean[] vis = new boolean[7];
        dfs(g, 1, -1, vis);


    }
}
