package DynamicProgramming.MCM;

public class GuessingGame {
    private static int getMinMoney(int lo, int hi) {
        if (lo >= hi) return 0;

        int ans = Integer.MAX_VALUE;
        for (int i = lo; i <= hi; i++) {
            int temp = i + Math.max(getMinMoney(lo, i - 1),
                    getMinMoney(i + 1, hi));
            ans = Math.min(ans, temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getMinMoney(1, 10));
    }
}
