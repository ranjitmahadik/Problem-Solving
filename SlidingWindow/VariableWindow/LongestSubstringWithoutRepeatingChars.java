package SlidingWindow.VariableWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {

    private static void longestSubstrWithoutRepeatingChars(String s) {
        int i = 0, j = 0, maxLen = 0;
        Map<Character, Integer> lookup = new HashMap<>();
        while (j < s.length()) {
            char currChar = s.charAt(j);
            lookup.put(currChar, lookup.getOrDefault(currChar, 0) + 1);
            int lookUpLen = lookup.size();
            if (lookUpLen == (j - i + 1)) {
                // they are same when all chars between i to j are unique.
                maxLen = Math.max(maxLen, lookUpLen);
            }
            while (lookUpLen < (j - i + 1)) {
                int lastCharOcc = lookup.get(s.charAt(i));
                if (lastCharOcc == 1) lookup.remove(s.charAt(i));
                else lookup.put(s.charAt(i), lastCharOcc - 1);
                i++;
                lookUpLen = lookup.size();
            }
            j++;
        }
        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        longestSubstrWithoutRepeatingChars(s);
    }
}
