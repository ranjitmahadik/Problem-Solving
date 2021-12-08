package DynamicProgramming.Misc;

import java.util.Arrays;

public class HouseRobber {

    private static int houseRobber(int[] arr, int idx) {
        if (idx <= 0) return 0;
        else if (idx == 1) return arr[idx - 1];

        int robbHouse = arr[idx - 1] + houseRobber(arr, idx - 2);
        int notRobbHouse = houseRobber(arr, idx - 1);

        return Math.max(robbHouse, notRobbHouse);
    }

    private static int[] dp;

    private static int houseRobberMemo(int[] arr, int idx) {
        if (idx <= 0) return 0;
        else if (dp[idx] != -1) return dp[idx];
        int robbHouse = arr[idx - 1] + houseRobberMemo(arr, idx - 2);
        int notRobbHouse = houseRobberMemo(arr, idx - 1);

        return dp[idx] = Math.max(robbHouse, notRobbHouse);
    }

    private static int houseRobberTopDown(int[] arr) {
        int[] dp = new int[arr.length + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            if (i == 0) dp[i] = 0;
            else {
                int robHouse = arr[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 0);
                int notRobHouse = dp[i - 1];

                dp[i] = Math.max(robHouse, notRobHouse);
            }
        }
        return dp[arr.length];
    }

    /**
     * rob = arr[idx] + robNext(idx+2)
     * notRob = robNext(idx+1);
     */
    private static int houseRobberSpaceOptimized(int[] arr) {
        int prevPrevStep = 0, prevStep = 0;
        for (int i = 0; i < arr.length + 1; i++) {
            if (i == 0) prevPrevStep = 0;
            else if (i == 1) prevStep = arr[i - 1];
            else {
                int robb = arr[i - 1] + prevPrevStep;
                int notRobb = prevStep;

                prevPrevStep = prevStep;
                prevStep = Math.max(robb, notRobb);
            }
        }
        return prevStep;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 3, 1};

        int ans1 = houseRobber(arr, arr.length);

        dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        int ans2 = houseRobberMemo(arr, arr.length);

        int ans3 = houseRobberSpaceOptimized(arr);

        System.out.println(ans1 + " : " + ans2 + " : " + houseRobberTopDown(arr) + " : " + ans3);
    }
}
