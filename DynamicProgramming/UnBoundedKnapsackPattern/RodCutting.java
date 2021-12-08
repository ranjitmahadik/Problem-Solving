package DynamicProgramming.UnBoundedKnapsackPattern;

public class RodCutting {

    private static int rodCutting(int[] length, int[] price, int rodLength, int idx) {
        if (idx <= 0 || rodLength == 0) return 0;
        else if (rodLength - length[idx - 1] >= 0) {
            int opt1 = price[idx - 1] + rodCutting(length, price, rodLength - length[idx - 1], idx);
            int opt2 = rodCutting(length, price, rodLength, idx - 1);
            return Math.max(opt1, opt2);
        }
        return rodCutting(length, price, rodLength, idx - 1);
    }

    public static void main(String[] args) {
        int[] length = {1, 2, 3, 4};
        int[] price = {5, 6, 8, 8};
        int rodLength = 8;
        System.out.println("rodCutting() = " + rodCutting(length, price, rodLength, price.length));
    }
}
