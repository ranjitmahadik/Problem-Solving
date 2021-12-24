package DynamicProgramming.DigitDP;

public class BoringNumbers {
    private static String L, R;

    private static int countBoringNumbers(int pos, int lo, int hi, int firstNonZero) {
        if (pos >= R.length()) return 1;
        int ans = 0;
        int loLim = 0, hiLim = 9;
        if (lo == 1) {
            loLim = L.charAt(pos) - '0';
        }
        if (hi == 1) {
            hiLim = R.charAt(pos) - '0';
        }

        for (int i = loLim; i <= hiLim; i++) {
            int newLoLim = lo;
            int newHiLim = hiLim;
            
        }
        return ans;
    }
}
