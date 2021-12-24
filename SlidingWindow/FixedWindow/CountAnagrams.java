package SlidingWindow.FixedWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountAnagrams {

    private static void countAnagrams(String input, String pat) {
        int i = 0, j = 0, ans = 0;
        int k = pat.length();
        String s = "";
        while (j < input.length()) {
            s += input.charAt(j);
            int currentLen = j - i + 1;
            if (currentLen < k) j++;
            else if (currentLen == k) {
                char[] sarr = s.toCharArray();
                Arrays.sort(sarr);
                String sortedString = new String(sarr);
                if (sortedString.equals(pat)) {
                    ans++;
                }
                s = s.substring(1);
                i++;
                j++;
            }
        }
        System.out.println(ans);
    }

    private static void countAnagramsOptimal(String inp, String pat) {
        Map<Character, Integer> lookup = new HashMap<>();
        for (char c : pat.toCharArray()) {
            if (lookup.containsKey(c)) {
                int occ = lookup.get(c);
                occ++;
                lookup.put(c, occ);
            } else {
                lookup.put(c, 1);
            }
        }
        int i = 0, j = 0, count = lookup.size();
        while (j < inp.length()) {
            char currentChar = inp.charAt(j);
            int currLen = j - i + 1;
            if (lookup.containsKey(currentChar)) {
                int charOcc = lookup.get(currentChar);
                if (charOcc == 1) count--;
                lookup.put(currentChar, charOcc - 1);
            }
            if (currLen == pat.length()) {
                if (count == 0) System.out.println("S : " + inp.substring(i, i + pat.length()));
                char startChar = inp.charAt(i);
                if (lookup.containsKey(startChar)) {
                    int startCharCount = lookup.get(startChar);
                    if (startCharCount == 0) {
                        count++;
                    }
                    lookup.put(startChar, startCharCount + 1);
                }
                i++;
            }
            j++;
        }
    }


    private static int countAnagramsSpaceOptimal(String s, String p) {
        int[] charCount = new int[256];
        Arrays.fill(charCount, Integer.MIN_VALUE);
        int count = 0;
        for (char c : p.toCharArray()) {
            if (charCount[c] == Integer.MIN_VALUE) charCount[c] = 0;
            charCount[c]++;
            if (charCount[c] == 1) count++; // count unique elements;
        }

        int i = 0, j = 0, ans = 0;
        while (j < s.length()) {
            char currentChar = s.charAt(j);
            int currLen = j - i + 1;
            if (contains(charCount, currentChar)) {
                charCount[currentChar]--;
                if (charCount[currentChar] == 0) count--;
            }
            if (currLen == p.length()) {
                if (count == 0) ans++;
                char startChar = s.charAt(i);
                if (contains(charCount, startChar)) {
                    if (charCount[startChar] == 0) count++;
                    charCount[startChar]++;
                }
                i++;
            }
            j++;
        }
        System.out.println(ans);
        return ans;
    }

    private static boolean contains(int[] arr, int key) {
        return arr[key] != Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        countAnagrams("cbaebabacd", "abc");
        countAnagramsOptimal("cbaebabacd", "abc");
        countAnagramsSpaceOptimal("cbaebabacd", "abc");
    }
}
