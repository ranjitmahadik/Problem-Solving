package DynamicProgramming.LIS;

import java.util.Arrays;
import java.util.Comparator;

// similar to Longest Increasing Subsequence with contraint.
public class MaximumLengthOfPairChain {

    private static int getMaxlength(int[][] pairs, int idx, int lastPickedIndex) {
        if (idx >= pairs.length) return 0;

        int pickItem = 0;
        if (lastPickedIndex == -1 || pairs[lastPickedIndex][1] < pairs[idx][0]) {
            pickItem = 1 + getMaxlength(pairs, idx + 1, idx);
        }
        int notPickItem = getMaxlength(pairs, idx + 1, lastPickedIndex);
        return Math.max(pickItem, notPickItem);
    }


    public static void main(String[] args) {
        int[][] pair = {{1, 2}, {7, 8}, {4, 5}};
        Arrays.sort(pair, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < pair.length; i++) {
            System.out.println(pair[i][0] + " : " + pair[i][1]);
        }
        System.out.println("pair = " + getMaxlength(pair, 0, -1));
    }
}
