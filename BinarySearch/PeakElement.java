package BinarySearch;

public class PeakElement {
    // 5 10 20 15
    public static int findPeak(int[] arr) {
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo >> 1);

            if (mid + 1 < arr.length && mid - 1 >= 0) {
                if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) return mid;
                else if (arr[mid] > arr[mid - 1]) lo = mid + 1;
                else hi = mid - 1;
            } else {
                if(mid == 0){
                    if(arr[mid] > arr[mid+1])   return mid;
                    else return mid+1;
                }else{
                    if(arr[mid] > arr[mid -1])  return mid;
                    else return mid-1;
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(PeakElement.findPeak(new int[]{5, 10, 20, 3}));
    }
}
