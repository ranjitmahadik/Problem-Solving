package BinarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AggressiveCows {

    public static boolean isPossible(List<Integer> integerList, int noOfCows, int allowedDistance) {
        int possibleCows = 1, previouslyPlacedCow = integerList.get(0);

        for (int i = 1; i < integerList.size(); i++) {
            int distance = integerList.get(i) - previouslyPlacedCow;
            if (distance >= allowedDistance) {
                previouslyPlacedCow = integerList.get(i);
                possibleCows++;
            }
            if (possibleCows >= noOfCows) return true;
        }
        return false;
    }

    public static int findMinDistance(List<Integer> integerList, int noOfCows) {
        Collections.sort(integerList);
        int maxDistance = integerList.get(integerList.size() - 1) - integerList.get(0), ans = -1;
        for (int i = 1; i <= maxDistance; i++) {
            if (isPossible(integerList, noOfCows, i)) {
                ans = i;
            }
        }
        return ans;
    }

    /**
     * ANS
     * isPossible function search space -> T T T T T T T T T F F F F F F F
     */

    public static int findMinDistanceBinarySearch(List<Integer> integerList, int noOfCows) {
        Collections.sort(integerList);
        int maxDistance = integerList.get(integerList.size() - 1) - integerList.get(0);
        int lo = 1, hi = maxDistance, ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo >> 1);
            if (isPossible(integerList, noOfCows, mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    //  0   2   3
    //  1   4   8
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 4, 8, 9);
        int noOfCows = 3;
        int result = AggressiveCows.findMinDistanceBinarySearch(integerList, noOfCows);
        System.out.println("Cows min distance " + result);
    }
}
