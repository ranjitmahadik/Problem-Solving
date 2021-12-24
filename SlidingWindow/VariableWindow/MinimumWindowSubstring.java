package SlidingWindow.VariableWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    private static void minWindow(String s, String pat) {
        int i = 0, j = 0, maxLen = Integer.MAX_VALUE;
        String ans = "";
        Map<Character, Integer> look = new HashMap<>();
        for (char c : pat.toCharArray()) look.put(c, look.getOrDefault(c, 0) + 1);
        int uChars = look.size();
        while (j < s.length()) {
            char currChar = s.charAt(j);
            if (look.containsKey(currChar)) {
                int currCharOcc = look.get(currChar);
                if (currCharOcc == 1) uChars--;
                look.put(currChar, currCharOcc - 1);
            }
            while (uChars == 0) {
                if (maxLen > (j - i + 1)) {
                    maxLen = (j - i + 1);
                    ans = s.substring(i, j + 1);
                }
                char firstChar = s.charAt(i);
                if (look.containsKey(firstChar)) {
                    int firstCharCount = look.get(firstChar);
                    if (firstCharCount == 0) {
                        uChars++;
                    }
                    look.put(firstChar, firstCharCount + 1);
                }
                i++;
            }
            j++;
        }

        System.out.println(maxLen + " " + ans);
    }

    public static void main(String[] args) {
        String s = "a";
        String p = "a";
        minWindow(s, p);
    }
}
