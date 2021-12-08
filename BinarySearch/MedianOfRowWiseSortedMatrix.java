package BinarySearch;

public class MedianOfRowWiseSortedMatrix {
    /**
     * search an integer which satifies following condition
     *  n/2 <= x <= n/2
     *  search x from lo = 1, hi = 2^32 which satisfies above criteria.
     * */
    public static int getMedian(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int totalNumbers = n * m;

        int desired = (totalNumbers + 1) / 2;           // handles both even and odd conditions very well.

        int lo = 0, hi = Integer.MAX_VALUE;
        int ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int count = 0;

            // count all numbers in given array which arr[i] <= mid;
            for (int i = 0; i < n; i++) {
                count += upper_bound(arr[i], mid);
            }

            if (count >= desired) {
                ans = mid;
                hi = mid - 1;
            } else lo = mid + 1;
        }
        return ans;
    }

    private static int upper_bound(int[] arr, int currentVal) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > currentVal) {
                hi = mid - 1;
            } else lo = mid + 1;
        }
        return hi + 1;
    }

    public static int upper_bound2(int[] arr, int currentVal) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= currentVal) {
                lo = mid + 1;
            } else hi = mid - 1;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 6}, {2, 6, 9}, {3, 6, 9}};
        int res = getMedian(arr);
        System.out.println("Median is : " + res);


//        int[] arr = {5, 6, 6, 6, 8};
//        int target = 6;
//        int ans = upper_bound(arr, target);
//        int ans2 = upper_bound2(arr, target);
//        System.out.println(ans + " : " + ans2);
    }
}
