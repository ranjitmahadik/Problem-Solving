package Graph;

import util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class MinStepsToTarget {
    private static final int RESULT_NOT_FOUND = -1;

    private static int getMinSteps(int[] arr, int start, int end) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        boolean[] vis = new boolean[end + 1];
        q.add(new Pair(start, 0));
        vis[start] = true;

        while (!q.isEmpty()) {
            Pair currentPair = q.poll();
            int currentSum = (int) currentPair.getFirst();
            int currentSteps = (int) currentPair.getSecond();

            if (currentSum == end) return currentSteps;

            for (int i = 0; i < arr.length; i++) {
                int tempSum = arr[i] * currentSum;
                if (tempSum <= end && !vis[tempSum]) {
                    q.add(new Pair(tempSum, currentSteps + 1));
                    vis[tempSum] = true;
                }
            }
        }
        return RESULT_NOT_FOUND;
    }


    public static void main(String[] args) {
        int[] arr = {2, 5, 10};
        int start = 3, end = 12;
        System.out.println("getMinSteps(arr, start, end) = " + getMinSteps(arr, start, end));

    }
}
