package Stack;

public class FindTheTownJudge {
    private static int findTownJudge(int[][] arr, int n) {
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int child : arr[i]) {
                in[child]++;
                out[i]++;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (out[i] == 0 && in[i] == n - 1) return i;
        }

        return -1;
    }

    private static int findTownJudgeSpaceOptimal(int[][] arr, int n) {
        int[] degree = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            int src = arr[i][0];
            int dest = arr[i][1];
            degree[src]--;
            degree[dest]++;
        }

        for (int i = 1; i < n + 1; i++) {
            if (degree[i] == n - 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 3}};
        System.out.println(findTownJudge(arr, 3));
    }
}
