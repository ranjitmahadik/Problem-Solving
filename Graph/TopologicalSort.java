package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * topological sort is only possible in case of graph is directed acyclic graph.
 */
public class TopologicalSort {

    private static void topologicalSortBFS(ArrayList<GraphBasics.Graph>[] graph) {
        int size = graph.length;
        int[] inDegree = new int[size];
        for (int i = 1; i <= 5; i++) {
            for (GraphBasics.Graph childNode : graph[i]) {
                inDegree[childNode.getChild()]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println("node = " + node);
            for (GraphBasics.Graph childNode : graph[node]) {
                int child = childNode.getChild();
                inDegree[child]--;

                if (inDegree[child] == 0) queue.add(child);
            }
        }

    }

    private static void topologicalSortDFS(ArrayList<GraphBasics.Graph>[] graphs, int src, boolean[] vis, Stack<Integer> stack) {
        for (GraphBasics.Graph childNode : graphs[src]) {
            int child = childNode.getChild();
            if (!vis[child]) {
                vis[child] = true;
                topologicalSortDFS(graphs, child, vis, stack);
            }
        }
        stack.add(src);
    }

    public static void main(String[] args) {
        GraphBasics graph = new GraphBasics(5, true);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(5, 4);
        graph.addEdge(4, 3);
//        boolean[] vis = new boolean[6];
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 1; i <= 5; i++) {
//            if (vis[i]) continue;
//            vis[i] = true;
//            topologicalSortDFS(graph.getGraph(), i, vis, stack);
//        }
//        while (!stack.isEmpty()) {
//            int node = stack.pop();
//            System.out.println("node = " + node);
//        }
        topologicalSortBFS(graph.getGraph());

    }
}
