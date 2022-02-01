package SlidingWindow.VariableWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueChars {
    private static void longestSubstringWithKUniqueChars(String s, int k) {
        int i = 0, j = 0, maxLen = Integer.MIN_VALUE;
        Map<Character, Integer> lookup = new HashMap<>();
        while (j < s.length()) {
            char currChar = s.charAt(j);
            lookup.put(currChar, lookup.getOrDefault(currChar, 0) + 1);
            int distinctSize = lookup.size();
            if (distinctSize == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
//            if (distinctSize > k) {
//                int startCharLen = lookup.get(s.charAt(i));
//                if (startCharLen == 1) lookup.remove(s.charAt(i));  // remove if it's the last instance.
//                else lookup.put(s.charAt(i), startCharLen - 1);
//                i++;
//            }

            while (distinctSize > k) {
                int startCharOcc = lookup.get(s.charAt(i));
                if (startCharOcc == 1) lookup.remove(s.charAt(i));
                else lookup.put(s.charAt(i), startCharOcc - 1);
                i++;
                distinctSize = lookup.size();
            }
            j++;
        }
        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        String s = "abc";   //ans = "cbebebe" = 7;
        int k = 2;
        longestSubstringWithKUniqueChars(s, k);
    }
}
