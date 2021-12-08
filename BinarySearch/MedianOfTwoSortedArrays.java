package BinarySearch;

public class MedianOfTwoSortedArrays {
    /**
     *  watch this video if you don't understand;
     *  https://www.youtube.com/watch?v=LPFhl65R7ww
     * */
    private static double getMedian(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        if (n > m) return getMedian(arr2, arr1);

        int totalNumbers = (n + m + 1) / 2;
        int lo = 0, hi = n;

        while (lo <= hi) {
            int mid1 = lo + (hi - lo) / 2;
            int mid2 = totalNumbers - mid1;

            int left1 = mid1 == 0 ? Integer.MIN_VALUE : arr1[mid1 - 1];
            int left2 = mid2 == 0 ? Integer.MIN_VALUE : arr2[mid2 - 1];

            int right1 = mid1 == n ? Integer.MAX_VALUE : arr1[mid1];
            int right2 = mid2 == m ? Integer.MAX_VALUE : arr2[mid2];

            if (left1 <= right2 && left2 <= right1) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                hi = mid1 - 1;
            } else {
                lo = mid1 + 1;
            }
        }

        return -1.0;
    }

    /**
     * 1 2 3 4   5 6   7  8  9  10
     * 1 2 3 3 | 4 6 | 7 10 12 15
     * <p>
     * 10/2 = 5 => {4 ,6} is median
     */

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 7, 10, 12};
        int[] arr2 = {2, 3, 6, 15};

        double res = getMedian(arr1, arr2);
        System.out.println("Median is : " + res);
    }
}

