package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {

    private static void findOrder(List<Integer>[] graph) {
        int[] indegree = new int[graph.length];
        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            int srcNode = i;
            for (int child : graph[srcNode]) {
                indegree[child]++;
            }
        }
        int[] ans = new int[indegree.length];
        int ansCounter = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                ans[ansCounter++] = i;
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int srcNode = q.poll();
            vis[srcNode] = true;
            for (int child : graph[srcNode]) {
                indegree[child]--;
                if (indegree[child] == 0) {
                    ans[ansCounter++] = child;
                    q.offer(child);
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            if (vis[i]) continue;
            System.out.println("Graph contains cycle.");
            return;
        }

        for (int i : ans) System.out.println(i + " ");
    }

    private static void findOrder(int numCourses, int[][] pre) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < pre.length; i++) {
            int src = pre[i][0];
            int dest = pre[i][1];
            graph[dest].add(src);
        }
        findOrder(graph);
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1}, {1, 0}};
        int numCourses = 2;
        findOrder(numCourses, arr);
    }

}
