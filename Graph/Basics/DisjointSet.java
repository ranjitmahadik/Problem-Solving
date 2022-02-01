package Graph.Basics;

import java.util.Arrays;

public class DisjointSet {
    private static int[] parent;

    private static int find(int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent[i]);
    }

    private static void union(int i, int j) {
        int iPar = find(i);
        int jPar = find(j);
        if (iPar != jPar) {
            parent[jPar] = iPar;
        }
    }


    private static void showParent() {
        for (int i : parent) System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        parent = new int[5];
        Arrays.fill(parent, -1);
        union(1, 2);
        union(3, 4);
        showParent();
        union(2, 4);
        showParent();
    }
}
