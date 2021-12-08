package BinarySearch;

public class SortedMatrixSearch {
    private static int[] search(int[][] arr, int target) {
        int rows = arr.length, cols = arr[0].length;

        int lo = 0, hi = (rows * cols) - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int row = mid / rows;
            int col = mid % cols;

            if (arr[row][col] == target) return new int[]{row, col};
            else if (arr[row][col] < target) lo = mid + 1;
            else hi = mid - 1;
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int target = 15;

        int[] res = SortedMatrixSearch.search(arr, target);
        if (res[0] != -1 && res[1] != -1) {
            System.out.println("Element Present at index : {" + res[0] + "," + res[1] + "}");
        }
    }
}
