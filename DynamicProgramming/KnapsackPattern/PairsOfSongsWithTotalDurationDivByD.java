package DynamicProgramming.KnapsackPattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsOfSongsWithTotalDurationDivByD {

    private static int numberOfSongs(int[] arr, int idx, int limit, int curr) {
        if (limit == 0 && curr % 60 == 0) return 1;
        else if (limit == 0 || idx >= arr.length) return 0;

        int pick = numberOfSongs(arr, idx + 1, limit - 1, curr + arr[idx]);
        int notPick = numberOfSongs(arr, idx + 1, limit, curr);

        return pick + notPick;
    }

    /**
     * 30 20 150 100 40
     * 30 20 30  40  40
     */
    // time complexity is O(n) considering map put and get takes avg O(1) time and space complexity is O(60) if all mod values are diff.
    private static int pairsOfSongs(int[] arr) {
        Map<Integer, Integer> dp = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int modVal = arr[i] % 60;
            int valNeeded = Math.abs(modVal - (modVal == 0 ? 0 : 60));
            if (dp.containsKey(valNeeded)) {
                count += dp.get(valNeeded);
            }
            dp.put(modVal, dp.getOrDefault(modVal, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {30, 20, 150, 100, 40};
        System.out.println(numberOfSongs(arr, 0, 2, 0));
        System.out.println(pairsOfSongs(arr));
    }
}
