package Recursion.InductionBaseHypothesis;

public class KthSymbolGrammer {

    /**
     * n = 1 k = 1             =>      0
     * n = 2 k = {1,2}         =>      0   1
     * n = 3 k = {1,2,3,4}     =>      0   1   1   0
     * n = 4 k = {}            =>      0   1   1   0    1   0  0  1
     */
    private static int kthGrammer(int n, int k) {
        if (n == 1 && k == 1) return 0;

        int noOfDigits = (int) Math.pow(2, n - 1);
        int mid = noOfDigits/2;
        if(k <= mid){
            return kthGrammer(n-1,k);
        }else{
            return kthGrammer(n-1,k - mid) == 0 ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("kthGrammer(2,1) = " + kthGrammer(4,5));
    }
}
