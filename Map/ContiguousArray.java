package Map;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/contiguous-array/
public class ContiguousArray {
    private static int maxContiguousSubarray(int[] arr) {
        int prefSum = 0, ans = 0;
        Map<Integer, Integer> look = new HashMap<>();
        look.put(prefSum, -1);
        for (int i = 0; i < arr.length; i++) {
            prefSum += arr[i] == 0 ? -1 : arr[i];

            if (look.containsKey(prefSum)) {
                int j = look.get(prefSum);
                ans = Math.max(ans, j - i);
            } else {
                look.put(prefSum, i);
            }
        }
        return ans;
    }
}
