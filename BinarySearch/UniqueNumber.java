package BinarySearch;

public class UniqueNumber {
    private static int getUniqueByXor(int[] arr) {
        int n = arr.length;
        if (n <= 0) return -1;

        int xorArray = arr[0];
        for (int i = 1; i < n; i++) {
            xorArray ^= arr[i];
        }
        return xorArray;
    }

    private static int getUniqueByBinarySearch(int[] arr) {
        int lo = 0, hi = arr.length - 2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == arr[mid ^ 1]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return arr[lo];
    }

    public static void main(String[] args) {
        System.out.println(getUniqueByBinarySearch(new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5, 6, 6}));
    }
}
