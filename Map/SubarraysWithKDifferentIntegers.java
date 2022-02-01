package Map;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {

    private static int largestSubarrayWithKDistinctIntegers(int[] arr, int K) {
        Map<Integer, Integer> lookup = new HashMap<>();
        int bestI = 0, bestJ = 0;
        int j = 0, i = 0, ans = 0;
        while (j < arr.length) {
            int currNumber = arr[j];
            lookup.put(currNumber, lookup.getOrDefault(currNumber, 0) + 1);
            int currSize = lookup.size();
            if (currSize == K) {
//                ans = Math.max(ans, j - i + 1);
                if (ans < j - i + 1) {
                    ans = j - i + 1;
                    bestI = i;
                    bestJ = j;
                }
            }
            if (currSize > K) {
                while (currSize > K) {
                    int firstNumber = arr[i];
                    lookup.put(firstNumber, lookup.getOrDefault(firstNumber, 0) - 1);
                    if (lookup.get(firstNumber) <= 0) lookup.remove(firstNumber);
                    i++;
                    currSize = lookup.size();
                }
            }
            j++;
        }
        for (int p = bestI; p <= bestJ; p++) System.out.print(arr[p] + " ");
        System.out.println();
        return ans;
    }

    private static int subarraysWithKDiffIntegers(int[] arr, int K) {
        Map<Integer, Integer> lookup = new HashMap<>();
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 1, 2, 3, 2, 1, 4, 5};
        int K = 3;
        System.out.println(largestSubarrayWithKDistinctIntegers(arr, K));
    }
}
