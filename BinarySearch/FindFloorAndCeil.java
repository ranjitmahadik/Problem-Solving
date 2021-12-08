package BinarySearch;

public class FindFloorAndCeil {
    public static int RESULT_NOT_FOUND = -1;

    public static int findFloorAndCeil(int[] arr, int target, boolean isFloorFunction) {
        int lo = 0, hi = arr.length - 1, ans = RESULT_NOT_FOUND;

        while (lo <= hi) {
            int mid = lo + (hi - lo >> 1);
            if (arr[mid] == target) return ans = target;
            else if (arr[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }

        System.out.println("lo : " + lo + "\nhi : " + hi);

        return isFloorFunction ? (hi >= 0 ? hi : ans) : (lo < arr.length ? lo : ans);
    }

    public static void main(String[] args) {
        //           0  1  2  3  4  5   6  7  8  9
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 10, 11};
        int target = 9;
        boolean isFloorFunction = false;
        int result = FindFloorAndCeil.findFloorAndCeil(arr, target, isFloorFunction);
        if (result != RESULT_NOT_FOUND) {
            System.out.println((isFloorFunction ? "Floor" : "Ceil") + " of " + target + " is " + arr[result]);
        }
    }
}
