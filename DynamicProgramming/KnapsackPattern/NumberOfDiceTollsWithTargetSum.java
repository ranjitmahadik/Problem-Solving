package DynamicProgramming.KnapsackPattern;

public class NumberOfDiceTollsWithTargetSum {
    private static final int mod = (int)1e9 + 7;
    private static int possibleWays(int d, int f, int target) {
        if (target == 0 && d == 0) return 1;
        else if (target < 0 || d < 0) return 0;

        int count = 0;

        for (int i = 1; i < f + 1; i++) {
            if (target - i >= 0) {
                int temp = possibleWays(d - 1, f, target - i);
                count = (count % mod + temp % mod) % mod;
                //(a+b)%mod => (a%mod + b%mod) % mod;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("possibleWays(2, 5, 10) = " + possibleWays(2, 5, 10));
    }
}
