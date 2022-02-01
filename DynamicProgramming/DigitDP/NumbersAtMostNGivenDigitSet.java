package DynamicProgramming.DigitDP;

import java.util.Arrays;

public class NumbersAtMostNGivenDigitSet {

    /**
     * permutation type recursion but fails to pass all the test cases give TLE.
     */
    private static int countNumberLessThanK(String[] digits, int K, String result) {
        Long currentNumber = Long.valueOf(result);
        if (currentNumber > K) {
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            Long genNumber = Long.valueOf(result + digits[i]);
            if (genNumber <= K) {
                System.out.print(genNumber + " ");
                sum += 1 + countNumberLessThanK(digits, K, result + digits[i]);
            } else {
                break;
            }
        }
        return sum;
    }

    /**
     * refer digit dp concept if don't understand.
     */
    private static int countNumbers(String[] digits, String a, int pos, boolean isRestricted, int z) {
        if (pos >= a.length()) return 1;

        int count = 0;
        int upperLim = isRestricted ? a.charAt(pos) - '0' : 9;
        for (int i = 0; i < digits.length; i++) {
            int currentDigit = (digits[i].charAt(0) - '0');
            if (currentDigit > upperLim) continue;

            count += countNumbers(digits, a, pos + 1, (isRestricted & upperLim == currentDigit), 1);
        }
        if (z == 0)     // to add 0 prefixes.
            count += countNumbers(digits, a, pos + 1, false, 0);

        return count;
    }

    private static int countNumbersDigitDp(String[] digits, String limit, int currPos, int isTight, int startZero) {
        if (currPos >= limit.length()) return 1;

        int count = 0;
        int upperLimit = isTight == 1 ? limit.charAt(currPos) - '0' : 9;
        for (int i = 0; i < digits.length; i++) {
            int currDigit = digits[i].charAt(0) - '0';
            if (currDigit > upperLimit) continue;

            int newTight = isTight == 1 && currDigit == upperLimit ? 1 : 0;
            count += countNumbersDigitDp(digits, limit, currPos + 1, newTight, 0);
        }

        if (startZero == 0) {
            //append only zero's at the beginning
            count += countNumbersDigitDp(digits, limit, currPos + 1, 0, 1);
        }

        return count;
    }


    public static void main(String[] args) {
        String[] digits = {"1", "3", "5", "7"};
        int K = 100;
        System.out.println("countNumberLessThanK(digits, 0, 100, \"0\") = " + countNumberLessThanK(digits, K, "0"));

        int ans = countNumbers(digits, String.valueOf(K), 0, true, 0);
        System.out.println(ans - 1);
    }
}
