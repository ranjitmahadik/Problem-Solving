package Graph.Basics;

import java.util.ArrayList;

public class UndirectedGraphCycleDetection {
    private static boolean hasCycle(ArrayList<int[]> graph, int src, int par, boolean[] vis) {
        vis[src] = true;
        for (int child : graph.get(src)) {
            if (!vis[child] && child != par) {
                if (hasCycle(graph, child, src, vis)) return true;
            } else if (vis[child] && child != par) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<int[]> graph = new ArrayList<>();
        graph.add(new int[]{1, 4, 5});  //0
        graph.add(new int[]{0, 2}); //1
        graph.add(new int[]{1, 3});//2
        graph.add(new int[]{2});//3
        graph.add(new int[]{0, 5});//4
        graph.add(new int[]{0, 4});//5

        boolean[] vis = new boolean[6];
        System.out.println(hasCycle(graph, 1, -1, vis));
    }
}
