package BinarySearch;

public class NumberOfTimesSortedArrayRotated {
    public static int RESULT_NOT_FOUND = -1;

    public static int findNumberOfTimesArrayRotated(int[] arr) {
        int lo = 0, hi = arr.length - 1, ans = RESULT_NOT_FOUND;

        while (lo <= hi) {
            int mid = lo + (hi - lo >> 1);
            int next = (mid + 1) % arr.length;
            int prev = (mid + arr.length - 1) % arr.length;

            if (arr[next] > arr[mid] && arr[mid] < arr[prev]) return ans = mid;
            else if (arr[mid] < arr[hi]) hi = mid - 1;
            else lo = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        //           0  1  2  3  4  5   6  7  8  9
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
        int result = NumberOfTimesSortedArrayRotated.findNumberOfTimesArrayRotated(arr);
        if (result != RESULT_NOT_FOUND) {
            System.out.println("Array Rotated : " + result + " times.");
        }
    }
}
