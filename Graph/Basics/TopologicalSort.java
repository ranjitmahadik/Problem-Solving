package Graph.Basics;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
    private static void topologicalSort(int[][] graph) {
        int[] indegree = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j : graph[i]) {
                indegree[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int child : graph[node]) {
                indegree[child]--;
                if (indegree[child] == 0) q.offer(child);
            }
        }
    }

    private static void topologicalSortRecursive(int[][] graph, int src, LinkedList<Integer> list, boolean[] vis) {
        vis[src] = true;
        for (int child : graph[src]) {
            if (!vis[child]) {
                topologicalSortRecursive(graph, child, list, vis);
            }
        }
        list.addFirst(src);
    }

    /**
     *          1    0
     *          | \ |
     *          4  2
     *          |  |
     *          \  3
     *           5
     * */
    public static void main(String[] args) {
        int[][] graph = {{2}, {4, 2}, {3}, {5}, {5}, {}};
        topologicalSort(graph);
        LinkedList<Integer> list = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];
        topologicalSortRecursive(graph, 0, list, vis);
        topologicalSortRecursive(graph, 1, list, vis);
        System.out.println();
        while (!list.isEmpty()){
            System.out.print(list.poll() + " ");
        }
    }
}
