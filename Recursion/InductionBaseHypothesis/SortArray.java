package Recursion.InductionBaseHypothesis;

import java.util.ArrayList;
import java.util.List;

public class SortArray {

    private static void insertLastElementCorrectly(List<Integer> arr, int lastElement) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) <= lastElement) continue;

            arr.add(i, lastElement);
            return;
        }
        arr.add(lastElement);
    }

    // 1,3,5 =  2
    private static void insertLastElementCorrectlyRecursive(List<Integer> arr, int elementToBeInserted) {
        if (arr.size() == 0 || arr.get(arr.size() - 1) < elementToBeInserted) {
            arr.add(elementToBeInserted);
            return;
        }

        int currentElement = arr.remove(arr.size() - 1);     // 5
        insertLastElementCorrectlyRecursive(arr, elementToBeInserted);  // 1 2 3
        arr.add(currentElement);         // 1 2 3 5
    }

    private static void sortArray(List<Integer> arr) {
        if (arr.size() <= 1) return;

        int lastElement = arr.remove(arr.size() - 1);   //3
        sortArray(arr); // 1,2,5
        insertLastElementCorrectlyRecursive(arr, lastElement);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(2);
        arr.add(1);
        arr.add(5);

        sortArray(arr);
        for (int i : arr) System.out.print(i + " ");
    }
}
