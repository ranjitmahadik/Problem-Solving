package util;

import java.util.Stack;

public class Solution {
    private static int[] powers = new int[20];

    private static void preComputePowers(int p, int k) {
        powers[0] = 1;
        powers[1] = p;
        for (int i = 2; i < k + 1; i++) {
            powers[i] = powers[i - 1] * p;
        }
    }

    private static String getAns(String s, int p, int k, int mod, int requiredHash) {
        preComputePowers(p % mod, k);
        int i = 0, j = 0, rollingHashSum = 0;
        while (j < s.length()) {
            int curr = s.charAt(j) - 'a' + 1;
            rollingHashSum = ((rollingHashSum % mod * p % mod) % mod + curr % mod) % mod;
            int currLen = j - i + 1;
            if (currLen == k) {
                if (rollingHashSum == requiredHash) return s.substring(i, j + 1);
                int firstChar = s.charAt(i) - 'a' + 1;
                rollingHashSum = (rollingHashSum % mod - (firstChar % mod * powers[k - 1] % mod) % mod) % mod;
                i++;
            }
            j++;
        }

        return "";
    }


    public static void main(String[] args) {
        System.out.println(getAns("fbxzaad", 31, 3, 100, 32));
    }
}
