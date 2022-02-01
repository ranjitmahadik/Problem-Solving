package Graph.DisjointSet;

import java.util.*;

public class EvaluateDivision {
    private String[] parent;
    private int[] ranks;

    private void init(int n) {
        char a = 'a';
        for (int i = 0; i < 26; i++) {
            parent[i] = String.valueOf(a);
            ranks[i] = 1;
            a++;
        }
    }

    private String find(char u) {
        String s = parent[u - 'a'];
        if (s.charAt(0) == u) return String.valueOf(u);
        return parent[u - 'a'] = find(parent[u - 'a'].charAt(0));
    }

    private void union(char u, char v) {
        String uParent = find(u);
        String vParent = find(v);

        if (!uParent.equals(vParent)) {
            if (ranks[uParent.charAt(0) - 'a'] > ranks[vParent.charAt(0) - 'a']) {
                parent[vParent.charAt(0) - '0'] = uParent;
            } else if (ranks[uParent.charAt(0) - 'a'] < ranks[vParent.charAt(0) - 'a']) {
                parent[uParent.charAt(0) - '0'] = vParent;
            } else {
                parent[vParent.charAt(0) - '0'] = uParent;
                ranks[uParent.charAt(0) - '0']++;
            }
        }
    }

    private boolean hasSameParent(String a, String b) {
        String aPar = find(a.charAt(0));
        String bPar = find(b.charAt(0));
        return aPar.equals(bPar);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Double> lookup = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            lookup.put(a, values[i]);
            lookup.put(b, values[i]);
            this.union(a.charAt(0), b.charAt(0));
        }
//        double[] ans = new double[queries.size()];
//        for (int i = 0; i < queries.size(); i++) {
//            String a = queries.get(i).get(0);
//            String b = queries.get(i).get(1);
//            if (!hasSameParent(a, b)) ans[i] = -1.0;
//            else {
//
//            }
//        }
        return new double[]{};
    }
}
