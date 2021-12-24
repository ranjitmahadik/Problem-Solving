package DynamicProgramming.Misc;

public class JumpGameIII {
    private static boolean canReach(int[] arr, int idx) {
        if (idx >= arr.length || idx < 0 || arr[idx] < 0) return false;
        else if (arr[idx] == 0) return true;

        //1.make current item as visited;
        int element = arr[idx];

        arr[idx] = -1;

        int rightSideJump = idx + element;
        if (canReach(arr, rightSideJump)) return true;

        int leftSideJump = idx - element;
        if (canReach(arr, leftSideJump)) return true;

        return false;
    }


}
