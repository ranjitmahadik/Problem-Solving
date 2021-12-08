package DynamicProgramming.Misc;

public class MaxCostClimbingStairs {

    private static int getMaxCost(int[] cost, int idx) {
        if (idx <= 0) return 0;
        else if (idx == 1) return cost[idx - 1];

        int currentStepCost = cost[idx - 1];

        int oneStep = getMaxCost(cost, idx - 1);
        int twoStep = getMaxCost(cost, idx - 2);

        return Math.max(oneStep, twoStep) + currentStepCost;
    }

    private static int getMaxCostTopDown(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 0; i < cost.length + 1; i++) {
            if (i == 0) dp[i] = 0;
            else if (i == 1) dp[i] = cost[i - 1];
            else {
                int oneStep = dp[i - 1];
                int twoStep = dp[i - 2];

                dp[i] = Math.max(oneStep, twoStep) + cost[i - 1];
            }
        }
        return Math.max(dp[cost.length], dp[cost.length - 1]);
    }

    private static int getMaxCostSpaceOptimized(int[] cost) {
        int prevStep = 0, prevPrevStep = 0;
        for (int i = 0; i < cost.length + 1; i++) {
            if (i == 0) prevPrevStep = 0;
            else if (i == 1) prevStep = cost[i - 1];
            else {
                int oneStep = prevStep;
                int twoStep = prevPrevStep;

                prevPrevStep = prevStep;
                prevStep = Math.max(oneStep, twoStep) + cost[i - 1];
            }
        }
        return Math.max(prevPrevStep, prevStep);
    }

    private static void getMaxCost(int[] cost) {
        int ans1 = Math.max(getMaxCost(cost, cost.length), getMaxCost(cost, cost.length - 1));
        int ans2 = getMaxCostTopDown(cost);
        int ans3 = getMaxCostSpaceOptimized(cost);
        System.out.println("ans1 = " + ans1 + " |  ans2 : " + ans2 + " | ans3 = " + ans3);
    }

    public static void main(String[] args) {
        getMaxCost(new int[]{10, 15, 20});
    }
}
