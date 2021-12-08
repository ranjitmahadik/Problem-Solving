package Graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBasics {
    class Graph {
        private int child;
        private int weight;

        public Graph(int dest) {
            this.child = dest;
            this.weight = 0;
        }

        public Graph(int dest, int weight) {
            this.child = dest;
            this.weight = weight;
        }

        public int getChild() {
            return child;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Graph{" +
                    "dest=" + child +
                    ", weight=" + weight +
                    '}';
        }
    }

    private ArrayList<Graph>[] graph;
    private int size = 20;
    private boolean isDirected;
    private boolean[] vis;

    GraphBasics() {
        init();
    }

    GraphBasics(int size) {
        this.size = size + 1;
        init();
    }

    GraphBasics(boolean isDirected) {
        this.isDirected = isDirected;
        init();
    }

    GraphBasics(int size, boolean isDirected) {
        this.size = size + 1;
        this.isDirected = isDirected;
        init();
    }

    private void init() {
        this.graph = new ArrayList[size];
        this.vis = new boolean[size];
        for (int i = 0; i < this.size; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        graph[u].add(new Graph(v));
        if (!isDirected) graph[v].add(new Graph(u));
    }

    public void addEdge(int u, int v, int w) {
        graph[u].add(new Graph(v, w));
        if (!isDirected) graph[v].add(new Graph(u, w));
    }

    public void dfs(int src, int par) {
        vis[src] = true;
        System.out.print(src + " ");
        for (Graph child : graph[src]) {
            if (child.getChild() != par && !vis[child.getChild()]) {
                dfs(child.getChild(), src);
            }
        }
    }

    private void dfs(int src) {
        vis[src] = true;
        for (Graph g : graph[src]) {
            if (vis[g.getChild()]) continue;
            dfs(g.getChild());
        }
    }

    public void bfs(int src) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;
        while (!q.isEmpty()) {
            int currentVertex = q.poll();
            System.out.print(currentVertex + " ");

            for (Graph child : graph[currentVertex]) {
                if (vis[child.getChild()]) continue;
                vis[child.getChild()] = true;
                q.add(child.getChild());
            }
        }
    }

    public int getComponentCount() {
        int count = 0;
        for (int i = 1; i < this.size; i++) {
            if (vis[i]) continue;
            dfs(i);
            count++;
        }
        return count;
    }

    public ArrayList<Graph>[] getGraph() {
        return graph;
    }

    /**
     * 1 ------ 2
     * |        |
     * 3 ------ 4
     */
    public static void main(String[] args) {
        GraphBasics graphBasics = new GraphBasics(4);
        graphBasics.addEdge(1, 2);
        graphBasics.addEdge(1, 3);
        graphBasics.addEdge(2, 4);
        graphBasics.addEdge(3, 4);
//        graphBasics.dfs(1, -1);
        graphBasics.bfs(1);

    }
}
