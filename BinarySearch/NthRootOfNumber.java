package BinarySearch;

public class NthRootOfNumber {


    public static void main(String[] args) {
//        double res = NthRootOfNumber.getSquareRoot(45);
//        System.out.println("Square root of number is : " + res);
//        assert res == Math.sqrt(18);

        double ans = NthRootOfNumber.getNthRoot(2,2);
        System.out.println("Ans is : " + ans);
        assert 2 == 3 : "Not Equal";
    }

    private static double canThisBeAns(double number, int rootVal) {
        double ans = 1;
        for(int i=0;i<rootVal;i++){
            ans *= number;
        }
        return ans;
    }

    private static double getNthRoot(int number, int rootVal) {
        double lo = 1, hi = number, eps = 1e-10;

        while ((hi - lo) > eps) {
            double mid = lo + (hi - lo) / 2;
            if (canThisBeAns(mid,rootVal) <= number) lo = mid;
            else hi = mid;
        }
        return lo;
    }

    private static double getSquareRoot(int number) {
        double lo = 1.0, hi = number, eps = 1e-7;
        while ((hi - lo) > eps) {
            double mid = lo + (hi - lo) / 2;
            double sqr = mid * mid;

            if (sqr <= number) {
                lo = mid;
            } else hi = mid;
        }
        return lo;
    }

    private static int getSquareRoot(int number, int root) {
        int lo = 1, hi = number;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid * mid == number) return mid;
            else if (mid * mid < number) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo - 1;
    }
}
