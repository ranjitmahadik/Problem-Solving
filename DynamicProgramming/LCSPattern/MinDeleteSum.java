package DynamicProgramming.LCSPattern;

//https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
public class MinDeleteSum {
    private static int minSum(String s1, int i, String s2, int j) {
        if (i == 0 && j == 0) return 0;
        else if (i == 0) {
            int sum = 0;
            for (int k = (j - 1); k >= 0; k--) {
                sum += s2.charAt(k);
            }
            return sum;
        } else if (j == 0) {
            int sum = 0;
            for (int k = (i - 1); k >= 0; k--) {
                sum += s1.charAt(k);
            }
            return sum;
        } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            // if both equal no need to delete anything.
            return minSum(s1, i - 1, s2, j - 1);
        }

        int opt1 = ((int) s1.charAt(i - 1)) + minSum(s1, i - 1, s2, j);
        int opt2 = ((int) s2.charAt(j - 1)) + minSum(s1, i, s2, j - 1);
        return Math.min(opt1, opt2);
    }


    private static int minSumOptimized(String s1, int i, int sum1, String s2, int j, int sum2) {
        if (i == 0 && j == 0) return 0;
        else if (i == 0) {
            return sum2;
        } else if (j == 0) {
            return sum1;
        } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            // if both equal no need to delete anything.
            int modifiedSum1 = sum1 - s1.charAt(i - 1);
            int modifiedSum2 = sum2 - s2.charAt(j - 1);
            return minSumOptimized(s1, i - 1, modifiedSum1, s2, j - 1, modifiedSum2);
        }
        // if both equal no need to delete anything.
        int modifiedSum1 = sum1 - s1.charAt(i - 1);
        int modifiedSum2 = sum2 - s2.charAt(j - 1);

        int opt1 = ((int) s1.charAt(i - 1)) + minSumOptimized(s1, i - 1, modifiedSum1, s2, j, sum2);
        int opt2 = ((int) s2.charAt(j - 1)) + minSumOptimized(s1, i, sum1, s2, j - 1, modifiedSum2);
        return Math.min(opt1, opt2);
    }

    public static void main(String[] args) {
        String a = "sea", b = "eat";
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < a.length(); i++) {
            sum1 += a.charAt(i);
        }
        for (int i = 0; i < b.length(); i++) {
            sum2 += b.charAt(i);
        }
        System.out.println("minSum(a, a.length(), b, b.length()) = " + minSum(a, a.length(), b, b.length()));
        System.out.println("minSumOptimized(a, a.length(), sum1, b, b.length(), sum2) = " + minSumOptimized(a, a.length(), sum1, b, b.length(), sum2));
    }
}
