package DynamicProgramming.MCM;

import java.util.HashMap;
import java.util.Map;

public class ScrambledString {
    private static Map<String, Boolean> dp = new HashMap<>();

    private static boolean isScrambledString(String s1, String s2) {
        String key = s1 + ":" + s2;
        if (s1.equals(s2)) return true;
        else if (s1.length() <= 1) return false;    // handles leaf and empty node conditions.
        else if (dp.containsKey(key)) return dp.get(key);
        /**
         *          5 - 2 = 3
         *          gr|eat
         *          eat|gr
         *
         * */
        int n = s1.length();
        for (int k = 1; k < s1.length(); k++) {
            if (isScrambledString(s1.substring(0, k), s2.substring(0, k)) &&
                    isScrambledString(s1.substring(k, n), s2.substring(k, n))) {
                dp.put(key, true);
                return true;
            }


            if (isScrambledString(s1.substring(0, n - k), s2.substring(k, n)) &&
                    isScrambledString(s1.substring(n - k, n), s2.substring(0, k))) {
                dp.put(key, true);
                return true;
            }

        }

        dp.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        String s = "great";
        String s1 = "rgeat";
        System.out.println(isScrambledString(s, s1));
    }
}
