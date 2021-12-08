package BinarySearch;

public class BinarySearch {
    public static int RESULT_NOT_FOUND = -1;

    public static int search(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1, ans = RESULT_NOT_FOUND;

        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (arr[mid] == target){
                ans = mid;
                break;
            }
            else if (arr[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }

        System.out.println("lo points to : " + lo + "\nhi point to " + hi);

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 2;
        int result = BinarySearch.search(arr, target);
        if (result != RESULT_NOT_FOUND) {
            System.out.println("Element " + target + " Found at Position " + result);
        } else {
            System.out.println("Searched Element Not Found.");
        }
    }
}
