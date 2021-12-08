package BinarySearch;

public class KthElementOfTwoSortedArrays {

    public static int getKthElement(int[] arr1, int[] arr2, int K) {
        int n = arr1.length, m = arr2.length;
        if (n > m) return getKthElement(arr2, arr1, K);

        int lo = 0, hi = Math.min(n,K);
        while (lo <= hi) {
            int mid1 = lo + (hi - lo) / 2;
            int mid2 = K - mid1;

            int left1 = mid1 <= 0 ? Integer.MIN_VALUE : arr1[mid1 - 1];
            int left2 = mid2 <= 0 ? Integer.MIN_VALUE : arr2[mid2 - 1];

            int right1 = mid1 >= n ? Integer.MAX_VALUE : arr1[mid1];
            int right2 = (mid2 >= m || mid2 < 0) ? Integer.MAX_VALUE : arr2[mid2];

            if (left1 <= right2 && left2 <= right1) {
                return Math.max(left1, left2);
            } else if (left1 > right2) {
                hi = mid1 - 1;
            } else {
                lo = mid1 + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // int[] arr1 = {1, 3, 4, 7, 10, 12};
        int[] arr1 = {1, 3, 4, 7, 10, 12,18,20,25,29,30,35};
        int[] arr2 = {2, 3, 6, 15,25,30,35,36,39,40};
        int ans = getKthElement(arr1, arr2, 2);
        System.out.println("Kth element is : " + ans);
    }
}
