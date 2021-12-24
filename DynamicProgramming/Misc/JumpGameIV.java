package DynamicProgramming.Misc;

import java.util.*;

public class JumpGameIV {
    private static int minJumps(int[] arr, int idx) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, List<Integer>> lookup = new HashMap<>();
        boolean[] vis = new boolean[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            lookup.computeIfAbsent(arr[i], x -> new LinkedList<>()).add(i);
        }
        q.offer(idx);
        vis[idx] = true;


        while (!q.isEmpty()) {

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        System.out.println("minJumps(arr,0) = " + minJumps(arr, 0));
    }
}
