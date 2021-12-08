package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {

    private static boolean isBipartiteBFS(ArrayList<GraphBasics.Graph>[] graph, int src) {
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) color[i] = -1;
        q.add(src);
        color[src] = 1;

        while (!q.isEmpty()) {
            int parentNode = q.poll();
            int parentColor = color[parentNode];

            for (GraphBasics.Graph childNode : graph[parentNode]) {
                int child = childNode.getChild();
                if (color[child] == -1) {
                    color[child] = 1 - parentColor;
                    q.add(child);
                } else if (color[child] == parentColor) return false;
            }
        }
        return true;
    }

    private static boolean isBipartite(ArrayList<GraphBasics.Graph>[] graph, int src, int[] color) {
        for (GraphBasics.Graph childNode : graph[src]) {
            int child = childNode.getChild();
            if (color[child] == -1) {
                color[child] = 1 - color[src];
                if (!isBipartite(graph, child, color)) return false;
            } else if (color[child] == color[src]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        GraphBasics graph = new GraphBasics();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);
        int[] color = new int[6];
        for (int i = 0; i < 6; i++) color[i] = -1;
        color[1] = 1;
//        System.out.println("isBipartite(graph.getGraph(), 1, 0, color) = " + isBipartite(graph.getGraph(), 1, color));
        System.out.println("isBipartiteBFS(graph.getGraph(), 1) = " + isBipartiteBFS(graph.getGraph(), 1));
    }
}
