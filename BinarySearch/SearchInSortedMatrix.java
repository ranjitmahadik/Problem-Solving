package BinarySearch;

public class SearchInSortedMatrix {
    public static int RESULT_NOT_FOUND = -1;

    private static class Points{
        private int row;

        public Points(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        private int col;

    }

    public static Points search(int[][] arr, int target) {
        int n = arr.length, m = arr[0].length;
        int i = 0, j = m-1;
        while (i < n && j >= 0){
            if(arr[i][j] == target) return  new Points(i,j);
            if(arr[i][j] > target)  j--;
            else i++;
        }
        return new Points(-1,-1);
    }

    public static void main(String[] args) {
        int[][] arr = {{10,20,30,40},
                       {15,25,35,45},
                       {27,29,37,48},
                       {32,38,39,50}};

        Points p = SearchInSortedMatrix.search(arr,29);
        if(p.getCol() != -1 && p.getRow() != -1){
            System.out.println("Found the element.");
        }else{
            System.out.println("Element not present.");
        }
    }
}
