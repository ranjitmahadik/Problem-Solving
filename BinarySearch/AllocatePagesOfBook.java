package BinarySearch;

import java.util.Arrays;
import java.util.List;

public class AllocatePagesOfBook {

    public static boolean isValid(List<Integer> arr, int minAllowedPages, int students) {
        int possibleStudents = 1, currentPageSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            currentPageSum += arr.get(i);
            if (currentPageSum > minAllowedPages) {
                currentPageSum = arr.get(i);
                possibleStudents++;
            }
            if(possibleStudents > students) return false;
        }
        return possibleStudents == students;
    }

    //Bruteforce approach
    public static int allocatePagesOfBook(List<Integer> arr, int students) {
        int bookSum = 0, minPages = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;
        for (int i : arr) {
            minPages = Math.min(minPages, i);
            bookSum += i;
        }
        for (int i = minPages; i <= bookSum; i++) {
            if (isValid(arr, i, students)) {
                return ans = i;
            }
        }
        return ans;
    }

    /**
     * search space of isValid Function is monotonic -> F F F F F F F F F F F F F F F F T T T T T T T T T T T
     * hence it is possible to use binary search
     */
    public static int allocatePagesOfBookBinarySearch(List<Integer> arr, int students) {
        int bookSum = 0, minPages = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;
        bookSum = arr.stream().reduce(0, (a, b) -> a + b);
        minPages = arr.stream().min(Integer::compare).get();

        int lo = minPages, hi = bookSum;
        while (lo <= hi) {
            int mid = lo + (hi - lo >> 1);

            if (isValid(arr, mid, students)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(10, 20, 30, 40);

        int students = 2;
        int result = AllocatePagesOfBook.allocatePagesOfBookBinarySearch(arr, students);
        System.out.println("Min Pages each student must read is : " + result);
    }
}
