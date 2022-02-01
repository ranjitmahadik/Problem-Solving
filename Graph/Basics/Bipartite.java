package Graph.Basics;


public class Bipartite {
    private static boolean isBipartite(int[][] graph, int src, int[] vis) {
        for (int child : graph[src]) {
            if (vis[child] == 0) {
                vis[child] = 3 - vis[src];
                if (!isBipartite(graph, child, vis)) return false;
            } else if (vis[child] == vis[src]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        int[] vis = new int[graph.length];
        vis[0] = 1;
        System.out.println(isBipartite(graph, 0, vis));
    }
}
