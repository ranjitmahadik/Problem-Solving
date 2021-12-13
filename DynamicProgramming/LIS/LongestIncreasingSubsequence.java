package DynamicProgramming.LIS;

public class LongestIncreasingSubsequence {
    private static int getLIS(int[] arr, int idx, int prevIdx) {
        if (idx >= arr.length) return 0;

        int select = 0;
        if (prevIdx == -1 || arr[prevIdx] < arr[idx]) {
            select = 1 + getLIS(arr, idx + 1, idx);
        }
        int notSelect = getLIS(arr, idx + 1, prevIdx);
        return Math.max(select, notSelect);
    }
}
