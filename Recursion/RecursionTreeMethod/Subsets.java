package Recursion.RecursionTreeMethod;

//  for subsets,subsequences,powerset
public class Subsets {

    private static void generateSubsets(int[] arr, int idx, String output) {
        if (idx >= arr.length) {
            System.out.println("output = " + output);
            return;
        }
        generateSubsets(arr, idx + 1, output + arr[idx]);
        generateSubsets(arr, idx + 1, output);
    }

    public static void main(String[] args) {
        generateSubsets(new int[]{1, 2, 3 }, 0, "");
    }
}
