package Graph.DisjointSet;

import java.util.*;

public class SmallestStringWithSwaps {
    private int[] parent;
    private int[] rank;

    private void init(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int v) {
        if (v == parent[v]) return v;
        return parent[v] = find(parent[v]);
    }

    private void union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u != v) {
            if (rank[u] > rank[v]) {
                parent[v] = u;
            } else if (rank[u] < rank[v]) {
                parent[u] = v;
            } else {
                parent[v] = u;
                rank[u]++;
            }
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        this.init(n);
        for (int i = 0; i < pairs.size(); i++) {
            int first = pairs.get(i).get(0);
            int second = pairs.get(i).get(1);
            this.union(first, second);
        }
        Map<Integer, Queue<Character>> queueMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int par = this.find(i);
            queueMap.computeIfAbsent(par, x -> new PriorityQueue<>()).add(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(queueMap.get(this.find(i)).poll());
        }

        return sb.toString();
    }
}
