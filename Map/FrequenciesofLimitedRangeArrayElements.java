package Map;

import java.util.HashMap;
import java.util.Map;

public class FrequenciesofLimitedRangeArrayElements {
    private static void countElementFrequencies(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : arr) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> map : count.entrySet()) {
            System.out.println(map.getKey() + " : " + map.getValue());
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 3, 3, 5,
                5, 8, 8, 8, 9, 9, 10};
        countElementFrequencies(arr);
    }
}
