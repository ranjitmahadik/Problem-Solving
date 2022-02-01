package Map;

import java.util.HashMap;
import java.util.Map;

public class countKdistinctSubstrings {
    private static int countSubstrings(String s, final int K) {
        int i = 0, j = 0, count = 0;
        Map<Character, Integer> look = new HashMap<>();
        while (j < s.length()) {
            char currChar = s.charAt(j);
            look.put(currChar, look.getOrDefault(currChar, 0) + 1);
            int currLen = look.size();

            if (currLen > K) {
                while (i <= j && currLen > K) {
                    char startChar = s.charAt(i);
                    int occurrence = look.get(startChar);
                    if (occurrence == 1) look.remove(startChar);
                    else look.put(startChar, occurrence - 1);

                    currLen = look.size();
                    i++;
                }
            }

            if (currLen == K) {
                count++;
            }

            j++;
        }
        System.out.println(count);
        return count;
    }


    /**
     * aba
     * ***
     * 12
     */
    private static long numberOfSubStrings(String s, final int K) {
        int i = 0, j = 0;
        long ans = 0;
        Map<Character, Integer> look = new HashMap<>();
        while (j < s.length()) {
            char currChar = s.charAt(j);
            look.put(currChar, look.getOrDefault(currChar, 0) + 1);
            int distinctChars = look.size();

            if (distinctChars > K) {
                while (distinctChars > K) {
                    char firstChar = s.charAt(i);
                    int occ = look.get(firstChar);
                    if (occ == 1) look.remove(firstChar);
                    else look.put(firstChar, occ - 1);
                    i++;
                    distinctChars = look.size();
                }
            }
            ans += j - i + 1;
            j++;
        }
        return ans;
    }

    private static long countNumberOfSubstrings(String s, final int K) {
        int[] dp = new int[27];
        int i = 0, j = 0, distinctChars = 0;
        long ans = 0;
        while (j < s.length()) {
            char currChar = s.charAt(j);
            dp[currChar - 'a']++;
            if (dp[currChar - 'a'] == 1) distinctChars++;

            while (distinctChars > K) {
                char firstChar = s.charAt(i);
                dp[firstChar - 'a']--;
                if (dp[firstChar-'a'] == 0) distinctChars--;
                i++;
            }

            ans += j - i + 1;
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
//        String a = "abcc";
//        final int K = 2;
//        System.out.println(countSubstrings(a, K));
        System.out.println(numberOfSubStrings("aba", 2) - numberOfSubStrings("aba", 1));
        System.out.println(countNumberOfSubstrings("aba",2) - countNumberOfSubstrings("aba",1));
    }
}
