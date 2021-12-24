package SlidingWindow.VariableWindow;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithSumZero {

    private static void largestSubarrayWithSumZero(int[] arr) {
        Map<Integer, Integer> lookup = new HashMap<>();
        int i = 0, runningSum = 0, ans = 0;
        while (i < arr.length) {
            runningSum += arr[i];
            if (runningSum == 0) {
                ans = Math.max(ans, i + 1);
            } else if (lookup.containsKey(runningSum)) {
                int len = i - lookup.get(runningSum);
                ans = Math.max(ans, len);
            } else {
                lookup.put(runningSum, i);
            }
            i++;
        }
        System.out.println("ans = " + ans);
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 3};
        largestSubarrayWithSumZero(arr);
    }
}
