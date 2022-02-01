package DynamicProgramming.MCM;

public class EggDropping {
    private static int eggDrop(int eggs, int floors) {
        if (eggs <= 0 || floors <= 0) return floors;

        int ans = Integer.MAX_VALUE - 1;
        for (int k = 1; k <= floors; k++) {
            int temp = Math.max(eggDrop(eggs - 1, k - 1),
                    eggDrop(eggs, floors - k));
            ans = Math.min(ans, 1 + temp);
        }
        return ans;
    }

    // e.f*log(f)
    private static int eggDropProblem(int e, int f) {
        if (e <= 0 || f <= 0) return f;
        int ans = Integer.MIN_VALUE - 1;

        int lo = 1, hi = f;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int eggBreak = eggDropProblem(e - 1, mid - 1);
            int eggNotBreak = eggDropProblem(e, f - mid);
            int inWorstCase = 1 + Math.max(eggBreak, eggNotBreak);
            if (eggBreak < eggNotBreak) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
            ans = Math.min(ans, inWorstCase);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(eggDrop(2, 4));
        System.out.println(eggDropProblem(2, 4));
    }
}
