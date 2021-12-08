package DynamicProgramming.Misc;

public class JumpGameI {
    /**
     * [2,3,1,1,4]
     * <p>
     * 3+1 = 4
     */
    private static boolean canJump(int[] arr, int idx) {
        if (idx >= arr.length - 1) return true;

        for (int i = 1; i <= arr[idx]; i++) {
            int nextJump = i + idx;
            if (canJump(arr, nextJump)) return true;
        }

        return false;
    }
}
