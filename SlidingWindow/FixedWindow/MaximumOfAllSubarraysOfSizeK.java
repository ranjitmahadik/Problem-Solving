package SlidingWindow.FixedWindow;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubarraysOfSizeK {

    /**
     * 1   3   -1  -3  5   3
     */
    private static void maxOfAllSubArraysOfSizeK(int[] arr, int K) {
        int i = 0, j = 0, runningMax = 0;
        Deque<Integer> deque = new LinkedList<>();
        while (j < arr.length) {
            runningMax = arr[j];
            int currLen = j - i + 1;
            if (deque.isEmpty()) deque.add(runningMax);
            else {
                while (!deque.isEmpty() && deque.getLast() < runningMax) deque.pollLast();
                deque.add(runningMax);
            }
            if (currLen == K) {
                System.out.println(deque.isEmpty() ? "-1" : deque.getFirst());
                if (!deque.isEmpty() && arr[i] == deque.getFirst()) {
                    deque.pollFirst();
                }
                i++;
            }
            j++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        maxOfAllSubArraysOfSizeK(arr,3);



    }
}
