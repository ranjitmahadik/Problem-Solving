package Graph.Basics;

import java.util.ArrayList;

public class DirectedGraphCycleDetection {
    private static boolean hasCycle(ArrayList<int[]> graph, int src, boolean[] vis, boolean[] currentPath) {
        vis[src] = true;
        currentPath[src] = true;
        for (int child : graph.get(src)) {
            if (!vis[child] && hasCycle(graph, child, vis, currentPath)) return true;
            else if (vis[child] && currentPath[child]) return true; //backedge.
        }
        currentPath[src] = false;
        return false;
    }

    public static void main(String[] args) {
        ArrayList<int[]> graph = new ArrayList<>();
        graph.add(new int[]{1, 4, 5});
        graph.add(new int[]{2});
        graph.add(new int[]{3});
        graph.add(new int[]{0});
        graph.add(new int[]{});
        graph.add(new int[]{4});
        boolean[] vis = new boolean[6];
        System.out.println(hasCycle(graph, 0, vis, new boolean[6]));
    }
}
