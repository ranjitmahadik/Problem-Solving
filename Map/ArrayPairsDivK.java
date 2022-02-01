package Map;

public class ArrayPairsDivK {
    private static boolean countPairs(int[] arr, int K) {
        int[] ans = new int[K];
        for (int i = 0; i < arr.length; i++) {
            int rem = arr[i] % K;
            if (rem < 0) rem += K;
            ans[rem]++;
        }
        if (ans[0] % 2 != 0) return false;
        for (int i = 1; i < K; i++) {
            if (ans[i] != ans[K - i]) {
                return false;
            }
        }
        return true;
    }
}
