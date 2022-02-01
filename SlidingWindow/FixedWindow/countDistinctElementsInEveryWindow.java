package SlidingWindow.FixedWindow;

import java.util.HashMap;
import java.util.Map;

public class countDistinctElementsInEveryWindow {
//    private static void countDistinctElements(int[] arr, final int K) {
//        Map<Integer, Integer> lookup = new HashMap<>();
//        int i = 0, j = 0;
//        while (j < arr.length) {
//            int currLen = j - i + 1;
//            if (currLen <= K) {
//                lookup.put(arr[j], lookup.getOrDefault(arr[j], 0) + 1);
//            }
//            if (currLen == K) {
//                System.out.print(lookup.size() + " ");
//                lookup.put(arr[i], lookup.getOrDefault(arr[i], 0) - 1);
//                if (lookup.get(arr[i]) <= 0) lookup.remove(arr[i]);
//                i++;
//            }
//            j++;
//        }
//    }

    private static void countDistinctElements(int[] arr, int K) {
        int i = 0, j = 0;
        int[] ans = new int[K];
        int kCounter = 0;
        Map<Integer, Integer> lookup = new HashMap<>();
        while (j < arr.length) {
            int currNumber = arr[j];
            lookup.put(currNumber, j);
            int currWindowLen = j - i + 1;
            if (currWindowLen == K) {
                ans[kCounter++] = lookup.size();
                int startNumber = arr[i];
                lookup.put(startNumber, lookup.getOrDefault(startNumber, 0) - 1);
                if (lookup.get(startNumber) <= 0) lookup.remove(startNumber);
                i++;
            }
            j++;
        }
        for (int p : ans) System.out.println(p + " ");
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int K = 4;
        countDistinctElements(arr, K);
    }
}
