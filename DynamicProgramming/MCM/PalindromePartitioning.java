package DynamicProgramming.MCM;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    private static boolean isPalin(String s, int lo, int hi) {
        if (lo >= hi) return true;
        while (lo <= hi) {
            if (s.charAt(lo) != s.charAt(hi)) return false;
            lo++;
            hi--;
        }

        return true;
    }

    private static void dfs(int startIdx, List<String> palindromeList, String s) {
        if (startIdx >= s.length()) {
            System.out.println(palindromeList);
            return;
        }

        for (int i = startIdx; i < s.length(); i++) {
            if (isPalin(s, startIdx, i)) {
                palindromeList.add(s.substring(startIdx, i + 1));
                dfs(i + 1, palindromeList, s);
                palindromeList.remove(palindromeList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        dfs(0, new ArrayList<>(), "aab");
    }
}
