package DynamicProgramming.DigitDP;


/**
 * find the count of numbers between L and R which have a sum of digits = x.
 * 1 <= L <= R <= 10^18
 * 1 <= X <= 180
 */

public class CountNumberWithSumX {

    private static int countNumbers(String R, int n, int x, boolean isStrict) {
        if (x < 0) return 0;
        if (n == 1) {
            if (x >= 0 && x <= 9) return 1;
            return 0;
        }

        int upperBound = isStrict ? R.charAt(R.length() - n) - '0' : 9;
        int ans = 0;
        for (int i = 0; i <= upperBound; i++) {
            ans += countNumbers(R, n - 1, x - i, isStrict & (i == upperBound));
        }
        return ans;
    }


    private static int countNumbersWithDigitSumK(String R, int pos, int x, boolean isStrict) {
        if (x < 0) return 0;
        else if (pos == (R.length() - 1)) {
            if (x >= 0 && x <= 9) return 1;
            return 0;
        }

        int ub = isStrict ? R.charAt(pos) - '0' : 9;
        int ans = 0;
        for (int i = 0; i < ub + 1; i++) {
            ans += countNumbersWithDigitSumK(R, pos + 1, x - i, isStrict & i == ub);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countNumbersWithDigitSumK("11235", 0, 5, true));
        System.out.println(countNumbers("11235", 5, 5, true));
    }
}
