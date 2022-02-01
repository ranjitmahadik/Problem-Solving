package Map;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarayWithEqualZeroOneTwos {
    private static int longestSubarrayWithEqualZeroOneTwos(int[] arr) {
        int oneCount = 0, twoCount = 0, zeroCount = 0, ans = 0;
        Map<String, Integer> lookup = new HashMap<>();
        String curr = (oneCount - zeroCount) + " " + (twoCount - oneCount);
        lookup.put(curr, -1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) zeroCount++;
            else if (arr[i] == 1) oneCount++;
            else if (arr[i] == 2) twoCount++;

            curr = (oneCount - zeroCount) + " " + (twoCount - oneCount);
            if (lookup.containsKey(curr)) {
                ans = Math.max(ans, i - lookup.get(curr));
            } else {
                lookup.put(curr, i);
            }
        }
        System.out.println(ans);
        return ans;
    }

    private static int countS(int[] arr) {
        int oneCount = 0, zeroCount = 0, ans = 0;
        Map<String, Integer> lookup = new HashMap<>();
        String curr = " " + (oneCount - zeroCount);
        lookup.put(curr, -1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) zeroCount++;
            else if (arr[i] == 1) oneCount++;
            curr = " " + (oneCount - zeroCount);
            if (lookup.containsKey(curr)) {
                ans = Math.max(ans, i - lookup.get(curr));
            } else {
                lookup.put(curr, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 0, 1, 0};
        longestSubarrayWithEqualZeroOneTwos(arr);
    }
}
