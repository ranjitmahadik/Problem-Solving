package SlidingWindow.VariableWindow;

import java.util.HashMap;
import java.util.Map;

public class PickToys {
    private static final int NO_OF_TOYS_ALLOWED = 2;

    private static void maxToys(String s) {
        int i = 0, j = 0, maxLen = 0;
        Map<Character, Integer> look = new HashMap<>();
        while (j < s.length()) {
            char currChar = s.charAt(j);
            look.put(currChar, look.getOrDefault(currChar, 0) + 1);
            int pickedDistinctToys = look.size();
            if (pickedDistinctToys == NO_OF_TOYS_ALLOWED) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
            while (pickedDistinctToys > NO_OF_TOYS_ALLOWED) {
                int firstPickedToyOcc = look.get(s.charAt(i));
                if (firstPickedToyOcc == 1) look.remove(s.charAt(i));
                else look.put(s.charAt(i), firstPickedToyOcc - 1);
                i++;
                pickedDistinctToys = look.size();
            }
            j++;
        }
        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        String s = "abaccab";
        maxToys(s);
    }
}
