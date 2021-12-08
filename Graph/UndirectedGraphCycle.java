package Graph;

import util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraphCycle {

    private static boolean hasCycleBFS(ArrayList<GraphBasics.Graph>[] graph) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        boolean[] vis = new boolean[7];
        q.add(new Pair<>(1, 0));
        vis[1] = true;

        while (!q.isEmpty()) {
            int currentNode = q.peek().getFirst();
            int currentNodeParent = q.peek().getSecond();
            q.poll();

            for (GraphBasics.Graph node : graph[currentNode]) {
                int child = node.getChild();
                if (!vis[child] && child != currentNodeParent) {
                    vis[child] = true;
                    q.add(new Pair<>(child, currentNode));
                } else if (vis[child] && child != currentNodeParent) {
                    return true;
                }
            }
        }
        return false;

    }

    private static boolean hasCycleDfs(ArrayList<GraphBasics.Graph>[] graph, int src, int parent, boolean[] vis) {
        for (GraphBasics.Graph node : graph[src]) {
            int child = node.getChild();
            if (!vis[child] && child != parent) {
                vis[child] = true;
                if (hasCycleDfs(graph, child, src, vis)) return true;
            } else if (vis[child] && child != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GraphBasics graph = new GraphBasics();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        boolean[] vis = new boolean[7];
        vis[1] = true;
        System.out.println("hasCycleDfs(graph.getGraph(), 1, 0, new boolean[6]) = " + hasCycleDfs(graph.getGraph(), 1, 0, vis));
        System.out.println("hasCycleBFS(graph.getGraph()) = " + hasCycleBFS(graph.getGraph()));
    }
}
