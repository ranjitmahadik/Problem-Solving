package DynamicProgramming.Misc;

public class FrogJump {
    private static int minEnergy(int[] arr, int idx) {
        if (idx <= 0) return 0;

        int jumpOne = Math.abs(arr[idx] - arr[idx - 1]) + minEnergy(arr, idx - 1);
        int jumpTwo = Integer.MAX_VALUE;
        if (idx >= 2) {
            jumpTwo = Math.abs(arr[idx] - arr[idx - 2]) + minEnergy(arr, idx - 2);
        }
        return Math.min(jumpOne, jumpTwo);
    }

    private static int minEnergyWithKJumps(int[] arr, int idx, final int K) {
        if (idx <= 0) return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= K; i++) {
            if (idx - i >= 0) {
                int temp = Math.abs(arr[idx] - arr[idx - i]) + minEnergyWithKJumps(arr, idx - i, K);
                ans = Math.min(ans, temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {30, 10, 60, 10, 60, 50};
        System.out.println(minEnergy(arr, arr.length - 1));
        System.out.println(minEnergyWithKJumps(arr, arr.length - 1, 2));
    }
}
