package Trees;

import java.util.*;

/**
 * link : https://cses.fi/problemset/task/1674/
 */
public class Subordinates {


    static int[] ans = new int[200005];
//    public static int getSubordinates(Map<Integer, List<Integer>> graph, int src, int par) {
//        if (!graph.containsKey(src)) {
//            ans[src] = 0;
//            return 1;
//        }
//        int subs = 0;
//
//        for (int child : graph.get(src)) {
//            if (child != par) {
//                int childInfo = getSubordinates(graph, child, src);
//                subs += childInfo;
//            }
//        }
//
//        ans[src] = subs;
//        return subs + 1;
//    }

    public static void getSubordinates(Map<Integer, List<Integer>> graph, int src, int par){
        int subs = 0;
        if(graph.containsKey(src)){
            for(int child : graph.get(src)){
                if(child != par){
                    getSubordinates(graph,child,src);
                    subs += (1 + ans[child]);
                }
            }
        }
        ans[src] = subs;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 2; i <= n; i++) {
            int input = sc.nextInt();
            if (graph.containsKey(input)) {
                List<Integer> edges = graph.get(input);
                edges.add(i);
                graph.put(input, edges);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                graph.put(input, arr);
            }
        }
        getSubordinates(graph, 1, 0);
        for (int i = 1; i <=n; i++) {
            String postFix = i == n ? "" : " ";
            System.out.print(ans[i] + postFix);
        }
    }
}
