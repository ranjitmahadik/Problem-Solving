package DynamicProgramming.DigitDP;

public class SumDigitsBetweenLR {
    /**
     * find the sum of all digits between 0 and 25;
     */
    private static int findSumOfDigits(int pos, int sum, boolean isStrict, String a) {
        if (pos == a.length()) return sum;

        int ans = 0;
        int hiLim = 9;
        int loLim = 0;
        if (isStrict) {
            hiLim = a.charAt(pos) - '0';
        }

        for (int i = loLim; i <= hiLim; i++) {
            boolean newStrict = isStrict;
            if (i != hiLim) {
                newStrict = false;
            }
            ans += findSumOfDigits(pos + 1, sum + i, newStrict, a);
        }

        return ans;
    }

    public static void main(String[] args) {
        int ans = findSumOfDigits(0, 0, true, "9");
        System.out.println(ans);
    }
}
