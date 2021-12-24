package DynamicProgramming.DigitDP;

public class DigitSumDivByK {
    private static String a;
    private static int d;
    private static int len;

    private static int countNumbers(int idx, int tight, int rem) {
        if (idx == len) return rem == 0 ? 1 : 0;

        int sum = 0;
        int loLim = 0;
        int hiLim = 9;
        if (tight == 1) {
            hiLim = a.charAt(idx) - '0';
        }
        for (int i = loLim; i <= hiLim; i++) {
            int newTight = tight;
            if (i != (a.charAt(idx) - '0')) {
                newTight = 0;
            }
            sum += countNumbers(idx + 1, newTight, (rem + i) % d);
        }

        return sum;
    }

    public static void main(String[] args) {
        a = "98765432109876543210";
        d = 58;
        len = a.length();
        System.out.println("countNumbers(0,1,0) = " + (countNumbers(0, 1, 0) - 1));
    }
}
