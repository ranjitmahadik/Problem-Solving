package BinarySearch;

public class FindFirstAndLastOccurrence {
    public static int RESULT_NOT_FOUND = -1;

    // T,T,T,T,T,T,F,F,F,F,F

    public static int searchLastOccurrence(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1, ans = RESULT_NOT_FOUND;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (arr[mid] == target) {
                ans = mid;
                lo = mid + 1;
            } else if (arr[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }

        return ans;
    }

    public static int searchFirstOccurrence(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1, ans = RESULT_NOT_FOUND;

        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);

            if (arr[mid] == target) {
                ans = mid;
                hi = mid - 1;
            } else if (arr[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        //           0, 1, 2  3  4  5  6  7  8  9 10  11
        int[] arr = {1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 9, 10};
        int target = 5;
        int firstOccurrence = FindFirstAndLastOccurrence.searchFirstOccurrence(arr, target);
        int lastOccurrence = FindFirstAndLastOccurrence.searchLastOccurrence(arr, target);
        if (firstOccurrence != RESULT_NOT_FOUND && lastOccurrence != RESULT_NOT_FOUND) {
            System.out.println("Element " + target + " Found at Position " + firstOccurrence + " and " + lastOccurrence);
        } else {
            System.out.println("Searched Element Not Found.");
        }
    }
}
