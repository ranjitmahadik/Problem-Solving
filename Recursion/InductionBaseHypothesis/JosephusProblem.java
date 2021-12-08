package Recursion.InductionBaseHypothesis;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {

    private static void josephusProblem(List<Integer> arrList, int idx, final int k) {
        if (arrList.size() == 1) {
            System.out.println(arrList.get(0));
            return;
        }

        int targetPosition = (idx + k) % arrList.size();
        arrList.remove(targetPosition);
        josephusProblem(arrList, targetPosition, k);

    }

    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<>();
        for (int i = 1; i <= 40; i++) arrList.add(i);
        int k = 7;

        josephusProblem(arrList, 0, k-1);
    }
}
